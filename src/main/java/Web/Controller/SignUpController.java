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
@WebServlet(urlPatterns ="/signup")
public class SignUpController extends HttpServlet{

	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		String re_pass = req.getParameter("repass");
		if(!pass.equals(re_pass)) {
			resp.sendRedirect("Login.jsp");
		}
		else {
			ProductDAO dao = new ProductDAO();
			Account a = dao.CheckAccount(user);
			if(a == null) {
				HttpSession session = req.getSession();
				req.setAttribute("acc", a);
				dao.signUp(user,pass);
				resp.sendRedirect("trang-chu");
			}
			else {
				resp.sendRedirect("Login.jsp");
			}
		}
		
}
}
