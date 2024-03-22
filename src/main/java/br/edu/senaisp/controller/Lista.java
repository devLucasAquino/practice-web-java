package br.edu.senaisp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;

@WebServlet(urlPatterns = "/lista")
public class Lista extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");
		
		StringBuilder html = new StringBuilder();
		html.append("");
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='ISO-8859-1'>");
		html.append("<title>Pagina Principal</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<a href=\"http://localhost:8080/buttonHTML/cadastro.html\"><button type=\"button\">Novo</button></a>");
		
		SaborDAO dao = new SaborDAO();
		html.append("<ul>");
		for (Sabor sabor : dao.lista()) {
			html.append("<li>");
			html.append("<h2>").append(sabor.getNome()).append("</h2>").append(" <a href='/buttonHTML/remove?id="+sabor.getId()+"'>").append("Excluir").append("</a>")
			.append(" <a href='/buttonHTML/altera?id="+sabor.getId()+"'>").append("Alterar").append("</a>");
			html.append("</li>");
		}
		html.append("</ul>");	
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = response.getWriter();
		pw.print(html.toString());

	}
}
