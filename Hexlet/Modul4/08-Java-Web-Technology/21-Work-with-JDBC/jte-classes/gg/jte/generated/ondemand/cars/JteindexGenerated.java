package gg.jte.generated.ondemand.cars;
import io.hexlet.dto.cars.CarsPage;
import io.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "cars/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,11,11,11,11,11,11,11,11,11,15,15,18,18,18,21,21,21,21,21,21,21,21,21,21,21,21,24,24,24,27,27,31,31,31,32,32,32,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CarsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <main>\r\n                <h1>All cars</h1>\r\n                <div class=\"mb-3\">\r\n                    <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCarPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Create new car</a>\r\n                </div>\r\n\r\n                <table class=\"table table-striped\">\r\n                    ");
				for (var car : page.getCars()) {
					jteOutput.writeContent("\r\n                        <tr>\r\n                            <td>\r\n                                ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(car.getId());
					jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                <a");
					var __jte_html_attribute_1 = NamedRoutes.carPath(car.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(car.getMake());
					jteOutput.writeContent("</a>\r\n                            </td>\r\n                            <td>\r\n                                ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(car.getModel());
					jteOutput.writeContent("\r\n                            </td>\r\n                        </tr>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                </table>\r\n            </main>\r\n        </div>\r\n    ");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CarsPage page = (CarsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
