package com.sqli.skillcenter.kpi.service;

import com.sqli.skillcenter.kpi.Application;
import com.sqli.skillcenter.kpi.model.Collaborateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CollabsService {
    private static final Logger log = LoggerFactory.getLogger(CollabsService.class);

    public static void saveCollabs(List<Collaborateur> collabs) {
        for (Collaborateur collab :
                collabs) {
            log.info(collab.toString());
        }
    }
}
