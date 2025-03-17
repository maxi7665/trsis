package com.trsis;

import java.io.PrintWriter;

public class Utils {
	public static void appendHead(PrintWriter writer) {
		writer.append("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>Bootstrap demo</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				);
	}
	
	public static void appendTail(PrintWriter writer) {
		writer.append("</body>\r\n"
				+ "</html>"
				);
	}
}
