package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {

    public NoAppScopeListener() {
        // TODO Auto-generated constructor stub
    }


    public void attributeAdded(ServletContextAttributeEvent scae)  {
         System.out.println("アプリケーションスコープにインスタンスを保存しようとしています");
    }


    public void attributeRemoved(ServletContextAttributeEvent scae)  {
         // TODO Auto-generated method stub
    }


    public void attributeReplaced(ServletContextAttributeEvent scae)  {
         // TODO Auto-generated method stub
    }

}
