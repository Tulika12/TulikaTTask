package com.example.tulika.corpotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List list;
    RecyclerView recyclerView1;
    RecyclerAdapter adapter;
    List<ProductModel> heroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview);
        heroList = new ArrayList<>();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        getProductData();
    }

    public void getProductData() {
        String JSON_URL="http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray worldArray = obj.getJSONArray("worldpopulation");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < worldArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject heroObject = worldArray.getJSONObject(i);
                                String rank=heroObject.getString("rank");
                                String country=heroObject.getString("country");
                                String population=heroObject.getString("population");
                                String flag=heroObject.getString("flag");
                                int ran=Integer.parseInt(rank);

                                ProductModel productModel=new ProductModel(ran,country,flag,population);
                                 heroList.add(productModel);
                                adapter = new RecyclerAdapter(heroList, getApplicationContext(),ImageLoader.getInstance());
                                recyclerView1.setAdapter(adapter);
                                recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
