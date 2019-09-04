<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 프로그램</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<form id="lotto" action="<%=request.getContextPath()%>/lotto.do">
	입금액 : <input type="text" name="money"/> <br />
	<input type="submit" value="로또번호생성"/>
	</form>
</body>
<script>
$('#lotto').submit(function(){
	alert('로또구입완료');
})
</script>
</html>