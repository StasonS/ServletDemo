package com.stasiamba.servletdemo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String title = "RequestServlet";
        PrintWriter printWriter = response.getWriter();

        Enumeration headers = request.getHeaderNames();

        printWriter.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<body>");

        while (headers.hasMoreElements()){
            String param = (String) headers.nextElement();
            String value = (String) request.getHeader(param);
            printWriter.println("<h4>" + param + ": " + value + "</h4>\n");
        }

        printWriter.println("</body>" +
                "</html>");
    }
}
