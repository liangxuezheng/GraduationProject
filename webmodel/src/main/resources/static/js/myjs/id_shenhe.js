/**
 * 登录页面 login js
 */
(function(win, $) {

	var doctor_list = {};

	var base ="http://localhost:8082/gra/queryMember";
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
	$('#table')
			.bootstrapTable(
					{
						url : base,
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
						pageSize : 10,// 每页条数
						pageList : [10,30,50],// 可选的每页数据
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
								user_phone:$("#user_phone").val(),
								idcard_state:$("#idcard_state").val()

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
									field : 'user_uid',
									title : '会员编号',
								},
                            {
                                align : 'center',
                                valign : 'middle',
                                field : 'user_phone',
                                title : '手机号',
                            },
								{
									align : 'center',
									valign : 'middle',
									field : 'info_name',
									width:'100',
									title : '真实姓名',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_idcard',
									title : '身份证号'
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_sex',
									title : '性别',
								}, {
                                align: 'center',
                                valign: 'middle',
                                field: 'idcard_state',
                                title: '审核状态',
                            	}, {
                                align: 'center',
                                valign: 'middle',
                                field: 'opt',
                                title: '操作',
                                formatter: function (value, row, index) {
                                    var str = "";
									if(row.idcard_state=='已认证'){
                                        str+= '已审核';
									}else{
                                        str+= '<a title="通过" class="tongguo" href="">通过</a>&nbsp;&nbsp;&nbsp;';
                                        str+= '<a title="不通过" class="butongguo" href="">不通过</a>&nbsp;&nbsp;&nbsp;';
									}
                                    return str;
                                },
                                events: {
                                    'click .butongguo': function (e, value,
                                                                  row, index) {
                                        var base = "http://localhost:8082/gra/ShenHe_IdCard";
                                        $.post(base, {info_id: row.info_id, idcard_state: '已驳回'}, function (res) {
                                            if(res.msg="success"){
                                                layer.msg('操作成功');
											}

                                        })
                                        $('#table').bootstrapTable('refresh');
                                    },
                                    'click .tongguo': function (e, value, row, index) {
                                        if (confirm("确定要审核通过么，一旦确定不可恢复")) {
                                            var url = "http://localhost:8082/gra/ShenHe_IdCard";
                                            $.post(url, {info_id: row.info_id, idcard_state: '已认证'}, function (result) {
                                                if(result.msg=="success"){
                                                    layer.msg('审核成功');
                                                }
                                            })
                                            $('#table').bootstrapTable('refresh');
                                        }
                                    },

                                }
                            }




                        ]
					});

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
