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

public class Find extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
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

            Toast.makeText(this, "Already on this page", Toast.LENGTH_SHORT).show();


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


    public void find(View view)
    {
        EditText textID = (EditText) findViewById(R.id.ID);
        String ID =  textID.getText().toString().toLowerCase();
        firebasedDAO.find(ID,this);

    }
}