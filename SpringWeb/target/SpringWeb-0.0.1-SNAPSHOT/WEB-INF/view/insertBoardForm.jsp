<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유게시판(글쓰기)</title>
</head>
<body>
	<h2>자유게시판</h2>
	<form method="post" action="insert.html" enctype="multipart/form-data">
		<!--  enctype="multipart/form-data : 파일업로드 사용시 필요 -->
		<table border="0" width="700" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td>글쓰기</td>
			</tr>
			<tr>
				<td>
					<table border="1" align="center">
						<tr>
							<td width="100">제목</td>
							<td width="400"><input type="text" name="title" /></td>
						</tr>
						<tr>
							<td width="100">내용</td>
							<td width="400"><textarea name="content" rows="10" cols="70"></textarea>
							</td>
						</tr>
						<tr>
							<td width="100">파일</td>
							<td width="400"><input type="file" name="file" />
						</tr>
					</table> <input type="hidden" name="userid" value="test1"> <input
					type="hidden" name="count" value="0" /> 

				</td>
			</tr>
			<tr>
				<td><input type="submit" value="등록" /> <input type="button"
					value="취소" onclick="history.go(-1)" /></td>
			</tr>

		</table>
	</form>
</body>
</html>