package cn.bd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.entity.destineinfo;
import cn.bd.impdao.ImpDao;

public class DoRe extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoRe() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String meetroom=request.getParameter("meetingRoom");
		
		
		/*Date date = null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=format.parse(request.getParameter("time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String date=request.getParameter("time");
		String name=request.getParameter("userName");
		
		destineinfo d=new destineinfo();
		d.setRoom_name(meetroom);
		d.setDestine_time(date);
		d.setDestine_name(name);
		ImpDao dao=new ImpDao();
		int result=dao.addDinfo(d);
		
		String contextPath=request.getContextPath();
		
		//System.out.println(contextPath);
		if(result>0){
			out.print("<script type='text/javascript'>" +
					"alert('预定成功!');" +"location.href='"+contextPath+"/index.jsp';</script>");
		}
		else{
			out.print("<script type='text/javascript'>" +
					"alert('预定失败!');"
					+"location.href='"+contextPath+"/index.jsp';</script>");
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
