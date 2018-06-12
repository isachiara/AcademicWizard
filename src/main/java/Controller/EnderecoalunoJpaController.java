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
import Model.Aluno;
import java.io.Serializable;
import Model.Enderecoaluno;
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
public class EnderecoalunoJpaController implements Serializable, DAO<Enderecoaluno> {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AcademicPU");
    
    @Override
    public EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    @Override
    public void create(Enderecoaluno enderecoAluno) throws RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(enderecoAluno);
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

    @Override
    public void edit(Enderecoaluno enderecoAluno) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(enderecoAluno);
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

    @Override
    public void destroy(Enderecoaluno enderecoAluno) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            Enderecoaluno enderecoAlunoRemove = em.merge(enderecoAluno);

            et.begin();
            em.remove(enderecoAlunoRemove);
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

    public Enderecoaluno findEnderecoaluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enderecoaluno.class, id);
        } finally {
            em.close();
        }
    }

    public Enderecoaluno findEnderecoPorAluno(Aluno aluno) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery(
                "SELECT e FROM Enderecoaluno e WHERE e.idEndereco LIKE :aluno", Enderecoaluno.class);
        q.setParameter("aluno", aluno.getEnderecoaluno().getIdEndereco());

        Enderecoaluno resultado = (Enderecoaluno) q.getSingleResult();
        return resultado;

    }

    @Override
    public Enderecoaluno find(Enderecoaluno entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
