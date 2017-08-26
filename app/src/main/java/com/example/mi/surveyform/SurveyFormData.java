package com.example.mi.surveyform;

/**
 * Created by mi on 26/8/17.
 */

public class SurveyFormData {

    public String mName;
    public String mAddress;
    public int mAge;
    public String mMarried;
    public String mPwd;
    public String mEducation;
    public String mIncome;
    public int mAge1;
    public int mAge2;
    public int mAge3;
    public int mAge4;
    public int mAge5;
    public int mTotal;
    SurveyFormData(String name, String address, int age, String married, String pwd, String education, String income, int age1,int age2, int age3, int age4, int age5, int total){
        mName = name;
        mAddress = address;
        mAge = age;
        mAge1 = age1;
        mAge2 = age2;
        mAge3 = age3;
        mAge4 = age4;
        mAge5 = age5;
        mTotal = total;
        mMarried = married;
        mPwd = pwd;
        mEducation = education;
        mIncome = income;
    }
    public String getName(){return mName;}
    public String getAddress(){return mAddress;}
    public String getMarriedStatus(){return mMarried;}
    public String getPwdStatus(){return mPwd;}
    public String getEducationStatus(){return mEducation;}
    public String getIncome(){return mIncome;}
    public int getAge(){return mAge;}
    public int getAge1(){return mAge1;}
    public int getAge2(){return mAge2;}
    public int getAge3(){return mAge3;}
    public int getAge4(){return mAge4;}
    public int getAge5(){return mAge5;}
    public int getTotal(){return mTotal;}
}
