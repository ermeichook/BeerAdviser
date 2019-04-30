package com.example.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    //Вызывается при щелчкке на кнопке
    public void onClickFindBeer(View view){
        //Получить ссылку на TextView
        TextView brands = (TextView)findViewById(R.id.brands);
        //Получить ссылку на Spinner
        Spinner color = (Spinner)findViewById(R.id.color);
        //Получить вариант, выбранный в Spinner

        String beerType = String.valueOf(color.getSelectedItem());
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandList){
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_beer_activity);
    }

}
