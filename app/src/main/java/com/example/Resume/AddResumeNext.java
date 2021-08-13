package com.example.Resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddResumeNext extends AppCompatActivity {
    private Resume resume;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume_next);
        resume = (Resume) getIntent().getSerializableExtra("ObjectData");
        if(resume.getPositionName()!= null || resume.getLanguages() != null || resume.getQualifications() != null || resume.getInterests() !=null || resume.getSkills()!=null)
        {
            ShowData(resume);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.Nav1)
        {
            firebasedDAO.GetAll(this);
        }
        if (item.getItemId() == R.id.Nav2)
        {

            Intent intent = new Intent(this, Find.class );
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);


        }

        if (item.getItemId() == R.id.Nav3)
        {

            Toast.makeText(this, "Already on this page", Toast.LENGTH_SHORT).show();

        }
        if (item.getItemId() == R.id.Nav4)
        {

            Intent intent = new Intent(this, UpdateResume.class );
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }

    public void Back(View view)
    {
        Resume sent = fetchInput();
        Intent intent = new Intent(this, AddResume.class );
        intent.putExtra("ObjectR",sent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
    public void Save(View view)
    {
        firebasedDAO.add(fetchInput(),this);
    }

    private Resume fetchInput()
    {
        String Qualify[] = new String[3];

        EditText TextPosition = (EditText) findViewById(R.id.Position);
        resume.setPositionName(TextPosition.getText().toString().split(","));

        EditText TextLanguage = (EditText) findViewById(R.id.Language1);
        resume.setLanguages(TextLanguage.getText().toString().split(","));

        EditText TextQualification1 = (EditText) findViewById(R.id.Qualify1);
        Qualify[0] = TextQualification1.getText().toString();

        EditText TextQualification2 = (EditText) findViewById(R.id.Qualify2);
        Qualify[1] = TextQualification2.getText().toString();

        EditText TextQualification3 = (EditText) findViewById(R.id.Qualify3);
        Qualify[2] = TextQualification3.getText().toString();
        resume.setQualifications(Qualify);

        EditText TextInterest =(EditText) findViewById(R.id.InterestIN);
        resume.setInterests(TextInterest.getText().toString().split(","));

        EditText TextSkills = (EditText) findViewById(R.id.SkillIN);
        resume.setSkills(TextSkills.getText().toString().split(","));

        return  resume;
    }
    private void ShowData(Resume data)
    {

        String Qualify[] = data.getQualifications();

        EditText TextPosition = (EditText) findViewById(R.id.Position);
        TextPosition.setText(Arrays.toString(data.getPositionName()).substring(1, Arrays.toString(data.getPositionName()).length() - 1));

        EditText TextLanguage = (EditText) findViewById(R.id.Language1);
        TextLanguage.setText(Arrays.toString(data.getLanguages()).substring(1,Arrays.toString(data.getLanguages()).length()-1));

        EditText TextQualification1 = (EditText) findViewById(R.id.Qualify1);
        TextQualification1.setText(Qualify[0]);

        EditText TextQualification2 = (EditText) findViewById(R.id.Qualify2);
        TextQualification2.setText(Qualify[1]);

        EditText TextQualification3 = (EditText) findViewById(R.id.Qualify3);
        TextQualification3.setText(Qualify[2]);

        EditText TextInterest =(EditText) findViewById(R.id.InterestIN);
        TextInterest.setText(Arrays.toString(data.getInterests()).substring(1,Arrays.toString(data.getInterests()).length()-1));

        EditText TextSkills = (EditText) findViewById(R.id.SkillIN);
        TextSkills.setText(Arrays.toString(data.getSkills()).substring(1,Arrays.toString(data.getSkills()).length()-1));
    }




}