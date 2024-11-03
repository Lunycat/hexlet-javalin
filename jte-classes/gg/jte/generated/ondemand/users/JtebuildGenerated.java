package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.util.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,6,6,8,8,8,10,10,12,12,14,14,15,15,16,16,16,17,17,18,18,20,20,22,22,22,22,22,22,22,22,22,26,26,26,26,26,26,26,26,26,32,32,32,32,32,32,32,32,32,49,49,49,49,49,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\r\n        <div class=\"alert alert-danger\" role=\"alert\">\r\n            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("\r\n        </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    ");
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
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n        <div>\r\n            <label>\r\n                Имя\r\n                <input type=\"text\" required name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Email\r\n                <input type=\"email\" required name=\"email\"");
				var __jte_html_attribute_2 = page.getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Пароль\r\n                <input type=\"password\" required name=\"password\"/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Подтверждение пароля\r\n                <input type=\"password\" required name=\"passwordConfirmation\"/>\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Зарегистрировать\"/>\r\n    </form>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
