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
               // em.close();
            }
        }
    }

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
               // em.close();
            }
        }
    }

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
              //  em.close();
            }
        }
    }

    public Disciplina disciplinaPorNome(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery(
                "SELECT d FROM Disciplina d WHERE d.nome = ?1", Disciplina.class);
        query.setParameter(1, nome);
        Disciplina disciplina = (Disciplina) query.getSingleResult();
        //em.close();
        return disciplina;
    }
    
    public List<Disciplina> getAllDisciplinas(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Disciplina> query = em.createQuery(
                "SELECT d FROM Disciplina d", Disciplina.class);
        List<Disciplina> aulas = query.getResultList();
        
        //em.close();
        return aulas;
    }
    
    public List<Disciplina> findDisciplinas(Professor professor) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Disciplina> q = em.createQuery(
                "SELECT d FROM Disciplina d WHERE d.professorSiape.siape = ?1", Disciplina.class);
        q.setParameter(1, professor.getSiape());
        List<Disciplina> disciplinas = q.getResultList();
       // em.close();
        return disciplinas;
    }

    @Override
    public Disciplina find(Disciplina entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Disciplina> DisciplinaPorPeriodo(int periodo){
        EntityManager em = getEntityManager();
        
        TypedQuery<Disciplina> q = em.createQuery(
                "SELECT d FROM Disciplina d WHERE d.periodo = ?1", Disciplina.class);
        q.setParameter(1, periodo);
        List<Disciplina> disciplinas = q.getResultList();
       // em.close();
        return disciplinas;
    }
}