package Web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Web.DAO.ProductDAO;
@WebServlet(urlPatterns = "/deleteA")
public class AccountDelete extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Aid =req.getParameter("Aid");
		ProductDAO dao = new ProductDAO();
		dao.deleteA(Aid);
		resp.sendRedirect("managerAccount ");
	}
}
