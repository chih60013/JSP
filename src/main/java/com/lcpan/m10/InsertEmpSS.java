package com.lcpan.m10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;


@WebServlet("/InsertEmpSS")
public class InsertEmpSS extends HttpServlet {
 private static final long serialVersionUID = 1L;
       

    Connection conn;

 
    public String sql="insert into  [jdbc].[dbo].[employee] values (?,?,?,?,?,?) ";
    
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  
  String empno = request.getParameter("empno");
  String ename=request.getParameter("ename");
  String hiredate=request.getParameter("hiredate");
  String salary=request.getParameter("salary");
  String deptno=request.getParameter("deptno");
  String title=request.getParameter("title");
  String message="";
//  System.out.println("empno is "  + empno );
  
  try {
   Context context= new InitialContext();
   DataSource ds =(DataSource)context.lookup("java:/comp/env/jdbc/servdb");
   conn=ds.getConnection();
//   System.out.println("conneted !!!");
   PreparedStatement stmt=conn.prepareStatement(sql);
   stmt.setString(1, empno);
   stmt.setString(2, ename);
   
   stmt.setString(4, salary);
   stmt.setString(5,deptno);
   stmt.setString(6, title);
   stmt.setString(3, hiredate);
   int check=stmt.executeUpdate();
   if(check>0) {
    message="成功";
    request.setAttribute("message",message);
    EmpBean emp =new EmpBean();
    emp.setEmpno(empno);
    emp.setEname(ename);
    emp.setHiredate(hiredate);
    emp.setSalary(salary);
    emp.setTitle(title);
    emp.setDeptno(deptno);
    request.setAttribute("emp", emp);
    
   }
   
   
   request.getRequestDispatcher("/m10/InsertEmp.jsp").forward(request, response);
   stmt.close();
   
  } catch (SQLException e) {
     
     e.printStackTrace();
    } catch (NamingException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  finally {
   if(conn!=null) {
    try {
     conn.close();
    }catch(SQLException e) {
     e.printStackTrace();
    }
   }
  }
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
 }

 

}