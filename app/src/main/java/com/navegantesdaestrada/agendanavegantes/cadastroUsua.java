package com.navegantesdaestrada.agendanavegantes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class cadastroUsua extends AppCompatActivity {
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usua);


    }
    //Cadastrar usuário
    public void cadastrar (View view){
        usuario.createUserWithEmailAndPassword("theooo@gmail.com", "123abc")
                .addOnCompleteListener(cadastroUsua.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(cadastroUsua.this, "Cadastro efetuado comsucesso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(cadastroUsua.this, "Erro ao fazer o cadastro", Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
}