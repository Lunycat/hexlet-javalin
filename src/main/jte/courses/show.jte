@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page
@param int id

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<html>
<head>
    <meta charset="utf-8"/>
</head>
<main>
    <h1>${page.getCourses().get(id-1).getName()}</h1>
    <p>${page.getCourses().get(id-1).getDescription()}</p>
</main>
</html>