package br.edu.senaisp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/altera")
public class Altera extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		SaborDAO dao = new SaborDAO();
		Sabor s = dao.buscaPorId(id);
		
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Cadastro</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("	<form action='/buttonHTML/altera' method='POST'>");
		html.append("		<input type='hidden' name='id' value='"+s.getId()+"' /> <br><br>");		
		html.append("		<label for='nome'>Nome:</label> ");
		html.append("		<input type='text' name='nome' value='"+s.getNome()+"' /> <br><br>");
		html.append("		<label for='descricao'>Descri��o:</label> ");
		html.append("		<input type='text' name='descricao' value='"+s.getDescricao()+"' /><br><br> ");
		html.append("		<label for='preco'>Preco:</label> ");
		html.append("		<input type='number' name='preco' value='"+s.getPreco()+"' /><br><br>");
		html.append("		<button type='submit'>Gravar</button>");
		html.append("	</form>");
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = resp.getWriter();
		pw.print(html.toString());		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		float preco = Float.parseFloat(req.getParameter("preco"));
		int id = Integer.parseInt(req.getParameter("id"));
		
		Sabor s = new Sabor();
		s.setId(id);
		s.setNome(nome);
		s.setDescricao(descricao);
		s.setPreco(preco);

		SaborDAO dao = new SaborDAO();
		dao.altera(s);
		
		resp.sendRedirect("/buttonHTML/lista");
	}
	
}
