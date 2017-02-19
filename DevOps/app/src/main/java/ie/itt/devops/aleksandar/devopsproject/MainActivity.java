package ie.itt.devops.aleksandar.devopsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login_sigin(View v)
    {
        switch(v.getId())
        {
            case R.id.log_in:
                Intent i=new Intent(this,LogMeIn.class);
                startActivityForResult(i, 500);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.sign_in:
                i=new Intent(this,SignIn.class);
                startActivityForResult(i, 500);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}