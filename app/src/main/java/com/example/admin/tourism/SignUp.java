package com.example.admin.tourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ADMIN on 28/06/2016.
 */
public class SignUp extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    public void onSignUpClick(View v){
        if(v.getId()==R.id.Bsignupbutton){
            EditText name=(EditText)findViewById(R.id.TFname);
            EditText email=(EditText)findViewById(R.id.TFemail);
            EditText uname=(EditText)findViewById(R.id.TFusername);
            EditText pass1=(EditText)findViewById(R.id.TFpass1);
            EditText pass2=(EditText)findViewById(R.id.TFpass2);

            String namestr=name.getText().toString();
            String emailstr=email.getText().toString();
            String unamestr=uname.getText().toString();
            String pass1str=pass1.getText().toString();
            String pass2str=pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //Pop up message
                Toast pass=Toast.makeText(SignUp.this,"Passwords don't match.!!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                //insert the details in database
                Contact c=new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
            }
        }
    }
}
