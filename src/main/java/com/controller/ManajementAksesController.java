package com.controller;

import java.util.List;
import java.util.Optional;


import com.dto.CreateManejementAksesDTO;
import com.entity.ManajementAksesEntity;
import com.service.ManajementAksesService;
import com.util.ResponseUtil;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

@Controller("/management-access")
public class ManajementAksesController {
    
    private final ManajementAksesService manajementAksesService;

    public ManajementAksesController(ManajementAksesService manajementAksesService) {
        this.manajementAksesService = manajementAksesService;
    }

    @Post("/")
    public HttpResponse<Object> createAccess(@Body CreateManejementAksesDTO dto) throws Exception {
        try {
            ManajementAksesEntity createdEntity = manajementAksesService.createAccess(dto);
            return ResponseUtil.successResponse(createdEntity, "Successfully created data access", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.failedResponse(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @Get("/{accessId}")
    public HttpResponse<Object> getAccess(@PathVariable Long accessId) {
        Optional<ManajementAksesEntity> access = manajementAksesService.getAccess(accessId);
        if (access.isPresent()) {
            return ResponseUtil.successResponse(access.get(), "Access found", HttpStatus.OK);
        } else {
            return ResponseUtil.failedResponse("Access not found", HttpStatus.NOT_FOUND);
        }
    }

    @Get("/")
    public HttpResponse<Object> getAllAccess() {
        List<ManajementAksesEntity> accesses = manajementAksesService.getAllAccess();
        return ResponseUtil.successResponse(accesses, "All accesses retrieved", HttpStatus.OK);
    }

    @Patch("/{accessId}")
    public HttpResponse<Object> updateAccess(@PathVariable Long accessId, @Body ManajementAksesEntity updatedAccess) {
        try {
            ManajementAksesEntity updatedEntity = manajementAksesService.updateAccess(accessId, updatedAccess);
            return ResponseUtil.successResponse(updatedEntity, "Successfully updated data access", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.failedResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Delete("/{accessId}")
    public HttpResponse<Object> deleteAccess(@PathVariable Long accessId) {
        try {
            manajementAksesService.deleteAccess(accessId);
            return ResponseUtil.successResponse("Successfully deleted data access", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.failedResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
