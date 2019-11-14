package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/laskuri")
public class LaskuriServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int laskuri;

	public LaskuriServlet() {
		super();
		this.laskuri = 0;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		laskuri++;
		out.print("<b>Laskurin arvo on: " + laskuri + "</b>");
		}
}