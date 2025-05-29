package gg.jte.generated.ondemand;
import io.hexlet.dto.MainPage;
import io.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,14,15,15,15,16,16,16,16,16,16,16,16,16,21,21,22,22,22,22,22,22,22,22,22,23,23,26,26,26,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Hello World!</title>\r\n    </head>\r\n    <body>\r\n        <main>\r\n            <h1>Привет, Мир!</h1>\r\n            ");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\r\n                Добро пожаловать, ");
			jteOutput.setContext("main", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(".\r\n                <form");
			var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" method=\"post\">\r\n                    <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\r\n                    <button type=\"submit\">Выйти</button>\r\n                </form>\r\n                Чтобы разлогиниться, удалите куку JSESSIONID из браузера или кнопка выйти.\r\n            ");
		} else {
			jteOutput.writeContent("\r\n                <a");
			var __jte_html_attribute_1 = NamedRoutes.buildSessionPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Войти</a>\r\n            ");
		}
		jteOutput.writeContent("\r\n        </main>\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
