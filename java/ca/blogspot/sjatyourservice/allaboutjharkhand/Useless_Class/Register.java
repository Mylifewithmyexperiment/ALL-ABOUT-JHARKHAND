package ca.blogspot.sjatyourservice.allaboutjharkhand.Useless_Class;
/**
 * page missing init.php
 * button onclick is created in onCreate methods only
 *
 *
 * //my public IP address while using psiphon  194.187.251.172
 *   my public IP address while using cyber room           182.76.152.38
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;

import ca.blogspot.sjatyourservice.allaboutjharkhand.MySingleton;
import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Register extends AppCompatActivity {

    Button b;
    EditText e1, e2, e3, e4, e5;
    String Name, Email, Username, Password, ConPass;


    AlertDialog.Builder builder;

    String reg_url="http://172.16.10.116/register.php";
   // 192.168.43.198
	//String reg_url="http://192.168.43.198/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        b=(Button)findViewById(R.id.btn_baidh2);

        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);

        builder=new AlertDialog.Builder(Register.this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name=e1.getText().toString();
                Email=e2.getText().toString();
                Username=e3.getText().toString();
                Password=e4.getText().toString();
                ConPass=e5.getText().toString();

                if(Name.equals("")||Email.equals("")||Username.equals("")||Password.equals("")||ConPass.equals(""))
                {
                    builder.setTitle("Something went Wrong");
                    builder.setMessage("Please fill all fields !!!");
                    displayAlert("input_error");
                }

                else
                {
                    if(!Password.equals(ConPass))
                    {
                        builder.setTitle("Something went Wrong");
                        builder.setMessage("Passwords do not match!!!");
                        displayAlert("input_error");
                    }
                    else
                    {
                        StringRequest stringRequest=new StringRequest(Request.Method.POST, reg_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        try {
                                            JSONArray jsonArray=new JSONArray(response);
                                            JSONObject jsonObject=jsonArray.getJSONObject(0);

                                            String code=jsonObject.getString("code");
                                            String message=jsonObject.getString("message");

                                            builder.setTitle("Server Response......");
                                            builder.setMessage(message);
                                            displayAlert(code);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Register.this,"ok..!!",Toast.LENGTH_SHORT).show();
                                error.printStackTrace();

                            }
                        })
                        {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String,String> params=new HashMap<String, String>();
                                params.put("Name",Name);
                                params.put("Email",Email);
                                params.put("Username",Username);
                                params.put("Password",Password);


                                return params;
                            }
                        }
                                ;
                        MySingleton.getMinstance(getApplicationContext()).AddtoRq(stringRequest);
                        // MySingleton.getMinstance(Register.this).AddtoRq(stringRequest);
                    }
                }



            }
        });


    }

    public void displayAlert(final String code)
    {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(code.equals("input_error"))
                {
                    e4.setText("");
                    e5.setText("");
                }
                else if(code.equals("reg_success"))
                {
                    finish();
                }
                else if(code.equals("reg_failed"))
                {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                }

            }

        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
}
