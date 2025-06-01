package gg.jte.generated.ondemand.cars;
import io.hexlet.dto.cars.BuildCarPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "cars/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,11,11,11,11,11,11,11,11,11,17,17,17,17,17,17,17,17,17,23,23,23,24,24,24,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCarPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <form action=\"/cars\" method=\"post\">\r\n                <div class=\"mb-3\">\r\n                    <label class=\"form-label\">\r\n                        Make\r\n                        <input type=\"text\" class=\"form-control\" name=\"make\"");
				var __jte_html_attribute_0 = page.getMake();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\r\n                    </label>\r\n                </div>\r\n                <div class=\"mb-3\">\r\n                    <label class=\"form-label\">\r\n                        Model\r\n                        <input type=\"text\" class=\"form-control\" name=\"model\"");
				var __jte_html_attribute_1 = page.getModel();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\r\n                    </label>\r\n                </div>\r\n                <input type=\"submit\" class=\"btn btn-primary\" value=\"Save\" />\r\n            </form>\r\n        </div>\r\n    ");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCarPage page = (BuildCarPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
