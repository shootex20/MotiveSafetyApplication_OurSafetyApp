package servlets;


import dataaccess.ManualDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Manual;

public class ManualServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ManualDB manualDB = new ManualDB(); 
        ArrayList<Manual> manuals = new ArrayList<>();
        
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);

    }

}
