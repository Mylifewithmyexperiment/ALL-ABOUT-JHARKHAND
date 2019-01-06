package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;

        import java.util.HashMap;
        import java.util.Map;

public class Data extends AppCompatActivity
{
    Button b1;
    EditText ed1, ed2;
    TextView tv;


    String server_url="https://sjatyourservice.000webhostapp.com/www/init.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        b1=(Button)findViewById(R.id.btn_baidh2);

        ed1=(EditText)findViewById(R.id.editText1);
        ed2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView1);

        builder=new AlertDialog.Builder(Data.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final String Name, Email;
                Name=ed1.getText().toString();

                Email=ed2.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                builder.setTitle("Server Response!!");
                                builder.setMessage("Response:"+response);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ed1.setText("");
                                        ed2.setText("");
                                    }
                                });
                                AlertDialog alertDialog=builder.create();
                                alertDialog.show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Data.this,"Error..!!",Toast.LENGTH_SHORT).show();
                                error.printStackTrace();


                            }
                        }
                )

                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {Map<String, String> params=new HashMap<String, String>();

                        params.put("Name",Name);
                        params.put("Email",Email);

                        return params;
                    }
                };
                MySingleton.getMinstance(getApplicationContext()).AddtoRq(stringRequest);
            }
        });

    }
}

