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
								user_phone:$("#user_phone").val()
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
									field : 'info_nc',
									title : '昵称'
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
									width:'60'
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_school',
									title : '学校'
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_qq',
									title : 'QQ'
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_email',
									title : '邮箱',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_grade',
									title : '会员等级',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'info_touxiang',
									title : '头像',
                                    formatter:function(value,row,index){
                                        return "<img width='36' src='"+value+"'>";
                                    }
								},

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
	$("#export").click(function () {
        $('#table').tableExport({ type: 'excel', escape: 'false',fileName:'会员信息表' })
    })
})(window, jQuery);

// 服务器校验
