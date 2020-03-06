function qqfun(){
    var qNumber = $('#qqNum').val();
    if (qNumber) {
        $.ajax({
            type:'post',
            url: "/blog/comment/getUserInfo",
            data:{"qq":qNumber},
            success:function (res) {
                if (res) {
                    console.log(res)
                    $('#email').val(res.qemail)
                    $('#commentator').val(res.nickName)
                    $('#idPic').attr("src", res.headImage)
                }
            }
        })
    }
}

$('#commentSubmit').click(function () {
    var blogId = $('#blogId').val();
    var verifyCode = $('#verifyCode').val();
    var nickName = $('#commentator').val();
    var email = $('#email').val();
    var qNumber = $('#qqNum').val();
    var headImg = $('#idPic').attr("src");
    var websiteUrl = $('#websiteUrl').val();
    var commentBody = $('#commentBody').val();
    if (isNull(blogId)) {
        swal("参数异常", {
            icon: "warning",
        });
        return;
    }
    if (isNull(nickName)) {
        swal("请输入你的称呼", {
            icon: "warning",
        });
        return;
    }
    if (isNull(email)) {
        swal("请输入你的邮箱", {
            icon: "warning",
        });
        return;
    }
    if (isNull(qNumber)) {
        swal("请输入你的QQ号", {
            icon: "warning",
        });
        return;
    }
    if (isNull(verifyCode)) {
        swal("请输入验证码", {
            icon: "warning",
        });
        return;
    }
    var data = {
        "blogId": blogId, "verifyCode": verifyCode, "nickName": nickName,"headImg":headImg,
        "qNumber":qNumber, "email": email, "websiteUrl": websiteUrl, "commentBody": commentBody
    };
    console.log(data);

    $.ajax({
        type: 'POST',//方法类型
        url: '/blog/comment',
        data: data,
        success: function (result) {
            if (result.code == 0) {
                swal("评论提交成功请等待博主审核", {
                    icon: "success",
                });
                $('#commentBody').val('');
                $('#verifyCode').val('');
            }
            else {
                swal(result.desc, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});