package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quintal-dev-3 on 06/12/16.
 */

public class InitialDataModel implements Serializable {
    @SerializedName("assignment_class_semester_subject_submissions")
    private ArrayList<AssignmentClassSemesterSubjectSubmissionModel> assignmentClassSemesterSubjectSubmissions;

    @SerializedName("test_class_semester_subject_submissions")
    private ArrayList<TestClassSemesterSubjectSubmissionModel> testClassSemesterSubjectSubmissions;

    @SerializedName("event_user")
    private ArrayList<EventUserModel> eventUser;

    public InitialDataModel(ArrayList<AssignmentClassSemesterSubjectSubmissionModel> assignmentClassSemesterSubjectSubmissions, ArrayList<TestClassSemesterSubjectSubmissionModel> testClassSemesterSubjectSubmissions, ArrayList<EventUserModel> eventUser) {
        this.assignmentClassSemesterSubjectSubmissions = assignmentClassSemesterSubjectSubmissions;
        this.testClassSemesterSubjectSubmissions = testClassSemesterSubjectSubmissions;
        this.eventUser = eventUser;
    }

    public ArrayList<AssignmentClassSemesterSubjectSubmissionModel> getAssignmentClassSemesterSubjectSubmissions() {
        return assignmentClassSemesterSubjectSubmissions;
    }

    public void setAssignmentClassSemesterSubjectSubmissions(ArrayList<AssignmentClassSemesterSubjectSubmissionModel> assignmentClassSemesterSubjectSubmissions) {
        this.assignmentClassSemesterSubjectSubmissions = assignmentClassSemesterSubjectSubmissions;
    }

    public ArrayList<TestClassSemesterSubjectSubmissionModel> getTestClassSemesterSubjectSubmissions() {
        return testClassSemesterSubjectSubmissions;
    }

    public void setTestClassSemesterSubjectSubmissions(ArrayList<TestClassSemesterSubjectSubmissionModel> testClassSemesterSubjectSubmissions) {
        this.testClassSemesterSubjectSubmissions = testClassSemesterSubjectSubmissions;
    }

    public ArrayList<EventUserModel> getEventUser() {
        return eventUser;
    }

    public void setEventUser(ArrayList<EventUserModel> eventUser) {
        this.eventUser = eventUser;
    }
}
