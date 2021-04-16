/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.CompanyDB;
import dataaccess.ItemClassDB;
import dataaccess.ItemClassFieldsDB;
import dataaccess.ItemDB;
import dataaccess.LoginDB;
import dataaccess.TypeLibraryDB;
import domain.Company;
import domain.Item;
import domain.Itemclass;
import domain.Itemclassfields;
import domain.Logins;
import domain.Typelibrary;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.Equipment;

/**
 *
 * @author Chels
 */
@WebServlet(name = "InventoryServlet", urlPatterns = {"/InventoryServlet"})
public class EquipmentManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        request.getSession().setAttribute("token", token);
        request.setAttribute("token", token);

        int userID = (Integer) session.getAttribute("userID");
        Logins logins = new Logins();
        String logout = request.getParameter("action");
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
        //Company curr = new Company(1);

        String action = request.getParameter("action");
        ItemDB itemDB = new ItemDB();
        List<Item> itemsList = new ArrayList<Item>();

        try {
            itemsList = (List<Item>) itemDB.getAll(curr);
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("equipment", itemsList);

        TypeLibraryDB typeDB = new TypeLibraryDB();

        List<Typelibrary> typeList = new ArrayList<Typelibrary>();

        try {
            typeList = (List<Typelibrary>) typeDB.getAll();
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(typeList.get(1).getTypeLibraryID());
        List<Typelibrary> equipList = new ArrayList<Typelibrary>();

        for (int i = 0; i < typeList.size(); i++) {
            if (typeList.get(i).getTypeLibraryID() > 200 && typeList.get(i).getTypeLibraryID() < 300) {
                equipList.add(typeList.get(i));
            }
        }

        request.setAttribute("types", equipList);

        getServletContext().getRequestDispatcher("/WEB-INF/equipmentmanager.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String tokenInput = request.getParameter("token");

        if (tokenInput != null) {
            String tokenSession = (String) request.getSession().getAttribute("token");

            if (tokenInput.equals(tokenSession)) {

                int userID = (Integer) session.getAttribute("userID");
                Logins logins = new Logins();
                String logout = request.getParameter("action");
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
                Company comp = logins.getCompanyID();

                //Company comp = new Company(1);
                String action = request.getParameter("action");
                CompanyDB compDB = new CompanyDB();
                Equipment equip = new Equipment();

                if (action.equals("addform")) {

                    String type = request.getParameter("itemType");
                    int typeID = Integer.parseInt(type);

                    List<Typelibrary> typeArray = new ArrayList<Typelibrary>();
                    TypeLibraryDB typeDB = new TypeLibraryDB();
                    Typelibrary typeOfCat = new Typelibrary();

                    try {
                        typeArray = typeDB.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    for (int i = 0; i < typeArray.size(); i++) {
                        if (typeID == typeArray.get(i).getTypeLibraryID()) {
                            typeOfCat = typeArray.get(i);
                        }
                    }

                    List<Itemclassfields> icfList = new ArrayList<Itemclassfields>();
                    ItemClassFieldsDB icfDB = new ItemClassFieldsDB();
                    Itemclassfields icf = new Itemclassfields();

                    try {
                        icfList = icfDB.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    List<Itemclass> icList = new ArrayList<Itemclass>();
                    ItemClassDB icDB = new ItemClassDB();
                    Itemclass ic = new Itemclass();

                    for (int i = 0; i < icfList.size(); i++) {
                        if (typeOfCat.getTypeLibraryID() == icfList.get(i).getTypeLibraryID().getTypeLibraryID()) {
                            icf = icfList.get(i);
                        }
                    }

                    try {
                        icList = icDB.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    for (int i = 0; i < icList.size(); i++) {
                        if (icf.getItemClassFieldsID() == icList.get(i).getItemClassFieldsID().getItemClassFieldsID()) {
                            ic = icList.get(i);
                        }
                    }

                    request.setAttribute("question", ic.getItemClassInformation());
                    /*Hidden value, this is required.**/
                    request.setAttribute("selectedType", type);
                    doGet(request, response);
                } else if (action.equals("Add")) {
                    String model = request.getParameter("model");
                    String serial = request.getParameter("serialnumber");
                    String information = request.getParameter("itemClassInformation");
                    Boolean isChargeable = Boolean.parseBoolean(request.getParameter("isChargeable"));
                    Boolean isDepleting = Boolean.parseBoolean(request.getParameter("isDepleting"));
                    Boolean isDepreactiationType = Boolean.parseBoolean(request.getParameter("isDepreactiationType"));
                    String date = request.getParameter("datePurchased");

                    Date dateAdded = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String tempDate = formatter.format(dateAdded);
                    Date datePurchased = null;

                    try {
                        /*Formats the created date*/
                        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
                        /*Formats the date purchased.*/
                        datePurchased = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                        if (datePurchased.after(dateAdded)) {
                            request.setAttribute("message", "Purchase date cannot be past the current date!");
                            doGet(request, response);
                        } else {
                            /*Inserst*/
                            equip.insert(dateAdded, userID, model, isChargeable, isDepleting, isDepreactiationType, information, serial, datePurchased, comp);
                            request.setAttribute("message", "Item added successfully.");
                            doGet(request, response);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (action.equals("Delete")) {
                    String id = request.getParameter("itemID");
                    int intid = Integer.parseInt(id);
                    try {
                        equip.delete(intid);
                        request.setAttribute("message", "Item successfully deleted.");
                        doGet(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }

    }

}
