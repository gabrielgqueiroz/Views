package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.limparBt.setOnClickListener(view -> {
            activityMainBinding.nomeEt.setText("");
            activityMainBinding.sobrenomeEt.setText("");
            activityMainBinding.emailEt.setText("");
            activityMainBinding.estadoCivilSp.setSelection(0);
            activityMainBinding.femininoRb.setChecked(true);
            pessoa = null;
        });

        activityMainBinding.salvarBt.setOnClickListener(view -> {
            //Toast.makeText(this, activityMainBinding.estadoCivilSp.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            pessoa = new Pessoa(
                    activityMainBinding.nomeEt.getText().toString(),
                    activityMainBinding.sobrenomeEt.getText().toString(),
                    activityMainBinding.emailEt.getText().toString(),
                    activityMainBinding.estadoCivilSp.getSelectedItem().toString(),
                    //activityMainBinding.femininoRb.isChecked() ? "feminino" : "masculino"
                    activityMainBinding.femininoRb.isChecked() ? getString(R.string.feminino) : getString(R.string.masculino)
                    //activityMainBinding.femininoRb.isChecked() ? activityMainBinding.femininoRb.getText().toString() : activityMainBinding.masculinoRb.getText().toString()
            );
            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}