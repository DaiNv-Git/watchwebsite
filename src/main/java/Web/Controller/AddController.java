package Web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Web.DAO.ProductDAO;
@WebServlet(urlPatterns = "/add")
public class AddController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String name = req.getParameter("name");
	String image = req.getParameter("image");
	String price = req.getParameter("price");
	String title = req.getParameter("title");
	String description = req.getParameter("description");
	String pcategory = req.getParameter("category");
	ProductDAO dao = new ProductDAO();
	dao.insertProduct(name, image, price, title, description, pcategory);
	resp.sendRedirect("managerProduct");
}
}
