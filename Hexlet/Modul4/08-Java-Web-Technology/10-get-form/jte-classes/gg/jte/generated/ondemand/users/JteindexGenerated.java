package gg.jte.generated.ondemand.users;
import io.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,21,21,21,21,21,21,21,21,21,21,24,24,26,26,30,30,32,32,33,33,33,35,35,37,37,39,39,40,40,41,41,41,41,41,41,42,42,45,45,47,47,47,47,47,47,48,48,48,50,50,52,52,58,58,58,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Пользователи</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\r\n          crossorigin=\"anonymous\">\r\n</head>\r\n<body>\r\n    <div class=\"col-lg-8 mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1>Пользователи</h1>\r\n\r\n            <div class=\"search-box\">\r\n                <form action=\"/users\" method=\"get\">\r\n                    <input type=\"text\" name=\"term\"");
		var __jte_html_attribute_0 = page.getTerm();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("\r\n                           placeholder=\"Search by first name...\" class=\"form-control\" />\r\n                    <button type=\"submit\" class=\"btn btn-primary mt-2\">Search</button>\r\n                    ");
		if (page.getTerm() != null && !page.getTerm().isEmpty()) {
			jteOutput.writeContent("\r\n                        <a href=\"/users\" class=\"btn btn-link mt-2\">Show all</a>\r\n                    ");
		}
		jteOutput.writeContent("\r\n                </form>\r\n            </div>\r\n\r\n            ");
		if (page.getUsers().isEmpty()) {
			jteOutput.writeContent("\r\n                <div class=\"alert alert-warning mt-3\">\r\n                    ");
			if (page.getTerm() != null && !page.getTerm().isEmpty()) {
				jteOutput.writeContent("\r\n                        <p>No users found matching \"");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getTerm());
				jteOutput.writeContent("\"</p>\r\n                        <p><a href=\"/users\" class=\"btn btn-sm btn-outline-primary\">Show all users</a></p>\r\n                    ");
			} else {
				jteOutput.writeContent("\r\n                        <p>No users available</p>\r\n                    ");
			}
			jteOutput.writeContent("\r\n                </div>\r\n            ");
		} else {
			jteOutput.writeContent("\r\n                ");
			if (page.getTerm() != null && !page.getTerm().isEmpty()) {
				jteOutput.writeContent("\r\n                    <p>Found ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUsers().size());
				jteOutput.writeContent(" users matching \"");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getTerm());
				jteOutput.writeContent("\"</p>\r\n                ");
			}
			jteOutput.writeContent("\r\n\r\n                <div class=\"list-group mt-3\">\r\n                    ");
			for (var user : page.getUsers()) {
				jteOutput.writeContent("\r\n                        <div class=\"list-group-item\">\r\n                            <h5 class=\"mb-1\">");
				jteOutput.setContext("h5", null);
				jteOutput.writeUserContent(user.getFirstName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("h5", null);
				jteOutput.writeUserContent(user.getLastName());
				jteOutput.writeContent("</h5>\r\n                            <small class=\"text-muted\">");
				jteOutput.setContext("small", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("</small>\r\n                        </div>\r\n                    ");
			}
			jteOutput.writeContent("\r\n                </div>\r\n            ");
		}
		jteOutput.writeContent("\r\n\r\n            <p class=\"mt-3\"><a href=\"/\" class=\"btn btn-outline-secondary\">Back to home</a></p>\r\n        </main>\r\n    </div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
