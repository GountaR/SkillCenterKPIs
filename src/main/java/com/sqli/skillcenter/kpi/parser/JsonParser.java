package com.sqli.skillcenter.kpi.parser;

import com.sqli.skillcenter.kpi.model.Collaborateur;
import com.sqli.skillcenter.kpi.model.Project;
import com.sqli.skillcenter.kpi.model.Projects;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;
public class JsonParser {

    public static List<Collaborateur> getCollabsFromJson(String jsonResponse) throws ParseException, java.text.ParseException {
        List<Collaborateur> collabsListe = new ArrayList<>();


        Map<String, Object> jsonMap = jsonToMap(jsonResponse);
        Map<String, Object> jsonMapData = (Map<String, Object>) jsonMap.get("data");
        Map<String, Object> jsonMapCollaborateur = (Map<String, Object>) jsonMapData.get("collaborateur");
        System.out.println("---------------------------------------------------------------");
        for (Map.Entry<String, Object> entry : jsonMapCollaborateur.entrySet()) {
            collabsListe.add(getCollabFromJson(entry));
        }
        System.out.println("---------------------------------------------------------------");
        return collabsListe;
    }

    private static Collaborateur getCollabFromJson(Map.Entry<String, Object> entry) throws java.text.ParseException {
        Map<String, Object> collaborateurMap;
        Collaborateur newCollab = new Collaborateur();
        collaborateurMap = (Map<String, Object>) entry.getValue();
        newCollab.setLogin(collaborateurMap.get("login").toString());
        newCollab.setNom(collaborateurMap.get("nom").toString());
        newCollab.setPrenom(collaborateurMap.get("prenom").toString());
        Date dateArrivee=new SimpleDateFormat("yyyy-mm-dd").parse(collaborateurMap.get("date_arrivee").toString());
        newCollab.setDate_arrivee(dateArrivee);
        newCollab.setProfil_cout(collaborateurMap.get("profil_cout").toString());
        newCollab.setStructure(collaborateurMap.get("structure").toString());
        newCollab.setContrat(collaborateurMap.get("contrat").toString());
        newCollab.setProfil_poste(collaborateurMap.get("profil_poste").toString());
        newCollab.setSite(collaborateurMap.get("site").toString());
        newCollab.setCompetences(collaborateurMap.get("competences").toString());
        List<Project> projectList = new ArrayList<>();
        for (Map.Entry<String, Object> project : collaborateurMap.entrySet()) {
            projectList.add(new Project(project.getValue().toString()));
        }
        newCollab.setProjets(new Projects(projectList));
        return newCollab;
    }
    private static Map<String, Object> jsonToMap(Object json) throws JSONException {
        if(json instanceof JSONObject)
            return _jsonToMap_((JSONObject)json) ;

        else if (json instanceof String)
        {
            JSONObject jsonObject = new JSONObject((String)json) ;
            return _jsonToMap_(jsonObject) ;
        }
        return null ;
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
