package com.boa.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.Instant;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.boa.api.domain.ParamEndPoint;
import com.boa.api.domain.Tracking;
import com.boa.api.request.AssetFinRequest;
import com.boa.api.response.GenericResponse;
import com.boa.api.service.util.ICodeDescResponse;
import com.boa.api.service.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiService {
    
    private final Logger log = LoggerFactory.getLogger(ApiService.class);
    private final TrackingService trackingService;
    private final UserService userService;
    private final Utils utils;
    private final ParamEndPointService endPointService;

    public ApiService(TrackingService trackingService, UserService userService, Utils utils,
            ParamEndPointService endPointService) {
        this.trackingService = trackingService;
        this.userService = userService;
        this.utils = utils;
        this.endPointService = endPointService;
    }

	public GenericResponse assetFin(AssetFinRequest assetRequest, HttpServletRequest request) {
        log.info("Enter in assetFin=== [{}]", assetRequest);
        GenericResponse genericResp = new GenericResponse();
        Tracking tracking = new Tracking();
        tracking.setDateRequest(Instant.now());

        ParamEndPoint endPoint = endPointService.findByCodeParam("assetFin");
        if (endPoint == null) {
            genericResp.setCode(ICodeDescResponse.ECHEC_CODE);
            genericResp.setDescription(ICodeDescResponse.SERVICE_ABSENT_DESC);
            genericResp.setDateResponse(Instant.now());
            tracking = createTracking(tracking, ICodeDescResponse.ECHEC_CODE, "authorisation", genericResp.toString(),
            assetRequest.toString());
            trackingService.save(tracking);
            return genericResp;
        }
        try {
            String jsonStr = new JSONObject().put("pavi", assetRequest.getPavi())
                    .put("numero_dossier", assetRequest.getNumeroDossier())
                    .put("freq_ap", assetRequest.getFreqAp())
                    .put("tx_ap", assetRequest.getTxAp())
                    .put("charge_clt", assetRequest.getChargeClt())
                    .put("prix_ttc", assetRequest.getPrixTtc())
                    .put("type_pavi", assetRequest.getTypePavi()).put("code_mrk", assetRequest.getCodeMrk())
                    .put("mnt_ap", assetRequest.getMntAp()).put("echeance", assetRequest.getEcheance())
                    .put("etat_eng", assetRequest.getEtatEng()).put("prix_ht", assetRequest.getPrixHt())
                    .put("etat_prod", assetRequest.getEtatProd()).put("grace", assetRequest.getGrace())
                    .put("verssement", assetRequest.getVersement()).put("type_dossier", assetRequest.getTypeDossier())
                    .put("nooper", assetRequest.getNooper()).put("mnt_fin", assetRequest.getMntFin())
                    .put("frais_ass", assetRequest.getFraisAss()).put("id_clt", assetRequest.getIdClient())
                    .put("frais_doss", assetRequest.getFraisDossier()).put("id_apporteur", assetRequest.getIdApporteur())
                    .put("id_tire", assetRequest.getIdTitre()).put("num_immat", assetRequest.getNumImmat())
                    .put("num_chassis", assetRequest.getNumChassis()).put("flag_charge", assetRequest.getFlagCharge())
                    .put("taux_nominal", assetRequest.getTauxNominal()).put("garantie", assetRequest.getGarantie())
                    .put("duree", assetRequest.getDuree()).put("date_trait", assetRequest.getDateTrait())
                    .put("quantieme", assetRequest.getQuantieme()).put("type_frais_ass", assetRequest.getTypeFraisAss())
                    .put("code_css", assetRequest.getCodeCss()).put("type_frais_doss", assetRequest.getTypeFraisDossier())
                    .put("date_prem_ech", assetRequest.getDatePremEch()).put("num_ww", assetRequest.getNumWw())
                    .put("unite_grace", assetRequest.getUniteGrace()).put("teg", assetRequest.getTeg())
                    .put("date_der_ech", assetRequest.getDateDerEch()).put("vr", assetRequest.getVr())
                    .put("ris", assetRequest.getRis()).put("code_mdl", assetRequest.getCodeMdl())
                    .put("dos_com", assetRequest.getDosCom()).put("etat_inst", assetRequest.getEtatInst())
                    .put("date_effet", assetRequest.getDateEffet())//.put("garantie", assetRequest.getGarantie())
                    .toString();

            log.info("request assetFin [{}]", jsonStr);
            HttpURLConnection conn = utils.doConnexion(endPoint.getEndPoints(), jsonStr, "application/json", null);
            BufferedReader br = null;
            JSONObject obj = new JSONObject();
            String result = "";
            log.info("resp code envoi [{}]", conn.getResponseCode());
            if (conn != null && conn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String ligne = br.readLine();
                while (ligne != null) {
                    result += ligne;
                    ligne = br.readLine();
                }
                // result = IOUtils.toString(conn.getInputStream(), "UTF-8");
                log.info("releveCompte result ===== [{}]", result);
                obj = new JSONObject(result);
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> map = mapper.readValue(result, Map.class);
                obj = new JSONObject(result);
                //obj = obj.getJSONObject("InfoTransaction");
                genericResp.setData(map);
                /*genericResp.setCode(ICodeDescResponse.SUCCES_CODE);
                genericResp.setDescription(ICodeDescResponse.SUCCES_DESCRIPTION);
                genericResp.setDateResponse(Instant.now());
                tracking = createTracking(tracking, ICodeDescResponse.SUCCES_CODE, request.getRequestURI(),
                            genericResp.toString(), assetRequest.toString());*/
                //fin todo

                if (obj.toString() != null && !obj.isNull("rcode") && obj.get("rcode").equals("0100")) {
                    genericResp.setCode(ICodeDescResponse.SUCCES_CODE);
                    genericResp.setDescription(ICodeDescResponse.SUCCES_DESCRIPTION);
                    genericResp.setDateResponse(Instant.now());
                    tracking = createTracking(tracking, ICodeDescResponse.SUCCES_CODE, request.getRequestURI(),
                            genericResp.toString(), assetRequest.toString());
                } else {
                    genericResp.setCode(ICodeDescResponse.ECHEC_CODE);
                    genericResp.setDateResponse(Instant.now());
                    genericResp.setDescription(ICodeDescResponse.ECHEC_DESCRIPTION);
                    tracking = createTracking(tracking, ICodeDescResponse.ECHEC_CODE, request.getRequestURI(),
                            genericResp.toString(), assetRequest.toString());
                }
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String ligne = br.readLine();
                while (ligne != null) {
                    result += ligne;
                    ligne = br.readLine();
                }
                log.info("resp envoi error ===== [{}]", result);
                obj = new JSONObject(result);
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> map = mapper.readValue(result, Map.class);
                obj = new JSONObject(result);
                genericResp.setData(map);
                genericResp.setCode(ICodeDescResponse.ECHEC_CODE);
                genericResp.setDateResponse(Instant.now());
                genericResp.setDescription(ICodeDescResponse.ECHEC_DESCRIPTION);
                tracking = createTracking(tracking, ICodeDescResponse.ECHEC_CODE, request.getRequestURI(),
                        genericResp.toString(), assetRequest.toString());
            }

            
        } catch (Exception e) {
            log.error("Exception in assetFin [{}]", e);
            genericResp.setCode(ICodeDescResponse.ECHEC_CODE);
            genericResp.setDateResponse(Instant.now());
            genericResp.setDescription(ICodeDescResponse.ECHEC_DESCRIPTION + " " + e.getMessage());
            tracking = createTracking(tracking, ICodeDescResponse.ECHEC_CODE, request.getRequestURI(), e.getMessage(),
                    assetRequest.toString());
        }
        trackingService.save(tracking);
		return genericResp;
    }
    
    public Tracking createTracking(Tracking tracking, String code, String endPoint, String result, String req) {
        // Tracking tracking = new Tracking();
        tracking.setCodeResponse(code);
        tracking.setDateResponse(Instant.now());
        tracking.setEndPointTr(endPoint);
        tracking.setLoginActeur(userService.getUserWithAuthorities().get().getLogin());
        tracking.setResponseTr(result);
        tracking.setRequestTr(req);
        return tracking;
    }

}
