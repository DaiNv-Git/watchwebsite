package Web.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Web.DAO.ProductDAO;
import Web.Model.Account;
import Web.Model.Category;
import Web.Model.Product;
@WebServlet(urlPatterns = "/managerAccount")
public class ManagerAccount extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	Account a = (Account) session.getAttribute("acc");
	int id = a.getId();
	ProductDAO dao = new ProductDAO();
	List<Category> listC = dao.getAllCategory();
	List<Account> list = dao.getAllAcount();
	req.setAttribute("ListC", listC);
	req.setAttribute("listA",list);
	req.getRequestDispatcher("AccountManager.jsp").forward(req, resp);
}
}

