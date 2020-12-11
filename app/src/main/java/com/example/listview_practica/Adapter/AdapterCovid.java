package com.example.listview_practica.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listview_practica.Model.Covid;
import com.example.listview_practica.R;

import java.util.ArrayList;

public  class AdapterCovid extends ArrayAdapter<Covid> {

    public AdapterCovid(Context context, ArrayList<Covid> datos) {
        super(context, R.layout.ly_item_covid, datos);
}
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_item_covid, null);

        TextView lblCountry = (TextView)item.findViewById(R.id.lblCountry);
        TextView lblCountryCode = (TextView)item.findViewById(R.id.lblCountryCode);
        TextView lblNewConfirmed = (TextView)item.findViewById(R.id.lblNewConfirmed);
        TextView lblTotalConfirmed = (TextView)item.findViewById(R.id.lblTotalConfirmed);

        lblCountry.setText(getItem(position).getCountry());
        lblCountryCode.setText(getItem(position).getCountryCode());
        lblNewConfirmed.setText(getItem(position).getNewConfirmed().toString());
        lblTotalConfirmed.setText(getItem(position).getTotalConfirmed().toString());

        return(item);
}

}
