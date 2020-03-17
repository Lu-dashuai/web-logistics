  	 	 //效验邮寄单号
  	 	 $(function(){
  	 	 //alert("111");
		      //给邮寄单的输入框绑定失焦事件
		      $("#ol").blur(function(){
		         //alert($("#ol").val());//弹出输入框中的值
		         //获取输入值
		         var orderMailnum = $(this).val();  //去掉左右空格//var tempMailNum = $.trim(order_mailnum);//判断是否为空
		         if(orderMailnum==''){
		            $("#mailnumInfo").html("邮寄单号为空").css("color","red");
		            return;
		         } 
		         //alert(orderMailnum);
		         $.post(
		         	'order/checkMailnum.do',
		         	{ol:orderMailnum},
		         	function(data){
		         		//alert("返回值"+data.msg);
		         		//alert(data.msg == 'false');
						if (data.msg =='false'){
							//$('#tt').datagrid('reload');	// 更新父窗口
							//alert(date);
							$("#mailnumInfo").html("邮寄单号已重复，不能使用").css("color","red");
							$("#sbt").attr("disabled","disabled");
						} else {
							$("#mailnumInfo").html("邮寄单可以使用").css("color","green");
	         				$("#sbt").removeAttr("disabled");
						}
					},
		      	);  
		   });
		}); 
		//发货人手机号验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    phone:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9})/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入正确格式的电话号或手机号！'
		    }
		}); 
		//收获人手机号验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    accphone:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9})/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入正确格式的电话号或手机号！'
		    }
		}); 
		//邮编验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    zipcode:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /[1-9]{1}(\d+){5}/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入正确格式的邮政编码！'
		    }
		});
		//重量验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    weight:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /^\d+(\.\d+)?$/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入数字！'
		    }
		}); 
		//物品价值验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    value:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /^\d+(\.\d+)?$/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入数字！'
		    }
		});
		//保价金额验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    supportvalue:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /^\d+(\.\d+)?$/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入数字！'
		    }
		});
		//运费验证
		$.extend($.fn.validatebox.defaults.rules, { 
		    cost:{//对应<input/>框中的validType
		        validator:function(value,param){
		            var reg = /^\d+(\.\d+)?$/ ;//正则表达式
		            return reg.test(value);
		        },
		        message:  '请输入数字！'
		    }
		});