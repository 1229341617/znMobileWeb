/**
 * author:chenhe 
 * date:20190104 
 * 修改数据结构，foreach能够循环显示数据 
 * 下雨，潮湿，多云
 */
define([ 'knockout', 'text!pages/proDetail/proDetail.html', 'css!pages/proDetail/proDetail.css', 'uuitree', 'uuigrid' ], function(ko, template) {
	toastr.options = {
		"closeButton" : "true",
		"debug" : false,
		"positionClass" : "toast-top-right",
		"onclick" : null,
		"showDuration" : "1000",
		"hideDuration" : "1000",
		"timeOut" : "1000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	};
	var init = function(element) {
		var viewModel = {
			billtype : "",
			checkman : "",
			billid : "",
			//mobilebilltype : "",
			//workflowtype : "",
			pk_sender: "",
			pk_flow:"",
			detailURL : ctx + "/front/oaandmobile/getBillDetail",
			approvalUrl : ctx + "/front/oaandmobile/approval",
			downFile:ctx + "/front/oaandmobile/downFile",
			dataList : ko.observableArray([]),// 主表
			dataListNew : ko.observableArray([]),// 主表
			childList : ko.observableArray([]),// 子表
			grandList : ko.observableArray(),// 孙表
			otherList :ko.observableArray(),
			approhisinfoList: ko.observableArray([]),
			fileList:ko.observableArray([]),
			event : {
				pageInit : function() {
					$(element).html(template);
					app = u.createApp({
						el : element,
						model : viewModel
					});
					viewModel.event.initUserList();
					// viewModel.event.scroll();
				},
				// scroll事件监听
				scroll : function() {
					var nScrollTop = 0, nScrollHeightn;
					var dealHead = document.getElementById('dealHead');
					document.getElementById("hh").addEventListener("scroll", function() {
						nScrollTop = $(this)[0].scrollTop;
						nScrollHeight = $(this)[0].scrollHeight;// 当前不可见部分元素的高度
						// nClientHeight = $(this)[0].clientHeight;//滚动条的高度
						// console.log("1" + nScrollHeight);
						// console.log("2"+nClientHeight);
						if ((nScrollTop > (100 + 10))) {
							dealHead.style.position = "fixed";
							dealHead.style.width = "90%";
							dealHead.style.top = "0";
							dealHead.style.zIndex = "999";
							dealHead.style.boxShadow = "none";
							// dealHead.setAttribute("style",'box-shadow:none');
							dealHead.style.background = "#f4f9ff";
						} else {
							dealHead.style.position = "";
							dealHead.style.width = "";
							dealHead.style.top = "";
							dealHead.style.zIndex = "";
							dealHead.style.background = "#fff";
							dealHead.style.boxShadow = "0 10px 25px -10px #32c5d2";
						}
					})
				},
				getQuery : function(name){
					 var hash = window.location.hash;
					 var search = hash.substring(hash.indexOf("?"));
					 var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
					 var r = search.substr(1).match(reg);
					 if(r!=null) return unescape(r[2]);return null;
				},
				// 初始化数据
				initUserList : function() {
					viewModel.billtype = this.getQuery("billtype");
					// console.log(viewModel.pkBilltype);
					viewModel.checkman = this.getQuery("checkman");
					// console.log(viewModel.checkman);
					viewModel.billid = this.getQuery("billid");
					// console.log(viewModel.billid);
					//viewModel.mobilebilltype = this.getQuery("mobilebilltype");
					// console.log(viewModel.mobilebilltype);
					//viewModel.workflowtype = this.getQuery("workflowtype");
					// console.log(viewModel.workflow_type);
					viewModel.pk_flow = this.getQuery("pk_flow");
					viewModel.pk_sender = this.getQuery("pk_sender");
					// 插入图标
					var div1 = document.createElement("div");
					div1.setAttribute("class", "c-line c-dot c-dot-left c-theme-bg c-theme-bg-after");
					spHead.appendChild(div1);
					var initData = {
						billtype : viewModel.billtype,
						checkman : viewModel.checkman,
						billid : viewModel.billid,
						//mobilebilltype : viewModel.mobilebilltype,
						pk_flow : viewModel.pk_flow
						//billtypename: viewModel.billtypename,
						pk_sender: viewModel.pk_sender
					};
					$.ajax({
						type : 'get',
						url : viewModel.detailURL,
						contentType : 'application/json;charset=utf-8',
						data : initData,
						dataType : 'json',
						success : function(res) {
							//console.log(res);
							if (res.flag == "success") {
								//console.log(res);
								var data = res.data.data[0].data;
								//console.log(data)
								// 主表
								viewModel.dataListNew(data.head)
								viewModel.dataList(data.head[0].tabdata);
								//console.log(data.head[0].tabdata);
								/*var tablist=data.head[0].tabdata;
								$.each(tablist, function(key, item){
									if(typeof(item) === "object" ){
										$.each(item, function(key, item1){
											if(typeof(item) === "object" ){
												console.log(item1.colname);
												console.log(item1.colvalue);
											}
										});
									}
								}); */
								document.getElementById("typename").innerText = res.data.ebilltypename;
								document.getElementById("sender_name").innerText = res.data.sendername;
								document.getElementById("senddate").innerText = res.data.senderdate;
								// 子表
								//console.log(data.body);
								viewModel.childList(data.body);
								viewModel.approhisinfoList(res.data.approhisinfo);
								viewModel.fileList(res.data.ncfilelist);
							}
						}
					});
				},
				// 批准
				shenpi : function() {
					var checkNote = $('#checkNote').val();
					var spData = {
						billtype : viewModel.billtype,
						billid : viewModel.billid,
						checkResult : 'Y',
						checkman : viewModel.checkman,
						checkNote : checkNote,
						pk_flow : viewModel.pk_flow,
						workflowtype : viewModel.workflowtype
					};
					// console.log(spData);
					$.ajax({
						type : "get",
						url : viewModel.approvalUrl,
						data : spData,
						contentType : 'application/json;charset=utf-8',
						dataType : 'json',
						success : function(res) {
							//console.log(res);
							if (res.flag == "success") {
								toastr["success"]("审批成功啦~φ(>ω<*)");
								bootbox.confirm({
									message:"是否关闭当前页面？",
									size:"small",
									buttons:{
										confirm:{
											label:'确定'
										},
										cancel:{
											label:'取消'
										}
									},
									callback:function(result){
										if(result == true){
											window.close();
										}
									}
								});
							} else {
								toastr["warning"]("(╥╯^╰╥) emmmmm..." + res.msg);
								
							}
						},
						error : function(err) {
							toastr["error"]("(；´д｀)ゞ  出错啦!" + err);
						}
					})
				},
				// 驳回
				bohui : function() {
					var checkNote = $('#checkNote').val();
					var bhData = {
						billtype : viewModel.billtype,
						billid : viewModel.billid,
						checkResult : 'R',
						checkman : viewModel.checkman,
						checkNote : checkNote,
						pk_flow : viewModel.pk_flow,
						workflowtype : viewModel.workflowtype
					};
					// console.log(bhData);
					$.ajax({
						type : "get",
						url : viewModel.approvalUrl,
						data : bhData,
						contentType : 'application/json;charset=utf-8',
						dataType : 'json',
						success : function(res) {
							//console.log(res);
							if (res.flag == "success") {
								toastr["success"]("驳回成功！ヾ(=･ω･=)o");
								bootbox.confirm({
									message:"是否关闭当前页面？",
									size:"small",
									buttons:{
										confirm:{
											label:'确定'
										},
										cancel:{
											label:'取消'
										}
									},
									callback:function(result){
										if(result == true){
											window.close();
										}
									}
								})
							} else {
								toastr["warning"]("(；´д｀)ゞ  emmmmm..." + res.msg);
							}
						}
					})
				},
				
			}
		}//viewmodel
		//显示缩略图
		shrinkXX=function(obj){
			var name = obj.parentNode.childNodes;
			//删除相邻节点的native属性
			name[3].classList.remove("native");
			//增加自己的native属性
			name[1].className += " native";
		}
		//显示展开图
		spreadXX = function(obj){
			var name = obj.parentNode.childNodes;
			//删除相邻节点的native属性
			name[1].classList.remove("native");
			//增加自己的native属性
			name[3].className += " native";
		}
		//显示展开图
		getQueryString = function(name){
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			  var r = window.location.search.substr(1).match(reg); 
			  if (r != null) return decodeURI(r[2]); return null;
		}
		$(element).html(template);
		viewModel.md = document.querySelector('#user-mdlayout');
		viewModel.event.pageInit();
		
		//下载附件
		getDownLoad = function (args) {
			var child =  args.childNodes;
			var pk_file = child[3].innerHTML;
			//console.log(pk_file);
			var url = viewModel.downFile+"/"+pk_file;
			var form = $("<form></form>").attr("action",url).attr("method","post");
			form.append("<input/>").attr("type","hidden").attr("name","filename").attr("value",pk_file);
			form.appendTo('body').submit().remove();
			
		}
//		changeInput = function(obj){
//			let input = $(obj)
//			let inputAll = $('.file-detail input')
//			let checkAllState = true
//			inputAll.map((item, index) => {
//				if(!index.checked){
//					checkAllState = false
//				}
//			})
//			$('#checkAll').attr('checked', checkAllState)
//		}
//		clickLabel = function(obj){
//			let input = $(obj).prev()
//			let inputAll = $('.file-detail input')
//			let checkAllState = true
//			if(input.attr('checked')){
//				input.attr('checked',false)
//			}else{
//				input.attr('checked',true)
//			}
//			inputAll.map((item, index) => {
//				if(!index.checked){
//					checkAllState = false
//				}
//			})
//			$('#checkAll').attr('checked', checkAllState)
//		}
	}
	return {
		'template' : template,
		init : init
	}
})
