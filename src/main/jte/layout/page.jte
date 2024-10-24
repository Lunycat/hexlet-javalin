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
    <h1>Различные курсы</h1>
    <form action="/courses" method="get">
        <input type="search" required name="term">
        <input type="submit" value="Искать">
    </form>
    ${content}
</body>
</html>