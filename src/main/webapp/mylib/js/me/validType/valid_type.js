
$(function(){

    $('#regis_name').textbox({
        initValue:"用户名在4~18位之间"
    })



});


$.extend($.fn.validatebox.defaults.rules, {
    regis_username: {
        validator: function(value, param){
            return value.length >= 4 && value.length <= 18;
        },
        message: "用户名在 4 到 18 位之间！"
    }
});
