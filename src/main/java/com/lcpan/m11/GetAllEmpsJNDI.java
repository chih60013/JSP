package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetAllEmpsJNDI")
public class GetAllEmpsJNDI extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
 
  try {
     Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
            Connection conn = ds.getConnection();
            
   PreparedStatement stmt=conn.prepareStatement("select *from employee"); 
   ResultSet rs = stmt.executeQuery();
   List<EmpBean> emps=new ArrayList<>();//用來存儲EmpBean對象的ArrayList
   EmpBean emp=null;//初始化為null
   
   while(rs.next()) {
    emp = new EmpBean();//以便用bean
    emp.setEmpno(rs.getString("empno"));
    emp.setEname(rs.getString("ename"));
    emp.setHiredate(rs.getString("hiredate"));
    emp.setSalary(rs.getString("salary"));
    emp.setDeptno(rs.getString("deptno"));
    emp.setTitle(rs.getString("title"));
    emps.add(emp);  //加到emps 
   }
   request.setAttribute("emps", emps); //把emps，存到emps ArrayList
   stmt.close();
   request.getRequestDispatcher("/m10/GetAllEmps.jsp").forward(request, response);
   
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  doGet(request, response);
 }

}