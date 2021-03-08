package servlets;

import dataaccess.AddressDB;
import dataaccess.CompanyPersonAddressDB;
import dataaccess.CompanyPersonPhoneDB;
import dataaccess.CompanypersonDB;
import dataaccess.CompanyPositionsDB;
import dataaccess.LoginDB;
import dataaccess.PersonDB;
import dataaccess.PhoneDB;
import domain.Address;
import domain.Company;
import domain.Companyperson;
import domain.Companypersonaddress;
import domain.Companypersonphone;
import domain.Companypositions;
import domain.Logins;
import domain.Person;
import domain.Phone;
import domain.Typelibrary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 809968
 */
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // DQ: This segment will probably be replaced by a filter
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login");
            return;
        }

        int userID = (Integer) session.getAttribute("userID");
        Logins logins = new Logins();
        String logout = request.getParameter("logout");
        String company = request.getParameter("company");
        String equipment = request.getParameter("equipment");
        String companyWelcome = request.getParameter("companyWelcome");
        String manual = request.getParameter("manual");
        LoginDB logindb = new LoginDB();

        try {
            List<Logins> loginList = logindb.getAll();
            for (Logins login : loginList) {
                if (login.getUserId() == userID) {
                    logins = login;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(companyWelcomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Test data.    Must be deleted when finished.
      //Company curr = new Company(1);

        Company curr = logins.getCompanyID();
        if(logins.getCompanyID().getCompanyID() == null)
        {
           request.setAttribute("companyName", "Welcome Motive Safety Admin!"); 
        }
        else
        {
        request.setAttribute("companyName", logins.getCompanyID().getDescription());
        }
        
        try {
            if (company != null) {
                response.sendRedirect("company");
                return;
            } else if (equipment != null) {
                response.sendRedirect("equipmentmanager");
                return;
            } else if (companyWelcome != null) {
                response.sendRedirect("companyWelcome");
                return;
            } else if (manual != null) {
                response.sendRedirect("manual");
                return;
            } else if (logout != null) {
                session.invalidate();
                session = request.getSession();
                response.sendRedirect("login");
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CompanypersonDB compPerDB = new CompanypersonDB();
        
        List<Companyperson> compPersonList = new ArrayList<Companyperson>();
        
        try {
            compPersonList = (List<Companyperson>) compPerDB.getAll(curr);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("employeeList", compPersonList);

        getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        // DQ: This segment will probably be replaced by a filter
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login");
            return;
        }

        int userID = (Integer) session.getAttribute("userID");
        Logins logins = new Logins();
        LoginDB logindb = new LoginDB();

        try {
            List<Logins> loginList = logindb.getAll();
            for (Logins login : loginList) {
                if (login.getUserId() == userID) {
                    logins = login;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(companyWelcomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Company curr = logins.getCompanyID();
        Person loggedIn = logins.getPersonID();
        
        String action = request.getParameter("action");
        
        /**Database stuff, do not touch.**/
        CompanypersonDB compPersonDB = new CompanypersonDB();
        PersonDB personDB = new PersonDB();
        AddressDB addressDB = new AddressDB();
        CompanyPersonAddressDB compAddDB = new CompanyPersonAddressDB();
        PhoneDB phoneDB = new PhoneDB();
        CompanyPersonPhoneDB compPhoneDB = new CompanyPersonPhoneDB();
        CompanyPositionsDB compPosDB = new CompanyPositionsDB();
                
        if(action.equals("Add"))  
        {

        }
        else if (action.equals("Edit"))
        {
            
        }
        else if (action.equals("Remove"))
        {
            String companyPersonIDString = request.getParameter("hidden_del_cp");
            String personIDString = request.getParameter("hidden_del_person");
            
            int companyPersonID = Integer.parseInt(companyPersonIDString);
            int personID = Integer.parseInt(personIDString);
            
            if(logins.getPersonID().getPersonID() == personID)
            {
                request.setAttribute("message", "You can't delete yourself!");
                doGet(request, response);
            }
            else
            {
                
            Companyperson cpToDelete = new Companyperson();
            Person personToDelete = new Person(3);
            Address addToDelete = new Address();
            List<Companypersonaddress> cpAddToDeleteList = new ArrayList<Companypersonaddress>();
            Phone phoneToDelete = new Phone();
            List <Companypersonphone> cpPhoneToDeleteList = new ArrayList<Companypersonphone>();
            
            List <Companypositions> cpPosition = new ArrayList<Companypositions>();
            Companypositions test= new Companypositions();
            
            Companypersonaddress cpAddToDelete = new Companypersonaddress();
            Companypersonphone cpPhoneToDelete = new Companypersonphone();
            
            LoginDB loginDB = new LoginDB();
            List<Logins> loginList = new ArrayList<Logins>();
            Logins t = new Logins();
            
            
            
            try {
                
                personToDelete = personDB.get(personID);
               
                cpToDelete = compPersonDB.get(companyPersonID);
                //Used to delete address and address lists.
                cpAddToDeleteList = compAddDB.getAll(cpToDelete);

                //Used to delete the phones and phone lists.
               cpPhoneToDeleteList = compPhoneDB.getAll(cpToDelete);
               
               cpPosition = compPosDB.getAll();

               
                //Deletes the addresses.
                for (int i = 0; i < cpAddToDeleteList.size(); i++)
                {
                    addToDelete = cpAddToDeleteList.get(i).getAddressID();
                    addressDB.delete(addToDelete);
                }

                for (int i = 0; i < cpPhoneToDeleteList.size(); i++)
                {
                    phoneToDelete = cpPhoneToDeleteList.get(i).getPhoneID();
                    phoneDB.delete(phoneToDelete);
                }          


                //personDB.delete(personToDelete);
                //Deletes company person
                //compPersonDB.delete(cpToDelete);
                //Deletes person

                
                request.setAttribute("message", "Successfully Deleted: " + personToDelete.getFirstName() + " " + personToDelete.getLastName());
                doGet(request, response);      
                } catch (Exception ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", ex);
                     doGet(request, response);   
                }
            }
            
            
        }
        

        //getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);

    }
}
