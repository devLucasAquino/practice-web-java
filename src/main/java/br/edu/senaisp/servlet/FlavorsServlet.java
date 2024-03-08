package br.edu.senaisp.servlet;

import java.io.IOException;

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
		
		System.out.print("Name: " +name+"\nDescription: " +description+"\nPrice: " +price);
		
		resp.sendRedirect("/buttonHTML/initial.html");
		
	}

}
