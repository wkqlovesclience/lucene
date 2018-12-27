<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    结果：<br>

    <#list result as r>
    <p>${r.poetry_id} </p>
    <p>${r.poetry_title}</p>
    <p>${r.poet.poet_name} </p>
    <p>${r.poetry_content}</p>


    </#list>
</body>
</html>