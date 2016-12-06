package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 06/12/16.
 */

public class TestClassSemesterSubjectSubmissionModel implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("test_date")
    private Timestamp testDate;

    @SerializedName("cognitive_marks")
    private String cognitiveMarks;

    @SerializedName("psychomotor_marks")
    private String psychomotorMarks;

    @SerializedName("affective_marks")
    private String affectiveMarks;

    @SerializedName("cognitive_marking")
    private boolean cognitiveMarking;

    @SerializedName("psychomotor_marking")
    private boolean psychomotorMarking;

    @SerializedName("affective_marking")
    private boolean affectiveMarking;

    @SerializedName("cognitive_average")
    private double cognitiveAverage;

    @SerializedName("psychomotor_average")
    private double psychomotorAverage;

    @SerializedName("affective_average")
    private double affectiveAverage;

    public TestClassSemesterSubjectSubmissionModel(int id, String title, Timestamp testDate, String cognitiveMarks, String psychomotorMarks, String affectiveMarks, boolean cognitiveMarking, boolean psychomotorMarking, boolean affectiveMarking, double cognitiveAverage, double psychomotorAverage, double affectiveAverage) {
        this.id = id;
        this.title = title;
        this.testDate = testDate;
        this.cognitiveMarks = cognitiveMarks;
        this.psychomotorMarks = psychomotorMarks;
        this.affectiveMarks = affectiveMarks;
        this.cognitiveMarking = cognitiveMarking;
        this.psychomotorMarking = psychomotorMarking;
        this.affectiveMarking = affectiveMarking;
        this.cognitiveAverage = cognitiveAverage;
        this.psychomotorAverage = psychomotorAverage;
        this.affectiveAverage = affectiveAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }

    public String getCognitiveMarks() {
        return cognitiveMarks;
    }

    public void setCognitiveMarks(String cognitiveMarks) {
        this.cognitiveMarks = cognitiveMarks;
    }

    public String getPsychomotorMarks() {
        return psychomotorMarks;
    }

    public void setPsychomotorMarks(String psychomotorMarks) {
        this.psychomotorMarks = psychomotorMarks;
    }

    public String getAffectiveMarks() {
        return affectiveMarks;
    }

    public void setAffectiveMarks(String affectiveMarks) {
        this.affectiveMarks = affectiveMarks;
    }

    public boolean isCognitiveMarking() {
        return cognitiveMarking;
    }

    public void setCognitiveMarking(boolean cognitiveMarking) {
        this.cognitiveMarking = cognitiveMarking;
    }

    public boolean isPsychomotorMarking() {
        return psychomotorMarking;
    }

    public void setPsychomotorMarking(boolean psychomotorMarking) {
        this.psychomotorMarking = psychomotorMarking;
    }

    public boolean isAffectiveMarking() {
        return affectiveMarking;
    }

    public void setAffectiveMarking(boolean affectiveMarking) {
        this.affectiveMarking = affectiveMarking;
    }

    public double getCognitiveAverage() {
        return cognitiveAverage;
    }

    public void setCognitiveAverage(double cognitiveAverage) {
        this.cognitiveAverage = cognitiveAverage;
    }

    public double getPsychomotorAverage() {
        return psychomotorAverage;
    }

    public void setPsychomotorAverage(double psychomotorAverage) {
        this.psychomotorAverage = psychomotorAverage;
    }

    public double getAffectiveAverage() {
        return affectiveAverage;
    }

    public void setAffectiveAverage(double affectiveAverage) {
        this.affectiveAverage = affectiveAverage;
    }
}
