package servlets;

import dataaccess.CompanyDB;
import domain.Company;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.CompanyService;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String action = request.getParameter("action");
         
         if (action != null && action.equals("view")) {
            Integer selectedCompany = Integer.parseInt(request.getParameter("selectedCompany"));
            try {
                Company comp = cs.get(selectedCompany);
                request.setAttribute("selectedComp", comp);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
        
        CompanyDB cs = new CompanyDB();
        List<Company> comp = new ArrayList<Company>();        
        try {
            comp = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("company", comp);

        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        try {
            
            CompanyService cs = new CompanyService();
            String action = request.getParameter("action");
            Integer companyid = Integer.parseInt(request.getParameter("compid"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            Date dateadded = sdf.parse(request.getParameter("dateadded"));
           
            String compname = request.getParameter("compname");
            String shortname = request.getParameter("shortname");
            String description = request.getParameter("description");
            String account = request.getParameter("account");
            String industry = request.getParameter("industry");
            
            
            try {
                if (action.equals("delete")) {
                    Integer selectedCompany = Integer.parseInt(request.getParameter("selectedCompany"));
                    cs.delete(selectedCompany);
                } else if (action.equals("edit")) {
                    cs.update(companyid, dateadded, compname, shortname, description, account, industry);
                } else if (action.equals("add")) {
                    cs.insert(companyid, dateadded, compname, shortname, description, account, industry);
                }
            } catch (Exception ex) {
                request.setAttribute("errorMessage", "An error occured.");
            }
            
            List<Company> comps = null;
            try {
                comps = (List<Company>) cs.getAll();
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("comps", comps);
            
            
            getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

}