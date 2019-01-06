package ca.blogspot.sjatyourservice.allaboutjharkhand;

/**
 * Created by SHASHI on 18-Aug-17.
 */

import android.content.Context;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;


public class MySingleton
{

    private static MySingleton minstance;
    private RequestQueue requestQueue;
    private Context mcontext;


    private MySingleton(Context context)
    {
        mcontext=context;
        requestQueue=getRequestQueue();
    }

    public  RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= com.android.volley.toolbox.Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getMinstance(Context context)
    {
        if(minstance==null)
            minstance=new MySingleton(context);

        return minstance;
    }
    public<T> void AddtoRq(Request<T> request)
    {

        requestQueue.add(request);

    }
}
