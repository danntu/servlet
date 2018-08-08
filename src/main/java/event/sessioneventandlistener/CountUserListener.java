package event.sessioneventandlistener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUserListener implements HttpSessionListener {

    ServletContext servletContext = null;
    static int total = 0, current = 0;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        total++;
        current++;

        servletContext = httpSessionEvent.getSession().getServletContext();
        servletContext.setAttribute("totalusers",total);
        servletContext.setAttribute("currentusers",current);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        current--;
        servletContext.setAttribute("currentusers",current);
    }
}
