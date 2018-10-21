//dostęp bezpieczenstwa ok

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.web.beans.controlers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import pl.java.biniek.endpoints.ThemeEndPoint;
import pl.java.biniek.model.Uzer;
import pl.java.biniek.exception.interceptor.frontend.BinderController;

@Named
@SessionScoped
@BinderController
public class AplicationController implements Serializable {

    //String theme;
    
    @EJB
    ThemeEndPoint themeEndPoint;

    private Uzer loggedUser;

    @Inject
    UzerController userController;

    private String string;

//    @PostConstruct
//    public void init() {
//        theme = "sunny";
//    }
    

    // loggedUzer;// = ((Uzer) FacesContext.getCurrentInstance().getExternalContext()).getUser();
    public static void resetSession() throws IOException {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        // loggedUzer = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("");
        //return "/index?faces-redirect=true";
    }

    public static String hashPassword(String password) {

        return getHash(password);
    }

    public static String getHash(String nonHashPassword) {
        return DigestUtils.sha256Hex(nonHashPassword);
    }

    /**
     * Wwyswietlanie komunikatów zlokalizowanych
     */
    public static String getInternationalMessage(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        String message = getDefaultBundle().getString(key);
        return message;

    }

    public static void showMessage(String id, String key) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", AplicationController.getDefaultBundle().getString(key));
        FacesContext.getCurrentInstance().addMessage(id, msg);
    }

    public static void showGeneralMessage(Severity info, String key) {

        FacesContext context = FacesContext.getCurrentInstance();
        String str = getDefaultBundle().getString(key);
        context.addMessage(null, new FacesMessage(info, "", str));

    }

    public static ResourceBundle getDefaultBundle() {

        FacesContext context = FacesContext.getCurrentInstance();
        String bundle = context.getExternalContext().getInitParameter("resourceBundle.path");
        if (null == bundle) {
            return null;
        } else {
            return ResourceBundle.getBundle(bundle);
        }
    }

    public static void showInfoSuccesMessage(String id) {
        AplicationController.showGeneralMessage(FacesMessage.SEVERITY_INFO, "messages.success");

    }

    public void saveTheme(String theme) {
        themeEndPoint.setLoggedUserTheme(theme);
    }

    public String getTheme() {
       return themeEndPoint.getLoggedUserTheme();
    }
}

