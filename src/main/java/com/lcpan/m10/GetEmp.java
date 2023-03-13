package com.lcpan.m10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;

/**
 * Servlet implementation class GetEmp
 */
@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

			  
	 Connection conn;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empno = request.getParameter("empno");
					   
 String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 String user = "chief";
 String pwd = "117";
 String sql = "select * from employee where empno= ?";
			try {
			
			
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=jdbc",user,pwd);
			PreparedStatement  psmt = conn.prepareStatement(sql);
			
			    
			psmt.setString(1, empno);
			ResultSet rs = psmt.executeQuery();
			EmpBean emp = new EmpBean();
			if(rs.next()) {
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			}
			request.setAttribute("emp", emp);
			psmt.close();
			request.getRequestDispatcher("/m10/GetEmp.jsp")
				.forward(request, response);
		}catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
