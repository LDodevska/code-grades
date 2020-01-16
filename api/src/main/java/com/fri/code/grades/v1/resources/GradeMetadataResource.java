package com.fri.code.grades.v1.resources;

import com.fri.code.grades.lib.GradeMetadata;
import com.fri.code.grades.services.beans.GradeMetadataBean;
import com.fri.code.grades.v1.dtos.ApiError;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/grades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GradeMetadataResource {

    @Inject
    private GradeMetadataBean gradeMetadataBean;

    @GET
    public Response getTotalPoints(){
        return Response.status(200).entity(gradeMetadataBean.getPoints()).build();
    }


    public ApiError createApiError(String message, Response.Status responseStatus){
        ApiError error = new ApiError();
        error.setCode(responseStatus.toString());
        error.setMessage(message);
        error.setStatus(responseStatus.getStatusCode());
        return error;
    }
}
