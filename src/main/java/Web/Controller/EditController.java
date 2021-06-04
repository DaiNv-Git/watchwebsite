package Web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Web.DAO.ProductDAO;
import Web.Model.Account;
@WebServlet(urlPatterns = "/edit")
public class EditController extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pId = req.getParameter("id");
	String name = req.getParameter("name");
	String image = req.getParameter("image");
	String price = req.getParameter("price");
	String title = req.getParameter("title");
	String description = req.getParameter("description");
	String pcategory = req.getParameter("category");
	ProductDAO dao = new ProductDAO();
	dao.EditProduct(name, image, price, title, description, pcategory);
	resp.sendRedirect("managerProduct");
}
}
