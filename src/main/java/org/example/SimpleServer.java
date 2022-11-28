package org.example;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SimpleServer extends ServerResource {

        public static void main(String[] args) throws Exception {
            // Create the HTTP server and listen on port 8182
            new Server(Protocol.HTTP, 8182, SimpleServer.class).start();

            // Outputting the content of a Web page
           // new ClientResource("http://restlet.com").get().write(System.out);
        }

        @Get
        public String toString() {
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                    "  <meta name=\"description\" content=\"\">\n" +
                    "  <title>Field Trips Online Homepage</title></head>\n" +
                    "<body>hello, world</body>\n</html>";
        }


}
