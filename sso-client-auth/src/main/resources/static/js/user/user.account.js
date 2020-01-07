$(function () {
    var form = layui.form, layer = layui.layer;

    //表单取消事件
    $('body').on('click', '#btnCancel', function (data) {
        parent.layer.closeAll();
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var obj_user = data.field;
        obj_user['mine'] = "0";
        layer.load(1);
        $.ajax({
            type: "POST",
            url: "/faq/user/save",
            dataType: "JSON",
            data: obj_user,
            success: function (data) {
                layer.closeAll('loading');
                if ($.constants.CODE_SUCCESS == data.code) {
                    parent.layer.closeAll();
                    setTimeout(function () {
                        layer.msg(data.msg, {icon: 1});
                        parent.location.reload();
                    }, 1 * 1000);
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            },
            error: function () {
                layer.closeAll('loading');
                layer.msg('网络异常，请刷新页面', {icon: 2});
            }
        });
        return false;
    });

});