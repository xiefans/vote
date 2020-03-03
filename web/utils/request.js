
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
                if (obj.success) {
                    obj.success(e);
                }
            } else {
                if (obj.fail) {
                    obj.fail(e);
                }
            }

            if (obj.complete) {
                obj.complete();
            }
        },
        error : function (e) {

            if (obj.fail) {
                obj.fail({message : "网络错误"});
            }

            if (obj.complete) {
                obj.complete();
            }
        }
    });
}