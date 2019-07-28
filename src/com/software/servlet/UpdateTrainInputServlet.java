package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.TrainDao;
import com.software.model.Train;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/UpdateTrainInputServlet")
public class UpdateTrainInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateTrainInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// 1.获取修改的车次编号
		int train_id = Integer.parseInt(request.getParameter("train_id"));
		// int train_id =1;
		// 2.创建数据库访问层对象
		TrainDao trainDao = new TrainDao();
		// 3.调用数据库访问层中的查询方法
		Train train = trainDao.findTrainById(train_id);
		// System.out.println(train.getTrain_id());
		// 4.跳转到修改页面
		request.setAttribute("obj", train);
		request.getRequestDispatcher("updateTrain.jsp").forward(request, response);
	}

}
