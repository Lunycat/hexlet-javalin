package gg.jte.generated.ondemand.cars;
import org.example.hexlet.dto.cars.CarsPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "cars/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,6,6,6,6,6,6,6,6,6,9,9,9,9,9,9,9,9,9,14,14,16,16,16,18,18,21,21,23,23,23,23,23,23,23,23,23,23,23,23,24,24,24,26,26,28,28,28,28,28,28,28,28,28,29,29,29,30,30,30,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CarsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.carsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n        <label>\n            Поиск:\n            <input type=\"search\" name=\"term\"");
				var __jte_html_attribute_1 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        </label>\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n    ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\n        <div class=\"alert alert-success\" role=\"alert\">\n            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("\n        </div>\n    ");
				}
				jteOutput.writeContent("\n    <h1>Машины</h1>\n\n    ");
				for (var car : page.getCars()) {
					jteOutput.writeContent("\n        <div>\n            <p><a");
					var __jte_html_attribute_2 = NamedRoutes.carPath(car.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(car.getMake());
					jteOutput.writeContent("</a></p>\n            <p>");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(car.getModel());
					jteOutput.writeContent("</p>\n        </div>\n    ");
				}
				jteOutput.writeContent("\n\n    <a");
				var __jte_html_attribute_3 = NamedRoutes.buildCarPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-primary\" role=\"button\" data-bs-toggle=\"button\">Добавить машину</a>\n");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CarsPage page = (CarsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
