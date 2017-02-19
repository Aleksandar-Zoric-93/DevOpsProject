package ie.itt.devops.aleksandar.devopsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
* Refactored From:
* https://drive.google.com/file/d/0B41RrECzQWB6anV2UHo1bnFjcVE/view
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn;
        loginBtn = (Button) findViewById(R.id.log_in);
        loginBtn.setOnClickListener(this);

        Button signinBtn;
        signinBtn = (Button) findViewById(R.id.sign_in);
        signinBtn.setOnClickListener(this);

    }


    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.log_in:
                Intent intent2=new Intent(getApplicationContext(),LogMeIn.class);
                Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
                startActivity(intent2);

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.sign_in:
                Intent intent=new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}
