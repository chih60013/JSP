package com.lcpan.m10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

/**
 * Servlet implementation class DeleteEmp
 */
@WebServlet("/DeleteEmpChih")
public class DeleteEmpChih extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    Connection conn = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");


		
		String Sql = "delete from employee where empno = ? ";
		String message = "" ;
		
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn =ds.getConnection();  //透過JNDI物件 去做 連線   這邊是在 XML檔內做修改，修改一次即可永久使用 不須再向JDBC一樣 寫連接詞彙等。
			PreparedStatement psmt = conn.prepareStatement(Sql);  //這邊則是透過 psmt(欲處理程序) 去做連接 準備開始執行 sql 語句，而sql語句則是透過上面sql語法來執行
			psmt.setString(1, empno);


			
			int rows = psmt.executeUpdate();
		
			if(rows>0) {
				message="刪除成功";
				request.setAttribute("message", message);
				EmpBean emp = new EmpBean();
				emp.setEmpno(empno);
				
				 
				request.setAttribute("emp", emp);
				
				}
			
			request.getRequestDispatcher("/m10/DeleteEmpChih.jsp")    
			.forward(request, response);   //指派m10/GetEmp.jsp檔案來當 servlet 執行 request 跟 response
		psmt.close();
		
			
			}catch (Exception e) {
			    e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
