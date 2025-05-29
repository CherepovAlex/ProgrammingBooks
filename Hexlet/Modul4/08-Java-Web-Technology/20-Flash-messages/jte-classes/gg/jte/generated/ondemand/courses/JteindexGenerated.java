package gg.jte.generated.ondemand.courses;
import io.hexlet.util.NamedRoutes;
import io.hexlet.dto.courses.CoursesPage;
import java.time.format.DateTimeFormatter;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,9,9,14,14,14,14,14,14,14,14,14,16,16,18,18,19,19,22,22,22,22,22,22,22,22,22,22,22,22,23,23,23,25,25,25,25,25,25,25,25,25,26,26,26,26,26,26,26,26,26,27,27,27,27,27,27,27,27,27,33,33,34,34,37,37,37,37,41,41,41,41,41,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <main>\r\n                <h1>Все курсы</h1>\r\n                <div class=\"mb-3\">\r\n                    <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Создать новый курс</a>\r\n                </div>\r\n                ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\r\n                 <p>Пока не добавлено ни одного курса</p>\r\n                    ");
				} else {
					jteOutput.writeContent("\r\n                         ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\r\n                            <tr>\r\n                                <div>\r\n                                    <td><h2><a");
						var __jte_html_attribute_1 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</a></h2></td>\r\n                                    <td><p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p></td>\r\n                                    <td>\r\n                                        <a");
						var __jte_html_attribute_2 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">Просмотр</a>\r\n                                        <a");
						var __jte_html_attribute_3 = NamedRoutes.editCoursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_3);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">Редактировать</a>\r\n                                        <form");
						var __jte_html_attribute_4 = NamedRoutes.deleteCoursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" action=\"");
							jteOutput.setContext("form", "action");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("form", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" method=\"post\">\r\n                                            <button type=\"submit\">Удалить</button>\r\n                                        </form>\r\n                                    </td>\r\n                                </div>\r\n                            </tr>\r\n                        ");
					}
					jteOutput.writeContent("\r\n                ");
				}
				jteOutput.writeContent("\r\n            </main>\r\n        </div>\r\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"container text-center\">\r\n            <p class=\"text-muted mb-0\">© 2025 Course Manager | Список курсов</p>\r\n        </div>\r\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
