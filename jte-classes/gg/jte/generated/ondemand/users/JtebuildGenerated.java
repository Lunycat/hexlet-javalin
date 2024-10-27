package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,15,15,15,17,17,18,18,19,19,19,20,20,21,21,23,23,25,25,25,25,25,25,25,25,25,29,29,29,29,29,29,29,29,29,35,35,35,35,35,35,35,35,35,53,53,53,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n    <title>Document</title>\r\n</head>\r\n<body>\r\n    ");
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
		jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Пароль\r\n                <input type=\"password\" required name=\"password\"/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Подтверждение пароля\r\n                <input type=\"password\" required name=\"passwordConfirmation\"/>\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Зарегистрировать\"/>\r\n    </form>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
