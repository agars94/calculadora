package com.garapps.myapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ArrayList<String> arraylist =new ArrayList<String>();
    String cadena="";
    String cadena2="";
    Boolean check=false;

    public void onClick1(View v){
        TextView view2 =(TextView) findViewById(R.id.view2);
        Button b =(Button) v;
        cadena = (String) b.getText().toString();

        if (check){
            onClickClean(v);
            check=false;
        }

        if (!cadena.contains("+") && !cadena.contains("-")&& !cadena.contains("*")&& !cadena.contains("/")){
         cadena2= cadena2+cadena;

            if (arraylist.size()>0){
                arraylist.remove((arraylist.size()-1));
            }
            arraylist.add(cadena2);
        }
        else {
            arraylist.add(cadena);
            arraylist.add(cadena);
            cadena2="";
        }
        //view2.setText(view2.getText().toString()+cadena);

        view2.setText(arraylist.toString());


    }

    public void onClick(View v){
        TextView view=(TextView)findViewById(R.id.view2);
        int calc=0;
        int c=arraylist.size();
//ejemplo: array(2,+3,*,4,-,3)


        while (c!=1){

            if(c>3){
                if (arraylist.get(3).contains("*") ||arraylist.get(3).contains("/")){
                    if (arraylist.get(3).contains("*")){calc=Integer.parseInt(arraylist.get(2))*Integer.parseInt(arraylist.get(4));}
                    if (arraylist.get(3).contains("/")){calc=Integer.parseInt(arraylist.get(2))/Integer.parseInt(arraylist.get(4));}

                    arraylist.remove(2);
                    arraylist.remove(2);
                    arraylist.remove(2);
                    arraylist.add(2,Integer.toString(calc));
                    c=arraylist.size();
                }

                else {

                    if (arraylist.get(1).contains("+")){calc=Integer.parseInt(arraylist.get(0))+Integer.parseInt(arraylist.get(2));}
                    if (arraylist.get(1).contains("-")){calc=Integer.parseInt(arraylist.get(0))-Integer.parseInt(arraylist.get(2));}
                    if (arraylist.get(1).contains("*")){calc=Integer.parseInt(arraylist.get(0))*Integer.parseInt(arraylist.get(2));}
                    if (arraylist.get(1).contains("/")){calc=Integer.parseInt(arraylist.get(0))/Integer.parseInt(arraylist.get(2));}
                    arraylist.remove(0);
                    arraylist.remove(0);
                    arraylist.remove(0);
                    arraylist.add(0,Integer.toString(calc));
                    c=arraylist.size();
                }
            }
            else {

                if (arraylist.get(1).contains("+")){calc=Integer.parseInt(arraylist.get(0))+Integer.parseInt(arraylist.get(2));}
                if (arraylist.get(1).contains("-")){calc=Integer.parseInt(arraylist.get(0))-Integer.parseInt(arraylist.get(2));}
                if (arraylist.get(1).contains("*")){calc=Integer.parseInt(arraylist.get(0))*Integer.parseInt(arraylist.get(2));}
                if (arraylist.get(1).contains("/")){calc=Integer.parseInt(arraylist.get(0))/Integer.parseInt(arraylist.get(2));}
                arraylist.remove(0);
                arraylist.remove(0);
                arraylist.remove(0);
                arraylist.add(0,Integer.toString(calc));
                c=arraylist.size();
            }
        }


        check=true;

        view.setText(Integer.toString(calc));
    }

    public void onClickClean(View v){
        TextView view2 =(TextView) findViewById(R.id.view2);
        TextView view1 =(TextView) findViewById(R.id.textView2);
        cadena="";
        cadena2="";
        view1.setText("0");
        view2.setText("");
        arraylist.clear();
    }
    public void onClickEquals(){

    }

}

//comentario
