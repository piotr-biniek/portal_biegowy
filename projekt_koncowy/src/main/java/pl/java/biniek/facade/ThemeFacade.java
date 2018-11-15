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
//@TransactionAttribute(TransactionAttributeType.MANDATORY)
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

//    public UzerTheme findThemeByUser(Uzer user) {
//
//        return findThemeBymail(user.getEmail());
//    }

    public UzerTheme findThemeByUzerId(long uzerId) {

        Query tq = em.createQuery("SELECT d FROM UzerTheme d WHERE d.uzerId = ?1 ", UzerTheme.class);
        tq.setParameter(1, uzerId);

        return (UzerTheme) tq.getSingleResult();

    }
@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void removeThemeByUserId(long uzerId) {// todo zrobić porządek z themami - przeniesc tworzenie do 1go logowania
        UzerTheme ut = findThemeByUzerId(uzerId);
        remove(ut);
    }

}

//    public void removeThemeByUserId(long userId) {// todo zrobić porządek z themami - przeniesc tworzenie do 1go logowania
//       
//              Query tq = em.createQuery("DELETE d FROM UzerTheme d WHERE d.uzerId = ?1 ", UzerTheme.class);
//              tq.setParameter("uzerId", userId);
//          
//                tq.executeUpdate();
//             }
