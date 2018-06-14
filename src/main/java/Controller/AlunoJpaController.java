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
import Model.Aluno;
import Util.EntityManagerSingleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Henrique
 */
public class AlunoJpaController implements Serializable, DAO<Aluno> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

    public void create(Aluno aluno) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();;

            et.begin();
            em.persist(aluno);
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

    public void edit(Aluno aluno) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(aluno);
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

    public void destroy(Aluno aluno) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            Aluno alunoRemove = em.merge(aluno);

            et.begin();
            em.remove(alunoRemove);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                //   em.close();
            }
        }
    }

    public Aluno findAluno(String Matricula, String Senha) {
        EntityManager em = getEntityManager();
        Aluno aluno = new Aluno();
        Query query = em.createQuery(
                "SELECT a FROM Aluno a WHERE a.matricula LIKE ?1 AND a.senha LIKE ?2", Aluno.class);
        query.setParameter(1, Matricula);
        query.setParameter(2, Senha);

        if(query.getSingleResult()==null){
            return null;
        }
        aluno = (Aluno) query.getSingleResult();
//        em.flush();
        //em.close();

        return aluno;

    }

    @Override
    public Aluno find(Aluno entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
