<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="js/jquery.bxslider/jquery.bxslider.css">
<title>메인 페이지</title>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/jquery.bxslider/jquery.bxslider.min.js"></script>
<script>  
$(document).ready(function(){
      //element
      //alert('jquery test!');
  $("h1").css("color","#660000");//h1의 엘리먼트를 찾아서 글자색 부여
  $("[name=love]").css("color","#f00");//name속성에 접근 후 글자색 부여
  //$("div").css("color","#f00");//만약 div전체에 스타일 주기
  $("#test1").css("color","#f00");//name이 아닌 id라면 이렇게 접근
  $(".test3").css("color","#cc99ff");//class 접근시.
  $("#test4").html("실패는 성공의 어머니");//id의 문구 대체
  $("#test4").css("color", "#f00");//id의 문구 색깔 주기
  /* 맨아래 2개를 합치면$("#test4").html("실패는 성공어머니").css("color","#f00"); 이걸 method chain이라함 */
  
  //$("#test5").html("서당개 3년이면 풍월을....").css("color","#f00").css("background-color","#ffffff");
  $("#test5").html("서당개 3년이면 풍월을....")
   			.css({"color":"red","background-color":"black","border":"1px solod green"});
  
  /*  var test = $("#test6").html();
  alert(test); //경고창 문구 띄우기 */
  
  $("#test4").html("<h1>시간은 돈이다..당근!!</h1>");
  //$("#test4").html("");//선택한 요소의 내용을 다 지워라
  //$("#test4").html();//선택한 요소의 내용을 가져와라(혼동금지!)
  
 /*  var test1 = $("#test6").text();
  alert(test1); //text는 태그를 읽는 능력이 없다. */
  
  $("#test6").text("원숭이도 <em>나무에</em>떨어질수 있다.")
  
  //폼태그 접근
  /* var tr = $("#travel").val();//#붙이고,val()요것만 기억하라!!
  var sp = $("#spot").val();
  alert(tr);
  alert(sp); */
  
 /*  $("#travel").val("일본 여행 가이드");//값 변경
  S("#spot").val("제주도"); */
  /* $("#travel").val("");//값삭제
  S("#spot").val(""); */
  
  $("#travel").blur(function(){//이벤트 핸들러
		  alert("한국 방문 감사드립니다.");
  	});
  
  /* $("#spot").change(function(){
	  alert("변경!");
	}); */
	
  $("#spot").change(function(){//체인지 이벤트
	  alert($(this).val()+"로 가실려구요?");
	});//this는 내가 선택한 값이다.
	
  $("#btn1").click(function(){//클릭 이벤트
	  alert("클릭하셨습니다");
  });
	
  $("#btn2").dblclick(function(){//더블클릭 이벤트
	  alert("더블클릭하셨습니다");
  });
  
  $("#travel").focus(function(){//포커스 이벤트
	  alert("한국에 오신 걸 환영합니다.");
  });
  
  $("#btn1").hover(
	  function(){//마우스르 위에 두었을때
		 $("#desc").css("color","#f00"); 
	  },
	  function(){//마우스를 요소에서 이동시켰을때 
		  $("#desc").css("color","#000"); 
	  }
  );
  
/*  $(document).ready(function(){
	 $("#main").fadeIn();//페이드인(괄호안에"slow"넣으면 기본값이다)
	 $("#welcome").fadeIn(5000);//천천히 (시간 지정:밀리언세컨)
	 });//페이드 인을 쓰려면 아래와 같이<style></style>을 먼저 주어야 한다. */
	 
 /* $(document).ready(function(){
		 $("#main").fadeOut();//페이드인(괄호안에"slow"넣으면 기본값이다)
		 $("#welcome").fadeOut(5000);	 
     });//페이드 아웃을 쓰려면 아래 스타일을 쓰면 안된다. */
 
/*   $(document).ready(function(){
	 $("#main").slideDown();//페이드인(괄호안에"slow"넣으면 기본값이다)
	 $("#welcome").slideDown(5000);
   }); */  //아래 display : none을 쓰면 안된다
     
/*  $(document).ready(function(){
	 $("#main").slideUp();
	 $("#welcome").slideUp(5000);
   }); //아래 display : none을 쓰면 안된다  */    
 
/*  $(document).ready(function(){
	 $("#student>p").each(function(){
		alert($(this).text()); 
	  	});
	}); */
   $(document).ready(function(){//bxslider표시 설정  
	    $(".bxslider").bxSlider({
      mode:'fade', //horizontal가로, vertical세로,fade사라짐
      speed:1000, //1초당 애니메이션 이동   
      auto:true,//자동재생(true: on, false:off)
      autoControls:true, //자동재생콘트롤 표시 (true: on, false:off)
      adaptiveHeight:true,//높이자동조정
      captions:false //true:title속성표시(이미지만표시) false:비표시
      });
   });	 
   
   
});
$(document).ready(function(){
	$("#searchBtn").click(function(){
		var nm = $("#name").val();
		$.ajax({
			timeout:3000,//3초이내 결과가 안나오면 에러(디폴트는 30초)
			type:"POST",//GET or POST
			url:"userSearch.json",//접속할 URL
			data:{"name":nm}, //파라미터얻기 
			dataType:"json",//출력데이터타입(html,xml,json,text)
			success:function(data){
				//alert(data);
				//테이블로 표시
				//제이슨 하위테이블 삭제
				$("#jsonOut>table").remove();
				var theTable = $("<table>");//테이블 요소 작성(꺽쇠를 반드시 써라)
				//만약$("table")이라면 기존의 테이블을 모두 참조하겠다라는 의미
				theTable.append("<tr><td>이름</td><td>비번</td><td>아이디</td><td>이메일</td></tr>");//테이블에 행 추가
				for(i=0;i<data.length;i++){
					theTable.append("<tr><td>" + data[i].name 
							+ "</td><td>" + data[i].password 
							+ "</td><td>" + data[i].userid 
							+ "</td><td>" + data[i].email + "</td></tr>");//
				}
				theTable.appendTo("#jsonOut");//테이블을 jsonOut에 붙인다.
			},
			error:function(xhr,textStatus,errorThrown){
				if(textStatus == "timeout"){
					alert("시간 초과");
				}else{
					alert("textStatus : "+ textStatus);//에러 타입					
					alert("errorThrown : "+ errorThrown);//에러 메시지
				}
			}
		});
	});
});
</script>
<style>
  /* h1,h2{display: none}  */
