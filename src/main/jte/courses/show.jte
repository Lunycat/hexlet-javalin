@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(content = @`
    <p>${page.getCourse().getId()}</p>
    <p>${page.getCourse().getName()}</p>
    <p>${page.getCourse().getDescription()}</p>
`)
