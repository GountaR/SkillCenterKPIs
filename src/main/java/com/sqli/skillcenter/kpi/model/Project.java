package com.sqli.skillcenter.kpi.model;

import java.util.Date;

public class Project {
    private String nom;
    private String codeAgresso;
    private String client;
    private String agance;
    private Date dateDebutTBP;
    private Date dateFinTBP;

    public Project(String nom, String codeAgresso, String client, String agance, Date dateDebutTBP, Date dateFinTBP) {
        this.nom = nom;
        this.codeAgresso = codeAgresso;
        this.client = client;
        this.agance = agance;
        this.dateDebutTBP = dateDebutTBP;
        this.dateFinTBP = dateFinTBP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeAgresso() {
        return codeAgresso;
    }

    public void setCodeAgresso(String codeAgresso) {
        this.codeAgresso = codeAgresso;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgance() {
        return agance;
    }

    public void setAgance(String agance) {
        this.agance = agance;
    }

    public Date getDateDebutTBP() {
        return dateDebutTBP;
    }

    public void setDateDebutTBP(Date dateDebutTBP) {
        this.dateDebutTBP = dateDebutTBP;
    }

    public Date getDateFinTBP() {
        return dateFinTBP;
    }

    public void setDateFinTBP(Date dateFinTBP) {
        this.dateFinTBP = dateFinTBP;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nom='" + nom + '\'' +
                ", codeAgresso='" + codeAgresso + '\'' +
                ", client='" + client + '\'' +
                ", agance='" + agance + '\'' +
                ", dateDebutTBP=" + dateDebutTBP +
                ", dateFinTBP=" + dateFinTBP +
                '}';
    }
}
