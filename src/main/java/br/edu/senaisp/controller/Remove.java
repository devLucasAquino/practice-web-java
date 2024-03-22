package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/remove")
public class Remove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		SaborDAO dao = new SaborDAO();
		dao.remove(id);
		
		resp.sendRedirect("/buttonHTML/lista");
		
	}
}
