package Web.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Web.DAO.ProductDAO;
import Web.Model.Product;
@WebServlet(urlPatterns = "/category")
public class Category extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String cateId = req.getParameter("cId");
	ProductDAO dao = new ProductDAO();
	try {
		List<Product> list = dao.getProductByCID(cateId);
		List<Web.Model.Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		req.setAttribute("ListP", list);
		req.setAttribute("ListC", listC);
		req.setAttribute("p", last);
		req.setAttribute("tag", cateId);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
