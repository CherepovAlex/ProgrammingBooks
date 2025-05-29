package gg.jte.generated.ondemand.layout;
import io.hexlet.util.NamedRoutes;
import io.hexlet.dto.BasePage;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,19,19,19,20,20,20,20,21,21,21,23,23,26,26,26,26,26,26,26,26,26,30,30,30,33,33,33,37,37,37,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, BasePage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n  <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>User Manager</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\r\n          crossorigin=\"anonymous\">\r\n  </head>\r\n  <body>\r\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n      <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType() != null ? page.getFlashType() : "success");
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\">\r\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\r\n      </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n      <div class=\"container\">\r\n        <a class=\"navbar-brand\"");
		var __jte_html_attribute_0 = NamedRoutes.homePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">На главную</a>\r\n      </div>\r\n    </nav>\r\n    <main class=\"container mt-4\">\r\n      ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n    </main>\r\n    <footer class=\"mt-5\">\r\n      ");
		jteOutput.setContext("footer", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\r\n    </footer>\r\n  </body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.get("footer");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, page);
	}
}
