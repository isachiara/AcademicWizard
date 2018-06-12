/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daoutil;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author henri
 */
public interface DAO <E> {
    
    public EntityManager getEntityManager();

    void create(E entity) throws RollbackFailureException, Exception;

    void edit(E entity) throws NonexistentEntityException, Exception;

    void destroy(E entity) throws NonexistentEntityException, IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception;

    public E find(E entity);
}
