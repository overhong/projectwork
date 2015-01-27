<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Index입니다...</title>
</head>
<body>
   <h1>Hello World!</h1>
   <h2>현재시간 : ${now}</h2>
   <table border="1" align="left">
      <form:form modelAttribute="loginForm">
         <tr>
            <td>아이디</td>
            <td><form:input path="userid" /></td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td><form:password path="password" showPassword="true" /></td>
         </tr>
         <tr>
            <td colspan="2" align="center"><input type="submit" value="로그인"/></td>
         </tr>
      </form:form>
   </table>
   <a href="./boardList.html">글목록보기</a>
   <a href="./insert.html">글작성하기</a>
</body>
</html>