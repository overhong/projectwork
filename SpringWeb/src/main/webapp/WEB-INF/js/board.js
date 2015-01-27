function save(){

var f = document.writeForm;
var fullfile = f.file.value;
var arr = fullfile.split("\\");
var filename = arr[arr.length-1];
if(f.title.value==""){
	alert("제목을 입력하라");
	f.title.focus();
	return false;
} else if(f.title.value.length>25){
	alert("제목 길이가 깁니다");
	f.title.focus();
	return false;
} else if(f.content.value==""){
	alert("내용을 입력하시오");
	f.content.focus();
	return false;
} else if(f.content.value.length>250){
	alert("내용 길이가 깁니다");
	f.content.focus();
	return false;
} else if(f.filename.lenght>20){
	alert("파일 이름이 깁니다.");
	return false;
} else {
	f.submit();
	retrun;
	}
}
