package com.navegantesdaestrada.agendanavegantes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class cadastro_usuario extends AppCompatActivity {
    private FirebaseDatabase referencia = FirebaseDatabase.getInstance();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        usuario.createUserWithEmailAndPassword("theo.ansi@gmail.com.br", "12345")
                .addOnCompleteListener(cadastro_usuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(cadastro_usuario.this, "Cadastro efetuado comsucesso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(cadastro_usuario.this, "Erro ao fazer o cadastro", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}