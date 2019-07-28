package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.OrderDao;

/**
 * Servlet implementation class TotalOrderServlet
 */
@WebServlet("/TotalOrderServlet")
public class TotalOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.�������
		String start = request.getParameter("order_strat");
		String end = request.getParameter("order_end");
		// ����������Ӳ��������Ӳ��������վƱ���� �������ܽ�Ӳ���ܽ�Ӳ���ܽ�վƱ�ܽ����������������ܽ��
		// 2.����Dao��Ķ���
		OrderDao orderDao = new OrderDao();
		// 3.���ö����ͳ�ƺ���
		List<List> data = orderDao.total_order(start, end);
		request.setAttribute("data", data);
		request.setAttribute("order_strat", start);
		request.setAttribute("order_end", end);
		request.getRequestDispatcher("order_total.jsp").forward(request, response);
	}

}
