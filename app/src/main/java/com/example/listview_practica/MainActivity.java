package com.example.listview_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview_practica.Adapter.AdapterCovid;
import com.example.listview_practica.Model.Covid;

import com.example.listview_practica.WebService.Asynchtask;
import com.example.listview_practica.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstListaCovid);

        View header = getLayoutInflater().inflate(R.layout.ly_header, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.covid19api.com/summary",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Covid> lstCovid = new ArrayList<Covid> ();
        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaCovid=  JSONlista.getJSONArray("Countries");

            lstCovid = Covid.JsonObjectsBuild(JSONlistaCovid);

            AdapterCovid adapterCovid = new AdapterCovid(this, lstCovid);

            lstOpciones.setAdapter(adapterCovid);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }

    }
}