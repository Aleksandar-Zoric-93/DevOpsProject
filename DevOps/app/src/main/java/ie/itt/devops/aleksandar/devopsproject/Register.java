package ie.itt.devops.aleksandar.devopsproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Alex on 19/02/2017.
 */

/*
* Refactored From:
* https://drive.google.com/file/d/0B41RrECzQWB6anV2UHo1bnFjcVE/view
* */

public class Register extends AppCompatActivity implements View.OnClickListener {
    ImageView im=null;
    EditText tv1,tv2,tv3,tv4;
    boolean flag=false;
    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        im=(ImageView)findViewById(R.id.register_show_hideBtn);
        tv1=(EditText)findViewById(R.id.registerNameFld);
        tv2=(EditText)findViewById(R.id.registerEmailFld);
        tv3=(EditText)findViewById(R.id.registerMobileFld);
        tv4=(EditText)findViewById(R.id.registerPasswordFld);
        db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);
        db.execSQL("create table if not exists Members(memberName varchar,memberMobile_no varchar,memberEmail_id varchar,memberPassword varchar,memberFlag varchar)");

        Button confirmRegistrationBtn;
        confirmRegistrationBtn = (Button) findViewById(R.id.confirmRegisterBtn);
        confirmRegistrationBtn.setOnClickListener(this);

        Button clearBtn;
        clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(flag==false)
                {
                    im.setImageResource(R.drawable.hide);
                    tv4.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    flag=true;
                }
                else
                {
                    im.setImageResource(R.drawable.show);
                    tv4.setInputType(129);
                    flag=false;

                }
            }
        });
    }

    public boolean clearAllFields(EditText input1, EditText input2, EditText input3, EditText input4)
    {
        input1.equals(tv1);
        input2.equals(tv2);
        input3.equals(tv3);
        input4.equals(tv4);

        input1.setText("");
        input2.setText("");
        input3.setText("");
        input4.setText("");

        if(input1.equals("") && input2.equals("") && input3.equals("") && input4.equals(""))
        {
            Toast.makeText(this, "Unknown Problem Occured", Toast.LENGTH_LONG).show();
            return true;
        }
        else
        {
            Toast.makeText(this, "All Fields Cleared", Toast.LENGTH_LONG).show();
            return false;
        }


    }

    public boolean validateRegistrationForm(String name, String mobile, String email, String password)
    {
        if(name==null||name==""||name.length()<3)
        {
            show("Please Enter Correct Name.");
            return false;
        }
        else if(mobile==null||mobile==""||mobile.length()<10)
        {
            show("Please Enter Correct mobile number.");
            return false;
        }
        else if(email==null||email==""||email.length()<10)
        {
            show("Please Enter Correct Email id.");
            return false;
        }
        else if(password==null||password==""||password.length()<6)
        {
            show("Please Enter Strong Password.");
            return false;
        }
        return true;
    }


    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.confirmRegisterBtn:
                String name=tv1.getText().toString();
                String email_id=tv2.getText().toString();
                String mobile_no=tv3.getText().toString();
                String password=tv4.getText().toString();

                if(validateRegistrationForm(name,mobile_no,email_id,password) ==true)
                {
                    db.execSQL("insert into Members values('"+name+"','"+mobile_no+"','"+email_id+"','"+password+"','nothing')");
                    Intent welcomeIntent=new Intent(getApplicationContext(),Welcome.class);
                    startActivity(welcomeIntent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    db.close();
                    finish();
                    Toast.makeText(this, "Member Registered Successfully", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.clearBtn:
                clearAllFields(tv1,tv2,tv3,tv4);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void show(String str)
    {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

}
