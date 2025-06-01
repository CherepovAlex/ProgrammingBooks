package gg.jte.generated.ondemand;
import io.hexlet.dto.users.MainPage;
import io.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,9,9,9,11,11,11,11,11,11,11,11,11,13,13,13,13,13,13,13,13,13,18,18,19,19,19,19,19,19,19,19,19,20,20,21,21,21,21,25,25,25,26,26,26,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\r\n            Welcome, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\r\n            <div>\r\n                <a");
					var __jte_html_attribute_0 = NamedRoutes.usersPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Go to Users</a>\r\n            </div>\r\n            <form");
					var __jte_html_attribute_1 = NamedRoutes.logoutPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\r\n                <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\r\n                <button type=\"submit\">Log out</button>\r\n            </form>\r\n            If you want to logout, delete cookie JSESSIONID from browser or button Log Out.\r\n        ");
				} else {
					jteOutput.writeContent("\r\n            <a");
					var __jte_html_attribute_2 = NamedRoutes.buildSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Log in</a>\r\n        ");
				}
				jteOutput.writeContent("\r\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"container text-center\">\r\n            <p class=\"text-muted mb-0\">© 2025 User Manager</p>\r\n        </div>\r\n    ");
			}
		}, null);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
