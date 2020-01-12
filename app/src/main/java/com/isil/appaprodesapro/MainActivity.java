package com.isil.appaprodesapro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declaraciones
    private EditText n1,n2,n3;
    private TextView resultado;
    private DecimalFormat df = new DecimalFormat("0.00");
    private double nota1,nota2,nota3;
    private String mensaje,condicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n_1);
        n2 = findViewById(R.id.n_2);
        n3 = findViewById(R.id.n_3);
        resultado = findViewById(R.id.txtresultado);

    }

    public void calcular(View view) {
        if(n1.getText().toString().isEmpty()||n2.getText().toString().isEmpty()||n3.getText().toString().isEmpty()){
            mensaje="Complete los campos";
            resultado.setText(mensaje);
        }else{
             nota1=Double.parseDouble(n1.getText().toString());
             nota2=Double.parseDouble(n2.getText().toString());
             nota3=Double.parseDouble(n3.getText().toString());

            if(nota3<0 || nota3>20||nota2<0 || nota2>20||nota1<0 || nota1>20){
                mensaje="Calificacion Invalida";
                resultado.setText(mensaje);
            }else{

                 double suma=nota1+nota2+nota3;
                 double promedio=suma/3;
                 if(promedio>=18.5)condicion="A";
                 else if(promedio>=14.5)condicion="B";
                 else if(promedio>=8.5)condicion="C";
                 else condicion="desaprobado";

                 resultado.setText("    PROMEDIO DE ALUMNO : "+df.format(promedio)+ "\n "+
                         "CONDICION DEL ALUMNO : "+condicion);
            }

        }
    }
    public void eliminar(View view){
        n1.setText("");
        n2.setText("");
        n3.setText("");
        resultado.setText("");
    }

}



