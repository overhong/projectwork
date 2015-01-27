<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#userid").blur(function(){
		var id = $("#userid").val();
		$.ajax({
			cache:false,
			type:"POST",
			url:"userSearchId.json",
			data:{"userid":id},
			dataType:"json",
			success:function(data){		
				if(data.length==0){
				$("#ok").slideDown();//slideDown 나타남
				$("#text1").text("써도 되는 아이디다");
				} else {
				$("#no").slideDown();
				$("#text1").text("쓰면 안되는 아이디다");
				}
				}
		});
	});
	
	 $("#userid").focus(function(){
		$("#ok").slideUp();//사라짐
		$("#no").slideUp();
	});	 
});
</script>
<style>
 #ok,#no{display:none;} 
</style>
</head>
<body>
   <h1>회원 가입</h1>
   <p>회원 가입 해주시기 바랍니다.</p>
   <table>
      <form:form modelAttribute="signUpForm">
         <tr><td colspan="2">
            <form:errors path="*" element="div"/>
         </td></tr>
         <tr><td>
            <form:label path="userid">아이디</form:label>
         	<p class="userid-block"></p>
         </td><td>
            <form:input path="userid" size="20" />
            <span id="dupmsg">          
            <img id="ok" src="images/valid.png" title="써도됨"/>
            <img id="no" src="images/invalid.png" title="쓰면 안됨"/>
            </span>
            <span id="text1"></span>
         </td></tr>
         <tr><td>
            <form:label path="password">패스워드</form:label>
         </td><td>
            <form:password path="password" size="20"/>
         </td></tr>
         <tr><td>
            <form:label path="name">이름</form:label>
         </td><td>
            <form:input path="name" size="20"/>
         </td></tr>
         <tr><td>
            <form:label path="email">이메일</form:label>
         </td><td>
            <form:input path="email" size="20"/>
         </td></tr>
         <tr><td colspan="2">
            <input type="submit" value="가입"/>
         </td></tr>
      </form:form>
   </table>
</body>
</html>





