/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.endpoints;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import pl.java.biniek.endpoints.service.themeinterceptor.ThemeCreateDeleteInterceptor;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.exceptions.NullPointerApplicationException;
import pl.java.biniek.exceptions.WrongUzerApplicationException;
import pl.java.biniek.facade.OrganiserFacade;
import pl.java.biniek.facade.RunnerFacade;
import pl.java.biniek.facade.UzerFacade;
import pl.java.biniek.exception.interceptor.backend.LoggingInterceptorWithRepackingForEndPoint;
import pl.java.biniek.facade.AdministratorFacade;
import pl.java.biniek.model.Administrator;
import pl.java.biniek.model.Organiser;
import pl.java.biniek.model.Runner;
import pl.java.biniek.model.Uzer;
//import pl.java.biniek.model.Uzer;

/**
 *
 * @author java pbi moje!!!!!
 */
@Stateless
@Interceptors(LoggingInterceptorWithRepackingForEndPoint.class)

public class UzerEndPoint implements Serializable {

 
    @EJB
    private UzerFacade uzerFacade;

    @EJB
    private OrganiserFacade organiserFacade;

    @EJB
    private RunnerFacade runnerFacade;

    @EJB
    private AdministratorFacade adminFacade;
    @EJB
    private ThemeEndPoint themeEndPoint;

    @RolesAllowed("Administrator")
    @Interceptors(ThemeCreateDeleteInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remove(Uzer uzer) throws BasicApplicationException {//todo porządek z themami

        String uzerMail = uzer.getEmail();

      
            
            uzerFacade.remove(uzer);

     
        }

// obsługa wyjątków w interceptorze
        //    themeEndPoint.removeThemeOfDeletedUzer(uzerMail);
    

    public List<Uzer> getAllUzers() {
        return uzerFacade.findAll();

    }

    public Uzer findUzerByEmail(String email) {
        return uzerFacade.findUzerByEmail(email);

    }
@Interceptors(ThemeCreateDeleteInterceptor.class)
//@TransactionManagement(TransactionManagementType.BEAN) 
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createUzer(Uzer uzer) throws BasicApplicationException {

      
            uzerFacade.create(uzer);

      

    }

    public Uzer getLoggedUser() {
            String email = this.getLoggedUserEmail();
        if (email==null)return null;
        else return this.findUzerByEmail(email);
     
    }

    public String getLoggedUserEmail() {
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    public List<Administrator> getAllAdmins() {
        return adminFacade.findAll();

    }

    public List<Organiser> getAllOrganisers() {
        return organiserFacade.findAll();

    }
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Organiser", "Administrator"})
    public void saveAfterEdit(Organiser organiser) throws BasicApplicationException {

        Uzer org = getLoggedUser();
        if (organiser == null) {
            throw new NullPointerApplicationException();
        }
        if (org instanceof Organiser && ((!Objects.equals(organiser.getId(), org.getId())))) {
            throw new WrongUzerApplicationException();
        } else {
                uzerFacade.edit(org);

          
        }
    }
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Runner", "Administrator"})
    public void saveAfterEdit(Runner runner) throws BasicApplicationException {
        Uzer run = getLoggedUser();

        if (runner == null) {
            throw new NullPointerApplicationException();
        }
        if (run instanceof Runner && (!Objects.equals(runner.getId(), run.getId()))) {

            throw new WrongUzerApplicationException();
        } else {

                runnerFacade.edit(runner);

        
        }

// starczy prosta zasada - przed edit dobrze po edit Źle!!!!!!! :)
    }

    @RolesAllowed({"Administrator"})

    public List<Runner> getAllRunners() {

        return runnerFacade.findAll();

    }
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Runner", "Administrator", "Organiser"})
    public void saveNewPasswordForLogged(String passwd) throws  BasicApplicationException {
        Uzer uzer = this.getLoggedUser();
        uzer.setPassword(passwd);

      
            uzerFacade.edit(uzer);

          
        

    }

    public boolean checkEmailExistsInDB(String email) {
        return uzerFacade.checkIfEmailExists(email);
    }

    @RolesAllowed({"Administrator"})
    public List<Administrator> getAllAdministrators() {
        return adminFacade.findAll();

    }
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Administrator"})
    public void createAdministrator(Administrator admin) throws BasicApplicationException{

     
            adminFacade.create(admin);
         
        }
    
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({"Administrator"})
    public void saveAfterEdit(Administrator admin) {

        adminFacade.edit(admin);

    }
}
