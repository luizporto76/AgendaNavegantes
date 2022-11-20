package com.navegantesdaestrada.agendanavegantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titulo.setText("1° ENCONTRO SAO JOSE DA LAPA");
        holder.dataInicial.setText("20");
        holder.dataFinal.setText("03");
        holder.mes.setText("DEZEMBRO");
        holder.cidade.setText("Belo Horizonte");
        holder.estado.setText("MG");

    }

    @Override
    public int getItemCount() {
        return 5;
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
