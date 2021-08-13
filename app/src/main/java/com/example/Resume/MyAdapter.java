package com.example.Resume;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UsersAdapterVh> implements Filterable {

private List<Resume> ResumeList;
private List<Resume> getListFiltered;
private Context context;
private OnResumeClickListener monResumeClickListener;

public MyAdapter(List<Resume> List,  OnResumeClickListener onResumeClickListener) {
        this.ResumeList = List;
        this.getListFiltered = List;
        this.monResumeClickListener = onResumeClickListener;
        }

@NonNull
@Override
public MyAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.adapter_row,null),monResumeClickListener);
        }

@Override
public void onBindViewHolder(@NonNull MyAdapter.UsersAdapterVh holder, int position) {

        Resume resume = ResumeList.get(position);

        String email = resume.getEmail();
        String name = resume.getName();
        String Position[] = resume.getPositionName();

        holder.Email.setText(email);
        holder.Name.setText(name);
        holder.Positions.setText(Arrays.toString(Position).substring(1, Arrays.toString(Position).length() - 1));

        }

@Override
public int getItemCount() {
        return ResumeList.size();
        }

@Override
public Filter getFilter() {

        Filter filter = new Filter() {
@Override
protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();

        if(charSequence == null | charSequence.length() == 0){
        filterResults.count = getListFiltered.size();
        filterResults.values = getListFiltered;

        }else{
        String searchChr = charSequence.toString().toLowerCase();

        List<Resume> resultData = new ArrayList<>();

        for(Resume userModel: getListFiltered){
        if(userModel.getName().toLowerCase().contains(searchChr)){
        resultData.add(userModel);
        }
        }
        filterResults.count = resultData.size();
        filterResults.values = resultData;

        }

        return filterResults;
        }

@Override
protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        ResumeList = (List<Resume>) filterResults.values;
        notifyDataSetChanged();

        }
        };
        return filter;
        }


        public class UsersAdapterVh extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView Email;
            TextView Name;
            TextView Positions;
            OnResumeClickListener onResumeClickListener;

            public UsersAdapterVh(@NonNull View itemView, OnResumeClickListener onResumeClickListener) {
                super(itemView);
                Email = itemView.findViewById(R.id.EmailRow);
                Name = itemView.findViewById(R.id.nameRow);
                Positions = itemView.findViewById(R.id.PositionRow);
                this.onResumeClickListener = onResumeClickListener;
                itemView.setOnClickListener(this);
            }

                @Override
                public void onClick(View v) {
                onResumeClickListener.onClick(getAdapterPosition());
                }
        }
        public interface  OnResumeClickListener
        {
                void onClick(int position);
        }


}
