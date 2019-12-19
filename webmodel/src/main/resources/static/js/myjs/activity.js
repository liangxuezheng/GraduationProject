/**
 * 登录页面 login js
 */
(function(win, $) {


	var activity_list = {};

	// 新增/修改方法
	activity_list.updateAdds = function(dialogRef) {
		var url ="http://localhost:8082/gra/addActivity";

		$.post(url, {
            act_name:$("#act_xjname").val(),
            act_body:$("#act_xjbody").val(),
            creat_time:$("#start2").val(),
            end_time:$("#end2").val(),
            act_yhl : $("#act_yhl").val(),
		}, function(result) {
			if ("success" == result.msg) {
				layer.msg("增加成功");
				dialogRef.close();
				$('#table').bootstrapTable('refresh');
			} else if ("fail" == result.msg) {
				layer.msg("增加失败");
				dialogRef.close();
				$('#table').bootstrapTable('refresh');
			}

		})

	};
	activity_list.load = function(base, stat) {
		BootstrapDialog.show({
			title : stat == 1 ? '新建活动' : '编辑活动',
			message : $('<div></div>').load(base),
			closeable : true,

			buttons : [ {
				id : 'renxiaoda',
				label : '确定',
				action : function(dialog) {
					activity_list.updateAdds(dialog);
				}
			}, {
				label : '取消',
				action : function(dialog) {
					dialog.close();
				}
			} ]
		});
	}

	/* 编辑新增结束 */

	var base ="http://localhost:8082/gra/queryActivity";
	var pagenumber = $("#pageNumber").val();
	var pageSize = $("#pageSize").val();
	if (pagenumber == "") {
		pagenumber = 1;
	}
	if (pageSize == "") {
		pageSize = 10;
	}
	$(window).resize(function () {
		$("#table").bootstrapTable('resetView');
	})
	$('#table').bootstrapTable(
					{
						url :base,
						striped : true,// 隔行变色
						showColumns : true,// 是否显示 内容列下拉框
						showPaginationSwitch : true,// 是否显示 数据条数选择框
						minimumCountColumns : 3,// 最小留下一个
						showRefresh : false,// 显示刷新按钮
						showToggle : true,// 显示切换视图
						search : false,// 是否显示搜索框
						// searchOnEnterKey:true,//设置为
						// true时，按回车触发搜索方法，否则自动触发搜索方法
						pagination : false,// 开启分页
						paginationLoop : false,// 开启分页无限循环
						cache : false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
						pageNumber : 1,// 当前页数
						pageSize : 50,// 每页条数
						pageList : [50,30,10,'All'],// 可选的每页数据
						sidePagination : "server",//
						height:600,
						method : 'post',// 发送请求的方式
						contentType : "application/x-www-form-urlencoded",// 必须的否则条件查询时会乱码
						// 得到查询的参数
						queryParams : function queryParams(params) {
							// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							var param = {
                                p_pageSize : this.pageSize,
                                p_pageIndex : this.pageNumber,
                                act_name:$("#act_name").val(),
                                act_body:$("#act_body").val(),
                              /*  start:$("#start").val(),
                                end:$("#end").val()*/
							};
							return param;
						},
						onLoadSuccess : function() {
							$('#table tr td').each(function() {
								$(this).attr("title", $(this).text());
								$(this).css("cursor", 'pointer');
							});
						},
						columns : [
								{
									align : 'center',
									valign : 'middle',
									field : 'act_aid',
									title : '活动编号',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'act_name',
									title : '活动标题',

								},
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'creat_time',
                                title : '开始时间',
                                //获取日期列的值进行转换
                                formatter: function (value, row, index) {
                                    return changeDateFormat(value)
                                }

                            },
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'end_time',
                                title : '结束时间',
                                //获取日期列的值进行转换
                                formatter: function (value, row, index) {
                                    return changeDateFormat(value)
                                }

                            },
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'act_body',
                                title : '活动内容',

                            },
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'act_yhl',
                                title : '优惠率',

                            },
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'state',
                                title : '状态',
                                formatter : function(value, row, index) {
                                    return value == "1" ? "<span class='text-success'>启用</span>"
                                        : "<span class='text-danger'>禁用</span>";
                                }
                            },
								{
									align : 'center',
									valign : 'middle',
									field : 'opt',
									title : '操作',
									width : '120px',
									formatter : function(value, row, index) {
										var str = "";
											if (row.state == 1) {
												str += '<a title="关闭" class="guanbi" href="#times"><i class="fa fa-close"></i></a>&nbsp;&nbsp;&nbsp;';
											} else {
												str += '<a title="开启" class="kaiqi" href="#check"><i class="fa fa-check"></i></a>&nbsp;&nbsp;&nbsp;';
											}

											str += '<a title="删除" class="shanchu" href="#check"><i class="fa fa-trash"></i></a>&nbsp;&nbsp;&nbsp;';

										return str;
									},
									events : {
										'click .kaiqi' : function(e, value,
												row, index) {
											layer.msg('启用');
											var base = 'http://localhost:8082/gra/updActivity?act_aid='
													+ row.act_aid
													+ "&state=1";
                                            $.post(base,{
                                            }, function(result) {

                                                if ("success" == result.msg) {
                                                    window.location.href = "/web/sys_activity";
                                                } else if ("fail" == result.msg) {
                                                    window.location.href = "/web/sys_activity";
                                                }else if("chongfu_success"==result.msg){
                                                    layer.msg('只能开启一个活动，请先关闭其他活动');
												}

                                            })

										},
										'click .guanbi' : function(e, value,
												row, index) {
											layer.msg('禁用');
											var base = 'http://localhost:8082/gra/updActivity?act_aid='
                                                + row.act_aid
                                                + "&state=0";
                                            $.post(base,{
                                            }, function(result) {
                                                if ("success" == result.msg) {
                                                    window.location.href = "/web/sys_activity";
                                                } else if ("fail" == result.msg) {
                                                    window.location.href = "/web/sys_activity";
                                                }

                                            })
										},
										'click .shanchu' : function(e, value,
												row, index) {
											if(confirm("删除将无法恢复，确认删除吗")){
											var url = "http://localhost:8082/gra/delActivity";

													$.post(
															url,
															{
                                                                act_aid : row.act_aid
															},
															function(result) {
																if ("success" == result.msg) {
																	var pageNumber = $(
																			'#table')
																			.bootstrapTable(
																					'getOptions').pageNumber;
																	layer
																			.msg('删除成功');
																	$('#table')
																			.bootstrapTable(
																					'refresh');
																	$("#table")
																			.bootstrapTable(
																					'selectPage',
																					pageNumber); // 重新查询，跳转到第一页，比如page=5会变成page=1

																}
															})
										}},
									}
								},

						]
					});
//转换日期格式(时间戳转换为datetime格式)
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

	$("#activity_edit").click(function() {
		var base = "/web/goedit";
		activity_list.load(base, 1);
	})
	$("#queryBtn").on("click", function() {

		$("#table").bootstrapTable("refresh");
	});
    $("#reset").click(function(){

        setTimeout(function(){
            $('#table').bootstrapTable('refresh');
        }, 100 );
    })

})(window, jQuery);

// 服务器校验
