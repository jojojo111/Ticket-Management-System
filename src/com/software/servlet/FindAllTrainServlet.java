package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.TrainDao;
import com.software.model.Train;

/**
 * Servlet implementation class FindAllTrainServlet
 */
@WebServlet("/FindAllTrainServlet")
public class FindAllTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PAGESIZE = 5;

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
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		if (obj == null) {
			// 用户没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			TrainDao trainDao = new TrainDao();
			// 1.调用数据库访问层中的查询用户信息的方法

			String train_number = request.getParameter("train_number");
			String train_start = request.getParameter("train_start");
			String train_end = request.getParameter("train_end");
			String train_start_time = request.getParameter("train_start_time");
			// 1.获取总页数
			// 1.1 获取表的总行数
			int rows = trainDao.getCountTrain(train_number, train_start, train_end, train_start_time);
			int totalPages = rows / PAGESIZE;
			if (rows % PAGESIZE != 0) {
				totalPages++;
			}
			// 2.获取当前页
			int currentpage = 1; // 默认值

			String getCurrentPage = request.getParameter("setcurrentpage");
			if (getCurrentPage != null && getCurrentPage.trim().length() > 0) {
				currentpage = Integer.parseInt(getCurrentPage);
			}

			List<Train> trains = trainDao.findTrain(train_number, train_start, train_end, train_start_time, currentpage,
					PAGESIZE);
			// 2.将查询到的用户信息显示到用户信息显示页面
			// 2.1 数据的封装
			request.setAttribute("data", trains);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("train_number", train_number);
			request.setAttribute("train_start", train_start);
			request.setAttribute("train_end", train_end);
			request.setAttribute("train_start_time", train_start_time);
			// 2.2 页面的跳转
			request.getRequestDispatcher("MainTrain.jsp").forward(request, response);
		}

	}

}
