@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.NamedRoutes

@param BuildCoursePage page

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
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.coursesPath()}" method="post">
        <div>
            <label>
                Название курса
                <input type="text" required name="name" value="${page.getName()}">
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <input type="text" required name="description" value="${page.getDescription()}">
            </label>
        </div>
        <input type="submit" value="Добавить курс">
    </form>
</body>
</html>