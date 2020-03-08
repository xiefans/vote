
function login(obj) {
    post({
        subUrl : "user/login",
        data : {username : obj.username, password : obj.password},
        success : function (e) {
            // 将用户的请求令牌保存到本地
            if (obj.success) {
                obj.success(e);
            }
        },
        fail : obj.fail
    });
}