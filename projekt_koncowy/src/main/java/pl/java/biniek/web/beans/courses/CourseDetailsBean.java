
package pl.java.biniek.web.beans.courses;

import pl.java.biniek.web.beans.controlers.CourseController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import pl.java.biniek.exception.interceptor.frontend.BinderPageBean;
import pl.java.biniek.exception.interceptor.frontend.BinderStringToNull;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.model.Course;
import pl.java.biniek.model.Organiser;
import pl.java.biniek.model.Payment;
import pl.java.biniek.web.beans.controlers.UzerController;

@Named
@ViewScoped
@BinderPageBean
public class CourseDetailsBean implements Serializable {

    Course viewedCourse;
    boolean backNavigatedFromPrivateRuns=false;

    @Inject
    CourseController courseController;

    @Inject
    UzerController uzerControler;

    @PostConstruct
    public void init() {
        viewedCourse = courseController.findByID(courseController.getViewedCourse().getId());
        backNavigatedFromPrivateRuns=courseController.isBackNavigatedFromPrivateRuns();
    }

    public Course getViewedCourse() {
        return viewedCourse;
    }

    public CourseController getCourseControler() {
        return courseController;
    }

    public String editCourse() throws BasicApplicationException {

        return courseController.editViewedCourse(viewedCourse);
       
    }

    public String back() {

        courseController.setViewedCourse(null);
        if (backNavigatedFromPrivateRuns) {
            return "listOfMyCourses";
        }
        return "listOfCourses";
    }
    
    public String getOutputDateTime(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh.mm");
         return formatter.format(date);
    }

    public String setViewOrganiser(Organiser org) {
        uzerControler.setViewedOrganiser(org);
        return "organiserDetails";


    }
@BinderStringToNull
    public Payment getCoursePaymentForLoggedRunner() throws BasicApplicationException {
        return courseController.getViewedCoursePaymentForLoggedRunner(viewedCourse);

    }
     public boolean isVievedCourseAfterCurrentDate() {
        LocalDateTime now = LocalDateTime.now();//new Date();
        return getViewedCourse().getDateOfStart().compareTo(now)<0;
    }


    public void signRunnerFor() throws BasicApplicationException {
        courseController.signLoggedRunnerForViewedCourse(viewedCourse);
        viewedCourse=courseController.findByID(viewedCourse.getId());//odswierzanie kursu
        
    }

    public void signRunnerOut() throws BasicApplicationException {
        courseController.signRunnerOut(viewedCourse);
        viewedCourse=courseController.findByID(viewedCourse.getId());
    }
    
    public String deleteViewedCourse() throws BasicApplicationException{
        courseController.setIsNavigatedFromMyCourses(backNavigatedFromPrivateRuns);
       return courseController.deleteCourse(viewedCourse);
        
    }
    
    public boolean  isAvalibleRunnersLimit(){
       return courseController.isAvalibleRunnersLimit(viewedCourse);
    }
        
    


}
