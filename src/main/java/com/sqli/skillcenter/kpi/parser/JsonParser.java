package com.sqli.skillcenter.kpi.parser;

import com.sqli.skillcenter.kpi.Application;
import com.sqli.skillcenter.kpi.model.Collaborateur;
import com.sqli.skillcenter.kpi.model.Project;
import com.sqli.skillcenter.kpi.model.Projects;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;
public class JsonParser {

    private static final String DATE_FORMAT = "yyyy-mm-dd";
    private JsonParser(){

    }
    public static List<Collaborateur> getCollabsFromJson(String jsonResponse) throws ParseException, java.text.ParseException {
        List<Collaborateur> collabsListe = new ArrayList<>();


        Map<String, Object> jsonMap = jsonToMap(jsonResponse);

        Map<String, Object> jsonMapData = (Map<String, Object>) jsonMap.get("data");
        Map<String, Object> jsonMapCollaborateur = (Map<String, Object>) jsonMapData.get("collaborateur");
        for (Map.Entry<String, Object> entry : jsonMapCollaborateur.entrySet()) {
            collabsListe.add(getCollabFromJson(entry));
        }
        return collabsListe;

        return collabsListe;
    }

    private static Collaborateur getCollabFromJson(Map.Entry<String, Object> entry) throws java.text.ParseException {
        Map<String, Object> collaborateurMap;
        Collaborateur newCollab = new Collaborateur();
        collaborateurMap = (Map<String, Object>) entry.getValue();
        newCollab.setLogin(collaborateurMap.get("login").toString());
        newCollab.setNom(collaborateurMap.get("nom").toString());
        newCollab.setPrenom(collaborateurMap.get("prenom").toString());
        newCollab.setDate_arrivee(new SimpleDateFormat(DATE_FORMAT).parse(collaborateurMap.get("date_arrivee").toString()));
        newCollab.setProfil_cout(collaborateurMap.get("profil_cout").toString());
        newCollab.setStructure(collaborateurMap.get("structure").toString());
        newCollab.setContrat(collaborateurMap.get("contrat").toString());
        newCollab.setProfil_poste(collaborateurMap.get("profil_poste").toString());
        newCollab.setSite(collaborateurMap.get("site").toString());
        newCollab.setCompetences(collaborateurMap.get("competences").toString());
        List<Project> projectList = new ArrayList<>();
        for (Map.Entry<String, Object> project : collaborateurMap.entrySet()) {
            if(!project.getKey().equals("login") && !project.getKey().equals("nom") && !project.getKey().equals("prenom") && !project.getKey().equals("date_arrivee") &&
                !project.getKey().equals("profil_cout") &&!project.getKey().equals("structure") &&!project.getKey().equals("contrat") &&!project.getKey().equals("profil_poste") &&
                        !project.getKey().equals("site") &&!project.getKey().equals("competences")){
                projectList.add(parseProjectFromJson(project.getValue().toString()));
            }
        }
        newCollab.setProjets(new Projects(projectList));
        return newCollab;
    }

    private static Project parseProjectFromJson(String jsonProject) throws java.text.ParseException {
        Project projet = new Project(jsonProject);
        String[] projectAttributs = jsonProject.split("\\|");
        projet.setNom(projectAttributs[0]);
        projet.setCodeAgresso(projectAttributs[1]);
        projet.setClient(projectAttributs[2]);
        projet.setAgence(projectAttributs[3]);
        projet.setDateDebutTBP(new SimpleDateFormat(DATE_FORMAT).parse(projectAttributs[4]));
        projet.setDateFinTBP(new SimpleDateFormat(DATE_FORMAT).parse(projectAttributs[5]));
        return projet;
    }
    private static Map<String, Object> jsonToMap(Object json) throws JSONException {
        if(json instanceof JSONObject)
            return _jsonToMap_((JSONObject)json) ;

        else if (json instanceof String)
        {
            JSONObject jsonObject = new JSONObject((String)json) ;
            return _jsonToMap_(jsonObject) ;
        }
        Map<String, Object> emptyMap = new HashMap<>();
        return emptyMap ;
    }

    private static Map<String, Object> _jsonToMap_(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if(json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();

            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }


    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }


}
