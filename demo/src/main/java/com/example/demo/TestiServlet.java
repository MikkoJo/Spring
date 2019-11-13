package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testi")
public class TestiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestiServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Koe</h1>");
		out.println("<div>Servlet voi tulostaa <b>HTML-kieltä</b>");
		out.println("<div>JavaScriptiä voi käyttää myös Servletillä, koska se palauttaa tekstiä takaisin selaimelle.</div>");
		out.println("<script>");
		out.println(
		"var arr = [1,2,3,4,5]; "
		+ "var div = document.getElementsByTagName('div')[1]; "
		+ "div.innerHTML += '<br>'; "
		+ "for (var i in arr) { div.innerHTML += i + ': ' + arr[i] + '<br>'}");
		out.println("</script>");


		}


}
