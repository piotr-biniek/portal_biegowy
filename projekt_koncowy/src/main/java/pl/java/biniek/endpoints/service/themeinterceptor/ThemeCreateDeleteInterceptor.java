package pl.java.biniek.endpoints.service.themeinterceptor;

import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import pl.java.biniek.endpoints.ThemeEndPoint;
import pl.java.biniek.endpoints.UzerEndPoint;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.model.Uzer;


public class ThemeCreateDeleteInterceptor {

    @EJB
    ThemeEndPoint themeEndPoint;

    @EJB
    UzerEndPoint uzerendpoint;

    boolean success = true;

    @Resource
    private SessionContext sessionContext;

    /**
     * Only for methods create and remove Uzer
     * 
     */
     @AroundInvoke
    public Object ceateDeleteTheme(InvocationContext invocation) throws Exception {
        //String uzerEmail;
        Uzer uzer;
        Object[] parameters = invocation.getParameters();
        Method invokedMethod = invocation.getMethod();
        uzer = ((Uzer) parameters[0]);

      
        Object result = invocation.proceed();

        if (invokedMethod.getName().matches("create*.*")) {
             themeEndPoint.createThemeForNewUzer(uzerendpoint.findUzerByEmail(uzer.getEmail()).getId());  
     
          
            
        }
        if (invokedMethod.getName().matches("remove.*")) {
            themeEndPoint.removeThemeOfDeletedUzer(uzer.getId());

        }

        return result;
    }
}
