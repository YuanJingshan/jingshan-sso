$(function () {
    var form = layui.form, layer = layui.layer;
    //表单取消事件
    $('body').on('click', '#btnCancel', function () {
        parent.layer.closeAll();
    })

    form.verify({
        password: function (value) {
            if (value.length > 30 || value.length < 6) {
                return '密码6~30字符';
            }
        }
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        layer.load(1);
        $.ajax({
            type: "POST",
            url: "/faq/user/changpwd",
            dataType: "JSON",
            data: data.field,
            success: function (data) {
                layer.closeAll('loading');
                if ($.constants.CODE_SUCCESS == data.code) {
                    setTimeout(function () {
                        layer.msg(data.msg, {icon: 1});
                        parent.layer.closeAll();
                    });
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