package com.fm.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Map<String, Object> command=new HashMap<>();

    public void init(ServletConfig config){
    	String props=config.getInitParameter("memberConfig");
    	Properties pr=new Properties();
    	String path=config.getServletContext().getRealPath("/WEB-INF/member");
    	FileInputStream fi=null;
    	try {
			fi=new FileInputStream(new File(path,props));
			pr.load(fi);
			Iterator<Object> ir=pr.keySet().iterator();
			while(ir.hasNext()){
				String commands=(String)ir.next();
				String className=pr.getProperty(commands);
				Class classCommand=Class.forName(className);			
				Object commandInstance=classCommand.newInstance();				
				command.put(commands, commandInstance);		
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	         try {
	             fi.close();
	          } catch (IOException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	          }
	      } 
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String commands = request.getRequestURI();
		String rootpath = request.getServletContext().getContextPath();
		rootpath = rootpath +"/sub";
		commands = commands.substring(rootpath.length());
		
		Action a = (Action) command.get(commands);
		
		ActionForward af = a.excute(request, response);
		
		if(af.isRedirect()){
			RequestDispatcher view = request.getRequestDispatcher(af.getPath());
			view.forward(request, response);
		}else{
			response.sendRedirect(af.getPath());
		}
	}

}
