package com.example.mi.surveyform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameText ;
    EditText addressText ;
    EditText ageText ;
    EditText maxEduText ;
    EditText monthlyIncomeText;
    EditText ageC1Text ;
    EditText ageC2Text ;
    EditText ageC3Text ;
    EditText ageC4Text;
    EditText ageC5Text ;
    EditText totalFamilyMembersText ;
    CheckBox marriedStatus;
    CheckBox pwdStatus;
    DBhelper dbHelper;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new DBhelper(this,null,null,1);
        nameText = (EditText) findViewById(R.id.NameId);
        addressText = (EditText) findViewById(R.id.AddressId);
        ageText = (EditText) findViewById(R.id.AgeId);
        maxEduText = (EditText) findViewById(R.id.EducationId);
        monthlyIncomeText = (EditText) findViewById(R.id.IncomeId);
        ageC1Text = (EditText) findViewById(R.id.Age1Id);
        ageC2Text = (EditText) findViewById(R.id.Age2Id);
        ageC3Text = (EditText) findViewById(R.id.Age3Id);
        ageC4Text = (EditText) findViewById(R.id.Age4Id);
        ageC5Text = (EditText) findViewById(R.id.Age5Id);
        totalFamilyMembersText = (EditText) findViewById(R.id.TotalId);
        saveButton = (Button) findViewById(R.id.saveButton);
        marriedStatus = (CheckBox) findViewById(R.id.IfMarriedId) ;
        pwdStatus = (CheckBox) findViewById(R.id.IfPwdId) ;


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(view);
            }
        });
    }

    public String ifMarried (CheckBox checkBox)
    {
        if(checkBox.isChecked()){return "yes";}
        else{return "no";}
    }

    public String ifPwd (CheckBox checkBox)
    {
        if(checkBox.isChecked()){return "yes";}
        else{return "no";}
    }


    public void saveData (View v){
        SurveyFormData data = new SurveyFormData(nameText.getText().toString(),
                addressText.getText().toString(), ageText.getText().toString(),
                ifMarried(marriedStatus), ifPwd(pwdStatus), maxEduText.getText().toString(), monthlyIncomeText.getText().toString(),
                ageC1Text.getText().toString(),ageC2Text.getText().toString(),ageC3Text.getText().toString(),ageC4Text.getText().toString(),
                ageC5Text.getText().toString(), totalFamilyMembersText.getText().toString());

        dbHelper.addProduct(data);
    }

}
