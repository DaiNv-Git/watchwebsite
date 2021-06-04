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

@WebServlet(urlPatterns = "/login")
public class LoginControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String pass = req.getParameter("pass");
		ProductDAO dao = new ProductDAO();
		Account a = dao.Login(username, pass);
		if (a == null) {
			req.setAttribute("mess", "Worng user or password");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		} else {
			HttpSession session =req.getSession();
			session.setAttribute("acc", a);
			resp.sendRedirect("trang-chu");	
		}
	}
}
