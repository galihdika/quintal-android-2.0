package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Danny Saksono on 7/04/2016.
 */


@SuppressWarnings("serial")
public class ProfileModel implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("middle_name")
    private String middleName;

    @SerializedName("gender")
    private String gender;

    @SerializedName("mobile_no")
    private String mobileNo;

    @SerializedName("other_no")
    private String otherNo;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    @SerializedName("post_code")
    private String postCode;

    @SerializedName("institution")
    private InstitutionModel institutionModel;

    @SerializedName("profile_photo")
    private File profilePhoto;

    @SerializedName("preferred_lang")
    private String preferredLang;

    @SerializedName("birth_date")
    private Timestamp birthDate;

    @SerializedName("nis")
    private String nis;

    @SerializedName("nisn")
    private String nisn;

    @SerializedName("created_by")
    private UserModel createdBy;

    @SerializedName("created_date")
    private Timestamp createdDate;

    @SerializedName("modified_by")
    private UserModel modifiedBy;

    @SerializedName("modified_date")
    private Timestamp modifiedDate;

    public ProfileModel(int id, UserModel user, String middleName, String gender, String mobileNo, String otherNo, String address, String city, String country, String postCode, InstitutionModel institutionModel, File profilePhoto, String preferredLang, Timestamp birthDate, String nis, String nisn, UserModel createdBy, Timestamp createdDate, UserModel modifiedBy, Timestamp modifiedDate) {
        this.id = id;
        this.user = user;
        this.middleName = middleName;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.otherNo = otherNo;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.institutionModel = institutionModel;
        this.profilePhoto = profilePhoto;
        this.preferredLang = preferredLang;
        this.birthDate = birthDate;
        this.nis = nis;
        this.nisn = nisn;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOtherNo() {
        return otherNo;
    }

    public void setOtherNo(String otherNo) {
        this.otherNo = otherNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public InstitutionModel getInstitution() { return institutionModel; }

    public void setInstitution(InstitutionModel institution) { this.institutionModel = institutionModel; }

    public File getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(File profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPreferredLang() {
        return preferredLang;
    }

    public void setPreferredLang(String preferredLang) {
        this.preferredLang = preferredLang;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public UserModel getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserModel modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
