package web;

import com.sun.net.httpserver.HttpServer;
import game.Game;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private int portNumber;
    private HttpServer httpServer;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void startServer(Game game) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(portNumber), 0);
        setContextPages(game);
        httpServer.start();
    }

    private void setContextPages(Game game) {
        httpServer.createContext("/", new IndexHandler());
        httpServer.createContext("/new-game/", new NewGameHandler(game));
        httpServer.setExecutor(null);
    }

    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if(pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }


}
