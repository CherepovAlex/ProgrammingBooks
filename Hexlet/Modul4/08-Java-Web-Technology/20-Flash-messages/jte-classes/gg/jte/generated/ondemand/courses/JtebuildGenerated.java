package gg.jte.generated.ondemand.courses;
import io.hexlet.dto.courses.BuildCoursePage;
import io.hexlet.util.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,11,11,12,12,13,13,13,14,14,15,15,18,18,19,19,19,19,19,19,19,19,19,23,23,23,23,23,23,23,23,23,29,29,29,34,34,34,34,38,38,38,39,39,39,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        ");
				if (page.getErrors() != null && !page.getErrors().isEmpty()) {
					jteOutput.writeContent("\r\n            <div class=\"alert alert-danger\">\r\n                <ul>\r\n                    ");
					for (var entry : page.getErrors().entrySet()) {
						jteOutput.writeContent("\r\n                        ");
						for (var error : entry.getValue()) {
							jteOutput.writeContent("\r\n                            <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n                        ");
						}
						jteOutput.writeContent("\r\n                    ");
					}
					jteOutput.writeContent("\r\n                </ul>\r\n            </div>\r\n        ");
				}
				jteOutput.writeContent("\r\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n          <div>\r\n            <label>\r\n              Название курса\r\n              <input type=\"text\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\r\n            </label>\r\n          </div>\r\n          <div>\r\n            <label>\r\n              Краткое описание курса\r\n              <textarea name=\"description\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getDescription());
				jteOutput.writeContent("</textarea>\r\n            </label>\r\n          </div>\r\n          <input type=\"submit\" value=\"Опубликовать\" />\r\n        </form>\r\n        ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"container text-center\">\r\n            <p class=\"text-muted mb-0\">© 2025 Course Manager | Создание курса</p>\r\n        </div>\r\n    ");
			}
		}, null);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
