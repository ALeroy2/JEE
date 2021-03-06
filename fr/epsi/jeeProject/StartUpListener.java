package fr.epsi.jeeProject;

import fr.epsi.jeeProject.jmx.Premier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.lang.management.ManagementFactory;

@WebListener()
public class StartUpListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger logger = LogManager.getLogger(StartUpListener.class);

    // Public constructor is required by servlet spec
    public StartUpListener() {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = null;

        try {
            name = new ObjectName("fr.epsi.jmx:type=PremierMBean");
            Premier mbean = new Premier();

            mbs.registerMBean(mbean, name);

        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        logger.debug("Lancement de l'application");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
        logger.debug("Fermeture de l'application");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        logger.debug("Ouverture de la session");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        logger.debug("Fermeture de la session");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}