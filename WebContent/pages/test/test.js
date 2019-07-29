define([ 'text!pages/test/test.html', 'uuitree', 'uuigrid' ], function(html) {
	var init = function(element) {
		var getListUrl = ctx + "/front/Testmobile/getMyToDoList";
		var viewModel = {
			md : document.querySelector('#test'),
			cardTable : new u.DataTable({
				meta : {
					'pk_group':{
						type:'string'
					},
					'pk_org':{
						type:'string'
					},
					'code':{
						type:'string'
					},
					'creator':{
						type:'string'
					}
				}
			}),
			data:[
				{
					"pk_group":"1",
					"pk_org":"1",
					"code":"1",
					"creator":"1"
				},
				{
					"pk_group":"1",
					"pk_org":"1",
					"code":"1",
					"creator":"1"
				},
				{
					"pk_group":"1",
					"pk_org":"1",
					"code":"1",
					"creator":"1"
				}
				
			],
			event : {
				pageInit : function() {
					$(element).html(html);
					app = u.createApp({
						el : element,
						model : viewModel
					});
					viewModel.event.initTestData();
				},
				initTestData : function() {
					var jsonData = {
							code:"1003537",
							searchname:""
					};
					$.ajax({
						type:"get",
						url:getListUrl,
						contentType:'application/json;charest=utf-8',
						dataType:"json",
						data:jsonData,
						success:function(res){
							console.log(res);
							if(res){
								var table = $('#sample_1').DataTable();
								var dataList = res.data;
								console.log(dataList);
								var billno,billtypename,sender_name,senddate,subject;
								for(var i in dataList){
									
									if(dataList[i].billno){
										billno = dataList[i].billno[1];
										
									}
									if(dataList[i].billtypename){
										billtypename = dataList[i].billtypename[1];
										
									}
									if(dataList[i].sender_name){
										sender_name = dataList[i].sender_name[1];
										
									}
									if(dataList[i].senddate){
										senddate = dataList[i].senddate[1].substring(0,10);
										
									}
									if(dataList[i].subject){
										subject = dataList[i].subject[1].substring(0,7)+"...";
										
									}
									/*if(dataList[i].billtypename){
										billtypename = dataList[i].billtypename[1];
									}*/
									
									table.row.add([billno,billtypename,sender_name,senddate,subject]).draw().node();
									
								}
								/*var td = document.getElementsByTagName('td');
								console.log(td);
								for(var i = 0;i < td.length;i++){
									if(td[i].className=="sorting_1")
									td[i].classList.remove("sorting_1");
								}
								console.log(td);*/
							}
						}
					})
					//console.log('test')
					//console.log(viewModel.data);
					//viewModel.cardTable.setSimpleData(viewModel.data);
					//console.log(viewModel.cardTable);
				}
			}
		}
		$(element).html(html);
		viewModel.md = document.querySelector('#test');
		viewModel.event.pageInit();
	}
	return {
		'template' : html,
		init : init
	}

})