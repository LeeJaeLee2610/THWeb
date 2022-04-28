    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductID;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author LeeJaeLee
 */
public class ProductUpdateController extends HttpServlet {

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
        String btn = request.getParameter("btn-up");
        String id = request.getParameter("id");
        String action = request.getParameter("action");
        ProductID dao = new ProductID();
        if(action == null){
            Product ptmp = dao.getProductByID(id);
            String v1 = ptmp.getCode();
            String v2 = ptmp.getDescription();
            String v3 = String.valueOf(ptmp.getPrice());
            String v4 = String.valueOf(ptmp.getId());
            request.setAttribute("v1", v1);
            request.setAttribute("v2", v2);
            request.setAttribute("v3", v3);
            request.setAttribute("v4", v4);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
        if(action.equals("update")){
            String pid = request.getParameter("pid");
            String code = request.getParameter("code");
            String des = request.getParameter("description");
            String price = request.getParameter("price");
            String mes1 = "";
            String mes2 = "";
            String mes3 = "";
            boolean ok = true;
            if(code.isEmpty()){
                ok = false;
                mes1 = "Nhập code";
            }
            if(des.isEmpty()){
                ok = false;
                mes2 = "Nhập description";
            }
            if(price.isEmpty()){
                ok = false;
                mes3 = "Nhập price";
            }
            if(checkPrice(price)){
                ok = false;
                mes3 = "Nhập số thập phân";
            }
            if(ok){
    //            dao.addProduct(new Product(code, des, Double.parseDouble(price)));
                dao.updateProduct1(pid, code, des, price);
                request.getRequestDispatcher("ProductsController").forward(request, response);
            }
            else{
                request.setAttribute("mes1", mes1);
                request.setAttribute("mes2", mes2);
                request.setAttribute("mes3", mes3);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private boolean checkPrice(String price) {
        String reg = "^[0-9.]";
        if(Pattern.matches(reg, price)){
            return true;
        }
        return false;
    }

}
