/**
 * Klasa RunnersPageViewBean  - klasa testowa  mozliwe rózne rozwiązania
 *  rozwiązanie odwołania się z xhtml do Kolekcji
 * albo poprzez nazwę klasy beana (jezeli nie damy mu nazwy @ManagedBean) czyli np poporzez
 * #{runnersPageViewBean.*}
 * jeżeli ma nazwę @ManagedBean(name = "listOfRunners")
 * #{listOfRunners.*}
 *
 * Tworzenie kolekcji rozwiązano na 2 sposoby
 * albo poprzez pobranie Kolekcji z endponta metodą Init opisaną   @PostConstruct,
 * #{*.runnersList}
 * albo wywołanie metody getAllRunners() która z wstrzyknietego endpointa zwraca kolekcje
 * #{*.allRunners}
 *
 */
package pl.java.biniek.web.beans.runners;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.exceptions.WrongUzerApplicationException;
import pl.java.biniek.exception.interceptor.frontend.BinderPageBean;
import pl.java.biniek.model.Administrator;
import pl.java.biniek.model.Runner;
import pl.java.biniek.web.beans.controlers.CourseController;
import pl.java.biniek.web.beans.controlers.UzerController;

@Named
@ViewScoped
@BinderPageBean
public class RunnerDetailsBean implements Serializable {

    @Inject
    UzerController uzerControler;
    @Inject
    CourseController courseController;

    Runner runner;

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    
    
    
    @PostConstruct
    public void init() {
        runner = uzerControler.getViewedRunner();
    }



    public String editRunnerFromDetails() throws WrongUzerApplicationException {
        if ((Objects.equals(uzerControler.getLoggedUser().getId(), uzerControler.getViewedRunner().getId())) || (uzerControler.getLoggedUser() instanceof Administrator)) {
            uzerControler.setEditetRunner(runner);
           
            return "runnerEdit";
        } else {
            throw new WrongUzerApplicationException();
        }
    }

    public String back() {

        // uzerControler.setViewedRunner(null);
        return "listOfRunners";
    }

    public String deleteVievedRunner() throws BasicApplicationException {

        return uzerControler.deleteViewedRunner(runner);
       
    }

}
