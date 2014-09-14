import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.test.reflection.java.Foo;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {

    @Test
    public void givenEntityIsPersisted_thenException() throws IOException {
        SessionFactory sessionFactory = configureSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(new User());
        session.getTransaction().commit();
    }

    private SessionFactory configureSessionFactory() throws IOException {
        Configuration configuration = new Configuration();
        InputStream inputStream = this.getClass().getClassLoader().
                getResourceAsStream("hibernate-mysql.properties");
        Properties hibernateProperties = new Properties();
        hibernateProperties.load(inputStream);
        configuration.setProperties(hibernateProperties);

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}