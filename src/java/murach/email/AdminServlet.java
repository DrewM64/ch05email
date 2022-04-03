/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.email;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import murach.business.TechSupport;
import murach.data.TechSupportDB;

/**
 *
 * @author Andrew M
 * Routing to admin pages
 * Handle validation for required fields and number format (phone number field)
 * routing to edit page pre-populates fields with employee info
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

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
        
        String url = "/view_tech_support.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "view";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("view")) {
            url = "/view_tech_support.jsp";    // the "view" page
            
            //get list of TechSupport objects to populate table
            ArrayList<TechSupport> techSupport = TechSupportDB.selectTechs();
            request.setAttribute("techSupport", techSupport);
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phoneNumber = request.getParameter("phoneNumber");

            // store data in User object
            TechSupport tech = new TechSupport(email, firstName, lastName, phoneNumber);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null || phoneNumber == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() ) {
                message = "Please fill out all three text boxes.";
                url = "/add_tech_support.jsp";
            } 
            else {
                message = "";
                url = "/view_tech_support.jsp";
                TechSupportDB.insert(tech);
            }
            
            ArrayList<TechSupport> techSupport = TechSupportDB.selectTechs();
            
            request.setAttribute("techSupport", techSupport);
            request.setAttribute("message", message);
        
        } else if(action.equals("editButton")) {
            url = "/edit_tech_support.jsp";    // the "edit" page
            
            // get email of single tech from view_tech_support.jsp
            // get parameters from the request
            String email = request.getParameter("email");
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String phoneNumber = request.getParameter("phoneNumber");

            // store data in TechSupport object
            TechSupport tech = TechSupportDB.selectTech(email);
            //sends to edit_tech_support.jsp
            request.setAttribute("tech", tech);
            
        } else if(action.equals("edit")) {
            //recieves data from edit_tech_support.jsp
            //update the selected tech in database
            // get new Arraylist and send back to view_tech_support.jsp
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }  

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
