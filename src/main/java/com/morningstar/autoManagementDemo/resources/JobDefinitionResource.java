package com.morningstar.autoManagementDemo.resources;


import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.morningstar.autoManagementDemo.api.JobDefinition;
import com.morningstar.autoManagementDemo.db.JobDefinitionDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@Api("/JobDefinition")
@Path("/JobDefinition")
@Slf4j
@Singleton
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class JobDefinitionResource {
	

	JobDefinitionDAO JobDefinitionDAO;

    public JobDefinitionResource(JobDefinitionDAO JobDefinitionDAO) {
        this.JobDefinitionDAO = JobDefinitionDAO;
    }
    
 
    @GET
    @Timed
//    @Metered
    @ExceptionMetered
    @Path("/{jobDefinitionId}")
    @ApiOperation(value = "Get job definition info by id.", notes = "There should be the note.")
    @ApiResponses({
            @ApiResponse(code = 401, message = "Valid credentials are required to access this resource."),
            @ApiResponse(code = 400, message = "Params not valid."),
            @ApiResponse(code = 500, message = "Something wrong from the server."),
            @ApiResponse(code = 200, message = "Success.", response = JobDefinition.class)
    })
    public JobDefinition get(@PathParam("jobDefinitionId") Integer jobDefinitionId){
    	log.info("start to get job definition by id.");
    	
    	JobDefinition jobDefinition=JobDefinitionDAO.findById(jobDefinitionId);
    	log.info(String.valueOf(jobDefinition.getJobName().length()));
        return JobDefinitionDAO.findById(jobDefinitionId);
    }
    
    @GET
    @PermitAll
    @ApiOperation(value = "get all  job definition,response a list.", notes = "There should be the note.")
    public List<JobDefinition> getAll(){
        return JobDefinitionDAO.getAll();
    }

    @POST
    @Timed
    @Path("/add")
    @ApiOperation(value = "add a new job definition and return list", notes = "There should be the note.")
    public List<JobDefinition> addList(@Valid JobDefinition jobDefinition) {
    	JobDefinitionDAO.insert(jobDefinition);
        return JobDefinitionDAO.getAll();
    }

    @POST
    @Timed
    @ApiOperation(value = "add a new job definition", notes = "There should be the note.")
    public JobDefinition add(@Valid JobDefinition jobDefinition) {
    	JobDefinitionDAO.insert(jobDefinition);
        return jobDefinition;
    }

    @PUT
    @Timed
    @Path("/{jobDefinitionId}")
    @ApiOperation(value = "update job definition info by id.just update job_name", notes = "There should be the note.")
    public JobDefinition update(@PathParam("jobDefinitionId") Integer jobDefinitionId, @Valid JobDefinition jobDefinition) {
    	JobDefinition updateTeam = new JobDefinition(jobDefinitionId, jobDefinition.getJobName(), null, null, null);
        JobDefinitionDAO.update(updateTeam);
        return updateTeam;
    }

    @DELETE
    @RolesAllowed("ADMIN")
    @Path("/{id}")
    @ApiOperation(value = "delete a job definition by id", notes = "There should be the note.")
    public void delete(@PathParam("id") Integer id) {
    	JobDefinitionDAO.deleteById(id);
    }
}
