package com.boa.api.request;

public class AssetFinRequest {
    private String freqAp, numeroDossier, idClient, codeCss, codeMrk, codeMdl, numWw, numChassis, numImmat;
    private Integer grace, duree, typeFraisDossier, typePavi;
    private Double prixHt, prixTtc, txAp, mntAp, mntFin, tauxNominal, teg, fraisDossier, fraisAss, typeFraisAss, pavi;
    private String datePremEch, dateDerEch, dateEffet, quantieme, uniteGrace, idTitre, cpteBq, chargeClt, ris, dosCom, echeance, vr;
    private String idApporteur, etatInst, etatEng, etatProd, flagCharge, garantie, nooper;
    private String dateTrait, versement, typeDossier, action;//47

    private Double montantCommissionConcerne, montantCommissionVendeur;
    private String periodeAss;


    public AssetFinRequest() {
    }

    public AssetFinRequest(String freqAp, String numeroDossier, String idClient, String codeCss, String codeMrk, String codeMdl, String numWw, String numChassis, String numImmat, Integer grace, Integer duree, Integer typeFraisDossier, Integer typePavi, Double prixHt, Double prixTtc, Double txAp, Double mntAp, Double mntFin, Double tauxNominal, Double teg, Double fraisDossier, Double fraisAss, Double typeFraisAss, Double pavi, String datePremEch, String dateDerEch, String dateEffet, String quantieme, String uniteGrace, String idTitre, String cpteBq, String chargeClt, String ris, String dosCom, String echeance, String vr, String idApporteur, String etatInst, String etatEng, String etatProd, String flagCharge, String garantie, String nooper, String dateTrait, String versement, String typeDossier, String action, Double montantCommissionConcerne, Double montantCommissionVendeur, String periodeAss) {
        this.freqAp = freqAp;
        this.numeroDossier = numeroDossier;
        this.idClient = idClient;
        this.codeCss = codeCss;
        this.codeMrk = codeMrk;
        this.codeMdl = codeMdl;
        this.numWw = numWw;
        this.numChassis = numChassis;
        this.numImmat = numImmat;
        this.grace = grace;
        this.duree = duree;
        this.typeFraisDossier = typeFraisDossier;
        this.typePavi = typePavi;
        this.prixHt = prixHt;
        this.prixTtc = prixTtc;
        this.txAp = txAp;
        this.mntAp = mntAp;
        this.mntFin = mntFin;
        this.tauxNominal = tauxNominal;
        this.teg = teg;
        this.fraisDossier = fraisDossier;
        this.fraisAss = fraisAss;
        this.typeFraisAss = typeFraisAss;
        this.pavi = pavi;
        this.datePremEch = datePremEch;
        this.dateDerEch = dateDerEch;
        this.dateEffet = dateEffet;
        this.quantieme = quantieme;
        this.uniteGrace = uniteGrace;
        this.idTitre = idTitre;
        this.cpteBq = cpteBq;
        this.chargeClt = chargeClt;
        this.ris = ris;
        this.dosCom = dosCom;
        this.echeance = echeance;
        this.vr = vr;
        this.idApporteur = idApporteur;
        this.etatInst = etatInst;
        this.etatEng = etatEng;
        this.etatProd = etatProd;
        this.flagCharge = flagCharge;
        this.garantie = garantie;
        this.nooper = nooper;
        this.dateTrait = dateTrait;
        this.versement = versement;
        this.typeDossier = typeDossier;
        this.action = action;
        this.montantCommissionConcerne = montantCommissionConcerne;
        this.montantCommissionVendeur = montantCommissionVendeur;
        this.periodeAss = periodeAss;
    }

    public String getFreqAp() {
        return this.freqAp;
    }

    public void setFreqAp(String freqAp) {
        this.freqAp = freqAp;
    }

