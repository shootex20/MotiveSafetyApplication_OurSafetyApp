package servlets;


import dataaccess.ManualDB;
import dataaccess.TypeLibraryDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Manual;
import domain.Typelibrary;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import services.ManualService;
public class ManualServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
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
        
 // set type library list       
         TypeLibraryDB typeDB = new TypeLibraryDB();
        
        List<Typelibrary> typeList = new ArrayList<Typelibrary>();
        
        try {
            typeList = (List<Typelibrary>) typeDB.getAll();
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(typeList.get(1).getTypeLibraryID());
        List<Typelibrary> equipList = new ArrayList<Typelibrary>();
        
        for(int i = 0; i < typeList.size(); i++)
        {
            if(typeList.get(i).getTypeLibraryID() > 100 && typeList.get(i).getTypeLibraryID() < 200)
            {
                equipList.add(typeList.get(i));
            }
        }
// set equipment type for dropdown box of add manual       
        request.setAttribute("types", equipList);

        String action = request.getParameter("action");
        if(action != null && action.equals("addform")){
            request.setAttribute("selectedAdd", "clicked");
        }
                
        if (action != null && action.equals("view")) {
            
            String manualid = request.getParameter("manualID");
            int manualID = Integer.parseInt(manualid);
            try {
                Manual manual = manualDB.get(manualID);
                request.setAttribute("selectedManual", manual);
                List<Typelibrary> manualList = new ArrayList<Typelibrary>();
                manualList.add(manual.getTypeLibraryID());
                for(Typelibrary m: equipList){
                    if(m.equals(manual.getTypeLibraryID())){
                       
                    }else{
                         manualList.add(m);
                    }
                }
//reset the dropdown box for edit manual view               
                request.setAttribute("types", manualList);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        HttpSession session = request.getSession();
        int userID = (Integer) session.getAttribute("userID");
        String dateadded = request.getParameter("itemType");
        String title = request.getParameter("title");
        String intention = request.getParameter("intention");
        String content = request.getParameter("content");
        String action = request.getParameter("action");
        ManualService manualService = new ManualService();
        ManualDB manualDB = new ManualDB();
        
        String typeLibraryid = request.getParameter("manualType");
        if(typeLibraryid != null){
        int typeLibraryID = Integer.parseInt(typeLibraryid);
//get typelibrary Object
        TypeLibraryDB typeDB = new TypeLibraryDB();    
        Typelibrary typeLibrary = new Typelibrary();
        List<Typelibrary> typeList = new ArrayList<Typelibrary>();       
        try {
            typeList = (List<Typelibrary>) typeDB.getAll();
            for(Typelibrary t: typeList){
                if(t.getTypeLibraryID() == typeLibraryID){
                        typeLibrary = t;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EquipmentManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 // Parse dateAdded       
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        try {
            dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
        } catch (ParseException ex) {
            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(action.equals("add")){
            try {
                manualService.insert(dateAdded, userID, typeLibrary, title, intention, content);
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action.equals("edit")){
            String manualid = request.getParameter("manualID");
            int manualID = Integer.parseInt(manualid);
            try {               
                manualService.update(manualID, dateAdded, userID, typeLibrary, title, intention, content);
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action.equals("delete")){
            String manualid = request.getParameter("manualID");
            int manualID = Integer.parseInt(manualid);
            try {
//                manualService.delete(manualID);
                request.setAttribute("test", manualID);
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
        else{
            if(action.equals("delete")){
                 String manualid = request.getParameter("manualID");
                 int manualID = Integer.parseInt(manualid);
                 
                 
              try {
                manualService.delete(manualID);
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);
    }

}
