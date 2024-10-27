@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.NamedRoutes

@param CoursesPage page

@template.layout.page(content = @`
    <form action="${NamedRoutes.coursesPath()}" method="get">
        <label>
            Поиск:
            <input type="search" required name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>

    <h1>${page.getHeader()}</h1>

    @for(var course : page.getCourses())
        <div>
            <p><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></p>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
`)
