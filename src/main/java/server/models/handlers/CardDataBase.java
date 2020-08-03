package server.models.handlers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import server.models.cards.Card;

import java.io.Serializable;
import java.util.List;

public class CardDataBase {
    private  SessionFactory sessionFactory = buildSessionFactory();

    private  SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public <T> T fetch(Class<T> tClass, Serializable id) {
        Session session = sessionFactory.openSession();
        T t = session.get(tClass, id);
        session.close();
        return t;
    }

     public<E> List<E> fetchAll(Class<E> entity) {
        Session session = sessionFactory.openSession();
        List<E> list = session.createQuery("from " + entity.getName(), entity).getResultList();
        session.close();
        return list;
    }

    public <E> List<E> fetchWithCondition(Class<E> entity, String fieldName, Object value) {
        String sqlCode = "from " + entity.getName() + " where " + fieldName + "=" + "'" + value + "'";
        Session session = sessionFactory.openSession();
        List<E> list = session.createQuery(sqlCode, entity).getResultList();
        session.close();
        return list;
    }
}
