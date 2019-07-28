package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.TrainDao;
import com.software.model.Admin;
import com.software.model.Train;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateTrainServlet")
public class UpdateTrainServlet extends HttpServlet {
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
		// 1.获取管理员修改的信息(读取form表中的元素值)
		// 1.获取客户端提交的用户注册信息
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		Admin admin = (Admin) obj;

		int admin_id = admin.getAdmin_id();
		int hard_berth_number = Integer.parseInt(request.getParameter("hard_berth_number"));
		double hard_berth_price = Double.parseDouble(request.getParameter("hard_berth_price"));
		int hard_seat_number = Integer.parseInt(request.getParameter("hard_seat_number"));
		double hard_seat_price = Double.parseDouble(request.getParameter("hard_seat_price"));
		String remark1 = request.getParameter("remark1");
		int soft_berth_number = Integer.parseInt(request.getParameter("soft_berth_number"));
		double soft_berth_price = Double.parseDouble(request.getParameter("soft_berth_price"));
		int stand_number = Integer.parseInt(request.getParameter("stand_number"));
		double stand_price = Double.parseDouble(request.getParameter("stand_price"));
		String train_end = request.getParameter("train_end");
		String train_end_time = request.getParameter("train_end_time");
		String train_number = request.getParameter("train_number");
		String train_runtime = request.getParameter("train_runtime");
		String train_start = request.getParameter("train_start");
		String train_start_time = request.getParameter("train_start_time");
		// 创建车次对象
		Train train = new Train();
		train.setAdmin_id(admin_id);
		train.setHard_berth_number(hard_berth_number);
		train.setHard_berth_price(hard_berth_price);
		train.setHard_seat_number(hard_seat_number);
		train.setHard_seat_price(hard_seat_price);
		train.setRemark1(remark1);
		train.setSoft_berth_number(soft_berth_number);
		train.setSoft_berth_price(soft_berth_price);
		train.setStand_number(stand_number);
		train.setStand_price(stand_price);
		train.setTrain_end(train_end);
		train.setTrain_end_time(train_end_time);
		train.setTrain_number(train_number);
		train.setTrain_runtime(train_runtime);
		train.setTrain_start(train_start);
		train.setTrain_start_time(train_start_time);
		// 2.创建数据库访问层对象
		TrainDao trainDao = new TrainDao();
		// 3.调用数据库访问层中的修改方法
		trainDao.updateTrain(train);
		// 4.跳转到查询页面
		response.sendRedirect(request.getContextPath() + "/QueryTrainServlet");
	}

}
