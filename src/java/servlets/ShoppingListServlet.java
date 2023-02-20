/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kelsey
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        
        if(action != null){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);    
        }else if(username != null){
            response.sendRedirect("ShoppingList");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        String add = request.getParameter("itemadd");
        String list = request.getParameter("items");
        ArrayList<String> itemlist = new ArrayList<>();
        HttpSession session = request.getSession();
        
        switch(action){
            case "register": if(username == null || username.equals("")){
                request.setAttribute("message", "Enter a name");
               getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);  
            }else{
                session.setAttribute("name", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request,response);
            }
            break;
            case "logout": itemlist.clear();
             session.invalidate();
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response); 
             break;
            case "add":itemlist.add(add);
            session.setAttribute("itemname",itemlist);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request,response);
             break;
            case "delete":itemlist.remove(list);
            session.setAttribute("itemname",itemlist);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request,response);
            break;    
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request,response);
    }

   
}
