/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.InventoryDB;
import dataaccess.ItemDB;
import domain.Company;
import domain.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        /** Not used right now **/
        //String username = (String) session.getAttribute("username");
        
        InventoryDB invDB = new InventoryDB();
        
       /* List<Inventory> inventory = new ArrayList<Inventory>();
        try {
            inventory = (List<Inventory>) invDB.getAll(curr);
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        ItemDB itemDB = new ItemDB();
        
        List<Item> itemsList = new ArrayList<Item>();
        
       /* for(int i = 0; i < inventory.size(); i++)
        {
            try {
                itemsList.add(itemDB.get(1));
            } catch (Exception ex) {
                Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
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
        getServletContext().getRequestDispatcher("/WEB-INF/equipmentmanager.jsp").forward(request, response);
    }

}
