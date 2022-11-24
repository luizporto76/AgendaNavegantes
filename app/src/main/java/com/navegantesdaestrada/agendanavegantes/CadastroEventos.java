package com.navegantesdaestrada.agendanavegantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  CadastroEventos extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private Button bt_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_eventos);

        bt_cadastrar = findViewById(R.id.bt_cadastrar_evento);
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getCurrentUser() != null){
                    reference.child("EVENTO").child("Titulo").setValue("2º evento cadastradao");
                    reference.child("EVENTO").child("Titulo").child("1º evento cadastradao").setValue("1º evento cadastradao");

                }else{
                }
            }
        });

    }
}