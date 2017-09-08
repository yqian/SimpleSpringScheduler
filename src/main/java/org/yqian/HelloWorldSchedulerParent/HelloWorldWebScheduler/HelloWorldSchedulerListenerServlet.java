package org.yqian.HelloWorldWebScheduler;
import javax.servlet.ServletContextEvent;import javax.servlet.ServletContextListener;import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@WebListenerpublic class HelloWorldSchedulerServlet implements ServletContextListener {
private AnnotationConfigApplicationContext applicationContext = null;
public void contextDestroyed(ServletContextEvent arg0) {applicationContext.close();}
public void contextInitialized(ServletContextEvent arg0) {applicationContext = new AnnotationConfigApplicationContext(HelloWorldScheduler.class);}}
