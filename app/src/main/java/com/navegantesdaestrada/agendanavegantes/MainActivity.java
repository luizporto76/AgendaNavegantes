package com.navegantesdaestrada.agendanavegantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    
    private Button btnAgenda, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Chama tela de lista de eventos
        btnAgenda = findViewById(R.id.buttonAgenda);
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaDeEventos.class);
                startActivity(intent);
            }
        });


        //Chama tela de cadastro de usuário
        btnCadastrar = findViewById(R.id.buttonCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cadastro_usuario.class);
                startActivity(intent);
            }
        });
    }
}