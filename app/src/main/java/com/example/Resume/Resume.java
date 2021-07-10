package com.example.Resume;

import java.io.Serializable;

public class Resume  implements Serializable
{
    private String Name;
    private String phoneNum;
    private String Gender;
    private String Religion;
    private String Info;
    private String[] positionName;
    private String dateBirth;
    private String Nationality;
    private String Email;
    private String Address;
    private String[] Languages;
    private String[] Interests;
    private String[] Skills;
    private String[] Qualifications;

    public Resume()
    {
        super();
    }

    public Resume(String name, String phoneNum, String gender, String religion, String info, String[] positionName, String dateBirth, String nationality, String email, String address, String[] languages, String[] interests, String[] skills, String[] qualifications) {
        Name = name;
        this.phoneNum = phoneNum;
        Gender = gender;
        Religion = religion;
        Info = info;
        this.positionName = positionName;
        this.dateBirth = dateBirth;
        Nationality = nationality;
        Email = email;
        Address = address;
        Languages = languages;
        Interests = interests;
        Skills = skills;
        Qualifications = qualifications;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String[] getPositionName() {
        return positionName;
    }

    public void setPositionName(String[] positionName) {
        this.positionName = positionName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String[] getLanguages() {
        return Languages;
    }

    public void setLanguages(String[] languages) {
        Languages = languages;
    }

    public String[] getInterests() {
        return Interests;
    }

    public void setInterests(String[] interests) {
        Interests = interests;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        Skills = skills;
    }

    public String[] getQualifications() {
        return Qualifications;
    }

    public void setQualifications(String[] qualifications) {
        Qualifications = qualifications;
    }
}
