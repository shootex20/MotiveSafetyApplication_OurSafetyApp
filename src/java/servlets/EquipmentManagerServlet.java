/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.CompanyDB;
import dataaccess.ItemDB;
import domain.Company;
import domain.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        
        String action = request.getParameter("action");
        //Inventory inv = new Inventory();
        HttpSession session = request.getSession();
        
        Company curr = new Company(1);
        
        ItemDB itemDB = new ItemDB();
        
        Item newItem = null;
        
        List<Item> itemsList = new ArrayList<Item>();
        
        
        try {
            itemsList = (List<Item>) itemDB.getAll(curr);
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("equipment", itemsList);
        
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
        
        String action = request.getParameter("action");
        
        Company comp = new Company(1);
        
        CompanyDB compDB = new CompanyDB();
        
        try {
            comp = compDB.get(comp.getCompanyID());
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Equipment equip = new Equipment();
        
        if(action.equals("Add"))
        {
        String model = request.getParameter("model");
        String serial = request.getParameter("serialnumber");
        String information = request.getParameter("itemClassInformation");
        Boolean isChargeable = Boolean.parseBoolean(request.getParameter("isChargeable"));
        Boolean isDepleting = Boolean.parseBoolean(request.getParameter("isDepleting"));
        Boolean isDepreactiationType = Boolean.parseBoolean(request.getParameter("isDepreactiationType"));
        //Parses the date to java format date.
        String date = request.getParameter("datePurchased");
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAdded;
        dateAdded = new Date();
        String tempDate = formatter.format(dateAdded);
        Date datePurchased = null;

            /*End of Java data parse.*/
            try {
                /*Formats the created date*/
                dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
                /*Formats the date purchased.*/
                datePurchased = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                /*Inserst*/
                equip.insert(dateAdded, model, isChargeable, isDepleting, isDepreactiationType, information, serial, datePurchased, comp);
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        else if(action.equals("Delete"))
        {
            String id = request.getParameter("itemID");
            System.out.print(id);
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