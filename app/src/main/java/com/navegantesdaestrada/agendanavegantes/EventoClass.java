package com.navegantesdaestrada.agendanavegantes;

import android.view.View;
import android.widget.ImageView;

import java.util.Date;

public class EventoClass {
    private String titulo;
    private String iDia;
    private String iMes;
    private String iAno;
    private String fDia;
    private String fMes;
    private String fAno;
    private String endereco;
    private String descricao;
    private ImageView fly;

    public EventoClass() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getiDia() {
        return iDia;
    }

    public void setiDia(String iDia) {
        this.iDia = iDia;
    }

    public String getiMes() {
        return iMes;
    }

    public void setiMes(String iMes) {
        this.iMes = iMes;
    }

    public String getiAno() {
        return iAno;
    }

    public void setiAno(String iAno) {
        this.iAno = iAno;
    }

    public String getfDia() {
        return fDia;
    }

    public void setfDia(String fDia) {
        this.fDia = fDia;
    }

    public String getfMes() {
        return fMes;
    }

    public void setfMes(String fMes) {
        this.fMes = fMes;
    }

    public String getfAno() {
        return fAno;
    }

    public void setfAno(String fAno) {
        this.fAno = fAno;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ImageView getFly() {
        return fly;
    }

    public void setFly(ImageView fly) {
        this.fly = fly;
    }
}