package Web.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Web.DAO.ProductDAO;
import Web.Model.Category;
import Web.Model.Product;
@WebServlet(urlPatterns = "/trang-chu")
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.getAllProduct();
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		req.setAttribute("ListC", listC);
		req.setAttribute("ListP", list);
		req.setAttribute("p", last);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
