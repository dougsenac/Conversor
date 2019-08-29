package br.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimetros = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
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
                String texto = formataValorComDoisDigitos (progress / 100.0);
                texto += "m.";
                txtMetros.setText(texto);

            }
        });

        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alturaEmPes = alturaEmCentimetros / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });
      }

      private String formataValorComDoisDigitos(double valor){
        return String.format(Locale.FRANCE, "%.2f", valor);



    }
}
