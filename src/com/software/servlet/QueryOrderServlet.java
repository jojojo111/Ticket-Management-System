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
	// 每页显示的订单数量
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
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		if (obj == null) {
			// 用户没有登录
			response.sendRedirect(request.getContextPath() + "/login_failure.jsp");
		} else {
			OrderDao OrderDao = new OrderDao();
			// 获取查询条件
			String order_number = request.getParameter("order_number");
			String user_cardnumber = request.getParameter("user_cardnumber");
			String order_creation_time = request.getParameter("order_creation_time");
			// 获取表的总行数
			int rows = OrderDao.countOrderByCondition(order_number, user_cardnumber, order_creation_time);
			int totalPages = rows / PAGEROWS;
			if (rows % PAGEROWS != 0) {
				totalPages++;
			}
			// 获取当前页
			int currentPage = 1;// 默认值
			String getCurrentPage = request.getParameter("setcurrentpage");
			if (getCurrentPage != null && getCurrentPage.trim().length() > 0) {
				currentPage = Integer.parseInt(getCurrentPage);
			}

			List<List> Order = OrderDao.findorderByCondition(order_number, user_cardnumber, order_creation_time,
					currentPage, PAGEROWS);
			int count = OrderDao.countOrderByCondition(order_number, user_cardnumber, order_creation_time);
			// 2.将查询到的用户信息显示到用户信息显示页面
			// 2.1 数据的封装
			request.setAttribute("data", Order);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("order_number", order_number);
			request.setAttribute("user_cardnumber", user_cardnumber);
			request.setAttribute("order_creation_time", order_creation_time);
			request.setAttribute("result", count);
			// 2.2 页面的跳转
			request.getRequestDispatcher("order_manage.jsp").forward(request, response);
		}
	}
}
