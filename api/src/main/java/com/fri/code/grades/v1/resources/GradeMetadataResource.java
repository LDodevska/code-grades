package com.fri.code.grades.v1.resources;

import com.fri.code.grades.lib.GradeMetadata;
import com.fri.code.grades.services.beans.GradeMetadataBean;
import com.fri.code.grades.v1.dtos.ApiError;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/grades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GradeMetadataResource {

    @Inject
    private GradeMetadataBean gradeMetadataBean;


    @GET
    public Response getTotalPoints(@QueryParam("solvedExercises") Integer solvedExercises){
        try {
            GradeMetadata gradeMetadata = gradeMetadataBean.getGradeById(1);
            gradeMetadata.setSolvedExercises(solvedExercises);
            gradeMetadata = gradeMetadataBean.calculatePoints(gradeMetadata);
            return Response.status(Response.Status.OK).entity(gradeMetadata).build();
        }
        catch (Exception e) {
            ApiError error = createApiError(e.getMessage(), Response.Status.NOT_FOUND);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    public ApiError createApiError(String message, Response.Status responseStatus){
        ApiError error = new ApiError();
        error.setCode(responseStatus.toString());
        error.setMessage(message);
        error.setStatus(responseStatus.getStatusCode());
        return error;
    }
}