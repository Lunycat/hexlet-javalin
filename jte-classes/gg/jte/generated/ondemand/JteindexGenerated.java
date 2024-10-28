package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,20,20,20,24,24,26,26,26,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n    <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hello Hexlet!</title>\r\n    </head>\r\n    <body>\r\n    <div class=\"col-lg-8 mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1 class=\"text-body-emphasis\">Привет, Хекслет!</h1>\r\n            <p>Javalin + jte</p>\r\n            <p><a href=\"/users/build\">Зарегистрировать нового пользователя</a></p>\r\n            <p><a href=\"/courses\">Курсы</a></p>\r\n            <p><a href=\"/users\">Пользователи</a></p>\r\n        </main>\r\n    </div>\r\n    ");
		if (!page.isVisited()) {
			jteOutput.writeContent("\r\n        <div class=\"col-lg-8 mx-auto p-4 py-md-5\">\r\n            <p>Это сообщение будет показано 1 раз</p>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
