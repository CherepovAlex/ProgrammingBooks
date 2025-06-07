package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,30,30,30,30,30,30,30,30};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <form action=\"/users\" method=\"post\">\r\n            <div>\r\n                <label>\r\n                Name\r\n                <input type=\"text\" name=\"firstName\" />\r\n                </label>\r\n            </div>\r\n            <div>\r\n                <label>\r\n                Last Name\r\n                <input type=\"text\" name=\"lastName\" />\r\n                </label>\r\n            </div>\r\n            <div>\r\n                <label>\r\n                Email\r\n                <input type=\"email\" required name=\"email\" />\r\n                </label>\r\n            </div>\r\n            <div>\r\n                <label>\r\n                Пароль\r\n                <input type=\"password\" required name=\"password\" />\r\n                </label>\r\n            </div>\r\n            <input type=\"submit\" value=\"Submit\" />\r\n        </form>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
