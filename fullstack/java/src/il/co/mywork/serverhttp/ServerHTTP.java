package il.co.mywork.serverhttp;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import il.co.mywork.command.*;
import il.co.mywork.factory.Factory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerHTTP {
    private final Factory<String, Command, Object> factory = SingletonCommandFactory.getInstance();
    private final HttpHandler httpHandler = new RequestHandler(factory);
    private final InetSocketAddress socketAddress = new InetSocketAddress(8080);

    private void addCommandsToFactory() {

        factory.add("writelog", WriteLog::new);
        factory.add("CR", CompanyRegistration::new);
        factory.add("PR", ProductRegistration::new);
        factory.add("EUR", EndUserRegistration::new);
        factory.add("IOTUpdate", IOTUpdate::new);
    }

    public ServerHTTP() {
        addCommandsToFactory();
    }

    public void start() {
        try {
            /* connect to socket */
            HttpServer httpServer = HttpServer.create(socketAddress, 0);

            /* send handler object to server path */
            httpServer.createContext("/Users/ezragordon/My_Work/ezra-gordon/fullstack/java/src/il/co/mywork/requests", httpHandler);
//            httpServer.createContext("/home/student/ezra-gordon/fullstack/java/src/il/co/mywork/requests", httpHandler);
            httpServer.start();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
