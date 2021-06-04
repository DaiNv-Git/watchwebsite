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
@WebServlet(urlPatterns = "/search")
public class SearchControl extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String txtSearch = req.getParameter("txt");
		ProductDAO dao = new ProductDAO();
		try {
			List<Product> list = dao.SearchByName(txtSearch);
			req.setAttribute("ListP",list);
			List<Category> listC = dao.getAllCategory();
			Product last = dao.getLast();
			req.setAttribute("ListC", listC);
			req.setAttribute("ListP", list);
			req.setAttribute("p", last);
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
