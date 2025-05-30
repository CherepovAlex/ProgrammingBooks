package gg.jte.generated.ondemand.users;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,2,14,14,16,16,16,17,17,17,17,17,17,18,18,18,19,19,19,19,21,21,23,23,23,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, io.hexlet.dto.users.UsersPage page) {
		jteOutput.writeContent("\r\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n\r\n<table>\r\n    <thead>\r\n        <tr>\r\n            <th>ID</th>\r\n            <th>Full Name</th>\r\n            <th>Email</th>\r\n            <th>Actions</th>\r\n        </tr>\r\n    </thead>\r\n    <tbody>\r\n        ");
		for (io.hexlet.model.User user : page.getUsers()) {
			jteOutput.writeContent("\r\n            <tr>\r\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getId());
			jteOutput.writeContent("</td>\r\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getFirstName());
			jteOutput.writeContent(" ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getLastName());
			jteOutput.writeContent("</td>\r\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getEmail());
			jteOutput.writeContent("</td>\r\n                <td><a href=\"/users/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(user.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">View</a></td>\r\n            </tr>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </tbody>\r\n</table>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		io.hexlet.dto.users.UsersPage page = (io.hexlet.dto.users.UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
