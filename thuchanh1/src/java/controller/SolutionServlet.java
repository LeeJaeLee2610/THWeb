/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import IOFile.UserIO;
import dao.UserDao;
import dao.ViewDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.View;

/**
 *
 * @author Legion 5
 */
public class SolutionServlet extends HttpServlet {

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
        String url = "index.jsp";
        String action = request.getParameter("action");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String mes1 = "";
        String mes2 = "";
        String mes3 = "";
        String mes4 = "";
        UserDao ud = new UserDao();
        List<User> list = ud.getAll();
        if(action.equals("Log In")){
            boolean ok1 = true;
            if(user.isEmpty()){
                ok1 = false;
                mes1 = "Nhap User";
            }
            if(pass.isEmpty()){
                ok1 = false;
                mes2 = "Nhap Pass";
            }
            if(ok1){
                for(User u:list){
                    if(u.getUser().toString().equalsIgnoreCase(user) && u.getPass().toString().equalsIgnoreCase(pass)){
                        request.setAttribute("data", u.getUser());
                        UserIO tmp = new UserIO();
                        if(tmp.doc("D:/webPTIT/thuchanh1/web/WEB-INF/Login.txt").toString().contains(u.getUser())){
                            mes3 = "Tai khoan da co trong Login.txt";
                        }
                        else{
                            tmp.viet(u, "D:/webPTIT/thuchanh1/web/WEB-INF/Login.txt");
                        }
                        request.setAttribute("mes3", mes3);
                        url = "webApp.jsp";
                        break;
                    }
                }
            }
            else{
                mes3 = "Tai khoan khong ton tai";
                request.setAttribute("mes3", mes3);
                request.setAttribute("mes1", mes1);
                request.setAttribute("mes2", mes2);
                url = "index.jsp";
            }
        }
        if(action.equals("Register")){
            url = "register.jsp";
        }
        ViewDao vd = new ViewDao();
        HttpSession session = request.getSession();
        if(session.isNew()){
            vd.updateView();
        }
        int view = vd.getView();
        session.setAttribute("view", view);
        request.getRequestDispatcher(url).forward(request, response);
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
