package com.raghsonline.miniprojects.tms.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class TMSListener
 *
 */
@WebListener
public class TMSListener implements 
	ServletContextListener, ServletContextAttributeListener, 
	HttpSessionListener, ServletRequestListener, 
	ServletRequestAttributeListener, HttpSessionAttributeListener, 
	HttpSessionBindingListener, HttpSessionActivationListener 
{

	Logger logger = Logger.getLogger(TMSListener.class);
	
	boolean userLoggedIn = false;
	
    /**
     * Default constructor. 
     */
    public TMSListener() {
    	logger.info("TMSListener - instantiated");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        logger.info("sessionCreated, sessioEvent : " + se);
     	logger.info("... event class : " + se.getClass().getName());
     	Object source = se.getSource();
     	logger.info("... Source : " + source);    
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	logger.info("attributeRemoved, servletContextAttributeEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	logger.info("attributeAdded, servletRequestAttributeEvent : " + srae);
    	logger.info("... event class : " + srae.getClass().getName());
    	Object source = srae.getSource();
    	Object value = srae.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	logger.info("attributeReplaced, httpSessionBindingEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	HttpSession session = event.getSession();
    	logger.info("... Session : " + session);
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent se)  { 
    	logger.info("sessionWillPassivate, httpSessionEvent : " + se);
    	logger.info("... event class : " + se.getClass().getName());
    	Object source = se.getSource();
    	HttpSession session = se.getSession();
    	logger.info("... Session : " + session);
    	logger.info("... Source : " + source);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	logger.info("contextInitialized, servletContextEvent : " + sce);
    	logger.info("... event class : " + sce.getClass().getName());
    	Object source = sce.getSource();
    	ServletContext context = sce.getServletContext();
    	logger.info("... context : " + context);
    	logger.info("... Source : " + source);
    	
    	sce.getServletContext().setAttribute("userAvailable", userLoggedIn);
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
    	logger.info("attributeAdded, ServletContextAttributeEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	logger.info("requestDestroyed, ServletRequestEvent : " + sre);
    	logger.info("... event class : " + sre.getClass().getName());
    	Object source = sre.getSource();
    	Object request = sre.getServletRequest();
    	logger.info("... Source : " + source);
    	logger.info("... request : " + request);
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	logger.info("attributeRemoved, ServletRequestAttributeEvent : " + srae);
    	logger.info("... event class : " + srae.getClass().getName());
    	Object source = srae.getSource();
    	Object value = srae.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	logger.info("requestInitialized, ServletRequestEvent : " + sre);
    	logger.info("... event class : " + sre.getClass().getName());
    	Object source = sre.getSource();
    	logger.info("... Source : " + source);
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
    	logger.info("valueBound, HttpSessionBindingEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	logger.info("sessionDestroyed, HttpSessionEvent : " + se);
    	logger.info("... event class : " + se.getClass().getName());
    	Object source = se.getSource();
    	Object session = se.getSession();
    	logger.info("... Source : " + source);
    	logger.info("... Session : " + session);
    }

	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent se)  { 
    	logger.info("sessionDidActivate, HttpSessionEvent : " + se);
    	logger.info("... event class : " + se.getClass().getName());
    	Object source = se.getSource();
    	Object session = se.getSession();
    	logger.info("... Source : " + source);
    	logger.info("... Session : " + session);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	logger.info("contextDestroyed, ServletContextEvent : " + sce);
    	logger.info("... event class : " + sce.getClass().getName());
    	Object source = sce.getSource();
    	ServletContext context = sce.getServletContext();
    	logger.info("... Source : " + source);
    	logger.info("... Context : " + context);
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	logger.info("attributeReplaced, ServletRequestAttributeEvent : " + srae);
    	logger.info("... event class : " + srae.getClass().getName());
    	Object source = srae.getSource();
    	Object value = srae.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	logger.info("attributeAdded, HttpSessionBindingEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	logger.info("attributeRemoved, HttpSessionBindingEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value); 
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	logger.info("attributeReplaced, ServletContextAttributeEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value); 
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	logger.info("valueUnbound, HttpSessionBindingEvent : " + event);
    	logger.info("... event class : " + event.getClass().getName());
    	Object source = event.getSource();
    	Object value = event.getValue();
    	logger.info("... Source : " + source);
    	logger.info("... Value : " + value); 
    }
	
}
