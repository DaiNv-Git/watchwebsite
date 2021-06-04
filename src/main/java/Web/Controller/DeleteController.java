package Web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Web.DAO.ProductDAO;
@WebServlet(urlPatterns = "/delete")
public class DeleteController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid =req.getParameter("pid");
		ProductDAO dao = new ProductDAO();
		dao.delete(pid);
		resp.sendRedirect("managerProduct");
}
}
