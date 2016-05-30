package com.fm.control;

import java.io.File;
import java.io.FileInputStream;
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
 * Servlet implementation class AuctionController
 */
@WebServlet("/AuctionController")
public class AuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Map<String, Object> command = new HashMap<>();
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//프로퍼티 파일명 가져오기
    	String props = config.getInitParameter("auctionConfig");
    	Properties pr = new Properties();
    	//파일의 실제 경로명 가져오기
    	String path = config.getServletContext().getRealPath("WEB-INF/auction");
    	FileInputStream fi = null;
    	try {
			//프로퍼티 파일 연결
    		fi = new FileInputStream(new File(path, props));
    		//키와 벨류를 분리
    		pr.load(fi);
    		
    		Iterator<Object> ir = pr.keySet().iterator();
    		while(ir.hasNext()){
    			String commands = (String) ir.next();
    			String className= pr.getProperty(commands);
    			Class commandClass = Class.forName(className);
    			Object commandInstance = commandClass.newInstance();
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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
