package br.com.cwi.crescer.lavanderia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "outro", urlPatterns = { "/outro" })
public class Outro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mensagem = "Hello World";
		request.setAttribute("outro", mensagem);
		request.getRequestDispatcher("outro.jsp").forward(request, response);
	}

}
