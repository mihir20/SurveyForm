package com.example.mi.surveyform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameText = (EditText) findViewById(R.id.NameId);
    EditText addressText = (EditText) findViewById(R.id.AddressId);
    EditText ageText = (EditText) findViewById(R.id.AgeId);
    EditText maxEduText = (EditText) findViewById(R.id.EducationId);
    EditText monthlyIncomeText = (EditText) findViewById(R.id.IncomeId);
    EditText ageC1Text = (EditText) findViewById(R.id.Age1Id);
    EditText ageC2Text = (EditText) findViewById(R.id.Age2Id);
    EditText ageC3Text = (EditText) findViewById(R.id.Age3Id);
    EditText ageC4Text = (EditText) findViewById(R.id.Age4Id);
    EditText ageC5Text = (EditText) findViewById(R.id.Age5Id);
    EditText totalFamilyMembersText = (EditText) findViewById(R.id.TotalId);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
