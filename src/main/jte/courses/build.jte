<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <form action="/courses" method="post">
        <div>
            <label>
                Название курса
                <input type="text" required name="name">
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <input type="text" required name="description">
            </label>
        </div>
        <input type="submit" value="Добавить курс">
    </form>
</body>
</html>