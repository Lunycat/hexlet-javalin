package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,9,9,9,9,9,9,9,9,9,14,14,16,16,16,18,18,21,21,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,25,25,27,27,27,27,27,27,27,27,27,28,28,28,29,29,29,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <form action=\"/users\" method=\"get\">\r\n        <label>\r\n            Поиск:\r\n            <input type=\"search\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n        </label>\r\n        <input type=\"submit\" value=\"Искать\">\r\n    </form>\r\n\r\n    ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\r\n        <div class=\"alert alert-success\" role=\"alert\">\r\n            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("\r\n        </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n    <h1>Пользователи</h1>\r\n\r\n    ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\r\n        <div>\r\n            <p><a");
					var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(user.getName());
					jteOutput.writeContent("_");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(user.getEmail());
					jteOutput.writeContent("</a></p>\r\n        </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <a");
				var __jte_html_attribute_2 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-primary\" role=\"button\" data-bs-toggle=\"button\">Добавить пользователя</a>\r\n");
			}
		}, null);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
