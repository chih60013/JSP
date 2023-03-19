package com.lcpan.m10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/UpdateEmpChih")
public class UpdateEmpChih extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null; // 建立一連線物件

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empno = request.getParameter("empno"); // 透過 request.getParameter("empno") 方法從 HTTP 請求中獲取使用者輸入的值，並將其儲存在
														// empno 變數中
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		String message = ""; // 先設定一空值，未來用

		String sql = " UPDATE [jdbc].[dbo].[employee] SET ename=?, hiredate=?, salary=?, deptno=?, title=? WHERE empno=?";

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection(); // 透過JNDI物件 去做 連線 這邊是在 XML檔內做修改，修改一次即可永久使用 不須再向JDBC一樣 寫連接詞彙等。
			PreparedStatement psmt = conn.prepareStatement(sql); // 這邊則是透過 psmt(欲處理程序) 去做連接 準備開始執行 sql
																	// 語句，而sql語句則是透過上面sql語法來執行
			// 因 員工資料表中 有六個欄位 ， 這邊開始將值填入 第一個問號中，且第一個問號代表為 empno
			psmt.setString(1, ename); // 對應sql語句的第幾個問號
			psmt.setString(2, hiredate);
			psmt.setString(3, salary);
			psmt.setString(4, deptno);
			psmt.setString(5, title);
			psmt.setString(6, empno);
			int rows = psmt.executeUpdate(); // 執行結果必然是 0或 1 0代表失敗，代表未新增任何資料， 1代表成功更新1筆資料
			// executeUpdate() 方法來執行 SQL 語句並存儲結果。該方法的返回值表示受影響的行數，如果執行成功但沒有行被修改，返回值為 0。

			if (rows > 0) {
				message = "新增成功，已更新資料庫之中。";
				request.setAttribute("message", message); // 此行意思在於 InsertEmp.jsp檔中，有一欄位為
															// request.getAttribute("message") 。
				// 第一個欄位的message 代表為jsp中的message， 第二個message則是要取代的內容值，
				// 內容值原本設定為空值，透過判斷式來新增至message這個變數內容之中。
				EmpBean emp = new EmpBean(); // emp.bean 是一個存基本設定的地方，且這邊開始會準備存值進入。
				emp.setEmpno(empno); // 因上面已有透過 psmt.setstring 來存值， 這邊會把存取的值，寫進bean之中
				emp.setEname(ename);
				emp.setHiredate(hiredate);
				emp.setSalary(salary);          
				emp.setDeptno(deptno);
				emp.setTitle(title);

				request.setAttribute("emp", emp); // request.setAttribute() 是一個 Java Servlet API 中的方法，用於將資料存儲在
													// HttpServletRequest 物件中。
				// 這個方法接受兩個參數，第一個參數是一個字串，表示要存儲的資料的名稱或鍵（key），第二個參數是要存儲的資料本身。
				// 存儲後的資料可以在同一個 HTTP 請求中的其他 Servlet
				// 中訪問，也可以通過請求轉發（RequestDispatcher）或重定向（Redirect）在不同的請求中訪問。

				psmt.close();
				request.getRequestDispatcher("/m10/ShowUpdateEmpChih.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
