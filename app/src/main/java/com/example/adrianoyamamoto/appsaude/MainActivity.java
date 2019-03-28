package com.example.adrianoyamamoto.appsaude;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarDados();
    }

    public void Gravar(View v) {
        try {
            EditText editTextUltimoPeso = findViewById(R.id.etUltimoPeso);
            Float ultimoPeso =  Float.parseFloat(editTextUltimoPeso.getText().toString());

            EditText editTextAltura = findViewById(R.id.etAltura);
            Float altura =  Float.parseFloat(editTextAltura.getText().toString());

            EditText editTextBiceps = findViewById(R.id.etBiceps);
            Float biceps =  Float.parseFloat(editTextBiceps.getText().toString());

            EditText editTextBusto = findViewById(R.id.etBusto);
            Float busto = Float.parseFloat(editTextBusto.getText().toString());

            EditText editTextCintura = findViewById(R.id.etCintura);
            Float cintura =  Float.parseFloat(editTextCintura.getText().toString());

            EditText editTextQuadriceps = findViewById(R.id.etQuadriceps);
            Float quadriceps =  Float.parseFloat(editTextQuadriceps.getText().toString());

            EditText editTextQuadril = findViewById(R.id.etQuadril);
            Float quadril =  Float.parseFloat(editTextQuadril.getText().toString());

            SharedPreferences sharedPreferences = getSharedPreferences("MeusDados", MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putFloat("ultimoPeso", ultimoPeso);
            editor.putFloat("altura", altura);
            editor.putFloat("biceps", biceps);
            editor.putFloat("busto", busto);
            editor.putFloat("cintura", cintura);
            editor.putFloat("quadriceps", quadriceps);
            editor.putFloat("quadril", quadril);

            editor.apply();

            EmitirMensagem("App Saúde", "Dados Gravados com Sucesso.");
        }
        catch (Exception e) {
            EmitirMensagem("App Saúde", e.getMessage());
        }

    }

    private void CarregarDados() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("MeusDados", MODE_PRIVATE);

            EditText editTextUltimoPeso = findViewById(R.id.etUltimoPeso);
            editTextUltimoPeso.setText(String.valueOf(sharedPreferences.getFloat("ultimoPeso",0)));

            EditText editTextAltura = findViewById(R.id.etAltura);
            editTextAltura.setText(String.valueOf(sharedPreferences.getFloat("altura", 0)));

            EditText editTextBiceps = findViewById(R.id.etBiceps);
            editTextBiceps.setText(String.valueOf(sharedPreferences.getFloat("biceps", 0)));

            EditText editTextBusto = findViewById(R.id.etBusto);
            editTextBusto.setText(String.valueOf(sharedPreferences.getFloat("busto", 0)));

            EditText editTextCintura = findViewById(R.id.etCintura);
            editTextCintura.setText(String.valueOf(sharedPreferences.getFloat("cintura", 0)));

            EditText editTextQuadriceps = findViewById(R.id.etQuadriceps);
            editTextQuadriceps.setText(String.valueOf(sharedPreferences.getFloat("quadriceps", 0)));

            EditText editTextQuadril = findViewById(R.id.etQuadril);
            editTextQuadril.setText(String.valueOf(sharedPreferences.getFloat("quadril", 0)));
        }
        catch (Exception e) {
            EmitirMensagem("App Saúde", e.getMessage());
        }

    }

    private void EmitirMensagem(String titulo, String mensagem) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(mensagem);
        dlgAlert.setTitle(titulo);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
