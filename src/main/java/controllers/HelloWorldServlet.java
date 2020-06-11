package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String name = request.getParameter("name");
       String flavor = "red";


       if(name == null) {
           flavor = "green";
           name = "World";
       } else if (name.equals("fer")){
           flavor = "white";
       } else if(name.equals("bgates")) {
           response.sendRedirect("https://microsoft.com");
           return;
       }

       //THESE LINES CREATES FIELDS IN THE REQUEST TO BE USED IN THE FRONT END (VIEWS)
       request.setAttribute("name", name.toUpperCase());
       request.setAttribute("tea", flavor);
       //CONNECTS THE CONTROLLER TO THE VIEW
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
     }
}
