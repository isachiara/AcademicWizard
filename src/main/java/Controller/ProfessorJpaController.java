/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import Model.Professor;
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
public class ProfessorJpaController implements Serializable {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    public EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    public void create(Professor professor) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(professor);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Professor professor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(professor);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Professor professor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            Professor professorRemove = em.merge(professor);

            et.begin();
            em.remove(professorRemove);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean findProfessor(String Siape, String Senha) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Professor> query = em.createQuery(
                "SELECT a FROM Professor a WHERE a.siape LIKE :siape AND a.senha LIKE :senha", Professor.class);
        query.setParameter("siape", Siape);
        query.setParameter("senha", Senha);
        
        List<Professor> alunos = query.getResultList();
        em.clear();
        em.close();
        return !alunos.isEmpty();

    }
    public Professor findProfessor(String Siape) {
        EntityManager em = getEntityManager();
        
        Query query = em.createQuery(
                "SELECT a FROM Professor a WHERE a.siape LIKE ?1", Professor.class);
        query.setParameter(1, Siape);
        
        Professor professor = (Professor)query.getSingleResult();
        em.clear();
        em.close();
        return professor;

    }
    public List<Professor> getAllProfessores(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Professor> query = em.createQuery(
                "SELECT p FROM Professor p", Professor.class);
        List<Professor> professores = query.getResultList();
        
        em.clear();
        em.close();
        return professores;
    }
    
    public Professor verificaLogin(String siape, String senha){
        Professor usuarioEncontrado;
        EntityManager em = getEntityManager();
        
        Query q = em.createQuery("SELECT p FROM Professor p WHERE p.siape = ?1 AND p.senha = ?2", Professor.class);
        q.setParameter(1, siape);
        q.setParameter(2, senha);
        usuarioEncontrado = (Professor) q.getSingleResult();
        
        em.clear();
        em.close();
        return usuarioEncontrado;
    }
}