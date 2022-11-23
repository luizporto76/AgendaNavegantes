package com.navegantesdaestrada.agendanavegantes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroUsua extends AppCompatActivity {
    private EditText edit_email;
    private EditText edit_senha;
    private Button bt_cadastrar;
    private Button bt_voltar;
    String[] mensagem = {"Preencha todos os campos", "Cadastro realizado com sucesso "};
    private FirebaseAuth usuario = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usua);
        getSupportActionBar().hide();
        IniciarComponentes();

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
   }
    public void cadastrar (View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        if(email.isEmpty() || senha.isEmpty()){
            Snackbar snackbar = Snackbar.make(view, mensagem[0], Snackbar.LENGTH_LONG );
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }else {
            CadastrarUsuario(view);
        }
    }


    private void CadastrarUsuario(View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        usuario.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastroUsua.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Snackbar snackbar = Snackbar.make(view, mensagem[1], Snackbar.LENGTH_LONG );
                            snackbar.setBackgroundTint(Color.WHITE);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();

                            edit_email.setText("");
                            edit_senha.setText("");

                            Intent intent = new Intent(getApplicationContext(), CadastroEventos.class);
                            startActivity(intent);
                        }else{
                            String erro;
                            try {
                                throw task.getException();

                            }catch (FirebaseAuthWeakPasswordException e){
                                erro = "Digite uma senha com no minimo 6 caracteres";
                            }catch (FirebaseAuthUserCollisionException e){
                                erro = "Este e-mail ja foi cadastrado";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                erro = "E-mail inválido";
                            } catch (Exception e) {
                                erro = "Erro ao cadastrar usuário";
                            }
                            Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_LONG );
                            snackbar.setBackgroundTint(Color.WHITE);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();

                            edit_email.setText("");
                            edit_senha.setText("");
                        }
                   }
                });
    }
    private void IniciarComponentes(){
        edit_email = findViewById(R.id.editTextEmail);
        edit_senha = findViewById(R.id.editTextPassword);
        bt_voltar = findViewById(R.id.bt_voltar);
   }


}