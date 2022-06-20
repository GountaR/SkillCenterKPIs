package com.sqli.skillcenter.kpi.model;

import java.util.Date;

public class Collaborateur {
    private String login;
    private String nom;
    private String prenom;
    private Date date_arrivee;
    private String profil_cout;
    private String structure;
    private String contrat;
    private String profil_poste;
    private String site;
    private String competences;
    private Projects projets;

    public Collaborateur(){
        super();
    }
    public Collaborateur(String login, String nom, String prenom, Date date_arrivee, String profil_cout, String structure, String contrat, String profil_poste, String site, String competences, Projects projets) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.date_arrivee = date_arrivee;
        this.profil_cout = profil_cout;
        this.structure = structure;
        this.contrat = contrat;
        this.profil_poste = profil_poste;
        this.site = site;
        this.competences = competences;
        this.projets = projets;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getProfil_cout() {
        return profil_cout;
    }

    public void setProfil_cout(String profil_cout) {
        this.profil_cout = profil_cout;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getProfil_poste() {
        return profil_poste;
    }

    public void setProfil_poste(String profil_poste) {
        this.profil_poste = profil_poste;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public Projects getProjets() {
        return projets;
    }

    public void setProjets(Projects projets) {
        this.projets = projets;
    }

    @Override
    public String toString() {
        return "Collaborateur{" +
                "login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_arrivee=" + date_arrivee +
                ", profil_cout='" + profil_cout + '\'' +
                ", structure='" + structure + '\'' +
                ", contrat='" + contrat + '\'' +
                ", profil_poste='" + profil_poste + '\'' +
                ", site='" + site + '\'' +
                ", competences='" + competences + '\'' +
                ", projets=" + projets.toString() +
                '}';
    }
}
