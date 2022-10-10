package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos el título teniendo como referéncia el archivos strings.xml para que se traduzca dependiendo del idioma del terminal.
        TextView titol = findViewById(R.id.TextTitol);
        titol.setText(getResources().getText(R.string.titulo));

        //Añadimos campos al spinner.
        String[] tiempo = {(String) getResources().getText(R.string.sec), (String) getResources().getText(R.string.min), (String) getResources().getText(R.string.hrs), (String) getResources().getText(R.string.yrs)};
       Spinner spinner = findViewById(R.id.spinner);
       //Creació del adaptador (serveix per editar com es veuran les dades dins del spinner)
       ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiempo);
       //Referenciem l'adaptador al layout del spinner
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setejem el adaptador al spinner...
      spinner.setAdapter(adapter);

      //Referencia dels elemenents per a la traducció
        TextView segundos = findViewById(R.id.txtSegons);
       segundos.setText(getResources().getText(R.string.sec));

        TextView minutos = findViewById(R.id.txtMinuts);
         minutos.setText(getResources().getText(R.string.min));

        TextView horas = findViewById(R.id.txtHores);
         horas.setText(getResources().getText(R.string.hrs));

         TextView años = findViewById(R.id.txtAnys);
        años.setText(getResources().getText(R.string.yrs));

        TextView listaResultados = findViewById(R.id.TitolResultats);
        listaResultados.setText(getResources().getText(R.string.LR));



        //Referenciar camps del xml
        EditText CampValor = (EditText) findViewById(R.id.CampValor);
        TextView CampSegons = (TextView) findViewById(R.id.CampSegons);
        TextView CampMinuts =(TextView) findViewById(R.id.CampMinuts);
        TextView CampHores = (TextView) findViewById(R.id.CampHores);
        TextView CampAnys = (TextView) findViewById(R.id.CampAnys);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if (pos == 0){

                    //Setejar valor als camps corresponents
                    //Calcul segons
                    Float CalculMinuts = Float.parseFloat(CampValor.getText().toString()) / 60;
                    Float CalculHores = Float.parseFloat(CampValor.getText().toString()) / 3600;
                    Float CalculAnys = Float.parseFloat(CampValor.getText().toString()) / 31536000;

                    //Camp segons
                    CampSegons.setText(CampValor.getText().toString());
                    //Camp minuts
                    CampMinuts.setText(String.format("%.2f", CalculMinuts));
                    //Camp hores
                    CampHores.setText(String.format("%.2f", CalculHores));
                    //Camp anys
                    CampAnys.setText(String.format("%.2f", CalculAnys));
                } else if (pos == 1) {

                    Integer calculoSegundos = Integer.parseInt(CampValor.getText().toString()) * 60;
                    Float CalculHores = Float.parseFloat(CampValor.getText().toString()) / 60;
                    Double CalculAnys = Double.parseDouble(CampValor.getText().toString()) / 0.0000019025875190259;

                    //Camp segons
                    CampSegons.setText(String.valueOf(calculoSegundos));
                    //Camp minuts
                    CampMinuts.setText(CampValor.getText().toString());
                    //Camp hores
                    CampHores.setText(String.format("%.2f", CalculHores));
                    //Camp anys
                    CampAnys.setText(String.format("%.2f", CalculAnys));

                } else if (pos == 2) {

                    Integer calculoSegundos = Integer.parseInt(CampValor.getText().toString()) * 3600;
                    Float CalculMinuts = Float.parseFloat(CampValor.getText().toString()) * 60;
                    Double CalculAnys = Double.parseDouble(CampValor.getText().toString()) / 0.000114155;

                    //Camp segons
                    CampSegons.setText(String.valueOf(calculoSegundos));
                    //Camp minuts
                    CampMinuts.setText(String.format("%.2f", CalculMinuts));
                    //Camp hores
                    CampHores.setText(CampValor.getText().toString());
                    //Camp anys
                    CampAnys.setText(String.format("%.2f", CalculAnys));

                } else if (pos == 3) {

                    Integer calculoSegundos = Integer.parseInt(CampValor.getText().toString()) * 31536000;
                    Double calculoMinutos = Double.parseDouble(CampValor.getText().toString()) * 0.0000019025875190259;
                    Double calculoHoras = Double.parseDouble(CampValor.getText().toString()) * 0.000114155;

                    //Camp segons
                    CampSegons.setText(String.valueOf(calculoSegundos));
                    //Camp minuts
                    CampMinuts.setText(String.format("%.2f", calculoMinutos));
                    //Camp hores
                    CampHores.setText(String.format("%.2f", calculoHoras));
                    //Camp anys
                    CampAnys.setText(CampValor.getText().toString());

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }





    }


