package com.navegantesdaestrada.agendanavegantes;

import android.widget.TextView;

public class Eventos {
    private String titulo;
    private String dataInicial;
    private String dataFinal;
    private String mes;
    private String cidade;
    private String estado;

    public Eventos(String titulo, String dataInicial, String dataFinal, String mes, String cidade, String estado) {
        this.titulo = titulo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.mes = mes;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
