/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import Daoutil.DAO;
import java.io.Serializable;
import Model.Telefoneprofessor;
import Util.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Henrique
 */
public class TelefoneprofessorJpaController implements Serializable, DAO<Telefoneprofessor> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

    @Override
    public void create(Telefoneprofessor telefoneProfessor) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(telefoneProfessor);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    @Override
    public void edit(Telefoneprofessor telefoneProfessor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(telefoneProfessor);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    @Override
    public void destroy(Telefoneprofessor adm) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            Telefoneprofessor telefoneProfessorRemove = em.merge(adm);

            et.begin();
            em.remove(telefoneProfessorRemove);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }
    
    public Telefoneprofessor findTelefoneprofessor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefoneprofessor.class, id);
        } finally {
            //em.close();
        }
    }

    @Override
    public Telefoneprofessor find(Telefoneprofessor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