</style>
</head>
<body>
	<h1 id="main">Main Page입니다</h1>
	<h2 id="welcome"><font color="blue">
	${sessionScope.user.userid}님 환영합니다.
	</font></h2>
	<a href="./insert.html">글작성하기</a>
	<a href="logout.html"><font color="red">로그아웃</font></a>
	<div name="test">
		<p>I am a student.</p>			
	</div><hr/>
	<div name="love">
		<p>You are a student.</p>
	</div><hr/>
	<div id="test1">
		<p>He is a student.</p>				
	</div><hr/>
	<div id="test2">
		<p>She is a student.</p>			
	</div><hr/>
	<div class="test3">
		<p>They are students.</p>		
	</div><hr/>
	<div class="test3">
		<p>They are not students.</p>		
	</div><hr/>
	<div id="test4">구슬이 서말이라도 꿰어야 보배</div><hr/>
	<div id="test5">낮말은 새가 듣고 밤말은 쥐가 듣는다</div><hr/>
	<div id="test6">낮말은 새가 듣고 밤말은 <em>쥐가 듣는다</em></div><hr/>
	<p>
		<input type="text" id="travel" value="한국여행가이드"/>
	</p>
	<p>	
		<select id="spot">
			<option value="제주도" >제주도</option>
			<option value="울릉도" >울릉도</option>
			<option value="독도" selected>독도</option>
		</select>
	</p>
	
	<button id="btn1">버튼1 : 클릭해</button>
	<button id="btn2">버튼2 : 더블클릭해</button>
	
	<p id="desc">버튼1에 마우스를 올려 놓으시면 글씨 색깔이 변합니다.</p>
	
	<div id="student">
		 <p>홍길동</p>			
		 <p>이몽룡</p>			
		 <p>변강쇠</p>
	</div>
	
	<div class="slider" style="width:900px">
		<ul class="bxslider"><!-- <-이 문구는 꼭 넣어야 한다. -->
			<li><img src="images/33.jpg" title="고양이1"/></li>
			<li><img src="images/55.jpg" title="고양이2"/></li>
			<li><img src="images/77.jpg" title="고양이3"/></li>
		</ul>		
	</div>
	
	<p>이름 : <input type="text" id="name"/></p>			
	<p><button id="searchBtn">검색</button></p>
	<p><span id="jsonOut">여기에 결과가 출력</span></p>
	<p>2015.All right reserved</p>			
</body>
</html>



















