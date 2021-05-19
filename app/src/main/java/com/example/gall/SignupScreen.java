package com.example.gall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupScreen extends AppCompatActivity {
    EditText email, mdp, confirmdp;
    Button sinscrire2;
    ImageView imageview2;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignupScreen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        confirmdp = findViewById(R.id.confirmdp);
        mAuth = FirebaseAuth.getInstance();
        sinscrire2 = findViewById(R.id.sinscrire2);

        sinscrire2.setOnClickListener(v -> {


        String mEmail = email.getText().toString();
        String mMdp = mdp.getText().toString();
        String mConfirmMdp = confirmdp.getText().toString();

        if ( mMdp != mConfirmMdp)
        {
            mdp.setError("Les mots de passes ne sont pas identique");
        }

            mAuth.createUserWithEmailAndPassword(mEmail, mMdp)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                Intent i = new Intent(SignupScreen.this, MainActivity.class);
                                startActivity(i);
                                finish();


                            } else {

                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            }
                        }
                    });


        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }




}


