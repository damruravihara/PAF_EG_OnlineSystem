package api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;

/**
 * Servlet implementation class CustomerAPI
 */
@WebServlet("/CustomerAPI")
public class CustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Customer customerObj = new Customer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Customer customerObj = new Customer();
		
		String output = "";
		output = customerObj.readCustomers();
		
		response.getWriter().append(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String output = customerObj.insertCustomer(
				request.getParameter("cus_name"),
				request.getParameter("cus_address"),
				request.getParameter("cus_phone_no"),
				request.getParameter("cus_nic"),
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("account_number"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output = "";
			if(paras.get("idcustomer") != null) {
				output = customerObj.updateCustomer(
						paras.get("idcustomer").toString(),
						paras.get("cus_name").toString(),
						paras.get("cus_address").toString(),
						paras.get("cus_phone_no").toString(),
						paras.get("cus_nic").toString(),
						paras.get("username").toString(),
						paras.get("password").toString(),
						paras.get("account_number").toString());
			}
			else {
				output = customerObj.updateCustomer(
						request.getParameter("idcustomer"),
						request.getParameter("cus_name"),
						request.getParameter("cus_address"),
						request.getParameter("cus_phone_no"),
						request.getParameter("cus_nic"),
						request.getParameter("username"),
						request.getParameter("password"),
						request.getParameter("account_number"));
			}
			response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = "";
		
		if (paras.get("idcustomer") != null) {
			output = customerObj.deleteCustomer(paras.get("idcustomer").toString());
			
		}
		else {
			output = customerObj.deleteCustomer(request.getParameter("idcustomer"));
		}
		System.out.println("ID: " + output);
		response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
			
		}
		return map;
	}

}
