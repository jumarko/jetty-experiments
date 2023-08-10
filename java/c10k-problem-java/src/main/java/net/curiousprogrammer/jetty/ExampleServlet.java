package net.curiousprogrammer.jetty;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

// See https://www.vogella.com/tutorials/Jetty/article.html
public class ExampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"status\": \"ok\"}");
    }

     public static void main(String[] args) throws Exception {
        var server = new Server(3000);

        var handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(ExampleServlet.class, "/*");
        server.start();
        server.join();
    }

}