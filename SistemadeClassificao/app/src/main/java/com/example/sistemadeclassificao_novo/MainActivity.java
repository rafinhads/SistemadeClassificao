package com.example.sistemadeclassificao_novo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtstatus;
    RatingBar rtbvotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtstatus = (TextView) findViewById(R.id.txtstatus);
        rtbvotacao = (RatingBar) findViewById(R.id.rtbvotacao);
        txtstatus.setText("Status: Ruim");

        // Alerta na avaliação
        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 1) {
                    txtstatus.setText("Status: Ruim");
                    showAlert("Nota Ruim", " É uma pena, que você não gostou!");
                } else if (rating == 2) {
                    txtstatus.setText("Status: Regular");
                } else if (rating == 3) {
                    txtstatus.setText("Status: Bom");
                } else if (rating == 4) {
                    txtstatus.setText("Status: Excelente");
                } else if (rating == 5) {
                    txtstatus.setText("Status: Espetacular");
                    showAlert("Nota Espetacular", "Fico feliz que tenha gostado! Obrigada pela sua avaliação!");
                }
            }
        });
    }
    private void showAlert(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}