package servlets;

import dataaccess.CompanypersonDB;
import dataaccess.LoginDB;
import dataaccess.ManualDB;
import dataaccess.TypeLibraryDB;
import domain.Company;
import domain.Companyperson;
import domain.Logins;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Manual;
import domain.Typelibrary;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import services.CompanypersonService;
import services.EmailService;
import services.ManualService;

public class ManualServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        request.getSession().setAttribute("token", token);
        request.setAttribute("token", token);

        String action = request.getParameter("action");
        String logout = request.getParameter("logout");
        String equipment = request.getParameter("equipment");
        String companyWelcome = request.getParameter("companyWelcome");
        String employee = request.getParameter("employee");

        try {
            if (equipment != null) {
                response.sendRedirect("equipmentmanager");
                return;
            } else if (employee != null) {
                response.sendRedirect("employee");
                return;
            } else if (companyWelcome != null) {
                response.sendRedirect("manual");
                return;
            } else if (logout != null) {
                session.invalidate();
                session = request.getSession();
                response.sendRedirect("login");
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
        }

        ManualDB manualDB = new ManualDB();
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
            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Company curr = logins.getCompanyID();
        CompanypersonDB compPerDB = new CompanypersonDB();
        ArrayList<Manual> currentManual = new ArrayList();

        try {
            List<Manual> manual = manualDB.getAll();
            for (Manual m : manual) {
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
            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(typeList.get(1).getTypeLibraryID());
        List<Typelibrary> equipList = new ArrayList<Typelibrary>();

        for (int i = 0; i < typeList.size(); i++) {
            if (typeList.get(i).getTypeLibraryID() > 100 && typeList.get(i).getTypeLibraryID() < 200) {
                equipList.add(typeList.get(i));
            }
        }

// Set employee list
        List<Companyperson> compPersonList = new ArrayList<Companyperson>();
        List<Companyperson> compPersonListNotActive = new ArrayList<Companyperson>();
        List<Companyperson> compPersonListActive = new ArrayList<Companyperson>();

        try {
            compPersonList = (List<Companyperson>) compPerDB.getAll(curr);
        } catch (Exception ex) {
            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < compPersonList.size(); i++) {
            if (compPersonList.get(i).getIsEmployeeActive() == false) {
                compPersonListNotActive.add(compPersonList.get(i));
            } else if (compPersonList.get(i).getIsEmployeeActive() == true) {
                compPersonListActive.add(compPersonList.get(i));
            }
        }

        request.setAttribute("employees", compPersonListActive);
        request.setAttribute("inActiveEmployeeList", compPersonListNotActive);

// set equipment type for dropdown box of add manual       
        request.setAttribute("types", equipList);
        if (action != null && action.equals("Add Form")) {
            request.setAttribute("selectedAdd", "clicked");
        } else if (action != null && action.equals("Send to Employee")) {
            request.setAttribute("selectedSend", "clicked");

            String manualid = request.getParameter("manualID");
            int manualID = Integer.parseInt(manualid);

            try {
                Manual manual = manualDB.get(manualID);
                request.setAttribute("selectedManual2", manual);
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (action != null && action.equals("Edit")) {

            String manualid = request.getParameter("manualID");
            int manualID = Integer.parseInt(manualid);
            try {
                Manual manual = manualDB.get(manualID);
                request.setAttribute("selectedManual", manual);
                List<Typelibrary> manualList = new ArrayList<Typelibrary>();
                manualList.add(manual.getTypeLibraryID());
                for (Typelibrary m : equipList) {
                    if (m.equals(manual.getTypeLibraryID())) {

                    } else {
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

        String tokenInput = request.getParameter("token");

        if (tokenInput != null) {
            String tokenSession = (String) request.getSession().getAttribute("token");

            if (tokenInput.equals(tokenSession)) {

                int userID = (Integer) session.getAttribute("userID");
                String dateadded = request.getParameter("itemType");
                String title = request.getParameter("title");
                String intention = request.getParameter("intention");
                String content = request.getParameter("content");
                String action = request.getParameter("action");
                String path = "";
                String fileName = "";
                ManualService manualService = new ManualService();
                ManualDB manualDB = new ManualDB();

                String typeLibraryid = request.getParameter("manualType");
                if (typeLibraryid != null) {
                    int typeLibraryID = Integer.parseInt(typeLibraryid);
//get typelibrary Object
                    TypeLibraryDB typeDB = new TypeLibraryDB();
                    Typelibrary typeLibrary = new Typelibrary();
                    List<Typelibrary> typeList = new ArrayList<Typelibrary>();
                    try {
                        typeList = (List<Typelibrary>) typeDB.getAll();
                        for (Typelibrary t : typeList) {
                            if (t.getTypeLibraryID() == typeLibraryID) {
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

                    if (action.equals("add")) {
                        try {
                            int count = 0;
                            Manual currManual = new Manual();
                            manualService.insert(dateAdded, userID, typeLibrary, title, intention, content);
                            ArrayList<Manual> currentManual = new ArrayList();

                            try {
                                List<Manual> manual = manualDB.getAll();
                                for (Manual m : manual) {
                                    if (m.getUserAdded() == userID) {
                                        currentManual.add(m);
                                    }
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            for (Manual m : currentManual) {
                                if (m.getManualID() > count) {
                                    currManual = m;
                                    count = m.getManualID();
                                }
                            }
                            int manualID = currManual.getManualID();
                            String id = Integer.toString(manualID);
                            String manualTitle = currManual.getTitle();
                            fileName = id + manualTitle + ".pdf";
                            path = performTask(request, response, fileName, title, content);
                            request.setAttribute("message", "Manual is successufully created");
                            doGet(request, response);
                        } catch (Exception ex) {
                            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (action.equals("edit")) {
                        String manualid = request.getParameter("manualID");
                        int manualID = Integer.parseInt(manualid);
                        try {
                            manualService.update(manualID, dateAdded, userID, typeLibrary, title, intention, content);
                            request.setAttribute("message", "Manual is successufully updated");
                            doGet(request, response);
                        } catch (Exception ex) {
                            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (action.equals("Delete")) {
                        String manualid = request.getParameter("manualID");
                        int manualID = Integer.parseInt(manualid);
                        try {
                            manualService.delete(manualID);
                            doGet(request, response);
                        } catch (Exception ex) {
                            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (action.equals("sendManual")) {
                        try {

                            doGet(request, response);
                        } catch (Exception ex) {
                            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    if (action.equals("Delete")) {
                        String manualid = request.getParameter("manualID");
                        int manualID = Integer.parseInt(manualid);

                        try {
                            manualService.delete(manualID);
                            request.setAttribute("message", "Manual is successufully deleted");
                            doGet(request, response);
                        } catch (Exception ex) {
                            Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (action.equals("sendManual")) {
// Send Email                
                 String employeeEmail = request.getParameter("emailSendTo");
                 String currTitle = "";
                 String currContent = "";
                 Manual manual = new Manual();
                
                 EmailService es = new EmailService();
          
                 
                 
                 
                 
            String manualid = request.getParameter("manualid");
            int manualID = Integer.parseInt(manualid);
            
            try {
                manual = manualDB.get(manualID);
                currTitle = manual.getTitle();
                currContent = manual.getContent();
            } catch (Exception ex) {
                Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
// Create PDF
                 String id = Integer.toString(manualID);
                 String manualTitle = manual.getTitle();
                 fileName = id + manualTitle + ".pdf";
                 path = performTask(request, response, fileName, currTitle, currContent);                
//                request.setAttribute("test", employeeEmail);
                try { 
                    es.sendMailWithAttachments(employeeEmail, "hello", "hello", path, false);
                    request.setAttribute("test", employeeEmail);
//to do the test change the email to your test email                    
//                    es.sendMailWithAttachments("dsijnvsd@gmail.com", "hello", "hello", path, false);
                    request.setAttribute("message", "Manual is successufully send to email " + employeeEmail);
                } catch (MessagingException ex) {
                    Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NamingException ex) {
                    Logger.getLogger(ManualServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                doGet(request, response);
                    }
                }
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/manual.jsp").forward(request, response);
    }

    private String performTask(HttpServletRequest request, HttpServletResponse response, String fileName, String currTitle, String currContent) throws ServletException,
            IOException {

        String AbsolutePath = getServletContext().getRealPath("/WEB-INF/pdfFiles");
        String quote = "\\";
        String path = AbsolutePath + quote + fileName;
        String escaped = path.replace("\\", "\\\\");

//               String useable_path = "C:\\Users\\809968\\Desktop\\PROJ-354 _Capstone\\Project\\Version_03_25\\MotiveSafetyApplication_OurSafetyApp\\web\\WEB-INF\\pdfFiles\\" + fileName;
        //Create pdf
        PDDocument document = new PDDocument();

        //Create Page
        PDPage page = new PDPage();

        //Adding the page
        document.addPage(page);

        //Adding content of PDF file
        PDPageContentStream content = new PDPageContentStream(document, page);
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 26);
        content.moveTextPositionByAmount(220, 750);
        content.drawString(currTitle);
        content.endText();

        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80, 700);
        content.drawString(currContent);
        content.endText();

        content.close();

        //Saving the document
        document.save(escaped);

        //Closing the document
        document.close();
        return escaped;
    }
}
