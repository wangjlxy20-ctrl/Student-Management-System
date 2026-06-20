<%@ page import="com.wjl.entity.Student" %>

<%
    Student s = (Student) request.getAttribute("s");
    if (s == null) {
%>
<p>Do not get student information</p>
<%
        return;
    }
%>


<html>

<body>

<h2>update student</h2>


<form action="update" method="post">


    <input type="hidden"
           name="id"
           value="<%=s.getId()%>">


    Student Num:

    <input name="stu_num"
           value="<%=s.getSut_num()%>">


    <br>


    Name:

    <input name="name"
           value="<%=s.getName()%>">


    <br>


    Age:

    <input name="age"
           value="<%=s.getAge()%>">


    <br>


    <input type="submit"
           value="Save modification">


</form>

</body>

</html>