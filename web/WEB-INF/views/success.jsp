<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Sucess Page</h4>
	ModeAndView  id:${requestScope.id}
    <br>
    Map.map: ${requestScope.name}
    <br>
    session.attribute: ${requestScope.c}
    <br>
    ModelAttribute.name: ${requestScope.name}



这个标签必须有个默认的bean，程序默认的bean 是command,我们必须用ModleAttribute来回显示
    modelAttribut会先跟域中找。然后再找command的表单中找。
    表单的属性必须与bean中的属性一一对应。不然会报错。
    form标签是必须回显的。
    方法一  提示：我们访问handler必须要访问由ModelAttrbute标志的标签，所以我们可以在由ModelAttrbute中添加一个bean
    方法二    提示：我们也可以在访问的handler中添加。
<br>
  <form:form action="springmvc/ModelAttribute" method="post" modelAttribute="car">
      <form:input path="name"    />
      <br>
      <form:input path ="lun"/>





        <input type="submit" value="提交">
  </form:form>



</body>
</html>