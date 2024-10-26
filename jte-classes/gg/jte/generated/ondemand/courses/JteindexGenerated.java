package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,3,7,7,7,7,7,7,7,7,7,12,12,12,14,14,16,16,16,16,16,16,16,17,17,17,19,19,20,20,20,21,21,21,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form action=\"/courses\" method=\"get\">\n        <label>\n            Поиск:\n            <input type=\"search\" required name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        </label>\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\n\n    ");
				for (var course : page.getCourses()) {
					jteOutput.writeContent("\n        <div>\n            <p><a href=\"/courses/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(course.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(course.getName());
					jteOutput.writeContent("</a></p>\n            <p>");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(course.getDescription());
					jteOutput.writeContent("</p>\n        </div>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
