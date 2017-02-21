package ie.itt.devops.aleksandar.devopsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Alex on 19/02/2017.
 */

/*
* Refactored From:
* https://drive.google.com/file/d/0B41RrECzQWB6anV2UHo1bnFjcVE/view
* */

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button getMotivatedBtn;
        getMotivatedBtn = (Button) findViewById(R.id.getMotivatedBtn);
        getMotivatedBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.getMotivatedBtn:

                //Select Quote
                String[] strs = new String[] {"quote_1", "quote_2", "quote_3","quote_4","quote_5","quote_6",
                        "quote_7", "quote_8", "quote_9","quote_10", "quote_11"};

                int randomIndex = new Random().nextInt(3);
                int resId = getResources().getIdentifier(strs[randomIndex ], "string", "ie.itt.devops.aleksandar.devopsproject");
                String randomString = getString(resId);


                TextView quoteView;
                quoteView = (TextView) findViewById(R.id.quoteView);

                quoteView.setText(randomString);

                break;

        }
    }
}
