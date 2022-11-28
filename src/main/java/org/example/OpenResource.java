package org.example;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class OpenResource extends ServerResource {

    @Get
    public String present() {
        // Print the requested URI path
        return "OPEN Resource URI  : " + getReference() + '\n' + "Root URI      : "
                + getRootRef() + '\n' + "Routed part   : "
                + getReference().getBaseRef() + '\n' + "Remaining part: "
                + getReference().getRemainingPart()
                + '\n' +"parameter: " + getAttribute("id");
    }
}
