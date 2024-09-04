package br.edu.fatec.br;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito,
            numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, limpar, parentesesAbre, parentesesFecha,
            porcentagem, potenciacao, raizQuadrada;
    private TextView txtExpressao, txtResultado;
    private ImageView backspace;
    private boolean ultimoFoiResultado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        parentesesAbre.setOnClickListener(this);
        parentesesFecha.setOnClickListener(this);
        porcentagem.setOnClickListener(this);
        potenciacao.setOnClickListener(this);
        raizQuadrada.setOnClickListener(this);

        limpar.setOnClickListener(v -> {
            txtExpressao.setText("");
            txtResultado.setText("");
            ultimoFoiResultado = false;
        });

        backspace.setOnClickListener(v -> {
            String string = txtExpressao.getText().toString();

            if (!string.isEmpty()) {
                String txtExpressaoAtualizada = string.substring(0, string.length() - 1);
                txtExpressao.setText(txtExpressaoAtualizada);
            }

            txtResultado.setText("");
            ultimoFoiResultado = false;
        });

        igual.setOnClickListener(v -> {
            try {
                Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                double resultado = expressao.evaluate();

                long longResult = (long) resultado;

                if (resultado == (double) longResult) {
                    txtResultado.setText(String.valueOf(longResult));
                } else {
                    txtResultado.setText(String.valueOf(resultado));
                }

                ultimoFoiResultado = true;

            } catch (Exception e) {
                txtResultado.setText("Erro");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.bt_igual);
        limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
        parentesesAbre = findViewById(R.id.bt_parenteses_abre);
        parentesesFecha = findViewById(R.id.bt_parenteses_fecha);
        porcentagem = findViewById(R.id.bt_porcentagem);
        potenciacao = findViewById(R.id.bt_potenciacao);
        raizQuadrada = findViewById(R.id.bt_raiz_quadrada);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (ultimoFoiResultado) {
            txtExpressao.setText("");  // Limpa a expressão anterior
            ultimoFoiResultado = false;
        }

        if (limpar_dados) {
            txtResultado.setText("");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.numero_zero) {
            AcrescentarUmaExpressao("0", true);
        } else if (id == R.id.numero_um) {
            AcrescentarUmaExpressao("1", true);
        } else if (id == R.id.numero_dois) {
            AcrescentarUmaExpressao("2", true);
        } else if (id == R.id.numero_tres) {
            AcrescentarUmaExpressao("3", true);
        } else if (id == R.id.numero_quatro) {
            AcrescentarUmaExpressao("4", true);
        } else if (id == R.id.numero_cinco) {
            AcrescentarUmaExpressao("5", true);
        } else if (id == R.id.numero_seis) {
            AcrescentarUmaExpressao("6", true);
        } else if (id == R.id.numero_sete) {
            AcrescentarUmaExpressao("7", true);
        } else if (id == R.id.numero_oito) {
            AcrescentarUmaExpressao("8", true);
        } else if (id == R.id.numero_nove) {
            AcrescentarUmaExpressao("9", true);
        } else if (id == R.id.ponto) {
            AcrescentarUmaExpressao(".", true);
        } else if (id == R.id.bt_soma) {
            AcrescentarUmaExpressao("+", false);
        } else if (id == R.id.bt_subtracao) {
            AcrescentarUmaExpressao("-", false);
        } else if (id == R.id.bt_multiplicacao) {
            AcrescentarUmaExpressao("*", false);
        } else if (id == R.id.bt_divisao) {
            AcrescentarUmaExpressao("/", false);
        } else if (id == R.id.bt_parenteses_abre) {
            AcrescentarUmaExpressao("(", false);
        } else if (id == R.id.bt_parenteses_fecha) {
            AcrescentarUmaExpressao(")", false);
        } else if (id == R.id.bt_porcentagem) {
            AcrescentarUmaExpressao( "*0.01", false);
        } else if (id == R.id.bt_potenciacao) {
            AcrescentarUmaExpressao("^", false);
        } else if (id == R.id.bt_raiz_quadrada) {
            AcrescentarUmaExpressao("sqrt(", false);
        }
    }
}
