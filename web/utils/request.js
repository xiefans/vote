
let main_url = "http://localhost:9001/";
function post(obj) {
    $.ajax({
        type : "post",
        url : main_url + obj.subUrl,
        data : obj.data,
        crossDomain : true,
        dataType : "json",
        success : function (e) {
            if (e.code == 200) {
                obj.success(e);
            } else {
                obj.fail(e);
            }

            obj.complete();
        },
        error : function (e) {
            obj.fail({message : "网络错误"});
            obj.complete();
        }
    });
}