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
import pl.java.biniek.model.Uzer;
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

    public String findThemeOfLoggedUzer() {

        return themeFacade.findThemeByUser(uzerEndPoint.getLoggedUser()).getThemeType();

    }

    public void createThemeForNewUzer(String uzerEmail) throws BasicApplicationException {
        UzerTheme theme = new UzerTheme();
        theme.setThemeType("sunny");
        theme.setUzerEmail(uzerEmail);
        themeFacade.create(theme);
    }

    public String getLoggedUserTheme() {

        return themeFacade.findThemeByUser(uzerEndPoint.getLoggedUser()).getThemeType();

    }

    public void setLoggedUserTheme(String newThemeValue) {
        if (uzerEndPoint.getLoggedUser() != null) {
            UzerTheme theme = themeFacade.findThemeByUser(uzerEndPoint.getLoggedUser());
            theme.setThemeType(newThemeValue);
            themeFacade.edit(theme);
        }

    }

    
    public void removeThemeOfDeletedUzer(String uzerMail) {
        themeFacade.removeThemeByUserMail(uzerMail);
    }
}
