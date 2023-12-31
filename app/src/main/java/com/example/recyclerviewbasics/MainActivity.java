package com.example.recyclerviewbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvVertical;
    //rv pour RecyclerView
    private String[] interns, descriptions;

    int[] avatars = {
            R.drawable.stagiaire_01,
            R.drawable.stagiaire_02,
            R.drawable.stagiaire_03,
            R.drawable.stagiaire_04,
            R.drawable.stagiaire_05,
            R.drawable.stagiaire_06,
            R.drawable.stagiaire_07,
            R.drawable.stagiaire_08,
            R.drawable.stagiaire_09,
            R.drawable.stagiaire_010,
            R.drawable.stagiaire_011,
            R.drawable.stagiaire_012,
            R.drawable.stagiaire_013,
            R.drawable.stagiaire_014,

    };

    private void init(){
        rvVertical = findViewById(R.id.rv_vertical);
        interns = getResources().getStringArray(R.array.interns);
        descriptions = getResources().getStringArray(R.array.descriptionb);
    }

    private void fillRecyclerVertical(){
        MyRecyclerVerticalAdapter adapter = new MyRecyclerVerticalAdapter(this, interns, descriptions, avatars);
        rvVertical.setAdapter(adapter);
        //creation du layout

        //en effet le RV cache un LL(linearlayout) d'ou le fait qu on appele le manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvVertical.setLayoutManager(linearLayoutManager);
        //on range data en l'adaptant au layout d'ou l adaptateur

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //on associe a java
        setContentView(R.layout.activity_main);
        init();
        fillRecyclerVertical();



    }

}