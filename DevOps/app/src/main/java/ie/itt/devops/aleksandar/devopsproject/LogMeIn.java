package ie.itt.devops.aleksandar.devopsproject;

import android.content.Intent;
import android.database.Cursor;
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

public class LogMeIn extends AppCompatActivity implements View.OnClickListener {
    ImageView im=null;
    EditText tv1,tv4;
    boolean flag=false;
    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        im=(ImageView)findViewById(R.id.login_show_hideBtn);
        tv1=(EditText)findViewById(R.id.mobileLoginFld);
        tv4=(EditText)findViewById(R.id.passwordLoginFld);
        db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);

       /* Button registerBtn;
        registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);*/

        Button confirmLoginBtn;
        confirmLoginBtn = (Button) findViewById(R.id.confirmLoginBtn);
        confirmLoginBtn.setOnClickListener(this);
        //	db.execSQL("create table if not exists login(name varchar,mobile_no varchar,email_id varchar,password varchar,flag varchar)");

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

    public boolean validationMobNumPassword(String mobile, String password)
    {
        if(mobile==null||mobile==""||mobile.length()<10)
        {
            show("Please Enter Correct mobile number.");
            return false;
        }
        else if(password==null||password==""||password.length()<6)
        {
            show("Please Enter Correct Password.");
            return false;
        }

        return true;
    }


    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.confirmLoginBtn:
                String mobile_no=tv1.getText().toString();
                String password=tv4.getText().toString();

                if(validationMobNumPassword(mobile_no, password) == true)
                {
                    Cursor c=db.rawQuery("select * from Members where memberMobile_no='"+mobile_no+"' and memberPassword='"+password+"'",null);

                    c.moveToFirst();
                    if(c.getCount()>0)
                    {
                        Intent welcomeIntent=new Intent(getApplicationContext(),Welcome.class);
                        startActivity(welcomeIntent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        db.close();
                        finish();
                    }
                    else
                        show("Wrong Password or Mobile number.");

                }
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
