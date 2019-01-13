package com.example.kiran.apiexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.textclassifier.TextLinks;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import adapter.HerosAdapater;
import model.Heros;

public class MainActivity extends AppCompatActivity {

    private static final String url = "http://10.0.2.2:3000/superHeroes";
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private HerosAdapater myAdapter;
    Heros heroes;
    List<Heros> lstHeroes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_of_hero);
        displayHeroes();
    }
    private void displayHeroes() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject heroesObject = response.getJSONObject(i);
                                int id = heroesObject.getInt("id");
                                String name = heroesObject.getString("name");
                                String realName = heroesObject.getString("realName");
                                String superPowers = heroesObject.getString("superPowers");
                                String avatar = heroesObject.getString("avatar");
                                heroes = new Heros(id, name, realName, superPowers, avatar);
                                lstHeroes.add(heroes);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        myAdapter = new HerosAdapater(lstHeroes,getApplicationContext());
                        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(myAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error ", error.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }
}