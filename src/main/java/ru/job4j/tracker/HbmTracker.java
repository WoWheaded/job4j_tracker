package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean replaceItemById = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id);
            session.getTransaction().commit();
            replaceItemById = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return replaceItemById;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean deleteItemById = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            deleteItemById = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return deleteItemById;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemsAll = new ArrayList<>();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            itemsAll = session.createQuery(
                    "FROM Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemsAll;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemsByNameFounded = new ArrayList<>();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            itemsByNameFounded = session.createQuery(
                            "FROM Item as it WHERE it.name = :fName", Item.class)
                    .setParameter("fName", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemsByNameFounded;
    }

    @Override
    public Item findById(int id) {
        Item itemsByIdFounded = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            itemsByIdFounded = session.createQuery(
                            "FROM Item as it WHERE it.id = :fId", Item.class)
                    .setParameter("fId", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemsByIdFounded;
    }

    @Override
    public void close() throws Exception {

    }
}
