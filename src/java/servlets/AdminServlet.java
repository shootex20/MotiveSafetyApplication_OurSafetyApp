package servlets;

import dataaccess.CompanyDB;
import domain.Company;
import domain.Person;
import dataaccess.PersonDB;
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
         CompanyDB cs = new CompanyDB();
         CompanyService compservice = new CompanyService();
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
         
         
        
       
        List<Company> comp = new ArrayList<Company>();        
        try {
            comp = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("company", comp);
        
        // for logins 
        
         PersonDB pdb = new PersonDB();
         String actionM = request.getParameter("actionM");
         
          
         List<Person> personUser = new ArrayList<Person>();
        try {
      
            personUser = pdb.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         request.setAttribute("person", personUser);
        
           /**
         if (actionM != null && actionM.equals("view")) {
            Integer selectedManager = Integer.parseInt(request.getParameter("selectedManager"));
            try {
                Logins login = mdb.get(selectedManager);
                request.setAttribute("selectedMan", login);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        **/
        
        
        
        
        

        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         CompanyService cs = new CompanyService();
            String action = request.getParameter("action");
           // Integer companyid = Integer.parseInt(request.getParameter("compid"));
            Date dateAdded = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String tempDate = sdf.format(dateAdded);
            
        try {        
            dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
        } catch (ParseException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
            String compname = request.getParameter("compname");
            String shortname = request.getParameter("shortname");
            String description = request.getParameter("description");
            String account = request.getParameter("account");
            String industry = request.getParameter("industry");
            
            
            try {
                if (action.equals("delete")) {
                    Integer selectedCompany = Integer.parseInt(request.getParameter("selectedCompany"));
                    cs.delete(selectedCompany);
                } 
                else if (action.equals("add")) {
                    cs.insert(dateAdded, compname, shortname, description, account, industry);
                }
            } catch (Exception ex) {
                request.setAttribute("errorMessage", "An error occured.");
            }
            
            CompanyDB cd = new CompanyDB();
            
            /**
             List<Company> comp = new ArrayList<Company>();        
        try {
            comp = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("company", comp);
            
            
            **/
            
            List<Company> comps = new ArrayList<Company>(); 
            try {
                comps = (List<Company>) cs.getAll();
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("company", comps);
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

    }


}