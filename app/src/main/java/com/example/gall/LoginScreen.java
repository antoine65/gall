package com.example.gall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreen extends AppCompatActivity {


    EditText email, mdp;
    Button seconnecter;
    ImageView imageview2;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignupScreen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);


        mAuth = FirebaseAuth.getInstance();

        seconnecter.setOnClickListener(v -> {
            String mEmail = email.getText().toString();
            String mMdp = mdp.getText().toString();

            mAuth.signInWithEmailAndPassword(mEmail, mMdp)
                    .addOnCompleteListener(this, task -> {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Intent i = new Intent(LoginScreen.this, MainActivity.class);
                            startActivity(i);
                            finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                        }
                    });



        });
    }
}