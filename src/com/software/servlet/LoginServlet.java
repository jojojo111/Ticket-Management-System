package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.AdminDao;
import com.software.model.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String admin_loginname = request.getParameter("admin_loginname");
		int admin_loginpwd = Integer.parseInt(request.getParameter("admin_loginpwd"));

		AdminDao admindao = new AdminDao();
		Admin admin = admindao.adminLogin(admin_loginname, admin_loginpwd);

		if (admin.getAdmin_id() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}
