package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean; 

@WebServlet("/UpdateEmpChihJNDI")
public class UpdateEmpChihJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
///////////////更新資料
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		String message = "";// 輸入成功或失敗
		try {
			Context context = new InitialContext();// 透過 InitialContext() 建立 JNDI Context 物件。
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");// 這個名稱是在 context.xml 或 web.xml
																						// 中定義的資源參考名稱
			// lookup() 方法找到 JNDI 目錄中註冊的 DataSource 資源，並取得該資源的 DataSource 物件。
			Connection conn = ds.getConnection();// getConnection() 方法建立資料庫連接


			// insert進資料庫
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE employee SET ename=?, hiredate=?, salary=?, deptno=?, title=? WHERE empno=?");
			stmt.setString(1, ename);
			stmt.setString(2, hiredate);
			stmt.setString(3, salary);
			stmt.setString(4, deptno);
			stmt.setString(5, title);
			stmt.setString(6, empno);
			int rows = stmt.executeUpdate(); // 進行更新（insert，delete，update）操作

			if (rows > 0) {
				message = "更新成功";
				request.setAttribute("message", message);
				// bean
				EmpBean emp = new EmpBean();
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setHiredate(hiredate);
				emp.setSalary(salary);
				emp.setDeptno(deptno);
				emp.setTitle(title);

				request.setAttribute("emp", emp); // 之後讓jsp用<%=emp.getEmpno()%>印出
				stmt.close();
				request.getRequestDispatcher("/m11/UpdateEmpChih.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

