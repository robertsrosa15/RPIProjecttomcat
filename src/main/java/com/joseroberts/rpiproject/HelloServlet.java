package com.joseroberts.rpiproject;

import javax.servlet.http.*;
import java.io.IOException;
public class HelloServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.getWriter().print("Hello from servlet");

    }
}
