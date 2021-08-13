package com.example.Resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateResume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_resume);
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


    public void findUpdate(View view)
    {
        EditText textID = (EditText) findViewById(R.id.ID);
        EditText textPhone =(EditText) findViewById(R.id.Phone);
        String ID =  textID.getText().toString().toLowerCase();
        String Phone = textPhone.getText().toString();
        if(ID.isEmpty()&& Phone.isEmpty())
        {Toast.makeText(this, "Email or phone number is empty", Toast.LENGTH_SHORT).show();}
        else
        {firebasedDAO.findUpdate(ID,Phone,this,"Update");}


    }

    public void Delete(View view)
    {
        EditText textID = (EditText) findViewById(R.id.ID);
        EditText textPhone = (EditText) findViewById(R.id.Phone);
        String ID = textID.getText().toString().toLowerCase();
        String Phone = textPhone.getText().toString();
        if (ID.isEmpty() && Phone.isEmpty()) {
            Toast.makeText(this, "Email or phone number is empty", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Delete");
            builder.setMessage("Are you sure to delete this resume: Email "+ID);
            builder.setPositiveButton("Confirm",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            firebasedDAO.findUpdate(ID,Phone,UpdateResume.this,"Delete");
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}