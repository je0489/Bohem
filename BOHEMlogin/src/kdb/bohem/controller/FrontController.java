package kdb.bohem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/comm")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Map<String,Action> map;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = super.getServletContext();
		
		//리소번들을 이용해서 파일 로딩
		ResourceBundle rb= ResourceBundle.getBundle("kdb.bohem.model.util.action");
		
		map = new HashMap<String, Action>();
		
		for(String key: rb.keySet()){
			String value = rb.getString(key);
    		try{
	    		//System.out.println(key +" : " + value);
    			//map에 properties파일에 있는 객체들 생성해서 넣는다.
	    		Action action = (Action)Class.forName(value).newInstance();
	    		map.put(key, action);
	    		
    		    System.out.println(action);
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
		}
		System.out.println(map);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("command");
		System.out.println("asdf");
		if(key==null) key="select";
		
		Action action= map.get(key);
		action.execute(request, response);
	}
}
