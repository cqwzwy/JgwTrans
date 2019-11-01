// JavaScript Document
$(function(){
		//加载数据
		var dataJson;
		$.getJSON("json/拼音输入法.json",function(data){
			dataJson=data.result;
		})
		//跟据拼音查找数据
		function getData(value){
			$.each(dataJson,function(index,element){
				
				if(element.id==value){
					
					var rs="";
					$.each(element.result,function(index,e2){
						rs+="<div class='ziti' title='"+element.id+"' data-code='"
						+e2.code+"' data-res='"+e2.jgw
						+"'>"+e2.jgw+"</div>"
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
				
			})
		}
		
		//点击事件
		$(".InputId").bind("keypress",function(e){
			var value=$(".InputId").val()
			if(e.keyCode==13){
				getData(value)
			}
			
			
		})
		$(".s_submit").bind("click",function(){
			
			var value=$(".InputId").val()
			getData(value)
		})
		
	})