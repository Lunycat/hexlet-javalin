package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,4,4,4,4,6,6,7,7,7,9,9,10,10,10,10,10,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Привет, Хекслет!</h1>\r\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\r\n        Добро пожаловать, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\r\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\r\n    ");
				}
				jteOutput.writeContent("\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
