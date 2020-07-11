package com.vedhashala.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TokenActivity extends AppCompatActivity {
    Button submit;
    EditText access_token;
    private FirebaseAuth mAuth;
    private FirebaseUser mFirebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

submit=findViewById(R.id.submit);
access_token=findViewById(R.id.token);
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mAuth.getCurrentUser();
        if (mFirebaseUser == null) {


        } else {
            String id = mAuth.getCurrentUser().getUid();

            Token token=new Token();
            token.setAccess_token(access_token.getText().toString());
            updateInfo(token, id);
            }




    }
});



    }
    private void updateInfo(Token token, String id) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("privateData").child(id).setValue(token);
    }
}