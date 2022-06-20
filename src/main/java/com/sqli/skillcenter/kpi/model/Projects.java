package com.sqli.skillcenter.kpi.model;

import java.util.List;

public class Projects {
    private List<Project> projects;

    public Projects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        String str = "";
        for (Project project :
                projects) {
            str += project.toString();
        }
        return "Projects{" + str +
                '}';
    }
}
