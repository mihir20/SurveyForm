package com.example.mi.surveyform;

/**
 * Created by mi on 26/8/17.
 */

public class SurveyFormData {

    public String mName;
    public String mAddress;
    public String mAge;
    public String mMarried;
    public String mPwd;
    public String mEducation;
    public String mIncome;
    public String mAge1;
    public String mAge2;
    public String mAge3;
    public String mAge4;
    public String mAge5;
    public String mTotal;
    SurveyFormData(String name, String address, String age, String married, String pwd, String education, String income, String age1,String age2, String age3, String age4, String age5, String total){
        mName = name;
        mAddress = address;
        mAge = age;
        mAge1 = age1;
        mAge2 = age2;
        mAge3 = age3;
        mAge4 = age4;
        mAge5 = age5;
        mMarried = married;
        mPwd = pwd;
        mEducation = education;
        mTotal=total;
        mIncome = income;
    }
    public String getName(){return mName;}
    public String getAddress(){return mAddress;}
    public String getMarriedStatus(){return mMarried;}
    public String getPwdStatus(){return mPwd;}
    public String getEducationStatus(){return mEducation;}
    public String getIncome(){return mIncome;}
    public String getAge(){return mAge;}
    public String getAge1(){return mAge1;}
    public String getAge2(){return mAge2;}
    public String getAge3(){return mAge3;}
    public String getAge4(){return mAge4;}
    public String getAge5(){return mAge5;}
    public String getTotal(){return mTotal;}
}
