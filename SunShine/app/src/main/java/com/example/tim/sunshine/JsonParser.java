package com.example.tim.sunshine;

import android.util.JsonReader;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tim on 3/4/2015.
 */
public class JsonParser
{
    public static List<WeatherInfo> buildWeatherInfoObjects(InputStream json)
    {
        JsonReader reader = new JsonReader( new InputStreamReader(json));
        return readMessagesArray(reader);
    }

    private static List readMessagesArray(JsonReader reader)
    {
        List messages = new ArrayList();
        try
        {
            reader.beginObject();
            while(reader.hasNext())
            {
                String name = reader.nextName();
                if(name.equals("list"))
                {
                    messages = readMessage(reader);
                }

                else
                    reader.skipValue();
            }
        }
        catch(IOException e)
        {
            System.out.println("readMessagesArray");
            e.printStackTrace();
        }
        return messages;
    }


    private static List readMessage(JsonReader reader) throws IOException
    {
        List messages = new ArrayList();

        reader.beginArray();
        while(reader.hasNext())
        {
            WeatherInfo obj = new WeatherInfo();

            reader.beginObject();
            while(reader.hasNext())
            {
                String name = reader.nextName();

                if(name.equals("dt"))
                {
                obj.setDate(reader.nextString());
                }
                else if(name.equals("temp"))
                {
                    readTemp(reader, obj);
                }
                else if(name.equals("weather"))
                {
                   readWeather(reader, obj);

                }

                else if(name.equals("pressure"))
                {
                    obj.setPressure(reader.nextDouble());
                }
                else if(name.equals("humidity"))
                {
                    obj.setHumidity(reader.nextDouble());
                }
                else if(name.equals("speed"))
                {
                    obj.setSpeed(reader.nextDouble());
                }
                else if(name.equals("deg"))
                {
                    obj.setDirection(reader.nextDouble());
                }

                else
                {
                    reader.skipValue();
                }
            }
            reader.endObject();
            Long dv = Long.valueOf(obj.getDate())*1000;// its need to be in milliseconds
            Date df = new java.util.Date(dv);
            String vv = new SimpleDateFormat("MM/dd/yyyy").format(df);
            obj.setDate(vv);
            messages.add(obj);
        }
        reader.endArray();
        return messages;
    }

   private static void readTemp(JsonReader reader, WeatherInfo obj) throws IOException
   {
       reader.beginObject();
       while(reader.hasNext())
       {
           String nextName = reader.nextName();
           if(nextName.equals("max"))
               obj.setHigh(reader.nextDouble());
           else if(nextName.equals("min"))
               obj.setLow(reader.nextDouble());
           else if(nextName.equals("day"))
               obj.setDayTemp(reader.nextDouble());
           else if(nextName.equals("night"))
               obj.setNightTemp(reader.nextDouble());
           else
               reader.skipValue();
       }
       reader.endObject();
   }
    private static void readWeather(JsonReader reader, WeatherInfo obj) throws IOException
    {

        reader.beginArray();
        while(reader.hasNext())
        {
            reader.beginObject();
            while(reader.hasNext())
            {
                String nextName = reader.nextName();
                if (nextName.equals("main"))
                {
                    obj.setMain(reader.nextString());

                }
                else if (nextName.equals("description"))
                {
                    obj.setDescription(reader.nextString());
                }
                else if(nextName.equals("icon"))
                {
                    obj.setIcon(reader.nextString());
                }
                else
                {
                    reader.skipValue();
                }
            }
            reader.endObject();
        }
        reader.endArray();


    }


}
