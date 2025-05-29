package gg.jte.generated.ondemand;
import io.hexlet.dto.MainPage;
import io.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,8,8,10,10,10,12,12,12,12,12,12,12,12,12,15,15,17,17,17,17,17,17,17,17,17,19,19,21,21,21,22,22,22,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            ");
				if (page.getName() != null) {
					jteOutput.writeContent("\r\n                <div class=\"mb-3\">\r\n                    Привет, ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getName());
					jteOutput.writeContent("!\r\n                </div>\r\n                <form");
					var __jte_html_attribute_0 = NamedRoutes.logoutPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\r\n                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Выйти\" />\r\n                </form>\r\n            ");
				} else {
					jteOutput.writeContent("\r\n                <div>\r\n                    <a");
					var __jte_html_attribute_1 = NamedRoutes.buildSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Войти</a>\r\n                </div>\r\n            ");
				}
				jteOutput.writeContent("\r\n        </div>\r\n        ");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