    public String getNumeroDossier() {
        return this.numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public String getIdClient() {
        return this.idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getCodeCss() {
        return this.codeCss;
    }

    public void setCodeCss(String codeCss) {
        this.codeCss = codeCss;
    }

    public String getCodeMrk() {
        return this.codeMrk;
    }

    public void setCodeMrk(String codeMrk) {
        this.codeMrk = codeMrk;
    }

    public String getCodeMdl() {
        return this.codeMdl;
    }

    public void setCodeMdl(String codeMdl) {
        this.codeMdl = codeMdl;
    }

    public String getNumWw() {
        return this.numWw;
    }

    public void setNumWw(String numWw) {
        this.numWw = numWw;
    }

    public String getNumChassis() {
        return this.numChassis;
    }

    public void setNumChassis(String numChassis) {
        this.numChassis = numChassis;
    }

    public String getNumImmat() {
        return this.numImmat;
    }

    public void setNumImmat(String numImmat) {
        this.numImmat = numImmat;
    }

    public Integer getGrace() {
        return this.grace;
    }

    public void setGrace(Integer grace) {
        this.grace = grace;
    }

    public Integer getDuree() {
        return this.duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getTypeFraisDossier() {
        return this.typeFraisDossier;
    }

    public void setTypeFraisDossier(Integer typeFraisDossier) {
        this.typeFraisDossier = typeFraisDossier;
    }

    public Integer getTypePavi() {
        return this.typePavi;
    }

    public void setTypePavi(Integer typePavi) {
        this.typePavi = typePavi;
    }

    public Double getPrixHt() {
        return this.prixHt;
    }

    public void setPrixHt(Double prixHt) {
        this.prixHt = prixHt;
    }

    public Double getPrixTtc() {
        return this.prixTtc;
    }

    public void setPrixTtc(Double prixTtc) {
        this.prixTtc = prixTtc;
    }

    public Double getTxAp() {
        return this.txAp;
    }

    public void setTxAp(Double txAp) {
        this.txAp = txAp;
    }

    public Double getMntAp() {
        return this.mntAp;
    }

    public void setMntAp(Double mntAp) {
        this.mntAp = mntAp;
    }

    public Double getMntFin() {
        return this.mntFin;
    }

    public void setMntFin(Double mntFin) {
        this.mntFin = mntFin;
    }

    public Double getTauxNominal() {
        return this.tauxNominal;
    }

    public void setTauxNominal(Double tauxNominal) {
        this.tauxNominal = tauxNominal;
    }

    public Double getTeg() {
        return this.teg;
    }

    public void setTeg(Double teg) {
        this.teg = teg;
    }

    public Double getFraisDossier() {
        return this.fraisDossier;
    }

    public void setFraisDossier(Double fraisDossier) {
        this.fraisDossier = fraisDossier;
    }

    public Double getFraisAss() {
        return this.fraisAss;
    }

    public void setFraisAss(Double fraisAss) {
        this.fraisAss = fraisAss;
    }

    public Double getTypeFraisAss() {
        return this.typeFraisAss;
    }

    public void setTypeFraisAss(Double typeFraisAss) {
        this.typeFraisAss = typeFraisAss;
    }

    public Double getPavi() {
        return this.pavi;
    }

    public void setPavi(Double pavi) {
        this.pavi = pavi;
    }

    public String getDatePremEch() {
        return this.datePremEch;
    }

    public void setDatePremEch(String datePremEch) {
        this.datePremEch = datePremEch;
    }

    public String getDateDerEch() {
        return this.dateDerEch;
    }

    public void setDateDerEch(String dateDerEch) {
        this.dateDerEch = dateDerEch;
    }

    public String getDateEffet() {
        return this.dateEffet;
    }

    public void setDateEffet(String dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getQuantieme() {
        return this.quantieme;
    }

    public void setQuantieme(String quantieme) {
        this.quantieme = quantieme;
    }

    public String getUniteGrace() {
        return this.uniteGrace;
    }

    public void setUniteGrace(String uniteGrace) {
        this.uniteGrace = uniteGrace;
    }

    public String getIdTitre() {
        return this.idTitre;
    }

    public void setIdTitre(String idTitre) {
        this.idTitre = idTitre;
    }

    public String getCpteBq() {
        return this.cpteBq;
    }

    public void setCpteBq(String cpteBq) {
        this.cpteBq = cpteBq;
    }

    public String getChargeClt() {
        return this.chargeClt;
    }

    public void setChargeClt(String chargeClt) {
        this.chargeClt = chargeClt;
    }

    public String getRis() {
        return this.ris;
    }

    public void setRis(String ris) {
        this.ris = ris;
    }

    public String getDosCom() {
        return this.dosCom;
    }

    public void setDosCom(String dosCom) {
        this.dosCom = dosCom;
    }

    public String getEcheance() {
        return this.echeance;
    }

    public void setEcheance(String echeance) {
        this.echeance = echeance;
    }

    public String getVr() {
        return this.vr;
    }

    public void setVr(String vr) {
        this.vr = vr;
    }

    public String getIdApporteur() {
        return this.idApporteur;
    }

    public void setIdApporteur(String idApporteur) {
        this.idApporteur = idApporteur;
    }

    public String getEtatInst() {
        return this.etatInst;
    }

    public void setEtatInst(String etatInst) {
        this.etatInst = etatInst;
    }

    public String getEtatEng() {
        return this.etatEng;
    }

    public void setEtatEng(String etatEng) {
        this.etatEng = etatEng;
    }

    public String getEtatProd() {
        return this.etatProd;
    }

    public void setEtatProd(String etatProd) {
        this.etatProd = etatProd;
    }

    public String getFlagCharge() {
        return this.flagCharge;
    }

    public void setFlagCharge(String flagCharge) {
        this.flagCharge = flagCharge;
    }

    public String getGarantie() {
        return this.garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    public String getNooper() {
        return this.nooper;
    }

    public void setNooper(String nooper) {
        this.nooper = nooper;
    }

    public String getDateTrait() {
        return this.dateTrait;
    }

    public void setDateTrait(String dateTrait) {
        this.dateTrait = dateTrait;
    }

    public String getVersement() {
        return this.versement;
    }

    public void setVersement(String versement) {
        this.versement = versement;
    }

    public String getTypeDossier() {
        return this.typeDossier;
    }

    public void setTypeDossier(String typeDossier) {
        this.typeDossier = typeDossier;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Double getMontantCommissionConcerne() {
        return this.montantCommissionConcerne;
    }

    public void setMontantCommissionConcerne(Double montantCommissionConcerne) {
        this.montantCommissionConcerne = montantCommissionConcerne;
    }

    public Double getMontantCommissionVendeur() {
        return this.montantCommissionVendeur;
    }

    public void setMontantCommissionVendeur(Double montantCommissionVendeur) {
        this.montantCommissionVendeur = montantCommissionVendeur;
    }

    public String getPeriodeAss() {
        return this.periodeAss;
    }

    public void setPeriodeAss(String periodeAss) {
        this.periodeAss = periodeAss;
    }

    public AssetFinRequest freqAp(String freqAp) {
        setFreqAp(freqAp);
        return this;
    }

    public AssetFinRequest numeroDossier(String numeroDossier) {
        setNumeroDossier(numeroDossier);
        return this;
    }

    public AssetFinRequest idClient(String idClient) {
        setIdClient(idClient);
        return this;
    }

    public AssetFinRequest codeCss(String codeCss) {
        setCodeCss(codeCss);
        return this;
    }

    public AssetFinRequest codeMrk(String codeMrk) {
        setCodeMrk(codeMrk);
        return this;
    }

    public AssetFinRequest codeMdl(String codeMdl) {
        setCodeMdl(codeMdl);
        return this;
    }

    public AssetFinRequest numWw(String numWw) {
        setNumWw(numWw);
        return this;
    }

    public AssetFinRequest numChassis(String numChassis) {
        setNumChassis(numChassis);
        return this;
    }

    public AssetFinRequest numImmat(String numImmat) {
        setNumImmat(numImmat);
        return this;
    }

    public AssetFinRequest grace(Integer grace) {
        setGrace(grace);
        return this;
    }

    public AssetFinRequest duree(Integer duree) {
        setDuree(duree);
        return this;
    }

    public AssetFinRequest typeFraisDossier(Integer typeFraisDossier) {
        setTypeFraisDossier(typeFraisDossier);
        return this;
    }

    public AssetFinRequest typePavi(Integer typePavi) {
        setTypePavi(typePavi);
        return this;
    }

    public AssetFinRequest prixHt(Double prixHt) {
        setPrixHt(prixHt);
        return this;
    }

    public AssetFinRequest prixTtc(Double prixTtc) {
        setPrixTtc(prixTtc);
        return this;
    }

    public AssetFinRequest txAp(Double txAp) {
        setTxAp(txAp);
        return this;
    }

    public AssetFinRequest mntAp(Double mntAp) {
        setMntAp(mntAp);
        return this;
    }

    public AssetFinRequest mntFin(Double mntFin) {
        setMntFin(mntFin);
        return this;
    }

    public AssetFinRequest tauxNominal(Double tauxNominal) {
        setTauxNominal(tauxNominal);
        return this;
    }

    public AssetFinRequest teg(Double teg) {
        setTeg(teg);
        return this;
    }

    public AssetFinRequest fraisDossier(Double fraisDossier) {
        setFraisDossier(fraisDossier);
        return this;
    }

    public AssetFinRequest fraisAss(Double fraisAss) {
        setFraisAss(fraisAss);
        return this;
    }

    public AssetFinRequest typeFraisAss(Double typeFraisAss) {
        setTypeFraisAss(typeFraisAss);
        return this;
    }

    public AssetFinRequest pavi(Double pavi) {
        setPavi(pavi);
        return this;
    }

    public AssetFinRequest datePremEch(String datePremEch) {
        setDatePremEch(datePremEch);
        return this;
    }

    public AssetFinRequest dateDerEch(String dateDerEch) {
        setDateDerEch(dateDerEch);
        return this;
    }

    public AssetFinRequest dateEffet(String dateEffet) {
        setDateEffet(dateEffet);
        return this;
    }

    public AssetFinRequest quantieme(String quantieme) {
        setQuantieme(quantieme);
        return this;
    }

    public AssetFinRequest uniteGrace(String uniteGrace) {
        setUniteGrace(uniteGrace);
        return this;
    }

    public AssetFinRequest idTitre(String idTitre) {
        setIdTitre(idTitre);
        return this;
    }

    public AssetFinRequest cpteBq(String cpteBq) {
        setCpteBq(cpteBq);
        return this;
    }

    public AssetFinRequest chargeClt(String chargeClt) {
        setChargeClt(chargeClt);
        return this;
    }

    public AssetFinRequest ris(String ris) {
        setRis(ris);
        return this;
    }

    public AssetFinRequest dosCom(String dosCom) {
        setDosCom(dosCom);
        return this;
    }

    public AssetFinRequest echeance(String echeance) {
        setEcheance(echeance);
        return this;
    }

    public AssetFinRequest vr(String vr) {
        setVr(vr);
        return this;
    }

    public AssetFinRequest idApporteur(String idApporteur) {
        setIdApporteur(idApporteur);
        return this;
    }

    public AssetFinRequest etatInst(String etatInst) {
        setEtatInst(etatInst);
        return this;
    }

    public AssetFinRequest etatEng(String etatEng) {
        setEtatEng(etatEng);
        return this;
    }

    public AssetFinRequest etatProd(String etatProd) {
        setEtatProd(etatProd);
        return this;
    }

    public AssetFinRequest flagCharge(String flagCharge) {
        setFlagCharge(flagCharge);
        return this;
    }

    public AssetFinRequest garantie(String garantie) {
        setGarantie(garantie);
        return this;
    }

    public AssetFinRequest nooper(String nooper) {
        setNooper(nooper);
        return this;
    }

    public AssetFinRequest dateTrait(String dateTrait) {
        setDateTrait(dateTrait);
        return this;
    }

    public AssetFinRequest versement(String versement) {
        setVersement(versement);
        return this;
    }

    public AssetFinRequest typeDossier(String typeDossier) {
        setTypeDossier(typeDossier);
        return this;
    }

    public AssetFinRequest action(String action) {
        setAction(action);
        return this;
    }

    public AssetFinRequest montantCommissionConcerne(Double montantCommissionConcerne) {
        setMontantCommissionConcerne(montantCommissionConcerne);
        return this;
    }

    public AssetFinRequest montantCommissionVendeur(Double montantCommissionVendeur) {
        setMontantCommissionVendeur(montantCommissionVendeur);
        return this;
    }

    public AssetFinRequest periodeAss(String periodeAss) {
        setPeriodeAss(periodeAss);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " freqAp='" + getFreqAp() + "'" +
            ", numeroDossier='" + getNumeroDossier() + "'" +
            ", idClient='" + getIdClient() + "'" +
            ", codeCss='" + getCodeCss() + "'" +
            ", codeMrk='" + getCodeMrk() + "'" +
            ", codeMdl='" + getCodeMdl() + "'" +
            ", numWw='" + getNumWw() + "'" +
            ", numChassis='" + getNumChassis() + "'" +
            ", numImmat='" + getNumImmat() + "'" +
            ", grace='" + getGrace() + "'" +
            ", duree='" + getDuree() + "'" +
            ", typeFraisDossier='" + getTypeFraisDossier() + "'" +
            ", typePavi='" + getTypePavi() + "'" +
            ", prixHt='" + getPrixHt() + "'" +
            ", prixTtc='" + getPrixTtc() + "'" +
            ", txAp='" + getTxAp() + "'" +
            ", mntAp='" + getMntAp() + "'" +
            ", mntFin='" + getMntFin() + "'" +
            ", tauxNominal='" + getTauxNominal() + "'" +
            ", teg='" + getTeg() + "'" +
            ", fraisDossier='" + getFraisDossier() + "'" +
            ", fraisAss='" + getFraisAss() + "'" +
            ", typeFraisAss='" + getTypeFraisAss() + "'" +
            ", pavi='" + getPavi() + "'" +
            ", datePremEch='" + getDatePremEch() + "'" +
            ", dateDerEch='" + getDateDerEch() + "'" +
            ", dateEffet='" + getDateEffet() + "'" +
            ", quantieme='" + getQuantieme() + "'" +
            ", uniteGrace='" + getUniteGrace() + "'" +
            ", idTitre='" + getIdTitre() + "'" +
            ", cpteBq='" + getCpteBq() + "'" +
            ", chargeClt='" + getChargeClt() + "'" +
            ", ris='" + getRis() + "'" +
            ", dosCom='" + getDosCom() + "'" +
            ", echeance='" + getEcheance() + "'" +
            ", vr='" + getVr() + "'" +
            ", idApporteur='" + getIdApporteur() + "'" +
            ", etatInst='" + getEtatInst() + "'" +
            ", etatEng='" + getEtatEng() + "'" +
            ", etatProd='" + getEtatProd() + "'" +
            ", flagCharge='" + getFlagCharge() + "'" +
            ", garantie='" + getGarantie() + "'" +
            ", nooper='" + getNooper() + "'" +
            ", dateTrait='" + getDateTrait() + "'" +
            ", versement='" + getVersement() + "'" +
            ", typeDossier='" + getTypeDossier() + "'" +
            ", action='" + getAction() + "'" +
            ", montantCommissionConcerne='" + getMontantCommissionConcerne() + "'" +
            ", montantCommissionVendeur='" + getMontantCommissionVendeur() + "'" +
            ", periodeAss='" + getPeriodeAss() + "'" +
            "}";
    }
    
}