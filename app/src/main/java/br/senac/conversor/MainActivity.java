package br.senac.conversor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;
//é o nome da classe
public class MainActivity extends AppCompatActivity {
    // declaração da variável
    int alturaEmCentimetros = 0;
    int altura1 = 5;
    int altura2 = 5;
    int altura3 = 5;
    private int CalcularMedia(int x,int y,int z){

        return (x + y + z) / 3;
    }


    @Override
    // metodo protegido
    protected void onCreate(Bundle savedInstanceState) {
        // estou indo no pai buscar todo o código e jogando dentro do super
        super.onCreate(savedInstanceState);
        // metodo que liga a MainActivity.JAVA no activity_main.xml (TELA)
        setContentView(R.layout.activity_main);

        // Instancia de um elemento texto para android
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        // Exemplo Convencional de Instancia objeto no Java
        // final TextView txtMetros = new TextView
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);
        // Exemplo Convencional de Instancia objeto no Java
        // final TextView txtPes = new TextView
        final TextView txtMedia = (TextView) findViewById(R.id.txtMedia);



        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        // Exemplo Convencional de Instancia objeto no Java
        // final SeekBar SeekBar = new SeekBar
        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch (SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Aviso para clicar no botão de conversão
                txtPes.setText("Toque em Converter");

            }




            @Override
            public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {

                alturaEmCentimetros = progress;
                // variavel texto recebe valor da equação e é declarada como String
                String texto = formataValorComDoisDigitos (progress / 100.0);
                // texto recebe mais valor dentro de aspas
                texto += "m.";

                txtMetros.setText(texto);






            }
        });



        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        // variavel botao sendo setada e sendo instanciada por view
        btnConverter.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // variavel alturaEmPes recebe valor da equação e é declarada como double
                double alturaEmPes = alturaEmCentimetros / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);

               int  calculo = CalcularMedia(altura1,altura2,altura3);

                if (alturaEmCentimetros > calculo){
                    txtMedia.setText("maior, " + calculo);
                    ;


                } if (alturaEmCentimetros < calculo){
                    txtMedia.setText("menor, " + calculo);
                   ;

                }    else {
                    txtMedia.setText("igual, " + calculo);
                    
                }

            }
        });



       ;




    }




    // variavel declarada e privada sendo instanciada com double valor
      private String formataValorComDoisDigitos(double valor){
        // retorno de String com formato inserido
        return String.format(Locale.FRANCE, "%.2f", valor);




    }




}
