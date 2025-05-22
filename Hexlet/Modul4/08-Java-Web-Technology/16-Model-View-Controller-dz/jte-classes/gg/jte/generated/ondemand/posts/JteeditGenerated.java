package gg.jte.generated.ondemand.posts;
import io.hexlet.dto.posts.EditPostPage;
import io.hexlet.util.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "posts/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,9,9,9,9,9,9,9,9,9,11,11,14,14,15,15,16,16,16,17,17,18,18,21,21,22,22,22,22,22,22,22,22,22,29,29,29,29,29,29,29,29,29,39,39,39,44,44,44,44,44,44,44,44,44,47,47,47,47,47,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditPostPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"d-flex justify-content-between align-items-center mb-4\">\r\n            <h1>Редактирование поста</h1>\r\n            <a");
				var __jte_html_attribute_0 = NamedRoutes.postsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-secondary\">Назад к списку</a>\r\n        </div>\r\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n            <div class=\"mb-3\">\r\n                <ul>\r\n                    ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\r\n                        ");
						for (var error : validator) {
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
				var __jte_html_attribute_1 = NamedRoutes.postPath(page.getPost().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n            <div class=\"mb-3\">\r\n                <label for=\"name\" class=\"form-label\">Наименование</label>\r\n                <input type=\"text\"\r\n                    class=\"form-control\"\r\n                    id=\"name\"\r\n                    name=\"name\"");
				var __jte_html_attribute_2 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\r\n                    required>\r\n            </div>\r\n\r\n            <div class=\"mb-3\">\r\n                <label for=\"body\" class=\"form-label\">Описание</label>\r\n                <textarea\r\n                    class=\"form-control\"\r\n                    id=\"body\"\r\n                    name=\"body\"\r\n                    required>");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getBody());
				jteOutput.writeContent("</textarea>\r\n            </div>\r\n\r\n            <div class=\"d-grid gap-2 d-md-flex justify-content-md-end\">\r\n                <button type=\"submit\" class=\"btn btn-primary me-md-2\">Сохранить изменения</button>\r\n                <a");
				var __jte_html_attribute_3 = NamedRoutes.postsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-outline-secondary\">Отмена</a>\r\n            </div>\r\n        </form>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditPostPage page = (EditPostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
