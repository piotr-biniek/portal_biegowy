/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.endpoints;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.transaction.UserTransaction;
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

@Interceptors({ThemeCreateDeleteInterceptor.class, LoggingInterceptorWithRepackingForEndPoint.class})
@TransactionManagement(TransactionManagementType.BEAN)
//@Interceptors()
//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UzerEndPoint implements Serializable {

    @Resource
    private UserTransaction userTransaction;
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

    public void remove(Uzer uzer) throws BasicApplicationException, Exception {//todo porządek z themami

        String uzerMail = uzer.getEmail();

        try {
            userTransaction.begin();
            
            uzerFacade.remove(uzer);

            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
            throw new BasicApplicationException(ex);

        }

// obsługa wyjątków w interceptorze
        //    themeEndPoint.removeThemeOfDeletedUzer(uzerMail);
    }

    public List<Uzer> getAllUzers() {
        return uzerFacade.findAll();

    }

    public Uzer findUzerByEmail(String email) {
        return uzerFacade.findUzerByEmail(email);

    }
//@Interceptors(ThemeCreateDeleteInterceptor.class)
//@TransactionManagement(TransactionManagementType.BEAN) 

    public void createUzer(Uzer uzer) throws BasicApplicationException, Exception {

        try {
            userTransaction.begin();
            uzerFacade.create(uzer);

            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
            throw new BasicApplicationException(ex);

        }

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

    @RolesAllowed({"Organiser", "Administrator"})
    public void saveAfterEdit(Organiser organiser) throws BasicApplicationException, Exception {

        Uzer org = getLoggedUser();
        if (organiser == null) {
            throw new NullPointerApplicationException();
        }
        if (org instanceof Organiser && ((!Objects.equals(organiser.getId(), org.getId())))) {
            throw new WrongUzerApplicationException();
        } else {
            try {
                userTransaction.begin();

                uzerFacade.edit(org);

                userTransaction.commit();
            } catch (Exception ex) {
                userTransaction.rollback();
                throw new BasicApplicationException(ex);

            }

        }
    }

    @RolesAllowed({"Runner", "Administrator"})
    public void saveAfterEdit(Runner runner) throws BasicApplicationException, Exception {
        Uzer run = getLoggedUser();

        if (runner == null) {
            throw new NullPointerApplicationException();
        }
        if (run instanceof Runner && (!Objects.equals(runner.getId(), run.getId()))) {

            throw new WrongUzerApplicationException();
        } else {

            try {
                userTransaction.begin();

                runnerFacade.edit(runner);

                userTransaction.commit();
            } catch (Exception ex) {
                userTransaction.rollback();
                throw new BasicApplicationException(ex);

            }

        }

// starczy prosta zasada - przed edit dobrze po edit Źle!!!!!!! :)
    }

    @RolesAllowed({"Administrator"})

    public List<Runner> getAllRunners() {

        return runnerFacade.findAll();

    }

    @RolesAllowed({"Runner", "Administrator", "Organiser"})
    public void saveNewPasswordForLogged(String passwd) throws Exception, BasicApplicationException {
        Uzer uzer = this.getLoggedUser();
        uzer.setPassword(passwd);

        try {
            userTransaction.begin();

            uzerFacade.edit(uzer);

            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
            throw new BasicApplicationException(ex);

        }

    }

    public boolean checkEmailExistsInDB(String email) {
        return uzerFacade.checkIfEmailExists(email);
    }

    @RolesAllowed({"Administrator"})
    public List<Administrator> getAllAdministrators() {
        return adminFacade.findAll();

    }

    @RolesAllowed({"Administrator"})
    public void createAdministrator(Administrator admin) throws BasicApplicationException, Exception{

        try {
            userTransaction.begin();

            adminFacade.create(admin);
            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
            throw new BasicApplicationException(ex);

        }

    }

    @RolesAllowed({"Administrator"})
    public void saveAfterEdit(Administrator admin) {

        adminFacade.edit(admin);

    }
}
