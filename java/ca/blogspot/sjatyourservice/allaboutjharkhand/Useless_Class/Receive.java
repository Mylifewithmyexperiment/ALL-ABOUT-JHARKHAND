package ca.blogspot.sjatyourservice.allaboutjharkhand.Useless_Class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
        import android.widget.Button;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Receive extends AppCompatActivity
{
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);


        b1=(Button)findViewById(R.id.btn_rnc_hills);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Receive.this,Register.class));
            }
        });
    }
}
