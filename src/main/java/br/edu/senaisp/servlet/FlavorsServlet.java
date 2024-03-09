package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.FlavorsDao;
import br.edu.senaisp.model.Flavor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet")
public class FlavorsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Flavor F = new Flavor(name, description, price);
		
		FlavorsDao dao = new FlavorsDao();
		
		dao.insert(F);
		
		
		
		
		System.out.print("Name: " +name+"\nDescription: " +description+"\nPrice: " +price+"\n\n");
		
		resp.sendRedirect("/buttonHTML/initial.html");
		
	}

}
