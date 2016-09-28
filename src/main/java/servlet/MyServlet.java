package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/status"}
    )
public class MyServlet extends HttpServlet {
/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("IF YOU ARE SEEING THIS THEN IT IS WORKING".getBytes());
        out.flush();
        out.close();
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();
        out.write(out.write(request.getParameter("age").getBytes());
        out.flush();
        out.close();
    }

    
}
