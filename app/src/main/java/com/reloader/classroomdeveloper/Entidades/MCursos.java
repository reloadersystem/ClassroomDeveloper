package com.reloader.classroomdeveloper.Entidades;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MCursos {

   private String id;
   private String name;
   private String section;
   private String descriptionHeading;
 //  private String room;
   private String ownerId;
   private String creationTime;
   private String updateTime;
   private String enrollmentCode;
   private String courseState;
   private String alternateLink;
   private String teacherGroupEmail;
   private String courseGroupEmail;
   //private JSONObject mTeacherFolders;
   private String guardiansEnabled;
   private String calendarId;

    public MCursos(String id, String name, String section, String descriptionHeading, String ownerId, String creationTime, String updateTime, String enrollmentCode, String courseState, String alternateLink, String teacherGroupEmail, String courseGroupEmail, String guardiansEnabled, String calendarId) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.descriptionHeading = descriptionHeading;
        this.ownerId = ownerId;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
        this.enrollmentCode = enrollmentCode;
        this.courseState = courseState;
        this.alternateLink = alternateLink;
        this.teacherGroupEmail = teacherGroupEmail;
        this.courseGroupEmail = courseGroupEmail;
        this.guardiansEnabled = guardiansEnabled;
        this.calendarId = calendarId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDescriptionHeading() {
        return descriptionHeading;
    }

    public void setDescriptionHeading(String descriptionHeading) {
        this.descriptionHeading = descriptionHeading;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getEnrollmentCode() {
        return enrollmentCode;
    }

    public void setEnrollmentCode(String enrollmentCode) {
        this.enrollmentCode = enrollmentCode;
    }

    public String getCourseState() {
        return courseState;
    }

    public void setCourseState(String courseState) {
        this.courseState = courseState;
    }

    public String getAlternateLink() {
        return alternateLink;
    }

    public void setAlternateLink(String alternateLink) {
        this.alternateLink = alternateLink;
    }

    public String getTeacherGroupEmail() {
        return teacherGroupEmail;
    }

    public void setTeacherGroupEmail(String teacherGroupEmail) {
        this.teacherGroupEmail = teacherGroupEmail;
    }

    public String getCourseGroupEmail() {
        return courseGroupEmail;
    }

    public void setCourseGroupEmail(String courseGroupEmail) {
        this.courseGroupEmail = courseGroupEmail;
    }

    public String getGuardiansEnabled() {
        return guardiansEnabled;
    }

    public void setGuardiansEnabled(String guardiansEnabled) {
        this.guardiansEnabled = guardiansEnabled;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }
}
