package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<String> weekForecast= new ArrayList<>();
            weekForecast.add("Hoy - Soleado - 20/21");
            weekForecast.add("Mañana -  Nublado - 10/11");
            weekForecast.add("PasadoMañana - Lluvioso - 16/17");
            weekForecast.add("Jueves - Imposible - 24/29");
            weekForecast.add("Viernes - PtaMareQueCalor - 30/35");

            String[] forecastArray= {
                "Columbus - Sunny - 95/95",
                "Tomorrow - Cloudy - 70/40",
                "Weds - Foggy - 72/65",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Iminlove - 65/75",
                    "Sat - HELP TO ALL UNITS - 90/92",
                    "Sun - Sunny - 80/68",
                    "Columbus - Sunny - 95/95",
                    "Tomorrow - Cloudy - 70/40",
                    "Weds - Foggy - 72/65",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Iminlove - 65/75",
                    "Sat - HELP TO ALL UNITS - 90/92",
                    "Sun - Sunny - 80/68",
                    "Columbus - Sunny - 95/95",
                    "Tomorrow - Cloudy - 70/40",
                    "Weds - Foggy - 72/65",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Iminlove - 65/75",
                    "Sat - HELP TO ALL UNITS - 90/92",
                    "Sun - Sunny - 80/68"
            };

            List<String> semanaClima= new ArrayList<>(Arrays.asList(forecastArray));

            // Se necesita crear un Arrtay Adapter esto hace que se genere un arreglo que indique como se generará
            // cada uno de los elementos del arreglo visualmente
            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<>(
                    getActivity(), // el contexto actual en donde se está ejecutando
                    R.layout.list_item_forecast, // el layout donde se cargará la información
                    R.id.list_item_forecast_textview, // el elemento en donde se cargar'ala información
                    semanaClima); //los datos que se cargarán en este caso los dummies que hice arriba

            ListView lista = (ListView) rootView.findViewById(R.id.listview_forecast);
            lista.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
