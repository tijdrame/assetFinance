package com.boa.api.web.rest;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.boa.api.request.AssetFinRequest;
import com.boa.api.response.GenericResponse;
import com.boa.api.service.ApiService;
import com.boa.api.service.util.ICodeDescResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiResource {

    private final Logger log = LoggerFactory.getLogger(ApiResource.class);

    private final ApiService apiService; 

    public ApiResource(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @PostMapping("/assetFin")
    public ResponseEntity<GenericResponse> assetFin(@RequestBody AssetFinRequest assetRequest, HttpServletRequest request) {
        log.debug("REST request to assetFin : [{}]", assetRequest);
        GenericResponse response = new GenericResponse();
        if (controleParam(assetRequest.getNumeroDossier()) || controleParam(assetRequest.getDateDerEch())||
        assetRequest.getDuree()==null || controleParam(assetRequest.getDateEffet())||
        controleParam(assetRequest.getDatePremEch()) || assetRequest.getMntFin()==null||
        assetRequest.getTauxNominal()==null || controleParam(assetRequest.getCpteBq())) {
            response.setCode(ICodeDescResponse.PARAM_ABSENT_CODE);
            response.setDateResponse(Instant.now());
            response.setDescription(ICodeDescResponse.PARAM_DESCRIPTION);
            return ResponseEntity.badRequest().header("Authorization", request.getHeader("Authorization")).body(response);
        }
        response = apiService.assetFin(assetRequest, request);
        return ResponseEntity.ok().header("Authorization", request.getHeader("Authorization")).body(response);
    }

    public Boolean controleParam(String param) {
        Boolean flag = false;
        if (StringUtils.isEmpty(param))
            flag = true;
        return flag;
    }
}
