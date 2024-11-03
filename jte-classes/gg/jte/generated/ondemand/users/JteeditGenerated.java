package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "users/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,6,6,8,8,9,9,10,10,10,11,11,12,12,14,14,16,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,20,26,26,26,26,26,26,26,26,26,37,37,37,37,37,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditUserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n        <ul>\r\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\r\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\r\n                    <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n                ");
						}
						jteOutput.writeContent("\r\n            ");
					}
					jteOutput.writeContent("\r\n        </ul>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.userPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n        <div>\r\n            <label>\r\n                Имя\r\n                <input type=\"text\" required name=\"name\"");
				var __jte_html_attribute_1 = page.getUser().getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Email\r\n                <input type=\"email\" required name=\"email\"");
				var __jte_html_attribute_2 = page.getUser().getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Пароль\r\n                <input type=\"password\" required name=\"password\"/>\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Сохранить изменения\"/>\r\n    </form>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditUserPage page = (EditUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
