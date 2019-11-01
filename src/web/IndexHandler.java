package web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class IndexHandler implements HttpHandler {
    private String title = "Homepage";

    private String page(Map<String, String> params) {
        StringBuilder s =  new StringBuilder();
            s.append("<html>" +
                    "<head> " +
                    "<title>" + title + "</title> " +
                    "</head> " +
                    "<body> " +
                    "<h1>This is a Heading</h1> " +
                    "<p>This is a paragraph.</p> " +
                    "</body>" +
                    "</html>");
        return s.toString();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Map<String, String> params = null;
        try {
            params = Server.queryToMap(httpExchange.getRequestURI().getQuery());
        } catch (Exception e) {
            //Do nothing
        }

        String response = page(params);

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
