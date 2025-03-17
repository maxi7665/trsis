package com.trsis;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateDepartureServlet
 */

@MultipartConfig
public class CreateDepartureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateDepartureServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = response.getWriter();
		
		// кодировка
//		writer.append("<head>\r\n"
//				+ "  <meta charset=\"UTF-8\">\r\n"
//				+ "</head>\r\n");
		
		Utils.appendHead(writer);
		
		writer.append("<h1>Создать отправление</h1>");
		
		writer.append("<a href=\"/webapp/MainServlet\">К отправлениям</a><br><br>");
		
		response.getWriter().append(
				"<form method=\"POST\" enctype=\"multipart/form-data\">\r\n"
				+ "<label for=\"source\">ОТ</label>"
				+ "  <input name=\"source\">\r\n<br>"
				+ "<label for=\"destination\">ДО</label>"
				+ "  <input name=\"destination\"><br>\r\n"
				+ "<label for=\"fromTimestamp\">Отправление В</label>"
				+ "  <input name=\"fromTimestamp\" type=\"datetime-local\"><br>\r\n"
				+ "<label for=\"toTimestamp\">Прибытие В</label>"
				+ "  <input name=\"toTimestamp\" type=\"datetime-local\"><br>\r\n"
				+ "<button>Создать</button>"
				+ "</form>");
		
		Utils.appendTail(writer);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> parameters = request.getParameterMap();
		
		if (parameters.size() > 0) {
			Departure dep = Departure.fromParameterMap(parameters);
			
			ScheduleDataSource.getInstance().addDeparture(dep);		
		}
		
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "/webapp/MainServlet");
	}

}
