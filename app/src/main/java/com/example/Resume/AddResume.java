package com.example.Resume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddResume extends AppCompatActivity
{
    Resume resume;
    Boolean fromNext = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume);
            resume = (Resume) getIntent().getSerializableExtra("ObjectR");
            if (resume != null)
            {
                ShowData(resume);
                fromNext = true;
            }


    }

    public void next(View view)
    {

        Intent intent = new Intent(this, AddResumeNext.class );
        intent.putExtra("ObjectData",fetchInput());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    private Resume fetchInput()
    {
        Resume data;
        if(!fromNext) {data = new Resume();}
        else{data = resume;}


        EditText textName = (EditText) findViewById(R.id.Namein);
        data.setName(textName.getText().toString());

        EditText Textbirthdate =(EditText) findViewById(R.id.Birthdatein);
        data.setDateBirth(Textbirthdate.getText().toString());

        EditText textGender = (EditText) findViewById(R.id.Genderin);
        data.setGender(textGender.getText().toString());

        EditText TextReligion = (EditText) findViewById(R.id.Religionin);
        data.setReligion(TextReligion.getText().toString());

        EditText TextNationality = (EditText) findViewById(R.id.Nationalityin);
        data.setNationality(TextNationality.getText().toString());

        EditText Textinfo = (EditText) findViewById(R.id.Qualify1);
        data.setInfo(Textinfo.getText().toString());

        EditText TextPhone = (EditText) findViewById(R.id.InterestIN);
        data.setPhoneNum(TextPhone.getText().toString());

        EditText TextEmail = (EditText) findViewById(R.id.SkillIN);
        data.setEmail(TextEmail.getText().toString());

        EditText TextAddress = (EditText) findViewById(R.id.AddressIN);
        data.setAddress(TextAddress.getText().toString());

        return  data;
    }

    private void ShowData(Resume data)
    {
        EditText textName = (EditText) findViewById(R.id.Namein);
        textName.setText(data.getName());

        EditText Textbirthdate =(EditText) findViewById(R.id.Birthdatein);
        Textbirthdate.setText(data.getDateBirth());

        EditText textGender = (EditText) findViewById(R.id.Genderin);
        textGender.setText(data.getGender());

        EditText TextReligion = (EditText) findViewById(R.id.Religionin);
        TextReligion.setText(data.getReligion());

        EditText TextNationality = (EditText) findViewById(R.id.Nationalityin);
        TextNationality.setText(data.getNationality());

        EditText Textinfo = (EditText) findViewById(R.id.Qualify1);
        Textinfo.setText(data.getInfo());

        EditText TextPhone = (EditText) findViewById(R.id.InterestIN);
        TextPhone.setText(data.getPhoneNum());

        EditText TextEmail = (EditText) findViewById(R.id.SkillIN);
        TextEmail.setText(data.getEmail());

        EditText TextAddress = (EditText) findViewById(R.id.AddressIN);
        TextAddress.setText(data.getAddress());
    }

}