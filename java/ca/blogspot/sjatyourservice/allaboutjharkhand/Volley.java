package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;

public class Volley extends AppCompatActivity
{   Button b1;
    TextView tv;
    String server_url="https://sjatyourservice.000webhostapp.com/www/greetings.php";
    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        b1=(Button)findViewById(R.id.btn_baidh2);
        tv=(TextView)findViewById(R.id.textView1);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      final RequestQueue requestQueue= com.android.volley.toolbox.Volley.newRequestQueue(Volley.this);
                                      StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                                              new Response.Listener<String>()
                                              {
                                                  @Override
                                                  public void onResponse(String response)
                                                  {
                                                      tv.setText(response);
                                                      // requestQueue.stop();


                                                  }
                                              }, new Response.ErrorListener()
                                      {
                                          @Override
                                          public void onErrorResponse(VolleyError error)
                                          {
                                              tv.setText("Somethng went wrong");
                                              error.printStackTrace();
                                              // requestQueue.stop();
                                          }
                                      });

                                      MySingleton.getMinstance(getApplicationContext()).AddtoRq(stringRequest);

                                  }
                              }




        );

    }
}
