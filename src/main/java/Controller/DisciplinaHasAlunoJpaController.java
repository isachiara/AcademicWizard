/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import DAOUtil.DAO;
import java.io.Serializable;
import Model.DisciplinaHasAluno;
import Util.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Henrique
 */
public class DisciplinaHasAlunoJpaController implements Serializable,DAO<DisciplinaHasAluno> {

     private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }


    public void create(DisciplinaHasAluno discHasAlun) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(discHasAlun);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
               // em.close();
            }
        }
    }

    public void edit(DisciplinaHasAluno discHasAlun) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(discHasAlun);
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

    public void destroy(DisciplinaHasAluno disHasAlun) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            DisciplinaHasAluno discHasAlunRemove = em.merge(disHasAlun);

            et.begin();
            em.remove(discHasAlunRemove);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
               // em.close();
            }
        }
    }

    public DisciplinaHasAluno findDisciplinaHasAluno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DisciplinaHasAluno.class, id);
        } finally {
            //em.close();
        }
    }

    @Override
    public DisciplinaHasAluno find(DisciplinaHasAluno entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
