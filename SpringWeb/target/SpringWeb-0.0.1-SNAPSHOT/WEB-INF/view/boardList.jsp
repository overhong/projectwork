<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유게시판(리스트)</title>
</head>
<body>
	<h2 align="center">자유게시판</h2>
	<table border="1" width="500" cellpadding="0" cellspacing="0"
		align="center">
		<tr>
			<td align="right"><a href="insert.html">글쓰기</a></td>
		</tr>
		<tr>
			<td width="80">번호</td>
			<td width="200">제목</td>
			<td width="80">작성자</td>
			<td width="80">조회수</td>
			<td width="80">파일</td>
			<td width="80">날짜</td>
		</tr>

		<c:forEach var="board" items="${list}">
			<tr>
				<td width="80">${board.num}</td>
				<td width="200"><a href="detail.html?num=${board.num}">${board.title}</a></td>
				<td width="80">${board.userid}</td>
				<td width="80">${board.count}</td>
				<td width="80"><a href ="./images/${board.filename}">${board.filename}</a></td>
				<td width="80"><fmt:formatDate value="${board.regdate}"
						pattern="yyyy/MM/dd HH:mm:ss" /></td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>