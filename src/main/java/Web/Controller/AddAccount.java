package Web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Web.DAO.ProductDAO;
@WebServlet(urlPatterns = "/AddA")
public class AddAccount extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String name = req.getParameter("name");
	String pass = req.getParameter("pass");
	String isSell = req.getParameter("isSell");
	String isAdmin = req.getParameter("isAdmin");
	ProductDAO dao = new ProductDAO();
	dao.AddAccount(isAdmin, pass, 0, 0);
	resp.sendRedirect("managerAccount");
}
}	
