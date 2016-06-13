package main.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.User;

/**
 * Servlet implementation class AdminSignIn
 */
@WebServlet("/AdminSignIn")
public class AdminSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String auto=request.getParameter("userPassword");
		User admin=new User(userName,userPassword);
		String page="SignIn.jsp";
		if(admin.Manager(admin)){
			page="index.jsp";
			request.setAttribute("userName", userName);        
	        request.getSession().setAttribute("login", userName);
	        if("auto".equals(auto)){//记住密码
	        	
	        	Cookie namecookie=new Cookie("name",userName);		//浏览器是否支持cookie	
	        	namecookie.setMaxAge(7*24*60*60);
	        	response.addCookie(namecookie);
	        	
	        	Cookie pswcookie=new Cookie("psw",userPassword);			
	        	pswcookie.setMaxAge(7*24*60*60);
	        	response.addCookie(pswcookie);
	        }
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
