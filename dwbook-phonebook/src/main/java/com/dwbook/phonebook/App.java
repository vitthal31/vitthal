package com.dwbook.phonebook;

import com.dwbook.phonebook.dao.UserLoginDAO;
import com.dwbook.phonebook.dao.impl.UserLoginDAOImpl;
import com.dwbook.phonebook.entity.UserLoginEntity;
import com.dwbook.phonebook.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App extends Application<PhonebookConfiguration> {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(PhonebookConfiguration t, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");

        // Create a DBI factory and build a JDBI instance
        final UserLoginDAO employeeDAO
                = new UserLoginDAOImpl(hibernateBundle.getSessionFactory());

        e.jersey().register(new UserResource(employeeDAO));

    }

    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<PhonebookConfiguration> hibernateBundle
            = new HibernateBundle<PhonebookConfiguration>(
                    UserLoginEntity.class
            ) {

                @Override
                public DataSourceFactory getDataSourceFactory(
                        PhonebookConfiguration configuration
                ) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(
            final Bootstrap<PhonebookConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

}
