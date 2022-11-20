package com.navegantesdaestrada.agendanavegantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ListaDeEventos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Eventos> listaEventos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_eventos);

        recyclerView = findViewById(R.id.recyclerView);

        //Chamar lista de eventos
        this.chamarEventos();

        //configurar o adapter
        adapter adapterr = new adapter(listaEventos);


        //Configurar o recycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterr);
    }
    public void chamarEventos(){
        Eventos eventos = new Eventos("Campina Grande MotoFest","17", "20","Novembro","Campina Grande","PB");
        this.listaEventos.add(eventos);

        eventos = new Eventos("5º ENCONRO DE CONCEIÇÃO DA APARECIDA","18", "20","NOVEMBRO","Conceição da aparecda","MG");
        this.listaEventos.add(eventos);

        eventos = new Eventos("2ºENCONTRO PIRTAS DO ASFALTO ","18", "20","NOVEMBRO","Mangaratiba","RJ");
        this.listaEventos.add(eventos);

        eventos = new Eventos("BRASIONAMENTO ALIADOS DA ESTRADA","26", "","NOVEMBRO","Contagem ","MG");
        this.listaEventos.add(eventos);

        eventos = new Eventos("10 ANOS ASAS DE FERRO","27", "","","Ribeirão das Neves ","MG");
        this.listaEventos.add(eventos);

        eventos = new Eventos("2º ENCONTRO SENADOR JOSÉ BENTO ","01", "04","dezembro","Senador José Bento ","MG");
        this.listaEventos.add(eventos);
    }
}