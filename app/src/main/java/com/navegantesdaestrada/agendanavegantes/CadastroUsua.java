package com.navegantesdaestrada.agendanavegantes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroUsua extends AppCompatActivity {
    private EditText edit_email;
    private EditText edit_senha;
    private Button bt_cadastrar, bt_voltar, bt_login, bt_logof;
    String[] mensagem = {"Preecha todos os campos", "Cadastro realizado com sucesso "};
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

        bt_login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroUsua.this);
                    dialog.setTitle("ERRO AO FAZER O LOGIN");
                    dialog.setMessage("Preencha todos os campos");
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.create();
                    dialog.show();
                }else{
                usuario.signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(CadastroUsua.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Login realizado com sucesso", Toast.LENGTH_LONG).show();
                                    edit_email.setText("");
                                    edit_senha.setText("");
                                    Intent intent = new Intent(getApplicationContext(), CadastroEventos.class);
                                    startActivity(intent);
                                }else{
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroUsua.this);
                                    dialog.setTitle("ERRO AO FAZER O LOGIN");
                                    dialog.setMessage("Confira o e-mail e senha digitado ou caso seja seu primeiro acesso faça seu cadastro");
                                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    dialog.create();
                                    dialog.show();

                                    edit_email.setText("");
                                    edit_senha.setText("");
                                }
                            }
                        });
            } //
        }});

        bt_logof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroUsua.this);
                    dialog.setTitle("ERRO AO FAZER O LOGINn");
                    dialog.setMessage("Preencha todos os campos");
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.create();
                    dialog.show();
                }else{
                usuario.signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(CadastroUsua.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Login realizado com sucesso", Toast.LENGTH_LONG).show();
                                    edit_email.setText("");
                                    edit_senha.setText("");
                                    Intent intent = new Intent(getApplicationContext(), CadastroEventos.class);
                                    startActivity(intent);
                                }else{
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroUsua.this);
                                    dialog.setTitle("ERRO AO FAZER O LOGIN");
                                    dialog.setMessage("Confira o e-mail e senha digitado ou caso seja seu primeiro acesso faça seu cadastro");
                                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    dialog.create();
                                    dialog.show();

                                    edit_email.setText("");
                                    edit_senha.setText("");
                                }
                            }
                        });
            } //
        }});

        bt_logof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
   }

    public void cadastrar (View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        if(email.isEmpty() || senha.isEmpty()){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroUsua.this);
            dialog.setTitle("ERRO AO FAZER O CADASTRO");
            dialog.setMessage("Preencha todos os campos");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.create();
            dialog.show();
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
        bt_login = findViewById(R.id.bt_login);
        bt_logof = findViewById(R.id.bt_logof);

   }


}