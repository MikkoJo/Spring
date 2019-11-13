package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aika")
public class TimeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TimeServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd-MM-yyyy HH:mm:ss");
		
		PrintWriter out = response.getWriter();
		out.print(formatter.format(LocalDateTime.now()));
		}
}