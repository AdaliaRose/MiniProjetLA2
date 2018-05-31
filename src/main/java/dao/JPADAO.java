/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author mac-clement
 */
public abstract class JPADAO<T> implements GenericDAO<T> {

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bulletin");
    final EntityManager em = emf.createEntityManager();

    @Override
    public boolean update(T object) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(object);
        et.commit();

        return true;
    }

    @Override
    public boolean create(T object) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(object);

        et.commit();

        return true;
    }

    @Override
    public boolean delete(T object) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(object);
        et.commit();

        return true;
    }

    @Override
    public void close() {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.close();
        et.commit();

    }

}
