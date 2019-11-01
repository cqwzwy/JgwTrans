$(document).ready(function() {
	
	
		//清空部首按钮
		$("#clear_btn").bind("click",function(){
			$(".select_list").html("");
			$(".imgClass").each(function(index){
				$(this).attr("data-flag","0");
				$(this).css("border-color","#000000")
			});
			$("#result").css("display","none")
			$("#result").html("");
		})
		
		//数据初始化
		var dataJson;
		$.getJSON("json/部首输入法.json",function(data){
			dataJson=data.result;
		})
		
		//初始化部首图片
		
		for(var i=1;i<177;i++){
			var imgPath="img/img_"+i+".jpg"
			result+="<img class='imgClass' alt='imgaes' src='"+imgPath+"' data-flag=0 data-res='"+(i)+"' />";
		}
		$("#KeyBoard").attr("class","jgwKey");
				
		$("#KeyBoard").html(result);
		
		
		//部首点击事件
		$(".imgClass").bind("click",function(){
			$(this).css("border-color","#ff0000")
			var msg=$(this).attr("data-res");
			var flag=0;
			$(".select_list .selected_radical").each(function(index){
				if($(this).attr("data-res")==msg){
					var rn=$(this).attr("data-num");
					rn++;
					$(this).attr("data-num",rn)
					$(this).children(".number").html(rn)
					flag=1;
				}
						
			});
			if(flag==0){
				var html=$(".select_list").html();
				var src=$(this).attr("src");
				html+="<div class='selected_radical' data-res='"+msg+"' data-num=1 >" +
						"<img class='ziti' data-flag='"+msg+"' src='"+src+"' />" +
								"<span class='number'>1</span></div>"
				$(".select_list").html(html)
			}else{
						
			}
			var sendMessage={result:[
			]};
			$(".selected_radical").each(function(index){
				var msgs={
						radical:$(this).attr("data-res"),
						num:$(this).attr("data-num")
					}
				sendMessage.result.push(msgs);

				})
			console.log(sendMessage)
			getData(sendMessage)
		})
		
		
		//查找部首
		function call(data,radical){
			var result={
					num:0,
					result:[]
				};
			$.each(data,function(index,e){
				var r2=e.result;
				$.each(r2,function(i2,e2){
					if(parseInt(e2.name)==radical.radical
							&&e2.Number>=radical.num){
						result.result.push(e)
						result.num++;
					}
					
				})
				
				
			})
			console.log(result);
			return result;
		}
		
		
		function getData(data){	
			data=data.result
			console.log(data)
			var callr;
			var datares=dataJson;
			$.each(data,function(index,e){
				
				console.log("e"+e)		
				datares=call(datares,e)
				datares=datares.result
				console.log(datares);
			})
			
			
			$("#result").css("display","block")
			var dataArray=datares;
			var i=0;
			var resultShow="<span>共有结果数 ：<b>"+dataArray.length+"</b></span></br>"
			$.each(dataArray,function(index){
				var FontStr;
							
				resultShow+="<span class='InputValue' data-code='"+dataArray[index].code
				+"' data-res='"+dataArray[index].jgw+"' >"
				+dataArray[index].jgw+"</span>";
								
			})
			$("#result").attr("class","resultShow");
			$("#result").html(resultShow);
			
			
			$(document).bind("click",function(e){
				if($(e.target).attr("class")=="InputValue"){
					var input_val=$("#ConditionValue2",window.parent.document).val();
					var goal=$(e.target).attr("data-res");
					if(input_val.indexOf(goal)!=-1){
								
					}else{
						//$(".FontId").val(input_val+goal)
						$("#ConditionValue2",window.parent.document).val(input_val+goal)
					}
				}
			})
			
			
		}
		
    });