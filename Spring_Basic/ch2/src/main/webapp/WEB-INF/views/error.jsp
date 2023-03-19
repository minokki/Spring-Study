<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<!-- isErrorPage="true" 에러페이지를 알려주는 기능, 작성시 컨트롤러에서 model객체로로 넘길 필요없다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
<%-- 발생한 예외 : ${ex}<br>    // 컨트롤러에서 model객체로 넘길시 받기--%>
<%-- 예외 메시지 : ${ex.message}<br> --%>

발생한 예외 : ${pageContext.exception}<br>
<!-- isErrorPage="true" 작성시 데이터받기 -->
예외 메시지 : ${pageContext.exception.message}<br>
<ol>
<c:forEach items="${ex.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>



