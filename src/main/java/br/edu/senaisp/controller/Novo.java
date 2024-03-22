package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novo")
public class Novo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		float preco = Float.parseFloat(req.getParameter("preco"));

		Sabor s = new Sabor();
		s.setNome(nome);
		s.setDescricao(descricao);
		s.setPreco(preco);

		SaborDAO dao = new SaborDAO();
		dao.novo(s);
		
		resp.sendRedirect("/buttonHTML/lista");
	}
}