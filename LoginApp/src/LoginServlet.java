

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId, password;
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		LoginService loginservice=new LoginService();
		boolean result=loginservice.authenticate(userId, password);
		if(result){
		    User user=loginservice.getUserDetails(userId);
		    //request.getSession().setAttribute("user", user);
		    //response.sendRedirect("success.jsp");
			
		    //we are now passing request and response to success.jsp
		    //instead of redirecting to success.jsp and getting value form session
		    
		    request.setAttribute("user", user);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			
		    return ;
		}
		else{
			response.sendRedirect("login.jsp");
			return ;
		}
		
		
		
		
	}

}
