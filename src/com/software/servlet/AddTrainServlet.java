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
 * Servlet implementation class AddTrainServlet
 */
@WebServlet("/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddTrainServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		exectue(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		exectue(request, response);
	}

	private void exectue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		Admin admin = (Admin) obj;
		if (obj == null) {
			// 用户没有登录
			response.sendRedirect(request.getContextPath() + "/login_failure.jsp");
		} else {
			// 1.获取客户端提交的用户注册信息
			String train_number = request.getParameter("train_number");
			String train_start = request.getParameter("train_start");
			String train_end = request.getParameter("train_end");
			String train_start_time = request.getParameter("train_start_time");
			String train_end_time = request.getParameter("train_end_time");
			String train_runtime = request.getParameter("train_runtime");
			int soft_berth_number = Integer.parseInt(request.getParameter("soft_berth_number"));
			int hard_berth_number = Integer.parseInt(request.getParameter("hard_berth_number"));
			int hard_seat_number = Integer.parseInt(request.getParameter("hard_seat_number"));
			int stand_number = Integer.parseInt(request.getParameter("stand_number"));
			double soft_berth_price = Double.parseDouble(request.getParameter("soft_berth_price"));
			double hard_berth_price = Double.parseDouble(request.getParameter("hard_berth_price"));
			double hard_seat_price = Double.parseDouble(request.getParameter("hard_seat_price"));
			double stand_price = Double.parseDouble(request.getParameter("stand_price"));
			int admin_id = admin.getAdmin_id();
			// String remark1 = request.getParameter("remark1");
			// 创建用户对象
			Train train = new Train();
			train.setTrain_number(train_number);
			train.setTrain_start(train_start);
			train.setTrain_end(train_end);
			train.setTrain_start_time(train_start_time);
			train.setTrain_end_time(train_end_time);
			train.setTrain_runtime(train_runtime);
			train.setSoft_berth_number(soft_berth_number);
			train.setHard_berth_number(hard_berth_number);
			train.setHard_seat_number(hard_seat_number);
			train.setStand_number(stand_number);
			train.setSoft_berth_price(soft_berth_price);
			train.setHard_berth_price(hard_berth_price);
			train.setHard_seat_price(hard_seat_price);
			train.setStand_price(stand_price);
			train.setAdmin_id(admin_id);
			// train.setRemarks1(remark1);

			// 2.创建数据库访问层对象
			TrainDao trainDao = new TrainDao();
			// 3.调用数据库访问层中的添加方法
			trainDao.addTrain(train);
			// request.getRequestDispatcher("MainTrain.jsp").forward(request,
			// response);
			response.sendRedirect(request.getContextPath() + "/FindAllTrainServlet");
		}
	}

}
