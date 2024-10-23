package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,4,4,10,10,10,11,11,11,13,13,13,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page, int id) {
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n<html>\n<head>\n    <meta charset=\"utf-8\"/>\n</head>\n<main>\n    <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getCourses().get(id-1).getName());
		jteOutput.writeContent("</h1>\n    <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.getCourses().get(id-1).getDescription());
		jteOutput.writeContent("</p>\n</main>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		int id = (int)params.get("id");
		render(jteOutput, jteHtmlInterceptor, page, id);
	}
}
