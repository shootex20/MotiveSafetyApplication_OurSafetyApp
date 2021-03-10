package servlets;

import dataaccess.CompanyDB;
import dataaccess.LoginDB;
import domain.Company;
import domain.Person;
import dataaccess.PersonDB;
import domain.Logins;
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
import services.LoginService;

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
        
         LoginDB pdb = new LoginDB();
         String actionM = request.getParameter("actionM");
         
          
       //  List<Person> personUser = new ArrayList<Person>();
       List<Logins> loginUser = new ArrayList<Logins>();
       
        try {
      
            loginUser = pdb.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         request.setAttribute("logins", loginUser);
        
           
         if ((actionM != null && actionM.equals("view"))) {
            Integer selectedManager = Integer.parseInt(request.getParameter("selectedMan"));
           
            try {
                Logins login = pdb.get(selectedManager);
               // Company compsel = cs.get(selectedCompany);
               // Company comp = cs.get(selectedCompany);
                request.setAttribute("selectedMan", login);
                 
                //request.setAttribute("selectedComp", compsel);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      
                    CompanyService cs = new CompanyService();
                    LoginService ls = new LoginService();
                    
                    
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
                        } else if (action.equals("edit")) {
                           
                           Integer id = Integer.parseInt(request.getParameter("id"));
                            cs.update(id, compname, shortname, description, account, industry);
                        }
                        else if (action.equals("add")) {
                            cs.insert(dateAdded, compname, shortname, description, account, industry);
                        }
                    } catch (Exception ex) {
                        request.setAttribute("errorMessage", "An error occured.");
                    }
                    
                    
                    CompanyDB compID = new CompanyDB();
                    
                    
                    List<Company> comps = new ArrayList<Company>();
                    try {
                        comps = (List<Company>) cs.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("company", comps);
                    
                    
                    // for logins
                    Logins logins = new Logins();
                      Company compM = logins.getCompanyID();
                    String actionM = request.getParameter("actionM");
                    
                    // variables
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                  
                    /**int ss = Integer.parseInt(request.getParameter("userCompanyID"));
                    Company cc = new Company();
                    
                    CompanyDB companydb = new CompanyDB();
                    try {
                        cc = companydb.get(ss);

                        // Integer companySelectedId = Integer.parseInt(request.getParameter("userCompanyID"));
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    **/
                    
                   // System.out.print(companySelectedId);
                    
                    String active = request.getParameter("isActive");
                    String admin = request.getParameter("isAdmin");
                    // if statement if active/admin is null
                    Character isActive;
                    Character isAdmin;
                   
                    
                    try {
                        if (actionM.equals("deleteM")) {
                            Integer selectedManager = Integer.parseInt(request.getParameter("selectedMan"));
                            ls.delete(selectedManager);
                        }
                        else if (actionM.equals("addUser") & (admin != null && active != null) ) {
                            int ss = Integer.parseInt(request.getParameter("userCompanyID"));
                    Company cc = new Company();
                    
                    CompanyDB companydb = new CompanyDB();
                    try {
                        cc = companydb.get(ss);

                        // Integer companySelectedId = Integer.parseInt(request.getParameter("userCompanyID"));
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                            isActive = active.charAt(0);
                            isAdmin = admin.charAt(0);
                            
                            ls.insert(dateAdded, username, password, cc, isActive, isAdmin);
                        }
                    } catch (Exception ex) {
                        request.setAttribute("errorMessage", "An error occured.");
                    }
                    
                    LoginDB loginDB = new LoginDB();
                    
                    List<Logins> user = new ArrayList<Logins>();
                    
                    try {
                        
                        user = (List<Logins>) ls.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    request.setAttribute("logins", user);
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
            
       
       
    }


}