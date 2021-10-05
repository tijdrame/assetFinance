package com.boa.api.web.rest;

import com.boa.api.ApiAssetFinanceApp;
import com.boa.api.domain.Tracking;
import com.boa.api.repository.TrackingRepository;
import com.boa.api.service.TrackingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link TrackingResource} REST controller.
 */
@SpringBootTest(classes = ApiAssetFinanceApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class TrackingResourceIT {

    private static final String DEFAULT_CODE_RESPONSE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_RESPONSE = "BBBBBBBBBB";

    private static final String DEFAULT_RESPONSE_TR = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_TR = "BBBBBBBBBB";

    private static final String DEFAULT_END_POINT_TR = "AAAAAAAAAA";
    private static final String UPDATED_END_POINT_TR = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATE_REQUEST = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_REQUEST = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_DATE_RESPONSE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_RESPONSE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_LOGIN_ACTEUR = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN_ACTEUR = "BBBBBBBBBB";

    private static final String DEFAULT_REQUEST_TR = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_TR = "BBBBBBBBBB";

    @Autowired
    private TrackingRepository trackingRepository;

    @Autowired
    private TrackingService trackingService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTrackingMockMvc;

    private Tracking tracking;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Tracking createEntity(EntityManager em) {
        Tracking tracking = new Tracking()
            .codeResponse(DEFAULT_CODE_RESPONSE)
            .responseTr(DEFAULT_RESPONSE_TR)
            .endPointTr(DEFAULT_END_POINT_TR)
            .dateRequest(DEFAULT_DATE_REQUEST)
            .dateResponse(DEFAULT_DATE_RESPONSE)
            .loginActeur(DEFAULT_LOGIN_ACTEUR)
            .requestTr(DEFAULT_REQUEST_TR);
        return tracking;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Tracking createUpdatedEntity(EntityManager em) {
        Tracking tracking = new Tracking()
            .codeResponse(UPDATED_CODE_RESPONSE)
            .responseTr(UPDATED_RESPONSE_TR)
            .endPointTr(UPDATED_END_POINT_TR)
            .dateRequest(UPDATED_DATE_REQUEST)
            .dateResponse(UPDATED_DATE_RESPONSE)
            .loginActeur(UPDATED_LOGIN_ACTEUR)
            .requestTr(UPDATED_REQUEST_TR);
        return tracking;
    }

    @BeforeEach
    public void initTest() {
        tracking = createEntity(em);
    }

    @Test
    @Transactional
    public void createTracking() throws Exception {
        int databaseSizeBeforeCreate = trackingRepository.findAll().size();
        // Create the Tracking
        restTrackingMockMvc.perform(post("/api/trackings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tracking)))
            .andExpect(status().isCreated());

        // Validate the Tracking in the database
        List<Tracking> trackingList = trackingRepository.findAll();
        assertThat(trackingList).hasSize(databaseSizeBeforeCreate + 1);
        Tracking testTracking = trackingList.get(trackingList.size() - 1);
        assertThat(testTracking.getCodeResponse()).isEqualTo(DEFAULT_CODE_RESPONSE);
        assertThat(testTracking.getResponseTr()).isEqualTo(DEFAULT_RESPONSE_TR);
        assertThat(testTracking.getEndPointTr()).isEqualTo(DEFAULT_END_POINT_TR);
        assertThat(testTracking.getDateRequest()).isEqualTo(DEFAULT_DATE_REQUEST);
        assertThat(testTracking.getDateResponse()).isEqualTo(DEFAULT_DATE_RESPONSE);
        assertThat(testTracking.getLoginActeur()).isEqualTo(DEFAULT_LOGIN_ACTEUR);
        assertThat(testTracking.getRequestTr()).isEqualTo(DEFAULT_REQUEST_TR);
    }

    @Test
    @Transactional
    public void createTrackingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = trackingRepository.findAll().size();

        // Create the Tracking with an existing ID
        tracking.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTrackingMockMvc.perform(post("/api/trackings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tracking)))
            .andExpect(status().isBadRequest());

        // Validate the Tracking in the database
        List<Tracking> trackingList = trackingRepository.findAll();
        assertThat(trackingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllTrackings() throws Exception {
        // Initialize the database
        trackingRepository.saveAndFlush(tracking);

        // Get all the trackingList
        restTrackingMockMvc.perform(get("/api/trackings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tracking.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeResponse").value(hasItem(DEFAULT_CODE_RESPONSE)))
            .andExpect(jsonPath("$.[*].responseTr").value(hasItem(DEFAULT_RESPONSE_TR)))
            .andExpect(jsonPath("$.[*].endPointTr").value(hasItem(DEFAULT_END_POINT_TR)))
            .andExpect(jsonPath("$.[*].dateRequest").value(hasItem(DEFAULT_DATE_REQUEST.toString())))
            .andExpect(jsonPath("$.[*].dateResponse").value(hasItem(DEFAULT_DATE_RESPONSE.toString())))
            .andExpect(jsonPath("$.[*].loginActeur").value(hasItem(DEFAULT_LOGIN_ACTEUR)))
            .andExpect(jsonPath("$.[*].requestTr").value(hasItem(DEFAULT_REQUEST_TR.toString())));
    }
    
    @Test
    @Transactional
    public void getTracking() throws Exception {
        // Initialize the database
        trackingRepository.saveAndFlush(tracking);

        // Get the tracking
        restTrackingMockMvc.perform(get("/api/trackings/{id}", tracking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tracking.getId().intValue()))
            .andExpect(jsonPath("$.codeResponse").value(DEFAULT_CODE_RESPONSE))
            .andExpect(jsonPath("$.responseTr").value(DEFAULT_RESPONSE_TR))
            .andExpect(jsonPath("$.endPointTr").value(DEFAULT_END_POINT_TR))
            .andExpect(jsonPath("$.dateRequest").value(DEFAULT_DATE_REQUEST.toString()))
            .andExpect(jsonPath("$.dateResponse").value(DEFAULT_DATE_RESPONSE.toString()))
            .andExpect(jsonPath("$.loginActeur").value(DEFAULT_LOGIN_ACTEUR))
            .andExpect(jsonPath("$.requestTr").value(DEFAULT_REQUEST_TR.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingTracking() throws Exception {
        // Get the tracking
        restTrackingMockMvc.perform(get("/api/trackings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTracking() throws Exception {
        // Initialize the database
        trackingService.save(tracking);

        int databaseSizeBeforeUpdate = trackingRepository.findAll().size();

        // Update the tracking
        Tracking updatedTracking = trackingRepository.findById(tracking.getId()).get();
        // Disconnect from session so that the updates on updatedTracking are not directly saved in db
        em.detach(updatedTracking);
        updatedTracking
            .codeResponse(UPDATED_CODE_RESPONSE)
            .responseTr(UPDATED_RESPONSE_TR)
            .endPointTr(UPDATED_END_POINT_TR)
            .dateRequest(UPDATED_DATE_REQUEST)
            .dateResponse(UPDATED_DATE_RESPONSE)
            .loginActeur(UPDATED_LOGIN_ACTEUR)
            .requestTr(UPDATED_REQUEST_TR);

        restTrackingMockMvc.perform(put("/api/trackings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedTracking)))
            .andExpect(status().isOk());

        // Validate the Tracking in the database
        List<Tracking> trackingList = trackingRepository.findAll();
        assertThat(trackingList).hasSize(databaseSizeBeforeUpdate);
        Tracking testTracking = trackingList.get(trackingList.size() - 1);
        assertThat(testTracking.getCodeResponse()).isEqualTo(UPDATED_CODE_RESPONSE);
        assertThat(testTracking.getResponseTr()).isEqualTo(UPDATED_RESPONSE_TR);
        assertThat(testTracking.getEndPointTr()).isEqualTo(UPDATED_END_POINT_TR);
        assertThat(testTracking.getDateRequest()).isEqualTo(UPDATED_DATE_REQUEST);
        assertThat(testTracking.getDateResponse()).isEqualTo(UPDATED_DATE_RESPONSE);
        assertThat(testTracking.getLoginActeur()).isEqualTo(UPDATED_LOGIN_ACTEUR);
        assertThat(testTracking.getRequestTr()).isEqualTo(UPDATED_REQUEST_TR);
    }

    @Test
    @Transactional
    public void updateNonExistingTracking() throws Exception {
        int databaseSizeBeforeUpdate = trackingRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTrackingMockMvc.perform(put("/api/trackings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tracking)))
            .andExpect(status().isBadRequest());

        // Validate the Tracking in the database
        List<Tracking> trackingList = trackingRepository.findAll();
        assertThat(trackingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTracking() throws Exception {
        // Initialize the database
        trackingService.save(tracking);

        int databaseSizeBeforeDelete = trackingRepository.findAll().size();

        // Delete the tracking
        restTrackingMockMvc.perform(delete("/api/trackings/{id}", tracking.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Tracking> trackingList = trackingRepository.findAll();
        assertThat(trackingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
