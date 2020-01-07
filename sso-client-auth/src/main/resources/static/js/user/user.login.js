layui.use(['layer', 'form'], function () {
    var layer = layui.layer, form = layui.form;

    $(window).on('load', function () {
        form.on('submit(login)', function (data) {
            $.ajax({
                url: "/faq/login/operate",
                type: "POST",
                dataType: "JSON",
                data: data.field,
                success: function (data) {
                    if ($.constants.CODE_SUCCESS == data.code) {
                        layer.closeAll('loading');
                        layer.msg(data.msg, {icon: 1});
                        setTimeout(function () {
                            location.replace("/faq/index");
                        }, 1000);
                    } else {
                        layer.closeAll('loading');
                        layer.msg(data.msg, {icon: 2});
                    }
                },
                error: function (xhr, status, info) {
                    layer.closeAll('loading');
                    layer.msg('网络异常，请刷新页面');
                }
            });
            return false;
        });
    }());
});