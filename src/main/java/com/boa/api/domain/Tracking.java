package com.boa.api.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Tracking.
 */
@Entity
@Table(name = "tracking")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tracking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tracking_seq_gen")
    @SequenceGenerator(name = "tracking_seq_gen", sequenceName = "tracking_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "code_response")
    private String codeResponse;

    @Column(name = "response_tr")
    private String responseTr;

    @Column(name = "end_point_tr")
    private String endPointTr;

    @Column(name = "date_request")
    private Instant dateRequest;

    @Column(name = "date_response")
    private Instant dateResponse;

    @Column(name = "login_acteur")
    private String loginActeur;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "request_tr")
    private String requestTr;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeResponse() {
        return codeResponse;
    }

    public Tracking codeResponse(String codeResponse) {
        this.codeResponse = codeResponse;
        return this;
    }

    public void setCodeResponse(String codeResponse) {
        this.codeResponse = codeResponse;
    }

    public String getResponseTr() {
        return responseTr;
    }

    public Tracking responseTr(String responseTr) {
        this.responseTr = responseTr;
        return this;
    }

    public void setResponseTr(String responseTr) {
        this.responseTr = responseTr;
    }

    public String getEndPointTr() {
        return endPointTr;
    }

    public Tracking endPointTr(String endPointTr) {
        this.endPointTr = endPointTr;
        return this;
    }

    public void setEndPointTr(String endPointTr) {
        this.endPointTr = endPointTr;
    }

    public Instant getDateRequest() {
        return dateRequest;
    }

    public Tracking dateRequest(Instant dateRequest) {
        this.dateRequest = dateRequest;
        return this;
    }

    public void setDateRequest(Instant dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Instant getDateResponse() {
        return dateResponse;
    }

    public Tracking dateResponse(Instant dateResponse) {
        this.dateResponse = dateResponse;
        return this;
    }

    public void setDateResponse(Instant dateResponse) {
        this.dateResponse = dateResponse;
    }

    public String getLoginActeur() {
        return loginActeur;
    }

    public Tracking loginActeur(String loginActeur) {
        this.loginActeur = loginActeur;
        return this;
    }

    public void setLoginActeur(String loginActeur) {
        this.loginActeur = loginActeur;
    }

    public String getRequestTr() {
        return requestTr;
    }

    public Tracking requestTr(String requestTr) {
        this.requestTr = requestTr;
        return this;
    }

    public void setRequestTr(String requestTr) {
        this.requestTr = requestTr;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tracking)) {
            return false;
        }
        return id != null && id.equals(((Tracking) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Tracking{" +
            "id=" + getId() +
            ", codeResponse='" + getCodeResponse() + "'" +
            ", responseTr='" + getResponseTr() + "'" +
            ", endPointTr='" + getEndPointTr() + "'" +
            ", dateRequest='" + getDateRequest() + "'" +
            ", dateResponse='" + getDateResponse() + "'" +
            ", loginActeur='" + getLoginActeur() + "'" +
            ", requestTr='" + getRequestTr() + "'" +
            "}";
    }
}
