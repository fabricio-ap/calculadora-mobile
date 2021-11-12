package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5,
            btn_6, btn_7, btn_8, btn_9, btn_0,
            btn_ponto, btn_adicao, btn_subtracao, btn_multiplicacao, btn_divisao,
            btn_limpar, btn_igual;

    private TextView txt_operacao, txt_resultado;

    private ImageButton btn_apagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        componentes();

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_ponto.setOnClickListener(this);
        btn_adicao.setOnClickListener(this);
        btn_subtracao.setOnClickListener(this);
        btn_multiplicacao.setOnClickListener(this);
        btn_divisao.setOnClickListener(this);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_operacao.setText("");
                txt_resultado.setText("");
            }
        });

        btn_apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView operacao = findViewById(R.id.txt_operacao);

                String string = operacao.getText().toString();

                if (!string.isEmpty()) {
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtOperacao = string.substring(var0, var1);

                    operacao.setText(txtOperacao);
                }

                txt_resultado.setText("");
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression operacao = new ExpressionBuilder(txt_operacao.getText().toString()).build();

                    double resultado = operacao.evaluate();
                    long long_resultado = (long) resultado;

                    if (resultado == (double) long_resultado) {
                        txt_resultado.setText((CharSequence) String.valueOf(long_resultado));
                    } else {
                        txt_resultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception ex) {

                }
            }
        });

    }

    public void componentes() {
        btn_0 = findViewById(R.id.btn_zero);
        btn_1 = findViewById(R.id.btn_um);
        btn_2 = findViewById(R.id.btn_dois);
        btn_3 = findViewById(R.id.btn_tres);
        btn_4 = findViewById(R.id.btn_quatro);
        btn_5 = findViewById(R.id.btn_cinco);
        btn_6 = findViewById(R.id.btn_seis);
        btn_7 = findViewById(R.id.btn_sete);
        btn_8 = findViewById(R.id.btn_oito);
        btn_9 = findViewById(R.id.btn_nove);
        btn_ponto = findViewById(R.id.btn_ponto);

        btn_adicao = findViewById(R.id.btn_adicao);
        btn_subtracao = findViewById(R.id.btn_subtracao);
        btn_multiplicacao = findViewById(R.id.btn_multiplicacao);
        btn_divisao = findViewById(R.id.btn_divisao);
        btn_igual = findViewById(R.id.btn_igual);

        btn_apagar = findViewById(R.id.btn_apagar);
        btn_limpar = findViewById(R.id.btn_limpar);

        txt_operacao = findViewById(R.id.txt_operacao);
        txt_resultado = findViewById(R.id.txt_resultado);
    }

    public void operacao (String string, boolean limpar_dados) {
        if (txt_resultado.getText().equals("")) {
            txt_operacao.setText(" ");
        }

        if (limpar_dados) {
            txt_resultado.setText(" ");
            txt_operacao.append(string);
        } else {
            txt_operacao.append(txt_resultado.getText());
            txt_operacao.append(string);
            txt_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                operacao("0", true);
                break;

            case R.id.btn_um:
                operacao("1", true);
                break;

            case R.id.btn_dois:
                operacao("2", true);
                break;

            case R.id.btn_tres:
                operacao("3", true);
                break;

            case R.id.btn_quatro:
                operacao("4", true);
                break;

            case R.id.btn_cinco:
                operacao("5", true);
                break;

            case R.id.btn_seis:
                operacao("6", true);
                break;

            case R.id.btn_sete:
                operacao("7", true);
                break;

            case R.id.btn_oito:
                operacao("8", true);
                break;

            case R.id.btn_nove:
                operacao("9", true);
                break;

            case R.id.btn_ponto:
                operacao(".", true);
                break;

            case R.id.btn_adicao:
                operacao("+", false);
                break;

            case R.id.btn_subtracao:
                operacao("-", false);
                break;

            case R.id.btn_multiplicacao:
                operacao("x", false);
                break;

            case R.id.btn_divisao:
                operacao("/", false);
                break;
        }
    }
}