package gg.jte.generated.ondemand.users;
import io.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,7,7,8,8,8,8,8,8,9,9,9,10,10,10,10,12,12,12,12,12,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(page.getUser().getFirstName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(page.getUser().getLastName());
				jteOutput.writeContent("</h2>\r\n        <div>");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</div>\r\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <p>Thanks for visiting, come again soon!</p>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
