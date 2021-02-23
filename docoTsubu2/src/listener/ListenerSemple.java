package listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ListenerSemple implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  {
         ServletContext context = sce.getServletContext();
         Integer count = 100;
         context.setAttribute("count", count);
    }

}
