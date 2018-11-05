package pl.java.biniek.endpoints.service.themeinterceptor;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import pl.java.biniek.endpoints.ThemeEndPoint;
import pl.java.biniek.endpoints.UzerEndPoint;
import pl.java.biniek.exceptions.BasicApplicationException;
import pl.java.biniek.model.Runner;
import pl.java.biniek.model.Uzer;

public class ThemeCreateDeleteInterceptor {

    @EJB
    ThemeEndPoint themeEndPoint;

    @EJB
    UzerEndPoint uzerendpoint;

    boolean success = true;

    @Resource
    private SessionContext sessionContext;

    @AroundInvoke
    public Object interceptorMethodForDAO(InvocationContext invocation) throws Exception {
        String uzerEmail;

        Object[] parameters = invocation.getParameters();
        Method invokedMethod = invocation.getMethod();
        uzerEmail = ((Uzer) parameters[0]).getEmail();

      
        Object result = invocation.proceed();

        if (invokedMethod.getName().matches("create*.*")) {
             themeEndPoint.createThemeForNewUzer(uzerEmail);  
     
        }
        if (invokedMethod.getName().matches("remove.*")) {
            themeEndPoint.removeThemeOfDeletedUzer(uzerEmail);

        }

        return result;
    }
}
