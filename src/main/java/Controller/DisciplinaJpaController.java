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
import Model.Disciplina;
import Model.Professor;
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
public class DisciplinaJpaController implements Serializable, DAO<Disciplina> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

    @Override
    public void create(Disciplina disciplina) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(disciplina);
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
    public void edit(Disciplina disciplina) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(disciplina);
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
    public void destroy(Disciplina disciplina) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
            et = em.getTransaction();

            Disciplina disciplinaRemove = em.merge(disciplina);

            et.begin();
            em.remove(disciplinaRemove);
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

    public Disciplina disciplinaPorAluno(Integer id) {
        /*EntityManager em = getEntityManager();
        TypedQuery <Disciplina> query = em.createQuery(
                "SELECT d FROM Disciplina d WHERE d.idDisciplina IN (SELECT ", resultClass)*/
        return null;
    }
    
    public List<Disciplina> getAllDisciplinas(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Disciplina> query = em.createQuery(
                "SELECT d FROM Disciplina d", Disciplina.class);
        List<Disciplina> aulas = query.getResultList();
        
        //em.close();
        return aulas;
    }
    
    public List<Disciplina> findDisciplinas(Professor usuario) {
        EntityManager em = getEntityManager();
        
        Query query = null; 
        
        try {
            String hql = "from Disciplina d where d.professorSiape.siape = " + usuario.getSiape();        
            query = em.createQuery(hql);

        } catch (Exception ex) {
            
            throw new RuntimeException(ex);
        }

        if(query != null){
            return (List<Disciplina>) query.getResultList();
        }
            
        return null;

    }

    @Override
    public Disciplina find(Disciplina entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}