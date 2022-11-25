package com.navegantesdaestrada.agendanavegantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class  CadastroEventos extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private Button bt_cadastrar;
    private EditText titulo, endereco, descricao, dataInicial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_eventos);

        DatabaseReference evento = reference.child("EVENTO");

        iniciandoComponentes();

        bt_cadastrar = findViewById(R.id.bt_cadastrar_evento);
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override//salvando no firebase
            public void onClick(View view) {
                EventoClass eventoClass = new EventoClass();

                DatabaseReference evento = reference.child("EVENTO");
                eventoClass.setTitulo(titulo.getText().toString());
                //eventoClass.setDataInicial("01022000");
                //eventoClass.setDataFinal(datateste.getText());
                eventoClass.setEndereco(endereco.getText().toString());
                eventoClass.setDescricao(descricao.getText().toString());

                evento.push().setValue(eventoClass);

                limpaFormulario();
            }
        });

    }
    public void iniciandoComponentes(){
        titulo = findViewById(R.id.editText_titulo);
        endereco = findViewById(R.id.editText_endereco);
        descricao = findViewById(R.id.editText_descicao);
        dataInicial = findViewById(R.id.editText_dataInicial);
    }
    public void limpaFormulario(){
        titulo.setText("");
        endereco.setText("");
        descricao.setText("");
        //dataInicial.parseDate();
    }

}