package servlets;


import dataaccess.ManualDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Manual;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class ManualServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login");
            return;
        }
        
        
        ManualDB manualDB = new ManualDB();         
        int userID = (Integer) session.getAttribute("userID");
        ArrayList <Manual> currentManual = new ArrayList();
        
        try {
            List <Manual> manual = manualDB.getAll();
            for (Manual m: manual){
                if (m.getUserAdded() == userID) {
                    currentManual.add(m);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("manualList", currentManual);
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);

    }

}
