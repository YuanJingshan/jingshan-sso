$(function () {
    layui.use(['table'], function () {
        var table = layui.table;
        //获取数据
        table.render({
            elem: '#table',
            url: 'log/list',
            page: true,
            method: 'post',
            cols: [[
                {field: 'id', title: 'ID', sort: true, fixed: 'left'},
                {field: 'reqClientIp', title: '客户端IP'},
                {field: 'reqUri', title: '请求路径'},
                {field: 'reqType', title: '请求类型'},
                {field: 'reqMethod', title: '请求方式'},
                {field: 'reqParamData', title: '请求参数'},
                {
                    field: 'reqTime', title: '请求时间',
                    templet: function (d) {
                        return $.common.dateFormat(d.reqTime);
                    }
                },
                {field: 'sessionId', title: '会话ID'},

                {field: 'httpStatusCode', title: '请求状态'},
                {
                    field: 'returnTime', title: '返回时间',
                    templet: function (d) {
                        return $.common.dateFormat(d.returnTime);
                    }
                },
                // {field: 'returnData', title: '返回数据'},
                {field: 'timeConsuming', title: '处理时长（秒）'},
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
            ]]
        });

        //监听行工具事件
        table.on('tool(log)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'del') {
                layer.confirm('真的删除行吗？', {icon: 3, title: '删除'}, function (index) {
                    // 删除
                    $.ajax({
                        type: "get",
                        async: false,
                        url: "log/delete/" + data.id,
                        success: function (res) {
                            if ($.constants.CODE_SUCCESS == res.code) {
                                layer.msg("删除成功!");
                            } else {
                                layer.msg("服务器忙,请稍后再试！");
                            }
                            // 刷新表格
                            table.reload('table');
                        }
                    });
                    layer.close(index);
                });
            }
        });

        /**
         * 搜索按钮点击事件
         */
        $("#search-btn").click(function(){
            var value = $("#search-value").val();
            table.reload('table', {where: {uri: value}});
        });
    });
});
