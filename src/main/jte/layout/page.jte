@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.BasePage
@import gg.jte.Content

@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
</head>
<body>
<nav class="navbar-expand-lg navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Мой сайт</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="${NamedRoutes.coursesPath()}">Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.usersPath()}">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.carsPath()}">Cars</a>
                </li>
            </ul>
            <span class="navbar-text">
      </span>
        </div>
    </div>
</nav>
@if(page != null && page.getFlash() != null)
    <p>${page.getFlash()}</p>
@endif
${content}
</body>
</html>