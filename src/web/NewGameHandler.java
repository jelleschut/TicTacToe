package web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import game.Game;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class NewGameHandler implements HttpHandler {
    private final String title = "Game";
    private Game game;

    public NewGameHandler(Game game) {
        this.game = game;
    }

    private String page(Map<String, String> params) {
        StringBuilder s = new StringBuilder();

        s.append("<html>" +
                "<head> " +
                "<style>" +
                "a {text-decoration: none;}" +
                ".tg  {margin: auto; border-collapse:collapse;border-spacing:0;} " +
                ".tg td{width: 100; height: 100; font-family:Arial, sans-serif;font-size:20px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:black;} " +
                ".tg th{width: 100; height: 100; font-family:Arial, sans-serif;font-size:20px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:black;} " +
                ".tg .tgbaqh{text-align:center;vertical-align:text-bottom}" +
                "</style>" +
                "<title>" + title + "</title> " +
                "</head> " +
                "<body> " +
                game.getGameView() +
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
            //Do Nothing
        }

        if(params != null) {
            System.out.println("test");
            try {
                if(game.getBoard().setPiece(new int[]{Integer.parseInt(params.get("row")), Integer.parseInt(params.get("column"))}, game.getCurrentPlayer().getPiece())) {
                    game.endTurn();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        String response = page(params);

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
