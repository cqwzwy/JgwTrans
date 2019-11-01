package com.transition;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import T_valition.getChars;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import static java.lang.System.out;
import static java.lang.System.err;
@WebServlet("/transition")
public class transition extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static org.apache.log4j.Logger log=Logger.getLogger(transition.class);
    
    public transition() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		
		String data=request.getParameter("data");
		
		JSONObject o=JSONObject.fromObject(data);
		
		JSONArray array=o.getJSONArray("result");
		
		StringBuffer result=new StringBuffer();
		
		result.append("{'pinyin':'"+(String)o.get("pinyin")+"','result':[");
		
		for(int i=0;i<array.size();i++) {
			
			JSONObject object=array.getJSONObject(i);
			
			String code=(String)object.get("code");
			
			String regex="([0-9]|[A-F]).*";
			
			if(Pattern.matches(regex, code)) {
				
				String msg=String.valueOf(getChars.getChars(code));
				
				result.append("{'font':'"+msg+"'},");
				
			}else {
				err.println(code);
			}
			
			
		}
		if(array.size()>0) {
			result.setLength(result.length()-1);
			
		}
		
		result.append("]}");
		
		pw.print(result.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
