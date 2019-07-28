package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.OrderDao;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ÿҳ��ʾ�Ķ�������
	private static final int PAGEROWS = 5;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		if (obj == null) {
			// �û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login_failure.jsp");
		} else {
			OrderDao OrderDao = new OrderDao();
			// ��ȡ��ѯ����
			String order_number = request.getParameter("order_number");
			String user_cardnumber = request.getParameter("user_cardnumber");
			String order_creation_time = request.getParameter("order_creation_time");
			// ��ȡ���������
			int rows = OrderDao.countOrderByCondition(order_number, user_cardnumber, order_creation_time);
			int totalPages = rows / PAGEROWS;
			if (rows % PAGEROWS != 0) {
				totalPages++;
			}
			// ��ȡ��ǰҳ
			int currentPage = 1;// Ĭ��ֵ
			String getCurrentPage = request.getParameter("setcurrentpage");
			if (getCurrentPage != null && getCurrentPage.trim().length() > 0) {
				currentPage = Integer.parseInt(getCurrentPage);
			}

			List<List> Order = OrderDao.findorderByCondition(order_number, user_cardnumber, order_creation_time,
					currentPage, PAGEROWS);
			int count = OrderDao.countOrderByCondition(order_number, user_cardnumber, order_creation_time);
			// 2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			// 2.1 ���ݵķ�װ
			request.setAttribute("data", Order);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("order_number", order_number);
			request.setAttribute("user_cardnumber", user_cardnumber);
			request.setAttribute("order_creation_time", order_creation_time);
			request.setAttribute("result", count);
			// 2.2 ҳ�����ת
			request.getRequestDispatcher("order_manage.jsp").forward(request, response);
		}
	}
}
