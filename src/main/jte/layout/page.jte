@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
    <h1>Мой сайт</h1>
    <p>
        <a href="/users/build">Зарегистрировать пользователя</a>
        <a href="/courses/build">Добавить курс</a>
        <a href="/courses">Курсы</a>
        <a href="/users">Пользователи</a>
    </p>
    ${content}
</body>
</html>