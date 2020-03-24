<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
<head>
    <mvc:annotation-driven enable-matrix-variables="true"></mvc:annotation-driven>
    <context:component-scan base-package="com.th.action"></context:component-scan>
    <mvc:default-servlet-handler/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>logon</title>

    <script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript" src="../js/calendar.js"></script>
    <link rel = "shortcut icon" href="#"/>
<style>
/*大区域开始*/
body {
	background-image: url(../img/bg.jpg);
	background-repeat: no-repeat;
}
/*大区域结束*/
/*注册区域开始*/
.box{
	width:600px;
	height:auto;
	background:rgba(255,255,255,0.8);
	margin:auto;
	margin-top:90px;
	border-radius:3px;
	box-shadow:3px 3px 5px #0066FF;
	}
/*注册区域结束*/
/*标题开始*/
.biaoTi{
	text-align:center;
	color:#09F;
	padding-top:20px;
	font-size:36px;
	font-family:"楷体";
	}
/*标题结束*/

/*信息开始*/
.massage{
	margin-top:25px;
	}

.logon{
	font-family:"宋体";
	margin-left: 260px;
	margin-top:30px;
	width:100px;
	background-color:#09F;
	color:#FFF;
	border:none;
	font-size:20px;
	border-radius:4px;
    margin-bottom: 10px;
	}
/*信息结束*/

/*数据区域开始*/
.dataArea{
	margin-top:20px;
	margin-left: 150px;
	}
.dataArea label{
	width: 80px;
	display: inline-block;
    line-height: 25px;
}
.messages {
			display:inline-block;
			width: 160px;
            font-size: 12px;
            color: #999;
            background: url(../img/mess.png) no-repeat left center;
			padding-left: 20px;
        }
.code{
    width:80px;
}
.error{
    display: inline-block;
    color: red;
    font-size: 14px;
    margin-left: 10px;
}
/*数据区域结束*/

/*定义函数*/
.wrong {
            color: red;
            background-image: url(../img/wrong.png);
        }
        
        .right {
            color: green;
            background-image: url(../img/right.png);
		}
/*定义函数*/	
</style>

<script>
    /*<![CDATA[*/
	function passWord(){	// 首先判断的事件是表单失去焦点 onblur
	// 如果输入正确则提示正确的信息颜色为绿色小图标变化
	// 如果输入不是6到16位，则提示错误信息颜色为红色 小图标变化
	// 因为里面变化样式较多，我们采取className修改样式
	// 1.获取元素
	var ipt = document.querySelector('#ipt');
	var messages = document.querySelector('.messages');
	//2. 注册事件 失去焦点
	ipt.onblur = function() {
		// 根据表单里面值的长度 ipt.value.length
		if (this.value.length < 6 || this.value.length > 16) {
			// console.log('错误');
			messages.className = 'messages wrong';
			messages.innerHTML = '您输入的位数不对要求6~16位';
		} else {
			messages.className = 'messages right';
			messages.innerHTML = '您输入的正确';
		}
	}
}
    function change(img){
        //请求一次以后就不会重复请求，所以加参数（时间）
        img.src="/getcode?" + new Date().getTime();

    }
    //点击注册按钮后提交数据
    function regist() {
	    <%--var formData = $("#registerForm").serialize();--%>

        <%--$.post("${pageContext.request.contextPath}/registerServlet",formData,function (result) {--%>
        <%--    console.log(result);--%>
        <%--},"json");--%>
        $.ajax({
            type:"POST",
            dataType:"json",
            url:"${pageContext.request.contextPath}/registerServlet",
            data:$('#registerForm').serialize(),
            success:function (result) {
                if(result.flag == true){
                    location.href="${pageContext.request.contextPath}/jsp/login.jsp"
                }else{
                    //注册失败
                    var errorMsg = result.errorMsg;
                    $("#msg").html(errorMsg);
                }
            },
            error:function () {
                alert("异常!!!");
            }
        });
    }

/*]]>*/
</script>

</head>

<body>
<!--注册大区域开始-->
<div class="box">
	<!--标题开始-->
	<div class="biaoTi"><strong>智惠生活&nbsp;&nbsp;欢迎注册！</strong></div>
    <div class="massage">
    	<form  id="registerForm" action="#" method="post" >
            <input type="hidden" name="action" value="register"/>
        	<div class="dataArea">
            	<label>*昵称</label>
                <input type="text" onfocus="FocusItem(this);" onblur="checkItem(this);" name="userName" value="" />
                <span></span>
            </div>
            <div class="dataArea">
            	<label>*性别</label>
                <input type="radio" name="userSex" value="T" checked="checked"/>男
                <input type="radio" name="userSex" value="F" checked="checked"/>女
                <span></span>
            </div>
            <div class="dataArea">
            	<label>*出生日期</label>
                <input type="text" name="userBirthday" onfocus="c.show(this);" value=""/>
                <span></span>
            </div>
            <div class="dataArea">
            	<label>*联系电话</label>
                <input type="text" name="userMobile" onfocus="FocusItem(this);" onblur="checkItem(this);" value=""/>
                <span></span>
			</div>
			<div class="dataArea">
            	<label>住址</label>
                <input type="text" name="userAddress" value=""/>
            </div>
            <div class="dataArea">
            	<label>E-MAIL</label>
                <input type="text" name="userEmail" value=""/>
            </div>
            <div class="dataArea ">
            	<label>*密码</label>
				<input type="password" id="ipt" value="" name="userPassword" onfocus="passWord()"/>
				<p class="messages">请输入6~16位密码</p>
			</div>

            <div class="dataArea">
            	<label>*确认密码</label>
                <input type="password" onfocus="FocusItem(this);" onblur="checkItem(this);" name="userRepass"
                       value=""/>
                <span></span>
            </div>

            <div class="dataArea">
                <label>验证码</label>
                <input type="text" class="code" onfocus="FocusItem(this);" onblur="checkItem(this);" name="veryCode" value=""/>
                <img src="${pageContext.request.contextPath}/getcode" alt="看不清，换一张" onclick="change(this);"/>
                <span></span>
            </div>

            <div>
            	<input type="button" onclick="regist();"  class="logon" value="注册">
                <span id="msg" style="color:red;"></span>
            </div>
        </form>
    </div>
	<!--标题结束-->
</div>
<!--注册大区域结束-->

</body>
</html>
