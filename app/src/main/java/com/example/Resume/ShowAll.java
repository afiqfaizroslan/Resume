package com.example.Resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity implements MyAdapter.OnResumeClickListener {
    MyAdapter Adapter;
    RecyclerView recyclerView;
    ArrayList<Resume> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        list = (ArrayList<Resume>) getIntent().getSerializableExtra("ObjectData");

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        MyAdapter myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);
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
            Toast.makeText(this, "Already on this page", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(int position)
    {
        firebasedDAO.find(list.get(position).getEmail(),this);
    }
}