$(function () {
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        //获取数据
        table.render({
            elem: '#table',
            url: '/faq/user/list/data',
            page: true,
            cols: [[
                {field: 'id', title: 'ID', sort: true, fixed: 'left'},
                {field: 'userName', title: '用户名'},
                {field: 'realName', title: '真实姓名', sort: true},
                {
                    field: 'sex', title: '性别', sort: true,
                    templet: function (d) {
                        if (d.sex) {
                            return '女';
                        } else {
                            return '男';
                        }
                    }
                },
                {
                    field: 'status', title: '是否锁定', sort: true,
                    templet: function (d) {
                        if (d.status) {
                            return '正常';
                        } else {
                            return '锁定';
                        }
                    }
                },
                {
                    field: 'createDate', title: '创建时间',
                    templet: function (d) {
                        return $.common.dateFormat(d.createDate);
                    }
                },
                {
                    field: 'updateDate', title: '更新时间',
                    templet: function (d) {
                        return $.common.dateFormat(d.createDate);
                    }
                },
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
            ]]
        });

        //监听行工具事件
        table.on('tool(user)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'del') {
                layer.confirm('真的删除行吗？', {icon: 3, title:'删除'}, function (index) {
                    // 删除
                    $.ajax({
                        type: "get",
                        async: false,
                        url: "/faq/user/delete/" + data.id,
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
            } else if (layEvent === 'edit') {
                layer.confirm('真的要重置密码？', {icon: 3, title:'重置密码'}, function(index){
                    $.ajax({
                        type: "get",
                        async: false,
                        url: "/faq/user/pwd/reset/" + data.id,
                        success: function (res) {
                            if ($.constants.CODE_SUCCESS == res.code) {
                                layer.msg("重置成功!");
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
         * 添加按钮点击事件
         */
        $("#add-btn").bind("click", function () {
            layer.open({
                title: '添加管理员',
                btn: ['确认', '取消'],
                area: '600px',
                content: $('#user-dialog').html(),
                success: function () {
                    form.render();
                },
                yes: function (index) {
                    debugger;
                    var params = {};
                    params.userName = $("#userName").val();
                    params.realName = $("#realName").val();
                    params.role = $("#role").val();
                    params.sex = $('input[name="sex"]:checked').val();
                    var lock = $('input[name="status"]:checked').val();
                    if ("on" == lock) {
                        params.status = 1;
                    } else {
                        params.status = 0;
                    }

                    $.ajax({
                        type: "post",
                        async: true,
                        data: params,
                        url: "/faq/user/save",
                        success: function () {
                            // 刷新表格
                            table.reload('table');
                        }
                    });
                    layer.close(index);
                },
                cancel: function (index) {
                    layer.close(index);
                }
            });
        })
    });
});