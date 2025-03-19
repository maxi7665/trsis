package com.trsis;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MainServlet
 */
//@WebServlet("/MainServlet")
// сервлет отображения отправлений
public class MainServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L; 

    /**
     * Default constructor. 
     */
    public MainServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ScheduleDataSource ds = ScheduleDataSource.getInstance();
		
		PrintWriter writer = response.getWriter();
		
		Utils.appendHead(writer);
		
		writer.append("<a href=\"createDeparture\">Добавить</a>");
		
		writer.append("<table border=\"1px\" class=\"table table-bordered\">");
		
		writer.append("<tr>");
		
		writer.append("<th>№</th>");
		writer.append("<th>От</th>");
		writer.append("<th>До</th>");
		writer.append("<th>С</th>");
		writer.append("<th>ПО</th>");
		writer.append("<th>Вид</th>");
		
		writer.append("</tr>");
		
		ArrayList<Departure> deps = ds.getDepartures();
		
		for (Departure dep : deps){
			writer.append("<tr>");
			
			writer.append("<td>" + new Integer(dep.getId()).toString() + "</td>");
			writer.append("<td>" + (dep.getSource()).toString() + "</td>");
			writer.append("<td>" + (dep.getDestination()).toString() + "</td>");
			writer.append("<td>" + (dep.getFromTimestamp()).toString() + "</td>");
			writer.append("<td>" + (dep.getToTimeStamp()).toString() + "</td>");
			writer.append("<td>" + (dep.getDepartureType()).toString() + "</td>");
			
			writer.append("<td>");
			
			writer.append(String.format("<form action=\"deleteDeparture?id=%d\" method=\"post\">\r\n"
					+ "    <button type=\"submit\" name=\"your_name\" value=\"your_value\" class=\"btn-link\">Удалить</button>\r\n"
					+ "</form>", dep.getId()));
			

			writer.append("</td>");
			
			writer.append("</tr>");
		}
		
		writer.append("</table>");	
		
		Utils.appendTail(writer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
