package com.semester.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class Pred
 */
@WebServlet("/Pred")
public class Pred extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pred() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 =request.getParameter("symptom1");
		String s2 =request.getParameter("symptom2");
		String s3 =request.getParameter("symptom3");
		String s4 =request.getParameter("symptom4");
		
		
		HttpSession session = request.getSession();
		String uname = session.getAttribute("username").toString();
		System.out.println(uname);
		UserDao ud = new UserDaoImpl();
		User u = ud.getPhoneno(uname);
		String p = u.getPhone();
		System.out.println(p);
		Client client = Client.create();
		Sms s = new Sms();
		WebResource webResource = client.resource("http://127.0.0.1:5000/symptoms_view").queryParam("k1",s1).queryParam("k2",s2).queryParam("k3",s3).queryParam("k4",s4);
		ClientResponse res = webResource.get(ClientResponse.class);
		System.out.println(res.getStatus());
		if(res.getStatus() == 200)
		{
			String output = res.getEntity(String.class);
			System.out.println("Received");
			System.out.println(output);
		   if(!output.equals("Wrong Symptoms"))
			{ 
			 String msg = s.sendSms(output, p);
			 System.out.println(msg);
			}
			request.setAttribute("message",output);
			request.getRequestDispatcher("pred.jsp").forward(request,response);
		}
		
}

}
