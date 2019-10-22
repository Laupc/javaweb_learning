<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" >

        function selected() {
            //获取用户请求信息
            var name = document.getElementById("name").value;
            //获取数据
            //创建ajax引擎对象
            var request;
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest();
            }else if (window.ActiveXObject){
                request = new ActiveXObject("Msxml2.XMLHTTP");
            }
            //复写onreadystatechange
            request.onreadystatechange=function () {
                //判断ajax状态码
                if (request.readyState == 4){
                    //判断响应状态码
                    if (request.status == 200){
                        //获取响应数据
                        var result = request.responseText;
                        eval("var shop=" + result);
                        //处理响应数据
                        //获取表格对象
                        var shopTable = document.getElementById("shopTable");
                        var tr = shopTable.insertRow(1);
                        var cell0 = tr.insertCell(0);
                        cell0.innerHTML = shop.id;

                        var cell1 = tr.insertCell(1);
                        cell0.innerHTML = shop.name;

                        var cell2 = tr.insertCell(2);
                        cell0.innerHTML = shop.price;

                        var cell3 = tr.insertCell(3);
                        cell0.innerHTML = shop.desc;
                    }else{
                        alert("状态码不是200")
                    }
                }
            }
            //发送请求
            request.open("get","http://localhost:8080/ajax/shop?name="+name);
            request.send(null);
        }
    </script>
</head>
<body>
    <h3>欢迎访问商店</h3>
    <hr>
    商品名称：<input type="text" id="name" name="name" value="" />
             <input type="button" value="搜索" onclick="selected()" />
    <hr>
    <table border="1px" id="shopTable">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>描述</td>
        </tr>
    </table>
</body>
</html>
