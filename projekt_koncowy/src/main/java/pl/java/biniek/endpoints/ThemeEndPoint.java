/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.endpoints;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.exception.interceptor.backend.LoggingInterceptorWithRepackingForEndPoint;
import pl.java.biniek.facade.ThemeFacade;
import pl.java.biniek.uzertheme.UzerTheme;
//import pl.java.biniek.model.Uzer;

/**
 *
 * @author java pbi moje!!!!!
 */
@Stateless
@Interceptors(LoggingInterceptorWithRepackingForEndPoint.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ThemeEndPoint implements Serializable {

    @EJB
    private ThemeFacade themeFacade;
    @EJB
    private UzerEndPoint uzerEndPoint;


    public void createThemeForNewUzer(long usrId) throws BasicApplicationException {
        UzerTheme theme = new UzerTheme();
        theme.setThemeType("sunny");
        theme.setUzerId(usrId);
        themeFacade.create(theme);
    }

//    public String findThemeOfLoggedUzer() {
//
//        return themeFacade.findThemeByUzerId((uzerEndPoint.getLoggedUser()).getId()).getThemeType();
//
//    }
    public String getLoggedUserTheme() {

        return themeFacade.findThemeByUzerId(uzerEndPoint.getLoggedUser().getId()).getThemeType();

    }

    public void setLoggedUserTheme(String newThemeValue) {
        if (uzerEndPoint.getLoggedUser() != null) {
            UzerTheme theme = themeFacade.findThemeByUzerId(uzerEndPoint.getLoggedUser().getId());
            theme.setThemeType(newThemeValue);
            themeFacade.edit(theme);
        }

    }

    
    public void removeThemeOfDeletedUzer(long uzerId) {
        themeFacade.removeThemeByUserId(uzerId);
    }
}
