/**
 * author:chenhe date:20181119
 */
define([ 'text!pages/proDetail/proDetail.html', 'css!pages/proDetail/proDetail.css', 'uuitree', 'uuigrid', 'config/sys_const' ], function(template) {
	toastr.options = {
		"closeButton" : "true",
		"debug" : false,
		"positionClass" : "toast-top-center",
		"onclick" : null,
		"showDuration" : "1000",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	};
	var init = function(element, params) {
		var viewModel = {
			app : {},
			pkBilltype : "",
			checkman : "",
			billid : "",
			mobilebilltype : "",
			workflow_type : "",
			billtypename : "",
			dataList : [],
			detailURL : ctx + "/front/Testmobile/getBillDetail",
			approvalUrl : ctx + "/front/Testmobile/approval",

			event : {
				agree : function() {
					console.log("审批");
				},
				// 初始化数据
				initUserList : function() {
					viewModel.pkBilltype = window.sessionStorage.getItem("pkBilltype");
					viewModel.checkman = window.sessionStorage.getItem("checkman");
					viewModel.billid = window.sessionStorage.getItem("billid");
					viewModel.mobilebilltype = window.sessionStorage.getItem("mobilebilltype");
					viewModel.workflow_type = window.sessionStorage.getItem("workflow_type");
					viewModel.billtypename = window.sessionStorage.getItem("billtypename");
					console.log(viewModel.billtypename);
					// 插入单据类型
					
					document.getElementById("typename").innerText = viewModel.billtypename;
					// 插入图标
					var div1 = document.createElement("div");
					div1.setAttribute("class", "c-line c-dot c-dot-left c-theme-bg c-theme-bg-after");

					
					spHead.appendChild(div1);
					var initData = {
						billtype : viewModel.pkBilltype,
						checkman : viewModel.checkman,
						billid : viewModel.billid,
						mobilebilltype : viewModel.mobilebilltype
					};
					$.ajax({
						type : 'get',
						url : viewModel.detailURL,
						contentType : 'application/json;charset=utf-8',
						data : initData,
						dataType : 'json',
						success : function(res) {
							if (res.flag == "success") {
								console.log(res);
								/*
								 * <div class="c-content-title-3 c-title-md
								 * c-theme-border" style="margin-top:15px">
								 * <h3 class="c-left c-font-uppercase">基本信息</h3>
								 * <div class="c-line c-dot c-dot-left "></div>
								 * </div>
								 */
								for ( var i in res) {
									if (i !== "flag" && i !== "msg") {
										// console.log(res[i]);
										 //在审批结果中插入报销人和报销时间
										 if(res[i].sender_name){
											// console.log(res[i].sender_name);
											 document.getElementById("sender_name").innerText = res[i].sender_name[1];
										 }
										 if(res[i].senddate){
											 document.getElementById("senddate").innerText = res[i].senddate[1];
										 }
										 //基本信息
										
										viewModel.event.getDetail(proDetail, res[i]);
									}

								}
								// viewModel.event.getDetail(res);
							}
						}

					});
				},

			}
		};
		// viewModel end

		/*
		 * <div class="col-md-4"> <div class="form-group"> <label>Small Input</label>
		 * <input type="text" class="form-control input-sm"
		 * placeholder="input-sm" disabled> </div> </div>
		 */
		// 显示基本信息
		viewModel.event.getDetail = function(proDetail, data) {
			// console.log(data);
			var baseContent = document.getElementById("baseContent");
			for ( var i in data) {

				// 动态创建基本信息(修改版2)
				if (data[i][0]) {
					
					var div2 = document.createElement("div");
					div2.setAttribute("class", "col-md-3");
					var div3 = document.createElement("div");
					div3.setAttribute("class", "form-group");
					
					div3.innerHTML = '<label style="font-size:14px;">'+data[i][0]+'</label>'+'<input type="text" class="form-control input-sm" style="text-align:center;" placeholder="'+data[i][1]+'" disabled />';
					
					div2.appendChild(div3);
					baseContent.appendChild(div2);
				} else {
					for (j in data[i]) {
						if (data[i][j]) {
							//console.log(data[i][j]);
							
							// 显示详细信息的小标题 start
							var divBody = document.createElement("div");
							var div1 = document.createElement("div");
							div1.setAttribute("class", "c-content-title-3 c-title-md c-theme-border");
							div1.setAttribute("id", "contentXX");
							div1.style.marginTop = "15px";
							
							div1.innerHTML = '<div class="img">'+'<span class="tools active" title="缩略视图">'+'<a onclick="shrinkXX(this,\''+j+'\')">'+'<i class="fa fa-list-ul">'+'</i>'+'</a></span>'+'<span class="tools" title="详细视图">'+'<a onclick="spreadXX(this,\''+j+'\')">'+'<i class="fa fa-th-large">'+'</i></a></span>'+'</div>'+'<h3 class="c-left c-font-uppercase" style="font-size:18px;">'+j+'</h3>'+'<span style="display:inline-block;margin-left:10px;">共2条'+'</span>'+'<div class="c-line c-dot c-dot-left"></div>';
							
							divBody.appendChild(div1);
							proDetail.appendChild(divBody);

							// 显示详细信息的小标题 end
							getShrinkXX(proDetail, divBody, j, data[i][j]);
							getSpreadXX(proDetail, divBody, j, data[i][j]);
						}

					}

				}

			}
		}
		// 点击缩略图，展开图隐藏
		shrinkXX = function(obj, data) {
			// 移除active属性
			var next1 = obj.parentNode.nextSibling;
			// console.log(next1);
			next1.classList.remove("active");
			// 移除active属性 end
			// 增加active属性
			obj.parentNode.className += " active";
			// 增加active属性 end
			// 显示缩略图
			var name1 = data + "_spread";
			var content = document.getElementById(name1);
			content.style.display = "none";
			var name2 = data + "_shrink";
			var content2 = document.getElementById(name2);
			content2.style.display = "block";
			// 显示缩略图 end
		}
		// 点击缩略图，展开图隐藏 end
		// 展开图
		spreadXX = function(obj, data) {
			// 移除active属性
			var next1 = obj.parentNode.previousSibling;

			next1.classList.remove("active");
			// 移除active属性 end
			// 增加active属性
			obj.parentNode.className += " active";
			// 增加active属性 end
			// 显示缩略图
			var name1 = data + "_shrink";
			var content1 = document.getElementById(name1);
			content1.style.display = "none";
			var name2 = data + "_spread";
			var content2 = document.getElementById(name2);
			content2.style.display = "block";
			// console.log(content2);
			// 显示缩略图
		}
		// 展开图 end
		// 显示缩略信息
		getShrinkXX = function(proDetail, divBody, j, data) {

			var _row = document.createElement("div");
			_row.setAttribute("class", "row tableHead");
			var name = j + "_shrink";
			// console.log(name);
			_row.setAttribute("id", name);
			var _col = document.createElement("div");
			_col.setAttribute("class", "col-md-12");
			var table = document.createElement("table");
			table.setAttribute("class", "table");
			var thead = document.createElement("thead");
			var trBody = document.createElement("tr");
			// 创建表头
			//console.log(data[0]);
			//创建编号
			var th = document.createElement("th");
			th.innerText = "";
			trBody.appendChild(th);
			//创建表头其他字段
			for ( var k in data[0]) {
				if (data[0][k] !== null) {
					var th = document.createElement("th");
					th.innerText = data[0][k][0];
					th.style.fontSize="14px";
					trBody.appendChild(th);
				}

			}
			thead.appendChild(trBody);
			table.appendChild(thead);
			// 设置表体
			var tbody = document.createElement("tbody");
			//console.log(data);
			for ( var k in data) {
				console.log(data[k]);
				//console.log(k);
				
				var trBody = document.createElement("tr");
				var td = document.createElement("td");
				td.innerText = (parseInt(k)+1);
				trBody.appendChild(td);
				for ( var l in data[k]) {
					if (data[k][l]) {
						var td = document.createElement("td");
						td.innerText = data[k][l][1];
						trBody.appendChild(td);
					}
				}
				tbody.appendChild(trBody);

			}
			table.appendChild(tbody);
			_col.appendChild(table);
			_row.appendChild(_col);
			divBody.appendChild(_row);
			proDetail.appendChild(divBody);
		}
		// 显示展开信息
		getSpreadXX = function(proDetail, divBody, j, data) {
			// 初始化序号
			var index = 1;
			// 初始化序号 end
			var div0 = document.createElement("div");
			// div0.setAttribute("class","col-md-12");
			var name = j + "_spread";
			div0.setAttribute("id", name);
			div0.style.marginLeft = "5px";
			div0.style.marginRight = "5px";
			div0.style.display = "none";
			for (k in data) {
				var div1 = document.createElement("div");
				div1.setAttribute("class", "row");
				// div1.setAttribute("id",j);
				div1.style.marginLeft = "5px";
				div1.style.marginRight = "5px";
				div1.style.marginBottom = "20px";
				div1.style.paddingTop = "10px";
				div1.style.boxShadow = "1px 2px 10px #EEE5EC";
				// 序号最外围的div start
				var divIndex = document.createElement("div");
				divIndex.style.display = "inline-block";
				divIndex.style.width = "30px";
				divIndex.style.height = "30px";
				divIndex.style.float = "left";
				divIndex.style.marginTop = "-10px";
				divIndex.style.background = "#32c5d2";
				divIndex.style.textAlign = "center"
				// 序号最外围的div end
				// 序号外围的span start
				var _id = document.createElement("span");
				_id.style.display = "inline-block";
				_id.style.marginTop = "2px";
				_id.innerText = index;
				index += 1;
				_id.style.color = "#fff";
				// 序号外围的span end
				divIndex.appendChild(_id);
				div1.appendChild(divIndex);
				// 数据显示最外围的col-md-12
				var col = document.createElement("div");
				col.setAttribute("class", "col-md-12");
				col.style.marginLeft = "20px";
				col.style.marginTop = "-10px";
				col.style.marginBottom = "20px";
				col.style.marginRight = "10px";
				for ( var l in data[k]) {
					if (data[k][l]) {

						if (data[k][l] !== null) {
							var div2 = document.createElement("div");
							div2.setAttribute("class", "col-md-3");

							div3 = '<div class=""form-group"><label style="font-size:14px;">' + data[k][l][0] + '</label>'
									+ '<input type="text" class="form-control input-sm" style="text-align:center;" placeholder="' + data[k][l][1] + '" disabled /></div>';
							div2.innerHTML = div3;

							col.appendChild(div2);
							div1.appendChild(col);

						}
					}

				}
				div0.appendChild(div1);
				divBody.appendChild(div0)
				proDetail.appendChild(divBody);

			}

		}
		viewModel.showTitle = function(data) {

		}
		viewModel.showContent = function(data) {

		}

		// 批准
		shenpi = function() {
			var checkNote = $('#checkNote').val();
			var spData = {
				billtype : viewModel.pkBilltype,
				billid : viewModel.billid,
				checkResult : 'Y',
				checkman : viewModel.checkman,
				checkNote : checkNote,
				pk_flow : "",
				workflowtype : viewModel.workflow_type
			};
			$.ajax({
				type : "get",
				url : viewModel.approvalUrl,
				data : spData,
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					if (res.flag == "success") {
						toastr["success"]("审批成功啦~");
					} else {
						toastr["warning"]("emmmmm..." + res.msg);
					}
				}
			})

		}
		// 驳回
		bohui = function() {
			var checkNote = $('#checkNote').val();
			var bhData = {
				billtype : viewModel.pkBilltype,
				billid : viewModel.billid,
				checkResult : 'N',
				checkman : viewModel.checkman,
				checkNote : checkNote,
				pk_flow : "",
				workflowtype : viewModel.workflow_type
			};
			$.ajax({
				type : "get",
				url : viewModel.approvalUrl,
				data : bhData,
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				success : function(res) {
					console.log(res);
					if (res.flag == "success") {
						toastr["success"]("驳回成功！");
					} else {
						toastr["warning"]("emmmmm..." + res.msg);
					}
				}
			})
		}
		document.addEventListener('scroll', function(event) {
			var t = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
			console.log(t);
		})

		$(element).html(template);
		viewModel.event.initUserList();
		$(function() {

		//document.getElementById("heads").style.display="none";
		})
	}

	return {
		'model' : init.viewModel,
		'template' : template,
		init : init
	}
});