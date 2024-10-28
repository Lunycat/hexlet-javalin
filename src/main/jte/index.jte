@import org.example.hexlet.dto.MainPage
@param MainPage page

<!doctype html>
<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
            <h1 class="text-body-emphasis">Привет, Хекслет!</h1>
            <p>Javalin + jte</p>
            <p><a href="/users/build">Зарегистрировать нового пользователя</a></p>
            <p><a href="/courses">Курсы</a></p>
            <p><a href="/users">Пользователи</a></p>
        </main>
    </div>
    @if(!page.isVisited())
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <p>Это сообщение будет показано 1 раз</p>
        </div>
    @endif
    </body>
</html>