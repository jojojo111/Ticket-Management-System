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
		// 1.��ȡ�޸ĵĳ��α��
		int train_id = Integer.parseInt(request.getParameter("train_id"));
		// int train_id =1;
		// 2.�������ݿ���ʲ����
		TrainDao trainDao = new TrainDao();
		// 3.�������ݿ���ʲ��еĲ�ѯ����
		Train train = trainDao.findTrainById(train_id);
		// System.out.println(train.getTrain_id());
		// 4.��ת���޸�ҳ��
		request.setAttribute("obj", train);
		request.getRequestDispatcher("updateTrain.jsp").forward(request, response);
	}

}
