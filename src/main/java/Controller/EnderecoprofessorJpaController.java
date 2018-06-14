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
import Model.Enderecoprofessor;
import Util.EntityManagerSingleton;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Henrique
 */
public class EnderecoprofessorJpaController implements Serializable, DAO<Enderecoprofessor> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

    @Override
    public void create(Enderecoprofessor enderecoProfessor) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(enderecoProfessor);
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
    public void edit(Enderecoprofessor enderecoProfessor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(enderecoProfessor);
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
    public void destroy(Enderecoprofessor enderecoProfessor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            Enderecoprofessor enderecoProfessorRemove = em.merge(enderecoProfessor);

            et.begin();
            em.remove(enderecoProfessorRemove);
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

    public Enderecoprofessor findEnderecoprofessor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enderecoprofessor.class, id);
        } finally {
            //em.close();
        }
    }

    @Override
    public Enderecoprofessor find(Enderecoprofessor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
