package com.example.tim.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tim on 3/10/2015.
 */
public class MyArrayAdapter extends ArrayAdapter<WeatherInfo>
{
    public MyArrayAdapter(Context context, int resource1, int resource2, List<WeatherInfo> values)
    {
        super(context, resource1, resource2, values);
    }

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout, parent, false);
        }

        // Lookup view for data population
        TextView tName = (TextView) convertView.findViewById(R.id.Itemname);
        ImageView ivIcon = (ImageView) convertView.findViewById(R.id.icon);

        // Get the data item for this position
        WeatherInfo info = getItem(position);

        // Populate the data into the template view using the data object
        tName.setText(info.toString());

        String weather = info.getMain();
        switch(weather)
        {
            case "Clear": ivIcon.setImageResource(R.drawable.sunny);
               break;
            case "Snow": ivIcon.setImageResource(R.drawable.snow);
               break;
            case "Rain": ivIcon.setImageResource(R.drawable.rain);
               break;
            case "Clouds": ivIcon.setImageResource(R.drawable.cloudy);
               break;
            default: ivIcon.setImageResource(R.drawable.sunny);
               break;
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
