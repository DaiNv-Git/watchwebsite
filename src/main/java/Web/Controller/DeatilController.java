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
@WebServlet(urlPatterns = "/detail")
public class DeatilController extends HttpServlet{
	private static final long serialVersionUID = 1533424387294994928L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pId");
		ProductDAO dao = new ProductDAO();
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		try {
			Product p = dao.getProductByID(id);
			req.setAttribute("detail", p);
			req.setAttribute("ListC", listC);
			req.setAttribute("p", last);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
