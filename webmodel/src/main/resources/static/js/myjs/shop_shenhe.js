/**
 * 登录页面 login js
 */
(function(win, $) {

	var doctor_list = {};

	var base ="http://localhost:8082/gra/ShenHeShop";
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
                                shop_name:$("#shop_name").val(),
                                shop_state:$("#shop_state").val()
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
									field : 'shop_sid',
									title : '商铺编号',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'user_uid',
									width:'100',
									title : '会员编号',
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'shop_name',
									title : '商铺名称'
								},
								{
									align : 'center',
									valign : 'middle',
									field : 'shop_state',
									title : '状态',
								}, {
                                align: 'center',
                                valign: 'middle',
                                field: 'shop_jianjie',
                                title: '简介',
                            	}, {
                                align: 'center',
                                valign: 'middle',
                                field: 'shop_time',
                                title: '注册时间',
                                //获取日期列的值进行转换
                                formatter: function (value, row, index) {
                                    return changeDateFormat(value)
                                }
                            },{
                                align: 'center',
                                valign: 'middle',
                                field: 'opt',
                                title: '操作',
                                formatter: function (value, row, index) {
                                    var str = "";
									if(row.shop_state=='已审核'){
                                        str+= '已审核';
									}else{
                                        str+= '<a title="通过" class="tongguo" href="#times">通过</a>&nbsp;&nbsp;&nbsp;';
                                        str+= '<a title="不通过" class="butongguo" href="#check">不通过</a>&nbsp;&nbsp;&nbsp;';
									}
                                    return str;
                                },
                                events: {
                                    'click .butongguo': function (e, value,
                                                                  row, index) {
                                        var base = "http://localhost:8082/gra/ShenHe_Shop";

                                        $.post(base, {shop_id: row.shop_id, shop_state: '已驳回'}, function (res) {
                                            if(res.msg="success"){
                                                layer.msg('操作成功');
                                            }

                                        })
                                        $('#table').bootstrapTable('refresh');
                                    },
                                    'click .tongguo': function (e, value, row, index) {
                                        if (confirm("确定要审核通过么，一旦确定不可恢复")) {

                                            var url = "http://localhost:8082/gra/ShenHe_Shop";
                                            $.post(url, {shop_sid: row.shop_sid, shop_state: '已审核'}, function (result) {
                                                if(res.msg="success"){
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
