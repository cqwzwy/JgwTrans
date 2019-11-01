<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="net.sf.json.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/pinyin.css" >
<style>
@font-face {
    font-family: 'TTs'; 
    src: url('ziku/6199JGW(AYJGW).ttf');
}
</style>
<title>拼音输入法</title>
</head>
<body>
<input class="FontId" type="input" style="font-family:'TTs'" name="input" placeholder="结果"  value=""/>
<div class="jgw_content">
	<center>
		<input class="InputId" type="input"  name="input" placeholder="请输入"  value="" />
        <input type="button" class="btn s_submit" name="submit"  value="检索" />
    </center>
    <div class="search_result">
    </div>
</div>
<%!
	public StringBuffer url=null;
	static JSONArray array;
	public String pinyin=null;
	public static String getData(String pinyin){
		
		if(pinyin!=null&&array!=null)
			for(int i=0;i<array.size();i++){
				JSONObject o=array.getJSONObject(i);
				System.out.println(o);
				String py=o.getString("id");
				if(py.equals(pinyin)){
					return o.toString();
				}
			}
			
			return null;
	} 
%>
<%
	
	String result="";
	File f=new File("D:\\testmaven\\JgwTrans\\src\\main\\webapp\\拼音输入法\\json\\拼音输入法.json");
	BufferedReader br=new BufferedReader(
			new InputStreamReader(new FileInputStream(f)));
	String str="";
	
	while((str=br.readLine())!=null)
		result+=str;
	
	JSONObject object=JSONObject.fromObject(result);
	array=object.getJSONArray("result");
	
%>
<% 	
	pinyin=request.getParameter("datas");
	String sst=getData(pinyin);
	url=request.getRequestURL();
	
%>
<script>
	var url='<%= url%>'
	var result='<%= sst%>'
	
	function getData(){
		var ds=result.result;
		var rs="";
		$.each(ds,function(index,e){
			rs+="<div class='ziti' title='"+result.id+"' data-code='"
			+e.code+"' data-res='"+e.jgw
			+"'>"+e.jgw+"</div>"
			
		})
		$(".search_result").css("padding-bottom","10px")
		$(".search_result").css("border","solid 2px #000")
		$(".search_result").html(rs);
			
			
		$(document).bind("click",function(e){
			if($(e.target).attr("class")=="ziti"){
				var input_val=$(".FontId").val();
				var goal=$(e.target).attr("data-res");
				if(input_val.indexOf(goal)!=-1){
							
				}else{
					$(".FontId").val(input_val+goal)
				}
			}
		})
	}
	if(result!='null'){
		result=eval('('+result+')')
		getData();
	}
	
//点击事件
$(".InputId").bind("keypress",function(e){
	var value=$(".InputId").val()
	if(e.keyCode==13){
		window.location.href=url+"?datas="+value
	}
	
	
})
$(".s_submit").bind("click",function(){
	
	var value=$(".InputId").val()
	window.location.href=url+"?datas="+value
})





</script>
</body>
</html>
