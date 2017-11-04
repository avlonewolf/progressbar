package com.example.lenovo.progress;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    DemoView dview;
    EditText et;
    Button b;
    float minutes,newangle;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mainView);
        cl=(ConstraintLayout)mainView.findViewById(R.id.cl1) ;
        dview=(DemoView)findViewById(R.id.arcView);
        Log.d("mainwa", "onCreate: "+dview.getArcAngle());
        et=(EditText)findViewById(R.id.et2);
        b=(Button)findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes= Float.valueOf(et.getText().toString());
                newangle=((minutes)/10)*360;
                dview.setMinutes(minutes);
                ArcAngleAnimation animation = new ArcAngleAnimation(dview, newangle);
                animation.setDuration(1000);
                dview.startAnimation(animation);
            }
        });





    }

}
