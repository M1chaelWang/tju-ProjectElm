package com.neusoft.elm.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 中文编码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		// 获取客户端请求路径
		String path = request.getServletPath();
		
		// 根据请求路径，将controller组件类名与方法名解析出来
		String className = path.substring(1, path.lastIndexOf("/"));
		String methodName = path.substring(path.lastIndexOf("/") + 1);
		
		PrintWriter out = null;
		
		try {
			// 通过Class.forName获取controllere类的信息
			Class clazz = Class.forName("com.neusoft.elm.controller." + className);
			// 创建controller对象
			Object controller = clazz.newInstance();
			// 获取controller的方法
			Method method = clazz.getMethod(methodName,new Class[] {HttpServletRequest.class});
			// 调用controller中的方法
			Object result = method.invoke(controller, new Object[] {request});
			
			out = response.getWriter();
			ObjectMapper om = new ObjectMapper();
			out.print(om.writeValueAsString(result));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DispatcherServlet信息：Servlet请求url路径：" + path);
			System.out.println("DispatcherServlet信息：类名：" + className + "\t方法名：" + methodName);
		} finally {
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
