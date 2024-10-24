@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(content = @`
    <h1>${page.getHeader()}</h1>
    @for(var course : page.getCourses())
        <div>
            <p><a href="/courses/${course.getId()}">${course.getName()}</a></p>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
`)
