package com.navegantesdaestrada.agendanavegantes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    
    private Button btnAgenda, btnCadastrar, btnPublica;
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

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
                Intent intent = new Intent(getApplicationContext(), CadastroUsua.class);
                startActivity(intent);
            }
        });

        //Chama tela de publicar eventos
        btnPublica = findViewById(R.id.buttonPublicar);
        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getCurrentUser() != null){
                    Intent intent = new Intent(getApplicationContext(), CadastroEventos.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("AVISO ");
                    dialog.setMessage("Para publicar um evento, faça o login ou caso seja seu primeiro acesso faça seu cadastro");
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.create();
                    dialog.show();
                }
            }
        });
    }
}