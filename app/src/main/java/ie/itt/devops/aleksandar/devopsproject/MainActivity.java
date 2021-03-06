package ie.itt.devops.aleksandar.devopsproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import io.fabric.sdk.android.Fabric;

/*
* Refactored From:
* https://drive.google.com/file/d/0B41RrECzQWB6anV2UHo1bnFjcVE/view
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//Test1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_main);

        Button loginBtn;
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        Button signinBtn;
        signinBtn = (Button) findViewById(R.id.registerBtn);
        signinBtn.setOnClickListener(this);
    }


    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.loginBtn:
                Intent intent2=new Intent(getApplicationContext(),LogMeIn.class);
                startActivity(intent2);

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.registerBtn:
                Intent intent=new Intent(getApplicationContext(),Register.class);
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
