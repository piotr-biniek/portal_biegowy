/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.web.beans.uzer;

import java.io.Serializable;
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.java.biniek.exception.interceptor.frontend.BinderPageBean;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.model.Organiser;
import pl.java.biniek.model.Runner;
import pl.java.biniek.model.Uzer;
import pl.java.biniek.web.beans.controlers.AplicationController;
import pl.java.biniek.web.beans.controlers.UzerController;

@RequestScoped
@Named
@BinderPageBean
public class PasswordPageBean implements Serializable {

    //    @EJB
    //   OrganiserEndPoint organiserEndPoint;
    @Inject
    UzerController uzerControler;

//@Inject
    AplicationController appControler;

    //  private Uzer uzer = new Uzer();
    private String oldPassword = "";

    private String newPassword = "";

    public UzerController getUzerControler() {
        return uzerControler;
    }

    public void setUzerControler(UzerController uzerControler) {
        this.uzerControler = uzerControler;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Uzer getLoggdUzer() {
        return uzerControler.getLoggedUser();

    }

    public String saveNewPassword() throws BasicApplicationException {   //

        Uzer uzer = this.getLoggdUzer();
        String haslo;
        haslo = uzer.getPassword();

        if (!haslo.equals(AplicationController.hashPassword(getOldPassword()))) {//
            AplicationController.showGeneralMessage(FacesMessage.SEVERITY_WARN, "messages.badpassword");
            return null;
        } else {
            return uzerControler.saveNewPasswordForLoggedUzer(AplicationController.hashPassword(newPassword));
        }

    }



}
