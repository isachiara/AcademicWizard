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
import Model.Professor;
import Util.EntityManagerSingleton;
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
public class ProfessorJpaController implements Serializable, DAO<Professor> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

    @Override
    public void create(Professor professor) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
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
                //em.close();
            }
        }
    }

    @Override
    public void edit(Professor professor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
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
                //em.close();
            }
        }
    }

    @Override
    public void destroy(Professor professor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = getEntityManager();
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
                //em.close();
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
        //em.close();
        return !alunos.isEmpty();

    }
    public List<Professor> findProfessor(String Siape) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Professor> query = em.createQuery(
                "SELECT a FROM Professor a WHERE a.siape LIKE :siape", Professor.class);
        query.setParameter("siape", Siape);
        
        List<Professor> professor = query.getResultList();
        //em.close();
        return professor;

    }
    public List<Professor> getAllProfessores(){
        EntityManager em = getEntityManager();
        
        TypedQuery<Professor> query = em.createQuery(
                "SELECT p FROM Professor p", Professor.class);
        List<Professor> professores = query.getResultList();
        
        //em.close();
        return professores;
    }
    
    public Professor verificaLogin(Professor usuario){
        Professor usuarioEncontrado;
        EntityManager em = getEntityManager();
        
        String hql = "from Professor u where u.nome = '" + usuario.getNome() + "' and u.senha = '" + usuario.getSenha() + "' ";
        Query query = em.createQuery(hql);
        
        usuarioEncontrado = (Professor) query.getSingleResult();
        
        if(usuarioEncontrado != null){
            return usuarioEncontrado;
        } 
        
        return usuarioEncontrado;
    }

    @Override
    public Professor find(Professor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}