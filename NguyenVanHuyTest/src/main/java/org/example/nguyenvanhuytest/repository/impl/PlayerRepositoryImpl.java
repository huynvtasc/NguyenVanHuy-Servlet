package org.example.nguyenvanhuytest.repository.impl;

import org.example.nguyenvanhuytest.entity.Player;
import org.example.nguyenvanhuytest.entity.PlayerIndex;
import org.example.nguyenvanhuytest.repository.PlayerRepository;
import org.example.nguyenvanhuytest.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    @Override
    public List<Player> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Player ", Player.class).list();
        }
    }

    @Override
    public void save(Player player) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Player findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Player.class, id);
        }
    }

    @Override
    public void update(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.getTransaction();
            session.update(player);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Player player = session.get(Player.class, id);
            if (player != null) {
                session.delete(player);
                transaction.commit();
            }
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
