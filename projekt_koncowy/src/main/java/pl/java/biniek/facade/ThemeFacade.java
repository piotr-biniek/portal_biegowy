/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.java.biniek.exception.interceptor.backend.ExceptionAndLoggingInterceptorWithRepackingExceptionsForFACADE;
import pl.java.biniek.uzertheme.UzerTheme;
import pl.java.biniek.model.Uzer;
/**
 *
 * @author samsung
 */
@Stateless
@Interceptors(ExceptionAndLoggingInterceptorWithRepackingExceptionsForFACADE.class)
public class ThemeFacade extends AbstractFacade<UzerTheme> {

    @PersistenceContext(unitName = "com.mycompany_aProjektKoncowy02_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThemeFacade() {
        super(UzerTheme.class);
    }
    

    public UzerTheme findThemeByUser(Uzer user) {
       
              Query tq = em.createQuery("SELECT d FROM UzerTheme d WHERE d.uzerId = ?1 ", UzerTheme.class);
              tq.setParameter(1, user.getId());
//            
//            TypedQuery<Payment> tq = em.createNamedQuery("Payment.findByCourseAndRunner", Payment.class);
//            tq.setParameter(1, course);
//            tq.setParameter(2, runner);

            
               return (UzerTheme) tq.getSingleResult();
            
         
       

            }

    
    public void removeThemeByUserId(long userId) {
       
              Query tq = em.createQuery("DELETE d FROM UzerTheme d WHERE d.uzerId = ?1 ", UzerTheme.class);
              tq.setParameter("uzerId", userId);
          
                tq.executeUpdate();
             }

        }
    


    

