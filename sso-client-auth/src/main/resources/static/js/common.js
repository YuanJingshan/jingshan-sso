(function ($) {
    layui.config({
        base: "/static/plugins/"
    }).extend({
        treeSelect: "treeSelect/treeSelect"
    });

    $.constants = {
        CODE_SUCCESS: 0,
        CODE_FAIL: 1
    };

    $.common = {
        dateFormat: function (time) {
            //时间戳为10位需*1000，时间戳为13位的话不需乘1000
            var date = new Date(time);
            var Y = date.getFullYear() + '-';
            var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
            var D = date.getDate() + ' ';
            var h = date.getHours() + ':';
            var m = date.getMinutes() + ':';
            var s = date.getSeconds();
            return Y + M + D + h + m + s;
            //
            // var d = new Date(time);
            // var year = d.getFullYear(); //年
            // var month = d.getMonth() + 1; //月
            // var day = d.getDate(); //日
            // var hh = d.getHours(); //时
            // var mm = d.getMinutes(); //分
            // var ss = d.getSeconds(); //秒
            //
            // var clock = year + "-";
            // if (month < 10)
            //     clock += "0";
            // clock += month + "-";
            // if (day < 10)
            //     clock += "0";
            // clock += day + " ";
            // if (hh < 10)
            //     clock += "0";
            // clock += hh + ":";
            // if (mm < 10) clock += '0';
            // clock += mm + ":";
            // if (ss < 10) clock += '0';
            // clock += ss;
            // return (clock);
        }
    }
})(jQuery);