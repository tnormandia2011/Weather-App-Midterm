package com.example.tim.sunshine;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

              String theCity =  editText.getText().toString();
              theCity = theCity.replace(" ", "%20");
              theCity = theCity.toLowerCase();

              getWeather(theCity);

            }

        });

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    public void getWeather(String searchText) {
        AsyncTask<String, Void, List<WeatherInfo>> as = new Website().execute(searchText);

        ListView lview = (ListView) findViewById(R.id.listView);

        try {

            final MyArrayAdapter adp = new MyArrayAdapter(this, R.layout.layout, R.id.Itemname, as.get());
            //final ArrayAdapter<WeatherInfo> adp = new ArrayAdapter<WeatherInfo>(this, R.layout.layout, R.id.Itemname, as.get());
            lview.setAdapter(adp);

            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    TextView textView = (TextView) view.findViewById(R.id.Itemname);
                    String text = textView.getText().toString();

                    try {
                        Intent myintent = new Intent(MainActivity.this, SecondActivity.class);
                        WeatherInfo theItem = adp.getItem(position);
                        String info = theItem.getInfo();
                        myintent.putExtra("info", info);
                        startActivity(myintent);
                    } catch (Exception e) {

                    }
                }
            });
        } catch (Exception e) {
            System.out.println("getWeather");
            e.printStackTrace();
        }
    }


        //WeatherInfo obj = new WeatherInfo(32, 25, 15, "3-4-15");
        //List<WeatherInfo> list = new ArrayList<WeatherInfo>();
        //list.add(obj);
        /*String forecastArray[] = {
          "Today - Cold",
          "Tomorrow -Cold"
        };

        ArrayAdapter<String> mForecastAdapter;
        List<String> weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray)
        );

        mForecastAdapter =
                    new ArrayAdapter<String>(
                            this,
                            R.layout.weathertext,
                            weekForecast
                    );
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mForecastAdapter);

        //new AlertDialog.Builder(this)
                //.setTitle("Delete entry")
                //.setMessage(SearchText)
                //.show();*/

}

