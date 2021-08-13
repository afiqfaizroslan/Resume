package com.example.Resume;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class firebasedDAO
{
    protected static final FirebaseFirestore db = FirebaseFirestore.getInstance();

    Resume pass = new Resume();
    public static void add (Resume resume, Context page)
    {
        String qualify[] = resume.getQualifications();
        Map<String, Object> cv = new HashMap<>();
        cv.put("Name", resume.getName());
        cv.put("phoneNum",resume.getPhoneNum());
        cv.put("gender", resume.getGender());
        cv.put("religion", resume.getReligion());
        cv.put("info", resume.getInfo());
        cv.put("positionName",Arrays.toString(resume.getPositionName()));
        cv.put("Address", resume.getAddress());
        cv.put("dateBirth",resume.getDateBirth());
        cv.put("nationality", resume.getNationality());
        cv.put("email",resume.getEmail());
        cv.put("language", Arrays.toString(resume.getLanguages()));
        cv.put("interest", Arrays.toString(resume.getInterests()));
        cv.put("skills", Arrays.toString(resume.getSkills()));
        cv.put("qualification1", qualify[0]);
        cv.put("qualification2", qualify[1]);
        cv.put("qualification3", qualify[2]);

        // Add a new document with a generated ID
        Task<Void> voidTask = db.collection("Resume").document(resume.getEmail()).set(cv)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot added with ID: ");
                        Toast.makeText(page, "Added success", Toast.LENGTH_SHORT).show();

                    }


                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }
    public static void find(String id, Context page)
    {
        DocumentReference docRef = db.collection("Resume").document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Resume temp = new Resume();
                        String qualify[] = new String[3];
                        temp.setName(document.getString("Name"));
                        temp.setPhoneNum(document.getString("phoneNum"));
                        temp.setGender(document.getString("gender"));
                        temp.setReligion(document.getString("religion"));
                        temp.setInfo(document.getString("info"));
                        temp.setPositionName(document.getString("positionName").substring(1, document.getString("positionName").length() - 1).split(","));
                        temp.setDateBirth(document.getString("dateBirth"));
                        temp.setNationality(document.getString("nationality"));
                        temp.setAddress(document.getString("Address"));
                        temp.setEmail(document.getString("email"));
                        temp.setLanguages(document.getString("language").substring(1, document.getString("language").length() - 1).split(","));
                        temp.setInterests(document.getString("interest").substring(1, document.getString("interest").length() - 1).split(","));
                        temp.setSkills(document.getString("skills").substring(1, document.getString("skills").length() - 1).split(","));
                        qualify[0] = document.getString("qualification1");
                        qualify[1] = document.getString("qualification2");
                        qualify[2] = document.getString("qualification3");
                        temp.setQualifications(qualify);
                        outside(temp,page);


                    } else {
                        Log.d(TAG, "No such document");
                        Toast.makeText(page, "No such document", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
    public static void outside(Resume resume, Context page)
    {
        Intent intent = new Intent(page, ShowResume.class );
        intent.putExtra("ObjectData",resume);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        page.startActivity(intent);

    }

    public static void GetAll(Context page)
    {
        db.collection("Resume")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            ArrayList<Resume> list = new ArrayList<Resume>();
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Resume temp = new Resume();
                                String qualify[] = new String[3];
                                temp.setName(document.getString("Name"));
                                temp.setPhoneNum(document.getString("phoneNum"));
                                temp.setGender(document.getString("gender"));
                                temp.setReligion(document.getString("religion"));
                                temp.setInfo(document.getString("info"));
                                temp.setPositionName(document.getString("positionName").substring(1, document.getString("positionName").length() - 1).split(","));
                                temp.setDateBirth(document.getString("dateBirth"));
                                temp.setNationality(document.getString("nationality"));
                                temp.setAddress(document.getString("Address"));
                                temp.setEmail(document.getString("email"));
                                temp.setLanguages(document.getString("language").substring(1, document.getString("language").length() - 1).split(","));
                                temp.setInterests(document.getString("interest").substring(1, document.getString("interest").length() - 1).split(","));
                                temp.setSkills(document.getString("skills").substring(1, document.getString("skills").length() - 1).split(","));
                                qualify[0] = document.getString("qualification1");
                                qualify[1] = document.getString("qualification2");
                                qualify[2] = document.getString("qualification3");
                                temp.setQualifications(qualify);
                                list.add(temp);
                            }
                            outsideList(list,page);
                        }
                        else
                            {
                                 Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                    }
                });
    }
    public static void outsideList(ArrayList<Resume> list , Context page)
    {
        Intent intent = new Intent(page, ShowAll.class );
        intent.putExtra("ObjectData",list);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        page.startActivity(intent);

    }

    public static void findUpdate(String id, String phone, Context page,String Type)
    {
        DocumentReference docRef = db.collection("Resume").document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Resume temp = new Resume();
                        String qualify[] = new String[3];
                        temp.setName(document.getString("Name"));
                        temp.setPhoneNum(document.getString("phoneNum"));
                        temp.setGender(document.getString("gender"));
                        temp.setReligion(document.getString("religion"));
                        temp.setInfo(document.getString("info"));
                        temp.setPositionName(document.getString("positionName").substring(1, document.getString("positionName").length() - 1).split(","));
                        temp.setDateBirth(document.getString("dateBirth"));
                        temp.setNationality(document.getString("nationality"));
                        temp.setAddress(document.getString("Address"));
                        temp.setEmail(document.getString("email"));
                        temp.setLanguages(document.getString("language").substring(1, document.getString("language").length() - 1).split(","));
                        temp.setInterests(document.getString("interest").substring(1, document.getString("interest").length() - 1).split(","));
                        temp.setSkills(document.getString("skills").substring(1, document.getString("skills").length() - 1).split(","));
                        qualify[0] = document.getString("qualification1");
                        qualify[1] = document.getString("qualification2");
                        qualify[2] = document.getString("qualification3");
                        temp.setQualifications(qualify);
                        if(temp.getPhoneNum().equals(phone))
                        {
                            if(Type.equalsIgnoreCase("Update")){next(temp,page);}
                            if(Type.equalsIgnoreCase("Delete")){Delete (temp.getEmail(),page);}



                        }
                        else
                        {
                            Toast.makeText(page, "Email or phone number is wrong", Toast.LENGTH_SHORT).show();
                        }



                    } else {
                        Log.d(TAG, "No such document");
                        Toast.makeText(page, "No such document", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
    public static void next(Resume resume, Context page)
    {
        Intent intent = new Intent(page, AddResume.class );
        intent.putExtra("ObjectR",resume);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        page.startActivity(intent);

    }

    public static void Delete (String id,Context page)
    {
        db.collection("Resume").document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                        Toast.makeText(page, "successfully deleted!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                        Toast.makeText(page, "Error deleting document", Toast.LENGTH_SHORT).show();
                    }
                });

    }



}
