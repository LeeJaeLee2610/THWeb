/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import IOFile.UserIO;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Legion 5
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
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
//        processRequest(request, response);
            String url = "/register.jsp";
            String action = request.getParameter("action");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String mes1 = "";
            String mes2 = "";
            String mes3 = "";
            UserDao ud = new UserDao();
            List<User> list = ud.getAll();
            if(action.equals("Register"))
            {
                boolean ok2 = true;
                if(user.isEmpty()){
                    ok2 = false;
                    mes1 = "Nhap Email";
                }
                if(pass.isEmpty()){
                    ok2 = false;
                    mes2 = "Nhap Pass";
                }
                if(trungNhau(user, list)){
                    ok2 = false;
                    mes1 = "Tai khoan bi trung";
                }
                if(ok2){
                    User u = new User(user, pass);
                    try {
                        ud.insert(u);
                    } catch (Exception e) {
                    }
                    mes3 = "Dang ki thang cong";
                    url = "/index.jsp";
                    request.setAttribute("mes3", mes3);
                }
                else{
                    mes3 = "Khong thanh cong";
                    request.setAttribute("mes1", mes1);
                    request.setAttribute("mes2", mes2);
                    request.setAttribute("mes3", mes3);
                }
            }
        getServletContext().getRequestDispatcher(url).forward(request, response);
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

    private boolean trungNhau(String user, List<User> list) {
        for(User u:list){
            if(u.getUser().toString().equalsIgnoreCase(user)){
                return true;
            }
        }
        return false;
    }

}
