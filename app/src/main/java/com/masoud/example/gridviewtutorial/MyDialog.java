package com.masoud.example.gridviewtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        Intent intent=getIntent();
        if(intent!=null){
            int ImageId=intent.getIntExtra("countryImage",R.drawable.afghanistan_flag);
            String countryName=intent.getStringExtra("countryName");


            ImageView myimage= (ImageView) findViewById(R.id.imageView2);
            myimage.setImageResource(ImageId);

            TextView myText=(TextView)findViewById(R.id.textViewnamecountry);
            myText.setText("country name: "+countryName);

        }

    }
    public void CloseDialog(View view){
        finish();

    }
}
