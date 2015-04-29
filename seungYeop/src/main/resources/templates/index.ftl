<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>GET방식으로 파라미터 넘기기</h2>
<form action="/greeting" method="get">
	name : <input type="text" name="name"/>
	<input type="submit" value="확인"/>
</form>
</div>
<div>
<h2>파라미터 넘긴 후 데이터베이스에 저장된 데이터 가져오기!</h2>
<form action="/greeting" method="post">
	userId : <input type="text" name="userId"/>
	<input type="submit" value="확인"/>
</form>
<br/>
DB저장된 값<br/>
<#if friendList?has_content>
		<#list friendList as friend>
			id : ${friend.userId }, name = ${friend.name }<br/>
		</#list>
	<#else>
		DB에 저장된 데이터가 없습니다.
	</#if>
</div>
</body>
</html>