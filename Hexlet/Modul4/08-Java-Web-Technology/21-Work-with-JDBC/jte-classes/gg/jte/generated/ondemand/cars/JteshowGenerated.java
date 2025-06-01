package gg.jte.generated.ondemand.cars;
import io.hexlet.dto.cars.CarPage;
import io.hexlet.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "cars/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,9,9,9,13,13,13,15,15,15,16,16,16,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CarPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <div class=\"mb-3\">\r\n            <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCar().getMake());
				jteOutput.writeContent("</h1>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getCar().getModel());
				jteOutput.writeContent("\r\n        </div>\r\n    ");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CarPage page = (CarPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
