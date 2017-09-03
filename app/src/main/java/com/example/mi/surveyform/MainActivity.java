package com.example.mi.surveyform;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    EditText addressText;
    EditText ageText;
    EditText maxEduText;
    EditText monthlyIncomeText;
    EditText ageC1Text;
    EditText ageC2Text;
    EditText ageC3Text;
    EditText ageC4Text;
    EditText ageC5Text;
    EditText totalFamilyMembersText;
    CheckBox marriedStatus;
    CheckBox pwdStatus;
    TextView location;
    DBhelper dbHelper;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBhelper(this);
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
        location = (TextView) findViewById(R.id.textView);
        totalFamilyMembersText = (EditText) findViewById(R.id.TotalId);
        saveButton = (Button) findViewById(R.id.saveButton);
        marriedStatus = (CheckBox) findViewById(R.id.IfMarriedId);
        pwdStatus = (CheckBox) findViewById(R.id.IfPwdId);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(view);
            }
        });
    }

    public String ifMarried(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            return "yes";
        } else {
            return "no";
        }
    }

    public String ifPwd(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            return "yes";
        } else {
            return "no";
        }
    }


    public void saveData(View v) {
        SurveyFormData data = new SurveyFormData(nameText.getText().toString(),
                addressText.getText().toString(),
                ageText.getText().toString(),
                ifMarried(marriedStatus),
                ifPwd(pwdStatus),
                maxEduText.getText().toString(),
                monthlyIncomeText.getText().toString(),
                ageC1Text.getText().toString(),
                ageC2Text.getText().toString(),
                ageC3Text.getText().toString(),
                ageC4Text.getText().toString(),
                ageC5Text.getText().toString(),
                totalFamilyMembersText.getText().toString());

        dbHelper.addToSurveyDatabase(data);

        Cursor mCursor;
        mCursor = dbHelper.getDataFromDatabase();
        Log.d("COUNT:", String.valueOf(mCursor.getCount()));


        addToExcel(mCursor);

        nameText.setText("Name: ");
        addressText.setText("Address: ");


    }

    public void addToExcel(Cursor myCursor) {


        String csvFile = "mySurveyDataSheet.xls";

        File directory = null;
     /*  //create directory if not exist
       if (!directory.isDirectory()) {
           directory.mkdirs();
       }*/
        try {


            //file path
            directory = getExternalFilesDir(null) ;
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("SurveyData", 0);
            // column and row

            sheet.addCell(new Label(0, 0, "name"));
            sheet.addCell(new Label(1, 0, "address"));
            sheet.addCell(new Label(2, 0, "age"));
            sheet.addCell(new Label(3, 0, "married"));
            sheet.addCell(new Label(4, 0, "PWD"));
            sheet.addCell(new Label(5, 0, "education"));
            sheet.addCell(new Label(6, 0, "income"));
            sheet.addCell(new Label(7, 0, "0-6"));
            sheet.addCell(new Label(8, 0, "7-15"));
            sheet.addCell(new Label(9, 0, "16-23"));
            sheet.addCell(new Label(10, 0, "24-60"));
            sheet.addCell(new Label(11, 0, "60+"));
            sheet.addCell(new Label(12, 0, "total"));

            //demo


            if (myCursor.moveToFirst()) {
                Toast.makeText(getApplication(), "reading data from cursor", Toast.LENGTH_LONG);
                do {
                    String name = myCursor.getString(myCursor.getColumnIndex("Name"));
                    String Address = myCursor.getString(myCursor.getColumnIndex("Adress"));
                    String Age = myCursor.getString(myCursor.getColumnIndex("Age"));
                    String Married = myCursor.getString(myCursor.getColumnIndex("Married"));
                    String PWD = myCursor.getString(myCursor.getColumnIndex("PWD"));
                    String EDUCATION = myCursor.getString(myCursor.getColumnIndex("Education"));
                    String INCOME = myCursor.getString(myCursor.getColumnIndex("Income"));
                    String age1 = myCursor.getString(myCursor.getColumnIndex("age1"));
                    String age2 = myCursor.getString(myCursor.getColumnIndex("age2"));
                    String age3 = myCursor.getString(myCursor.getColumnIndex("age3"));
                    String age4 = myCursor.getString(myCursor.getColumnIndex("age4"));
                    String age5 = myCursor.getString(myCursor.getColumnIndex("age5"));
                    int t = Integer.parseInt(age1) + Integer.parseInt(age2) + Integer.parseInt(age3) +
                            Integer.parseInt(age4) + Integer.parseInt(age5);

                    String total = Integer.toString(t);

                    int i = myCursor.getPosition() + 1;
                    sheet.addCell(new Label(0, i, name));
                    sheet.addCell(new Label(1, i, Address));
                    sheet.addCell(new Label(2, i, Age));
                    sheet.addCell(new Label(3, i, Married));
                    sheet.addCell(new Label(4, i, PWD));
                    sheet.addCell(new Label(5, i, EDUCATION));
                    sheet.addCell(new Label(6, i, INCOME));
                    sheet.addCell(new Label(7, i, age1));
                    sheet.addCell(new Label(8, i, age2));
                    sheet.addCell(new Label(9, i, age3));
                    sheet.addCell(new Label(10, i, age4));
                    sheet.addCell(new Label(11, i, age5));
                    sheet.addCell(new Label(12, i, total));
                } while (myCursor.moveToNext());
            }

            //closing myCursor
            myCursor.close();
            workbook.write();
            workbook.close();
            location.setText("Location of excel file is: "+ file);
            Toast.makeText(getApplication(),
                    "Data Exported in a Excel Sheet at " + directory, Toast.LENGTH_SHORT).show();
        } catch (RowsExceededException e) {
            e.printStackTrace();
            Toast.makeText(getApplication(),
                    "Data not Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();
        } catch (WriteException e) {
            e.printStackTrace();
            Toast.makeText(getApplication(),
                    "Don't do this", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplication(),
                    "this is not working", Toast.LENGTH_SHORT).show();
        }
    }

}
