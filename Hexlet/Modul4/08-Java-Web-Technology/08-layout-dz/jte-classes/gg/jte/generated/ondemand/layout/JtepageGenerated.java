package gg.jte.generated.ondemand.layout;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,30,30,30,30,34,34,34,38,38,38,0,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, gg.jte.Content content, gg.jte.Content footer) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>User Manager</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n    <style>\r\n        footer {\r\n            margin-top: 2rem;\r\n            padding: 1rem;\r\n            background-color: #f8f9fa;\r\n        }\r\n    </style>\r\n</head>\r\n\r\n<body>\r\n    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n        <div class=\"container\">\r\n            <a class=\"navbar-brand\" href=\"/\">Home</a>\r\n            <div class=\"navbar-nav\">\r\n                <a class=\"nav-link\" href=\"/users\">Users</a>\r\n            </div>\r\n        </div>\r\n    </nav>\r\n\r\n    <main class=\"container mt-4\">\r\n        ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n    </main>\r\n\r\n    <footer class=\"mt-5\">\r\n        ");
		jteOutput.setContext("footer", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\r\n    </footer>\r\n</body>\r\n\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		gg.jte.Content content = (gg.jte.Content)params.get("content");
		gg.jte.Content footer = (gg.jte.Content)params.get("footer");
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
