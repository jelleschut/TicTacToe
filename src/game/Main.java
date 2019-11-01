package game;

import web.Server;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        Server s =  new Server(8080);
        s.startServer(new Game());
    }
}
