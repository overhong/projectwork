<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="js/colorbox-master/example1/colorbox.css">
<title>자유게시판(리스트)</title>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/colorbox-master/jquery.colorbox-min.js"></script>
<script>
   $(document).ready(function() {
      //colorbox설정
      $(".colorbox").colorbox({
         rel : "colorbox",//컬러박스 그룹화
         transition : "elastic",//elastic,fade,none 효과?
         speed : 400,//화면 표시 속도
         opacity : 0.85//배경투명도(0~1)? 1주면 검은색

      });
   });
</script>
<style>
.pagenation {
   text-align: center;
}

.pagenation li {
   display: inline-block;
   list-style: none;
   padding: 5px 9px;
   background: #eee;
}

.pagenation li.current {
   background: #66CC00;
   color: #fff;
}
</style>
<script>
   function goPage(page) {
      location.href = 'boardList.html?pageNum=' + page;
   }
</script>
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
            <td width="80">
             <c:if test="${board.filename!=null}">
            	<a class="colorbox"
               href="./images/${board.filename}" title="${board.filename}">${board.filename}</a>
             </c:if>
             <c:if test="${board.filename==null }">
               비었음
             </c:if></td>    
            <td width="80"><fmt:formatDate value="${board.regdate}"
                  pattern="yyyy/MM/dd HH:mm:ss" /></td>
         </tr>
      </c:forEach>

   </table>
   count:${count}
   <br /> totalPage:${totalPage}
   <br /> pageSize:${pageSize}
   <br /> currentPage:${currentPage}
   <br /> prevPage:${prevPage}
   <br /> nextPage:${nextPage}
   <br />

   <div class="pagenation" style="padding-left: 150px;">
      <ul>
         <!-- 이전버튼 -->
         <!-- prevPage > 0  // lt 는 < -->
         <c:if test="${prevPage gt 0}">
            <li class="prev"><a href="javascript:goPage(${prevPage});">Prev</a></li>
         </c:if>
         <c:forEach begin="${1+prevPage}" end="${nextPage-1}" step="1"
            varStatus="status">
            <!-- varStatus="status 인덱스를줌 -->
            <c:choose>
               <c:when test="${currentPage eq status.index}">
                  <!-- eq 같다-->
                  <li class="current">${status.index}</li>
               </c:when>
               <c:otherwise>
                  <li><a href="javascript:goPage(${status.index});">${status.index }</a></li>
               </c:otherwise>
            </c:choose>
         </c:forEach>

         <!-- 다음 gt : > // ge :=> -->
         <c:if test="${totalPage ge nextPage}">
            <li class="next"><a href="javascript:goPage(${nextPage});">Next</a></li>
         </c:if>
      </ul>
   </div>
</body>
</html>