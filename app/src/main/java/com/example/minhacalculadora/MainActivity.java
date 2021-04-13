package com.example.minhacalculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView display1;
    private ArrayList<String> numerosEsinais;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        display1 = findViewById(R.id.tvDisplay1);
        numerosEsinais = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    public void onClickBtn1(View view) {
        AddValores(getString(R.string.btn1));
    }

    public void onClickBtn2(View view) {
        AddValores(getString(R.string.btn2));
    }

    public void onClickBtn3(View view) {
        AddValores(getString(R.string.btn3));
    }

    public void onClickBtn4(View view) {
        AddValores(getString(R.string.btn4));
    }

    public void onClickBtn5(View view) {
        AddValores(getString(R.string.btn5));
    }

    public void onClickBtn6(View view) {
        AddValores(getString(R.string.btn6));
    }

    public void onClickBtn7(View view) {
        AddValores(getString(R.string.btn7));
    }

    public void onClickBtn8(View view) {
        AddValores(getString(R.string.btn8));
    }

    public void onClickBtn9(View view) {
        AddValores(getString(R.string.btn9));
    }

    public void onClickBtn0(View view) {
        AddValores(getString(R.string.btn0));
    }

    public void onClickBtnVirgula(View view) {
        AddValores(getString(R.string.virgula));
    }

    public void onClickBtnDivisao(View view) {
        AddValores(getString(R.string.divisao));
    }

    public void onClickBtnMultiplicacao(View view) {
        AddValores(getString(R.string.multiplicacao));
    }

    public void onClickBtnSoma(View view) {
        AddValores(getString(R.string.soma));
    }

    public void onClickBtnSubtracao(View view) {
        AddValores(getString(R.string.subtracao));
    }

    public void onClickBtnDelete(View view) {
        if (display1.length() > 0)
            display1.setText(display1.getText().toString().substring(0, display1.length() - 1));
        if (stringBuilder.length() > 0) //verifica os valores da stringbuilder e deleta 1
            stringBuilder.setLength(stringBuilder.length() - 1);
        else {
            if (numerosEsinais.size() > 0 && numerosEsinais.get(numerosEsinais.size() - 1).length() > 0) {
                StringBuilder valor = new StringBuilder();
                valor.append(numerosEsinais.get(numerosEsinais.size() - 1));
                if (numerosEsinais.get(numerosEsinais.size() - 1).length() > 1) { //se o valor no indice tiver mais de um elemento o mesmo atribuido a variavel valor sera refuzido um caractere
                    valor.setLength(numerosEsinais.get(numerosEsinais.size() - 1).length() - 1); //ira deletar a posição do ultimo valor e atribuido a variavel valor com 1 caractere reduzido
                    numerosEsinais.remove(numerosEsinais.size() - 1);
                    numerosEsinais.add(valor.toString());
                } else { //caso o indice tenha apenas um valor o indice será deletado
                    numerosEsinais.remove(numerosEsinais.size() - 1);
                }
            }
        }
    }

    public void onClickBtnIgual(View view) {
        if (stringBuilder.length() > 0) {
            float resultado = 0;
            if (!stringBuilder.toString().equals("/") ||
                    !stringBuilder.toString().equals("*") ||
                    !stringBuilder.toString().equals("-") ||
                    !stringBuilder.toString().equals("+")) {
                if (!numerosEsinais.get(numerosEsinais.size() - 1).equals("/") &&
                        !numerosEsinais.get(numerosEsinais.size() - 1).equals("*") &&
                        !numerosEsinais.get(numerosEsinais.size() - 1).equals("-") &&
                        !numerosEsinais.get(numerosEsinais.size() - 1).equals("+")) { //se o valor da ultima posição vor um numero, logo ira concatenar o numero presento no stringbuilder
                    numerosEsinais.set(numerosEsinais.size()-1, numerosEsinais.get(numerosEsinais.size()-1)+""+stringBuilder.toString());
                }else
                    numerosEsinais.add(stringBuilder.toString());
            }
            if (numerosEsinais.size() >= 2) {
                if (numerosEsinais.get(0).equals("/") ||
                        numerosEsinais.get(0).equals("*") ||
                        numerosEsinais.get(0).equals("-") ||
                        numerosEsinais.get(0).equals("+")) {
                    if (numerosEsinais.size() >= 3)
                        for (int i = 2; numerosEsinais.size() - 1 > i; i += 2) {
                            if (i == 2 && numerosEsinais.get(i - 2).equals("-")) {
                                if (numerosEsinais.get(i).equals("+")) {
                                    resultado = -Float.parseFloat(numerosEsinais.get(i - 1)) + Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("-")) {
                                    resultado = -Float.parseFloat(numerosEsinais.get(i - 1)) - Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("/")) {
                                    resultado = -Float.parseFloat(numerosEsinais.get(i - 1)) / Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("*")) {
                                    resultado = -Float.parseFloat(numerosEsinais.get(i - 1)) * Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                            } else {
                                if (numerosEsinais.get(i).equals("+")) {
                                    resultado = Float.parseFloat(numerosEsinais.get(i - 1)) + Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("-")) {
                                    resultado = Float.parseFloat(numerosEsinais.get(i - 1)) - Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("/")) {
                                    resultado = Float.parseFloat(numerosEsinais.get(i - 1)) / Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                                if (numerosEsinais.get(i).equals("*")) {
                                    resultado = Float.parseFloat(numerosEsinais.get(i - 1)) * Float.parseFloat(numerosEsinais.get(i + 1));
                                    numerosEsinais.set(i + 1, "" + resultado);
                                }
                            }
                        }
                } else {
                    for (int i = 1; numerosEsinais.size() - 1 > i; i += 2) {
                        if (numerosEsinais.get(i).equals("+")) {
                            resultado = Float.parseFloat(numerosEsinais.get(i - 1)) + Float.parseFloat(numerosEsinais.get(i + 1));
                            numerosEsinais.set(i + 1, "" + resultado);
                        }
                        if (numerosEsinais.get(i).equals("-")) {
                            resultado = Float.parseFloat(numerosEsinais.get(i - 1)) - Float.parseFloat(numerosEsinais.get(i + 1));
                            numerosEsinais.set(i + 1, "" + resultado);
                        }
                        if (numerosEsinais.get(i).equals("/")) {
                            resultado = Float.parseFloat(numerosEsinais.get(i - 1)) / Float.parseFloat(numerosEsinais.get(i + 1));
                            numerosEsinais.set(i + 1, "" + resultado);
                        }
                        if (numerosEsinais.get(i).equals("*")) {
                            resultado = Float.parseFloat(numerosEsinais.get(i - 1)) * Float.parseFloat(numerosEsinais.get(i + 1));
                            numerosEsinais.set(i + 1, "" + resultado);
                        }
                    }
                }
                display1.setText(numerosEsinais.get(numerosEsinais.size() - 1));
                numerosEsinais = new ArrayList<>();
                stringBuilder = new StringBuilder();
            }
        }
    }

    public void onClickBtnClear(View view) {
        display1.setText("");
        numerosEsinais = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    public void AddValores(String str) {
        numerosEsinais = Verificacao1(numerosEsinais, stringBuilder, str, display1);
        numerosEsinais = Verificacao2(numerosEsinais, stringBuilder, str, display1);
        MostraDisplay(display1, numerosEsinais, stringBuilder);
    }

    private ArrayList<String> Verificacao1(ArrayList<String> numerosEsinais, StringBuilder stringBuilder, String str, TextView display1) {
        if (numerosEsinais.size() == 0 && stringBuilder.length() == 0)
            if (!str.equals("/") && !str.equals("*") && !str.equals("-") && !str.equals("+")) //com o resultado aparecendo se algum numero for digitado o display reseta
                display1.setText("");
            else {  //se for digitado um sinal então sera executado a operação com o resultado da conta anterior
                if (display1.getText().length() > 0) {
                    numerosEsinais.add(display1.getText().toString());
                }
                stringBuilder.append(str);
            }
        return numerosEsinais;
    }

    private ArrayList<String> Verificacao2(ArrayList<String> numerosEsinais, StringBuilder stringBuilder, String str, TextView display1) {
        if (str.equals("/") || str.equals("*") || str.equals("-") || str.equals("+")) {
            if (stringBuilder.length() > 0) { //se for um operador inserido o valor numérico contido na stringbuilder é anexado ao array de valores e sinais e resetado o valor da stringbuilder
                numerosEsinais.add(stringBuilder.toString());
                this.stringBuilder = new StringBuilder();
            }
            if (!numerosEsinais.get(numerosEsinais.size() - 1).equals("/") && !numerosEsinais.get(numerosEsinais.size() - 1).equals("*") &&
                    !numerosEsinais.get(numerosEsinais.size() - 1).equals("-") && !numerosEsinais.get(numerosEsinais.size() - 1).equals("+")) { //validação para não colocar mais de um operador para o calculo
                numerosEsinais.add(str);
            } else {
                if (!numerosEsinais.get(numerosEsinais.size() - 1).equals("-")) //valida a opção de atribuir um valor negativo ex: 5+-15 =-10, esse valor é atruibuido junto ao numero sem gerar um novo indice no array
                    stringBuilder.append(str);
            }
        } else {
            stringBuilder.append(str);
        }
        return numerosEsinais;
    }

    public void MostraDisplay(TextView display1, ArrayList<String> numerosEsinais, StringBuilder stringBuilder) {
        display1.setText("");
        for (String valor : numerosEsinais) {
            display1.append(valor);
        }
        if (stringBuilder.length() > 0)
            display1.append(stringBuilder);
    }
}