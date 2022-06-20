package com.sqli.skillcenter.kpi.model;

import java.util.Date;

public class Project {
    private String nom;
    private String codeAgresso;
    private String client;
    private String agence;
    private Date dateDebutTBP;
    private Date dateFinTBP;

    private String caracteristiquesProjet;


    public Project (String caracteristiquesProjet){
        this.caracteristiquesProjet = caracteristiquesProjet;
    }
    public Project(String nom, String codeAgresso, String client, String agence, Date dateDebutTBP, Date dateFinTBP) {
        this.nom = nom;
        this.codeAgresso = codeAgresso;
        this.client = client;
        this.agence = agence;
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

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
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
        if(this.nom == null){
            return "Project{" +
                    "caracteristiquesProjet='" + caracteristiquesProjet +
                    '}';
        }
        return "Project{" +
                "nom='" + nom + '\'' +
                ", codeAgresso='" + codeAgresso + '\'' +
                ", client='" + client + '\'' +
                ", agence='" + agence + '\'' +
                ", dateDebutTBP=" + dateDebutTBP +
                ", dateFinTBP=" + dateFinTBP +
                '}';
    }
}
