package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.UserDao;
import com.software.model.User;

/**
 * Servlet implementation class FindAllUserServlet
 */
@WebServlet("/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PAGESIZE = 5;

	/**
	 * Default constructor.
	 */
	public FindAllUserServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		excute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		excute(request, response);
	}

	private void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		if (obj == null) {
			// �û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login_failure.jsp");
		} else {
			UserDao userdao = new UserDao();
			// ��ȡ��ҳ��
			int countUser = userdao.getCountUsers();
			int totalPages = countUser / PAGESIZE;
			if (countUser % PAGESIZE != 0) {
				totalPages++;
			}
			// ��ȡ��ǰҳ
			int currentpage = 1; // Ĭ��ֵ

			String getCurrentPage = request.getParameter("setcurrentpage");
			if (getCurrentPage != null && getCurrentPage.trim().length() > 0) {
				currentpage = Integer.parseInt(getCurrentPage);
			}

			List<User> users = userdao.findAllUser(currentpage, PAGESIZE);
			request.setAttribute("users", users);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("currentpage", currentpage);
			request.getRequestDispatcher("user_manage.jsp").forward(request, response);
		}
	}

}
