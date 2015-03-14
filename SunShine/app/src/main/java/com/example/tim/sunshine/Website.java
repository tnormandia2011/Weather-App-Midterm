package com.example.tim.sunshine;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.util.List;

/**
 * Created by Tim on 3/4/2015.
 */
public class Website extends AsyncTask <String, Void, List<WeatherInfo>>
{
   public Website()
   {

   }
   protected List<WeatherInfo> doInBackground(String... city)
   {
       try
       {
           String website = "http://api.openweathermap.org/data/2.5/forecast/daily?q=" +city[0] + "&mode=json&units=imperial&cnt=7";

           HttpClient httpClient = new DefaultHttpClient();
           HttpContext localContext = new BasicHttpContext();
           HttpGet httpGet = new HttpGet(website);
           HttpResponse response = httpClient.execute(httpGet, localContext);

           return JsonParser.buildWeatherInfoObjects(response.getEntity().getContent());
       }
       catch (Exception e)
       {
           System.out.println("doInBackground");
           e.printStackTrace();
           return null;
       }

   }
}
