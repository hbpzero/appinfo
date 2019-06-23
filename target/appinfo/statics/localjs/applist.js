

$("#queryCategoryLevel1").change(function(){
	var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
	if(queryCategoryLevel1 != '' && queryCategoryLevel1 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"/appinfo/category/getlevel2",//请求的url
			data:{queryCategoryLevel1:queryCategoryLevel1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#queryCategoryLevel2").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){



					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel2").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载二级分类失败！");
			}
		});
	}else{
		$("#queryCategoryLevel2").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#queryCategoryLevel2").html(options);
	}
	$("#queryCategoryLevel3").html("");
	var options = "<option value=\"\">--请选择--</option>";
	$("#queryCategoryLevel3").html(options);
});

$("#queryCategoryLevel2").change(function(){
	var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
	if(queryCategoryLevel2 != '' && queryCategoryLevel2 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"/appinfo/category/getlevel3",//请求的url
			data:{queryCategoryLevel2:queryCategoryLevel2},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#queryCategoryLevel3").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].categoryName);
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel3").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载三级分类失败！");
			}
		});
	}else{
		$("#queryCategoryLevel3").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#queryCategoryLevel3").html(options);
	}
});


var queryFlatformId = null;
var categoryLevel1=null;
var categoryLevel2=null;
var categoryLevel3=null;
$(function(){
	queryFlatformId = $("#queryFlatformId");
	categoryLevel1=$("#queryCategoryLevel1");
	categoryLevel2=$("#queryCategoryLevel2");
	categoryLevel3=$("#queryCategoryLevel3");

   $.ajax({
	   type:"GET",
	   url:"/appinfo/flatform/getFlatformList.json",
	   data:{method:"getflatformlist"},
	   dataType:"json",
	   success:function (data) {
		   if (data != null) {
			   queryFlatformId.html("");
			   var options = "<option value=\"\">--请选择--</option>";
			   for (var i = 0; i < data.length; i++) {
				   //alert(data[i].id);
				   //alert(data[i].roleName);
				   options += "<option value=\"" + data[i].flatformId + "\">" + data[i].flatformName + "</option>";

			   }
			   $("#queryFlatformId").html(options);
		   }

		   },
	   error:function (data) {//当访问时候，404，500 等非200的错误状态码
		   alert("加载平台失败！");
	   }
   })

	$.ajax({
		type:"GET",
		url:"/appinfo/flatform/getCL1List.json",
		data:{method:"getCL1list"},
		dataType:"json",
		success:function (data) {
			if (data != null) {
				categoryLevel1.html("");
				var options = "<option value=\"\">--请选择--</option>";
				for (var i = 0; i < data.length; i++) {
					//alert(data[i].id);
					//alert(data[i].roleName);
					options += "<option value=\"" + data[i].categoryLevel1 + "\">" + data[i].categoryLevel1Name + "</option>";

				}
				$("#queryCategoryLevel1").html(options);
			}

		},
		error:function (data) {//当访问时候，404，500 等非200的错误状态码
			alert("加载一级分类失败！");
		}
	})

	$.ajax({
		type:"GET",
		url:"/appinfo/flatform/getCL2List.json",
		data:{method:"getCL2list"},
		dataType:"json",
		success:function (data) {
			if (data != null) {
				categoryLevel2.html("");
				var options = "<option value=\"\">--请选择--</option>";
				for (var i = 0; i < data.length; i++) {
					//alert(data[i].id);
					//alert(data[i].roleName);
					options += "<option value=\"" + data[i].categoryLevel2 + "\">" + data[i].categoryLevel2Name + "</option>";

				}
				$("#queryCategoryLevel2").html(options);
			}

		},
		error:function (data) {//当访问时候，404，500 等非200的错误状态码
			alert("加载二级分类失败！");
		}
	})

	$.ajax({
		type:"GET",
		url:"/appinfo/flatform/getCL3List.json",
		data:{method:"getCL3list"},
		dataType:"json",
		success:function (data) {
			if (data != null) {
				categoryLevel3.html("");
				var options = "<option value=\"\">--请选择--</option>";
				for (var i = 0; i < data.length; i++) {
					//alert(data[i].id);
					//alert(data[i].roleName);
					options += "<option value=\"" + data[i].categoryLevel3 + "\">" + data[i].categoryLevel3Name + "</option>";

				}
				$("#queryCategoryLevel3").html(options);
			}

		},
		error:function (data) {//当访问时候，404，500 等非200的错误状态码
			alert("加载三级分类失败！");
		}
	})


})

$(".checkApp").on("click",function(){


	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}else if(vid == "" || vid == null||vid==0){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}

    else if(status == "1" && vid != "" && vid != null&&vid!=0){//待审核状态下才可以进行审核操作
		window.location.href="/appinfo/app/checkApp.html/"+ obj.attr("appinfoid");
	}
});



	
