<%--
  Created by IntelliJ IDEA.
  User: LFool
  Date: 2019/7/28
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author Info Modify</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle!important;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Author Info Modify</h1>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>手机</th>

                </tr>
                </thead>
                <tbody>

                <form action="/author/update?id=${author.id}" method="post">
                    <tr>
                        <td><input type="hidden" value="${author.id}" class="input-small">${author.id}</td>
                        <td><input type="text" value="${author.userName}" class="input-small" name="userName"></td>
                        <td><input type="text" value="${author.password}" class="input-small" name="password"></td>
                        <td><input type="text" value="${author.email}" class="input-small" name="email"></td>
                        <td><input type="text" value="${author.address}" class="input-small" name="address"></td>
                        <td><input type="text" value="${author.phone}" class="input-small" name="phone"></td>
                        <td><button class="btn btn-info btn-sm" type="submit">修改</button></td>
                    </tr>
                </form>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
