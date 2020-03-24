
function FocusItem (msg) {
     if($(msg).attr('name')=='veryCode'){
          $(msg).next().next().html('').removeClass('error');
     }
     else{
          $(msg).next('span').html('').removeClass('error');
     }
}
//
// //校验用户名   单词字符，长度8-20位
// function checkUsername(){
//      //1.获取用户名的值
//      var username = $("#userName").value();
//      //2.定义正则表达式
//      var reg_username = "";
//      //3.判断，给出提示信息
//      var flag = reg_username.test(username);
//      if(!flag){
//           //用户名合法
//           $("#userName").css("border","");
//      }else{
//           //用户名非法
//           $("#userName").css("border","1px solid red");
//      }
//      alert("校验用户名");
//      return !flag;
// }
//
// //校验密码
// function checkpassword(){
//      alert("校验mima");
//      return false;
// }
// //onload入口函数

// $(function () {
//      //当表单提交时，调用所有的校验方法
//      $("#registerForm").submit(function () {
//           //返回true提交成功
//           return checkUsername() && checkpassword();
//           //如果这个方法没有返回值，或者返回为true,则表单提交，如果为false，则表单不提交
//      });
//      //当组件失去焦点，调用对用的验证方法
//      //用户名失去焦点
//      $("#userName").blur(checkUsername);
// });
//
//

function checkItem(obj) {
     var msgBox = $(obj).next('span');
     switch ($(obj).attr('name')) {
          case "userName":
               if (obj.value == "") {
                    msgBox.html('用户名不能为空');
                    msgBox.addClass('error');
                } //else {
     //                //url请求usernamecheck 传name  编码名字防止中文出错  对象obj   防止请求一个地址
     //                var url = "usernamecheck?name=" + encodeURI($(obj).val()) + "&" + new Date().getTime();
     //                //false   true
     //                //用ajax请求
     //                $.get(url, function (data) {
     //                     if (data == "false") {
     //                          msgBox.html('用户名已占用！');
     //                          msgBox.addClass('error');
     //                     } else {
     //                          msgBox.html().removeClass('error');
     //                     }
     //                });

               break;
          case "userSex":
               if (obj.value == "") {
                    msgBox.html('性别不能为空');
                    msgBox.addClass('error');
               }
               break;
          case "userBirthday":
               if (obj.value == "") {
                    msgBox.html('生日不能为空');
                    msgBox.addClass('error');
               }
               break;
          case "userMobile":
               if (obj.value == "") {
                    msgBox.html('电话不能为空');
                    msgBox.addClass('error');
               }
               break;
          case "userRepass":
               if (obj.value == "") {
                    msgBox.html('确认密码不能为空');
                    msgBox.addClass('error');
               } else if ($(obj).val() != $('input[name="userPassword"]').val()) {
                    msgBox.html('两次输入密码不一致');
                    msgBox.addClass('error');
               }
               break;
          case "veryCode":
               var numshow = $(obj).next().next();

               if (obj.value == "") {
                    numshow.html('验证码不能为空');
                    numshow.addClass('error');
               }
               break;
     }

}