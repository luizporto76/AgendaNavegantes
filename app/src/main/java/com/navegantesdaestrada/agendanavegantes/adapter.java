package com.navegantesdaestrada.agendanavegantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    private List<Eventos> listaeventos;
    public adapter(List<Eventos> listaeventos ){
        this.listaeventos = listaeventos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Eventos eventos = listaeventos.get(position);

        holder.titulo.setText(eventos.getTitulo());
        holder.dataInicial.setText(eventos.getDataInicial());
        holder.dataFinal.setText(eventos.getDataFinal());
        holder.mes.setText(eventos.getMes());
        holder.cidade.setText(eventos.getCidade());
        holder.estado.setText(eventos.getEstado());

    }

    @Override
    public int getItemCount() {
        return listaeventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView dataInicial;
        TextView dataFinal;
        TextView mes;
        TextView cidade;
        TextView estado;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTituloEvento);
            dataInicial = itemView.findViewById(R.id.textDtInicial);
            dataFinal = itemView.findViewById(R.id.textDtFinal);
            mes = itemView.findViewById(R.id.textMes);
            cidade = itemView.findViewById(R.id.textCidade);
            estado = itemView.findViewById(R.id.textEstado);
        }
    }

}
