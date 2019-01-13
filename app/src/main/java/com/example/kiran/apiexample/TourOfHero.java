package com.example.kiran.apiexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TourOfHero extends AppCompatActivity {
    private static final String TAG = "TourOfHero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_of_hero);

        new LongOperation().execute();
    }

    private class LongOperation extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            URL url = null;
            String response = null;
            try {
                //String url="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
               // url = new URL("https://cdn.esewa.com.np/esewa_gprs/creditcard/creditcard.json");
                //url = new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
                 url =new URL("http://10.0.2.2:4000/superHeroes");

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                int statusCode = urlConnection.getResponseCode();
                //200 means status = OK
                if (statusCode == 200) {
                    InputStream it = new BufferedInputStream(urlConnection.getInputStream());
                    InputStreamReader read = new InputStreamReader(it);
                    BufferedReader buff = new BufferedReader(read);
                    StringBuilder dta = new StringBuilder();
                    String chunks;
                    while ((chunks = buff.readLine()) != null) {
                        dta.append(chunks);
                    }
                    response = dta.toString();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            Log.d("Test", response);
            JSONArray jsonArr = null;
            JSONObject jsonObj=null;
//            try {
//                jsonArr = new JSONArray(response);
//                for (int i = 0; i < jsonArr.length(); i++) {
//                    jsonObj = jsonArr.getJSONObject(i);
//                    Bank bank = new Bank(jsonObj.getString("cardName"),
//                            jsonObj.getString("cardCode"),
//                            jsonObj.getString("cardNumber")
//                    );
//                    lstBank.add(bank);
//                }
//                //Attach to the recycler view from the adapter
//                RecyclerView recyclerView = findViewById(R.id.recyclerView);
//                BankAdapter myAdapter = new BankAdapter(lstBank);
//                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//                recyclerView.setLayoutManager(mLayoutManager);
//                recyclerView.setAdapter(myAdapter);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }

}