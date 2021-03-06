package com.example.admin_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i=getIntent();
        final String uname=i.getStringExtra("uname");

        setContentView(R.layout.activity_dashboard);
       LinearLayout linearLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        final TextView username=(TextView)findViewById(R.id.t);
        username.setText(uname);
        final TextView profile = (TextView) findViewById(R.id.profile);
        TextView qa = (TextView) findViewById(R.id.qa);
        Button logout=(Button)findViewById(R.id.logout);
        // TextView quiz = (TextView) findViewById(R.id.quiz);
        //TextView pquiz = (TextView) findViewById(R.id.pquiz);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent profileIntent = new Intent(Dashboard.this, Profile.class);
                profileIntent.putExtra("uname",uname);
                startActivity(profileIntent);

            }
        });
        qa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent qaIntent = new Intent(Dashboard.this, BooksList.class);
                qaIntent.putExtra("uname",uname);
                startActivity(qaIntent);
            }
        });
       /* quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent quizIntent = new Intent(Dashboard.this, CreateQuiz.class);
                startActivity(quizIntent);
            }
        });
        pquiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent pquizIntent = new Intent(Dashboard.this, PlayQuiz.class);
                startActivity(pquizIntent);
            }
        });*/

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }
 public void openShelf(View v)
 {
     Intent i=getIntent();
     final String uname=i.getStringExtra("uname");
     Intent j = new Intent(getApplicationContext(), RecyclerViewA.class);
     j.putExtra("uname", uname);
     startActivity(j);

 }

   /* public void openSearch(View view) {
        Intent j=new Intent(getApplicationContext(),BooksList.class);
        startActivity(j);
    }*/
}