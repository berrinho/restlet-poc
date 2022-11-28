package org.example;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class RESTDistributor {

    // URI of the root directory.
    public static final String ROOT_URI = "file:/Users/joeberry/spring/restlet-poc/src/main/resources";

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Create a new Restlet component and add a HTTP server connector to it
        Component component = new Component();
        // if you have an HTTP connector listening on the same port (i.e. 8182), you will get an error
        // in this case change the port number (e.g. 8183)
        component.getServers().add(Protocol.HTTP, 8182);

        //Router router = new Router( component.getContext().createChildContext());
        //router.attach( "/species", RESTResource.class );
        //router.attach( "/species/{id}", OpenResource.class );

        // Then attach it to the local host
        component.getDefaultHost().attach("/species", RESTResource.class);
        component.getDefaultHost().attach("/species/{id}", OpenResource.class);

        //setup file sharing for static html
        component.getClients().add(Protocol.FILE);

        // Create an application
        Application application = new Application() {
            @Override
            public Restlet createInboundRoot() {
                return new Directory(getContext(), ROOT_URI);
            }
        };

        // Attach the application to the component and start it
        component.getDefaultHost().attach(application);



        // Now, let's start the component!
        // Note that the HTTP server connector is also automatically started.
        component.start();
    }

}