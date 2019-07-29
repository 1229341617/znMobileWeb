/**
 * author:chenhe 
 * date:20181218
 * 太阳，暖和，第二次修改
 */

define([ 'text!pages/approval/approval.html', 'css!pages/approval/approval.css', 'uuitree', 'uuigrid' ], function(template) {
	var init = function(element) {
		var viewModel = {
			getListUrl : ctx + "/front/oaandmobile/getMyToDoList",
			approvalUrl : ctx + "/front/oaandmobile/approval",
			event : {
				pageInit : function() {
					$(element).html(template);
					app = u.createApp({
						el : element,
						model : viewModel
					});
					viewModel.event.iniUsertList();
				},
				// 初始化数据
				iniUsertList : function() {
					var jsonData = {
						code : "1003537",
						searchname : ""
					};
					var billno, billtypename, sender_name, senddate, subject;
					var detail;
					$.ajax({
						type : "get",
						url : viewModel.getListUrl,
						contentType : 'application/json;charest=utf-8',
						dataType : "json",
						data : jsonData,
						success : function(res) {
							console.log(res);
							if (res) {
								var table = $('#sample_1').DataTable();
								var dataList = res.data;
								for ( var i in dataList) {
									if (dataList[i].billno) {
										billno = dataList[i].billno[1];
									}
									if (dataList[i].billtypename) {
										billtypename = dataList[i].billtypename[1];
									}
									if (dataList[i].sender_name) {
										sender_name = dataList[i].sender_name[1];
									}
									if (dataList[i].senddate) {
										senddate = dataList[i].senddate[1].substring(0, 10);
									}
									if (dataList[i].subject) {
										subject = dataList[i].subject[1].substring(0, 7) + "...";
									}
									detail = '<a href="javascript:void(0);" onclick="getDetail(\'' + dataList[i].pk_billtype[1] + '\',' + '\'' + dataList[i].checkman[1] + '\','
											+ '\'' + dataList[i].billid[1] + '\',' + '\'' + dataList[i].mobilebilltype[1] + '\',' + '\'' + dataList[i].workflow_type[1] + '\','
											+ '\'' + billtypename +'\','+'\''+dataList[i].taskid[1]+'\','+'\''+sender_name+'\','+'\''+senddate+ '\')">' + billno + '</a>';
									table.row.add([ detail, billtypename, sender_name, senddate, subject ]).draw().node();

								}
							}
						}
					})
				},

			}

		}
		// 跳转到详细页面
		getDetail = function(billtype, checkman, billid, mobilebilltype, workflowtype, billtypename,pk_flow,name,date) {
			var path = ctx+ '/#proDetail/proDetail';
			var href = path + '?billtype='+ billtype +'&checkman=' +checkman +'&billid=' + billid +'&mobilebilltype=' + mobilebilltype +'&workflowtype='+workflowtype+'&billtypename='+escape(billtypename)+'&pk_flow='+pk_flow+'&name='+escape(name)+'&date='+date;
			//如果有中文，需要对中文先进行编码再传参
			window.open(href);
			
			//console.log(window.location);
		}
		$(element).html(template);
		viewModel.md = document.querySelector('#user-mdlayout');
		viewModel.event.pageInit();
	}
	return {
		'template' : template,
		init : init
	}
});
