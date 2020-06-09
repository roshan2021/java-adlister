import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        System.out.println("name param = " + name);

        //If null print out default Hello World
        if(name == null) {
            out.println("<strong>Hello World!</strong>");
        //If not null, print out something else
        } else {
            out.println("<strong>Hello, " + name + "</strong>");
        }
    }
}
