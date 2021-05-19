package com.example.gall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeScreen extends AppCompatActivity {
    Button Seconnecter;
    Button sinscrire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) // si l'utilisateur est déjà connecté, on le redirige direct sur la page d'accueuil (MainActivity)
        {
            Intent i = new Intent(WelcomeScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        Seconnecter = findViewById(R.id.Seconnecter);
        Seconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
        sinscrire = findViewById(R.id.sinscrire);
        sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(WelcomeScreen.this, SignupScreen.class);
                startActivity(i);
                finish();

            }
        });
    }


}

