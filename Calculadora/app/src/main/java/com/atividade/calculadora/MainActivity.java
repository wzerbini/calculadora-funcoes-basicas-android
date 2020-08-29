package com.atividade.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto;
    float numeroA = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = (TextView)findViewById(R.id.campoResultado);
        campoTexto.setText("0");
    }



    public void clicaBotao(View view){
        switch (view.getId()){
            case R.id.botaoClear:
                campoTexto.setText("0");
                numeroA=0;
                operacao="";
                break;
            case R.id.botaoSoma:
                calculaNumeros("+");
                break;
            case R.id.botaoSubtrai:
                calculaNumeros("-");
                break;
            case R.id.botaoDivide:
                calculaNumeros("/");
                break;
            case R.id.botaoMultiplica:
                calculaNumeros("*");
                break;
            case R.id.botaoIgual:
                mostraResultado();
                break;
            default :
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }

    public void calculaNumeros(String tipoOperacao){
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tipoOperacao;
        campoTexto.setText("0");
    }


    public void getKeyboard(String str)
    {
        String ScrCurrent = campoTexto.getText().toString();
        ScrCurrent += str;
        campoTexto.setText(ScrCurrent);
    }


    public void mostraResultado()
    {
        float numeroB = Integer.parseInt(campoTexto.getText().toString());
        float result = 0;
        if(operacao.equals("+"))
        {
            result = numeroB + numeroA;
        }
        if(operacao.equals("-"))
        {
            result = numeroA - numeroB;
        }
        if(operacao.equals("*"))
        {
            result = numeroB * numeroA;
        }
        if(operacao.equals("/"))
        {
            result = numeroA / numeroB;
        }
        campoTexto.setText(String.valueOf(result));
    }
}