package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtValor1;
    EditText edtValor2;
    TextView txtResultado;
    Button btnSomar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        final TextView txtNome = new TextView(this);
        txtNome.setText("Nome: ");
        EditText edtText = new EditText(this);
        Button btnMessage = new Button(this);
        btnMessage.setText("Visualizar mensagem");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(txtNome);
        layout.addView(edtText);
        layout.addView(btnMessage);
//        setContentView(layout);
        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        txtResultado = findViewById(R.id.txtResultado);
        btnSomar = findViewById(R.id.btnSomar);

        btnSomar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Esse botão serve para realizar a soma de dois valores",
                Toast.LENGTH_SHORT).show();
                return true; // os eventos subsequentes não são executados
            }
        });
    }

    public void onBtnSomarClick(View v) {
        try {
            Double valor1 = Double.parseDouble(edtValor1.getText().toString());
            Double valor2 = Double.parseDouble(edtValor2.getText().toString());
            Double resultado = valor1 + valor2;
            txtResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            Toast.makeText(MainActivity.this, "Informe valores validos", Toast.LENGTH_LONG).show();
        }
    }
}