package com.reloader.classroomdeveloper.Entidades;

public class MTeacherFolder {

    private String id;
    private String title;
    private String alternateLink;

    public MTeacherFolder(String id, String title, String alternateLink) {
        this.id = id;
        this.title = title;
        this.alternateLink = alternateLink;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlternateLink() {
        return alternateLink;
    }

    public void setAlternateLink(String alternateLink) {
        this.alternateLink = alternateLink;
    }
}
