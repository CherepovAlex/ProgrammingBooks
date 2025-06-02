package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,26,26,26,26,29,29,32,32,32,35,35,38,38,38,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Hexlet Javalin Example</title>\r\n    </head>\r\n    <body>\r\n        <nav>\r\n            <div>\r\n                <ul>\r\n                    <li>\r\n                        <a href=\"/\">Home</a>\r\n                    </li>\r\n                    <li >\r\n                        <a href=\"/users\">Users</a>\r\n                    </li>\r\n                </ul>\r\n            </div>\r\n        </nav>\r\n\r\n        <div>\r\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n        </div>\r\n\r\n        ");
		if (footer != null) {
			jteOutput.writeContent("\r\n            <footer>\r\n                <div>\r\n                    ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\r\n                </div>\r\n            </footer>\r\n        ");
		}
		jteOutput.writeContent("\r\n\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
