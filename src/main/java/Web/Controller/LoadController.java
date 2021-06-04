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
import Web.Model.Category;
import Web.Model.Product;
@WebServlet(urlPatterns = "/loadProduct")
public class LoadController extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("pId");
	ProductDAO dao = new ProductDAO();
	try {
		Product p = dao.getProductByID(id);
		List<Category> listC = dao.getAllCategory();
		req.setAttribute("detail",p);
		req.setAttribute("ListC", listC);
		req.getRequestDispatcher("Edit.jsp").forward(req, resp);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}