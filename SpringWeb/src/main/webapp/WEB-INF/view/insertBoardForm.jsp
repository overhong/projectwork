<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>자유게시판(글쓰기)</title>
<script>
   function save() {
      var f = document.writeForm;
      var fullfile = f.file.value;
      var arr = fullfile.split("\\");
      var filename = arr[arr.length - 1];
      var title = f.title.value;
      var content = f.content.value;
      if (title == "" || title.length > 25) {
         alert("제목은 필수입력사항이며 25글자 미만으로 입력하셔야합니다.");
         f.title.focus();
         return false;
      } else if (content == "" || content.length > 250) {
         alert("내용은 필수입력사항이며 250글자 미만으로 입력하셔야합니다.");
         f.title.focus();
         return false;
      } else if (filename.length > 20) {
         alert("파일 이름이 너무 깁니다.");
         return false;
      } else {
         f.submit();
         return;
      }

   }
</script>
</head>
<body>
   <h2>자유게시판</h2>
   <form:form modelAttribute="boardForm" name="writeForm" method="post" action="insert.html"
      enctype="multipart/form-data">
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
                     <td width="100"><input type="text" name="title" id="title" /></td>

                  </tr>
                  
                <%--   <tr>
                     <td width="100">작성자</td>
                     <td width="100"><input type="text" name="userid"
                        value="${sessionScope.user.userid}" readonly="readonly" /></td>
                  </tr> --%>

                  <tr>
                     <td width="100">내용</td>
                     <td width="400"><textarea name="content" rows="10" cols="70"
                           id="content"></textarea></td>
                  </tr>
                  <tr>
                     <td width="100">파일</td>
                     <td width="400"><input type="file" name="file" />
                  </tr>
                  <tr>
                     <td width="100">비디오</td><!-- varStatus? //var =""for문돌릴때 필요함 controller에서..  -->
                     <td width="400"><c:forEach items="${boardForm.videoList}" var="video" varStatus="videoStatus">
                     <p><form:input path="videoList[${videoStatus.index }].name"/><!-- path : id+name의 기능.. -->
                     <form:input path="videoList[${videoStatus.index }].file" type="file"/></p>
                     
                     </c:forEach>${videoList}</td>
                  </tr>
               </table> <%-- <input type="hidden" name="userid"
               value="${sessionScope.user.userid}" readonly="readonly" /> --%> <input
               type="hidden" name="count" value="0" />

            </td>
         </tr>
         <tr>
            <td><input type="button" value="등록" onclick="javascript:save()" />
               <input type="button" value="취소" onclick="history.go(-1)" /></td>
         </tr>

      </table>
   </form:form>
</body>
</html>