package com.sergiu.newfoodorderclient;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText userEmail, userPass;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private  Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

        userEmail=(TextInputEditText) findViewById(R.id.userEmail);
        userPass =(TextInputEditText) findViewById(R.id.userPass);
        mAuth =FirebaseAuth.getInstance();
        btnLogin=(Button) findViewById(R.id.idBtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signinButtonClicked(view);
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

    }
    public void signinButtonClicked(View view){
        String  email= userEmail.getText().toString().trim();
        String  pass = userPass .getText().toString().trim();
         if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
             mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful())
                     {
                        checkUserExists();
                     }
                 }
             });
         }
    }
    public void checkUserExists(){
        final String  user_id =mAuth.getCurrentUser().getUid();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(user_id)){
                    Intent menuIntent =new Intent(LoginActivity.this,FoodPageActivity.class);
                    startActivity(menuIntent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
