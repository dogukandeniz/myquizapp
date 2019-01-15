package com.example.dogu.myquizapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dogu.myquizapplication.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Activity_SignUp extends AppCompatActivity {
    EditText username;
    EditText uemail;
    EditText ufacultyname;
    EditText upassword;
    EditText urepassword;
    Button btn_Sign_Up;
    Button btn_Already_Member;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private boolean isTaken=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sign_up);
        username = (EditText) findViewById(R.id.edusername);
        uemail = (EditText) findViewById(R.id.edemail);
        ufacultyname = (EditText) findViewById(R.id.edfakultyname);
        upassword = (EditText) findViewById(R.id.edpass);
        urepassword = (EditText) findViewById(R.id.edrepass);
        btn_Sign_Up = (Button) findViewById(R.id.Sign_In);
        btn_Already_Member = (Button) findViewById(R.id.btn_Already_Member);
        setAuthInstance();
        setDatabaseInstance();
        btn_Already_Member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        btn_Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterUser();
            }
        });
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public boolean validate() {
        boolean valid = true;

        String name = username.getText().toString();
        String email = uemail.getText().toString();
        String password = upassword.getText().toString();
        String reEnterPassword = urepassword.getText().toString();
        String facultyname = ufacultyname.getText().toString();
        if (name.isEmpty()) {
            username.setError("enter user name");
            valid = false;
        } else {
            username.setError(null);
        }

        if (facultyname.isEmpty()) {
            ufacultyname.setError("enter faculty name");
            valid = false;
        } else {
            ufacultyname.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            uemail.setError("enter a valid email address");
            valid = false;
        } else {
            uemail.setError(null);
        }


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            upassword.setError(" entered password must contain 7 alphanumeric characters minimum");
            valid = false;
        } else {
            upassword.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            urepassword.setError("Password Do not match");
            valid = false;
        } else {
            urepassword.setError(null);
        }
        return valid;
    }

    private void onRegisterUser() {
        String name = username.getText().toString();
        Log.d("Name",""+name);
        boolean exist = retreiveUserNames(name);
        if (!validate()) {
        }
        else if (exist) {
            username.setError("enter the unique user name");
        } else {
            signUp(getUserEmail(), getUserPassword());
        }
    }

    public boolean retreiveUserNames(final String sUserName) {
        mDatabase = FirebaseDatabase.getInstance().getReference("userNames");

        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){


                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    String existingUsername = userSnapshot.getKey();
                    Log.d("Ex",""+sUserName);
                    Log.d("Shot ", "" + existingUsername);
                    if(sUserName.equals(existingUsername)) {
                        isTaken = true;
                        Log.d("BooleanShot ", "" + isTaken);
                        break;
                    }
                    else if(!(sUserName.equals(existingUsername))) {
                        isTaken = false;
                    }
                }
             }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Connection Error. Please try again in some time.", Toast.LENGTH_SHORT).show();
            }
        });
        return isTaken;
    }


    private String getUserDisplayName() {
        return username.getText().toString().trim();
    }

    private String getFakultyName() {
        return ufacultyname.getText().toString().trim();
    }

    private String getUserEmail() {
        return uemail.getText().toString().trim();
    }

    private String getUserPassword() {
        return upassword.getText().toString().trim();
    }

    public int getHukukB(){
        return 0;
    }


    private int getEczacilikB() { return 0; }


    private int getIktitasB() { return 0; }

    private int getMuhendislikB()
    {
        return 0;
    }


    private void signUp(String email, String password) {
        final ProgressDialog progressDialog = new ProgressDialog(Activity_SignUp.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()) {
                    onAuthSuccess(task.getResult().getUser());
                }
                else {
                    Toast.makeText(getApplicationContext(), "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void onAuthSuccess(FirebaseUser user) {
        createNewUser(user.getUid());
        createUserNames();
        goToMainActivity();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(Activity_SignUp.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void createNewUser(String userId){
        UserModel user = buildNewUser();
        FirebaseDatabase.getInstance().getReference("users").child(userId).setValue(user);
    }

    public void createUserNames() {
        //mDatabase.child("userNames").child(getUserDisplayName()).setValue(true);
        FirebaseDatabase.getInstance().getReference("userNames").child(getUserDisplayName()).setValue(true);
    }
    private UserModel buildNewUser() {
        return new UserModel(
                getFakultyName(),
                getUserDisplayName(),
                getUserEmail(),
                new Date().getTime(),
                getHukukB(),

                getEczacilikB(),

                getIktitasB(),
                getMuhendislikB(),
                getCountEcz(),
                getCountHuk(),
                getCountIkt(),
                getCountMuh()
        );
    }

    public int getCountEcz() {
        return 0;
    }

    public int getCountHuk() {
        return 0;
    }

    public int getCountIkt() {
        return 0;
    }

    public int getCountMuh() {
        return 0;
    }
}