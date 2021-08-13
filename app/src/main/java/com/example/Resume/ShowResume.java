package com.example.Resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ShowResume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resume);
        Resume resume = (Resume) getIntent().getSerializableExtra("ObjectData");
        ShowData(resume);
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

                        Intent intent = new Intent(this, AddResume.class );
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        this.startActivity(intent);

                }

            if (item.getItemId() == R.id.Nav4)
            {

                Intent intent = new Intent(this, UpdateResume.class );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent);

            }


                return super.onOptionsItemSelected(item);
        }

    private void ShowData(Resume resume)
    {

            TextView txtName = (TextView) findViewById(R.id.txtName);
            txtName.setText(resume.getName());

            TextView txtPhoneNum = (TextView) findViewById(R.id.txtPhoneNum);
            txtPhoneNum.setText(resume.getPhoneNum());

            TextView txtGender = (TextView) findViewById(R.id.txtGender);
            txtGender.setText(resume.getGender());

            TextView txtReligion = (TextView) findViewById(R.id.txtReligion);
            txtReligion.setText(resume.getReligion());

            TextView txtInfo = (TextView) findViewById(R.id.txtInfo);
            txtInfo.setText(resume.getInfo());

            TextView txtDateBirth = (TextView) findViewById(R.id.txtDateBirth);
            txtDateBirth.setText(resume.getDateBirth());

            TextView txtNationality = (TextView) findViewById(R.id.txtNationality);
            txtNationality.setText(resume.getNationality());

            TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
            txtEmail.setText(resume.getEmail());

            TextView txtAddress = (TextView) findViewById(R.id.txtAddress);
            txtAddress.setText(resume.getAddress());

            String Qualifications[] = resume.getQualifications();

            TextView txtQualify1 = (TextView) findViewById(R.id.txtQualify1);
            txtQualify1.setText(Qualifications[0]);

            TextView txtQualify2 = (TextView) findViewById(R.id.txtQualify2);
            txtQualify2.setText(Qualifications[1]);

            TextView txtQualify3 = (TextView) findViewById(R.id.txtQualify3);
            txtQualify3.setText(Qualifications[2]);

            Spinner PositionSpin = (Spinner) findViewById(R.id.PositionSpin);
            ArrayAdapter<String> PAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,resume.getPositionName());
            PAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            PositionSpin.setAdapter(PAdapter);

            Spinner LanguageSpin = (Spinner) findViewById(R.id.LanguageSpin);
            ArrayAdapter<String> LAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,resume.getLanguages());
            LAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            LanguageSpin.setAdapter(LAdapter);

            Spinner InterestSpin = (Spinner) findViewById(R.id.InterestSpin);
            ArrayAdapter<String> IAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,resume.getInterests());
            IAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            InterestSpin.setAdapter(IAdapter);

            Spinner SkillSpin = (Spinner) findViewById(R.id.SkillSpin);
            ArrayAdapter<String> SAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,resume.getSkills());
            SAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            SkillSpin.setAdapter(SAdapter);




    }

}
