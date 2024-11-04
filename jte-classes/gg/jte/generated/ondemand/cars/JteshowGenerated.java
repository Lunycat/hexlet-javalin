package gg.jte.generated.ondemand.cars;
import org.example.hexlet.dto.cars.CarPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "cars/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,6,6,6,7,7,7,8,8,8,10,10,10,10,10,10,10,10,10,11,11,11,12,12,12,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CarPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCar().getId());
				jteOutput.writeContent("</p>\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCar().getMake());
				jteOutput.writeContent("</p>\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCar().getModel());
				jteOutput.writeContent("</p>\n\n    <a");
				var __jte_html_attribute_0 = NamedRoutes.carsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-primary\" role=\"button\" data-bs-toggle=\"button\">Назад</a>\n");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CarPage page = (CarPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
