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

@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection conn;  //大哥說 這行程式碼是宣告一個名稱為 "conn" 的變數，類型為 "Connection"，
    //這個變數是用來儲存與資料庫建立的連線物件。宣告這個變數的目的是為了在程式中使用這個連線物件來執行資料庫操作，例如執行SQL查詢、更新等等。由於這個變數還未初始化，所以必須在後面的程式碼中指定資料庫的連線資訊，才能讓它真正地建立起連線物件。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");      //empno 來自 取html內輸入的值   大哥說是從網頁請求(request)中取得名為"empno"的參數(parameter)的值，並將其存入名為"empno"的字串(string)變數中。
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		String message = "";    //
		
		
		 String sql = " INSERT INTO [employee] values (?,?,?,?,?,?)";  //sql新增語法  ? 代表屬性格  有六個格子 就是 六個? 前面也可放欄位名稱 避免找不到相關詞彙。
		 //寫法會像這樣  
		try {
		Context context = new InitialContext();  //這行程式碼是建立一個JNDI(Java Naming and Directory Interface)的命名空間上下文(Context)物件，以便在Java應用程式中存取命名和目錄服務。它使用了Java命名和目錄接口(JNDI)的API，通過調用InitialContext()建構函數來創建上下文物件。在這個上下文物件中，可以綁定和查找資源，例如資料庫連線、郵件服務、設定檔等等。
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		conn =ds.getConnection();  //上面的這三行  於講義p.165之中
		PreparedStatement  psmt = conn.prepareStatement(sql);   //這邊準備透過  conn變數 來連接將一個SQL語句(sql)傳入到資料庫連線(Connection)物件(conn)中進行預編譯(prepare)。PreparedStatement物件可以用來執行已編譯的SQL語句
		psmt.setString(1, empno);
		psmt.setString(2, ename);
		psmt.setString(3, hiredate);
		psmt.setString(4, salary);
		psmt.setString(5, deptno);
		psmt.setString(6, title);
		int rows = psmt.executeUpdate();
		
		if(rows>0) {
			message = "成功";
			request.setAttribute("message", message);
			EmpBean emp = new EmpBean();
			emp.setEmpno(empno);
			emp.setEname(ename);
			emp.setHiredate(hiredate);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			emp.setTitle(title);
			
			
			request.setAttribute("emp", emp); 
		psmt.close();
		request.getRequestDispatcher("/m10/GetEmp.jsp")
			.forward(request, response);
			
		}
			
	}catch (Exception e) {
	    e.printStackTrace();
	}
	
	
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
