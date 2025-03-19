package com.trsis;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDepartureServlet
 */
public class DeleteDepartureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteDepartureServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ScheduleDataSource sds = ScheduleDataSource.getInstance();
		
		String idStr = request.getParameter("id");
		
		if (idStr == null) {
			throw new ServletException("id is not present in query");
		}
		
		int id = Integer.parseInt(idStr);	
		if (!sds.removeDeparture(id)) {
			throw new ServletException("Can't remove departure");
		}
		
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "/webapp/MainServlet");
	}

}
