/*
package org.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

*/
/**
 * @program: spring
 * @ClassName HttpTest
 * @description:$
 * @author: 李杰
 * @create: 2020-09-03 20:12
 * @Version 1.0
 **//*

@WebServlet("/sayLove")
public class HttpTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("test/html");
		resp.getWriter().write("I LOVE YOU");
	}
}*/
