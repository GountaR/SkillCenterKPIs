package com.sqli.skillcenter.kpi.model;

import java.util.ArrayList;

public class Projects {
    private ArrayList<Project> projects;

    public Projects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        String str = "";
        for (Project project:
             projects) {
            str += project.toString();
        }
        return "Projects{" + str+
                '}';
    }
}
