<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $("#testRedbody").click(function(){
            var url = this.href;
            var args = {};
            $.post(url, args, function(data){
                for(var i = 0; i < data.length; i++){
                    var id = data[i].lun;
                    //var lastName = data[i].name;

                    alert(id + ": ");
                }
            });
            return false;
        });
    })


</script>

<a href="/springmvc/ResponseBody" id="testRedbody">16.测试Resbody</a>

<br><br>



14.form标签
<a href="springmvc/formbiaodan">14.form标签</a>
<br>

<!--13.重定向 -->
13.重定向
<a href="springmvc/testRedirect">13.重定向</a>

<br>

12.测试ModelAttribute这个方法 先通过参数去数据库里查找，然后再放到session中，然后再通过session，注入到实体pojo类型中
<form action="springmvc/ModelAttribute" method="post">

    name:  <input type="text" name="name"><br><br>
    lun: <input type="text" name="lun"><br><br>
    company.name:<input type="text" name="company.name"><br><br>
    company.address: <input type="text" name="company.address"><br><br>

    <input type="submit" value="这是测试实体类，直接注入" >
</form>

<br>




<br><br>

11.测试session 先注入实体类，然后再放到session中
<form action="springmvc/SessionAttrbute" method="post">
    name:  <input type="text" name="name"><br><br>
    lun: <input type="text" name="lun"><br><br>
    company.name:<input type="text" name="company.name"><br><br>
    company.address: <input type="text" name="company.address"><br><br>

    <input type="submit" value="这是测试实体类，直接注入" >
</form>



<br>


<a href="springmvc/map">10.测试map</a>
<br>
<a href="springmvc/ModeAndView/1">9.测试ModeAndView</a>

<br>
8.测试直接注入实体类。
<form action="springmvc/inPoJo" method="post">
  name:  <input type="text" name="name"><br><br>
   lun: <input type="text" name="lun"><br><br>
    company.name:<input type="text" name="company.name"><br><br>
    company.address: <input type="text" name="company.address"><br><br>

    <input type="submit" value="这是测试实体类，直接注入" >
</form>


<a href="springmvc/testParamsAndHeaders?username=atguigu&age=10">7.CookValueANDhead</a>
<br><br>
<a href="springmvc/requestParam?username=2343242">6.测试requestParam</a>
<br><br>
<form action="springmvc/restful/1" method="POST">
    <!-- POST风格我们只能用表单去请求-->
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="5.restFul风格DELECT"/>
</form>

<form action="springmvc/restful/1" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="5.restFul风格DELECT"/>
</form>
<form action="springmvc/restful" method="POST">
    <input type="submit" value="5.restFul风格POST"/>
</form>
<form action="springmvc/restful/1" method="get">
    <input type="submit" value="5.restFul风格GET"/>
</form>

<br><br>
<a href="springmvc/PathVariable/{id}">4.PathVarable占位符</a>
<br><br>
<a href="springmvc/reqeustMappingMethod/*/abc">3.通配符</a>
<br><br>
<a href="springmvc/reqeustMappingMethod">2.测试requestMapping的四个参数</a>

<br><br>
<a href="springmvc/helloWorld">1.Hello World</a>


</body>
</html>