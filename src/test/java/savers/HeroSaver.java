package savers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import server.models.cards.Card;
import server.models.heroes.*;

public class HeroSaver {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    private static void saveHero(Hero hero) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(hero);
        session.getTransaction().commit();
        session.close();

    }

    public static void main(String[] args) {
        saveHero(new Mage());
        saveHero(new Rogue());
        saveHero(new Warlock());
        saveHero(new Paladin());
        saveHero(new Hunter());
    }
}
