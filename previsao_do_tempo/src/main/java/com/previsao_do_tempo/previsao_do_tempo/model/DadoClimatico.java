package com.previsao_do_tempo.previsao_do_tempo.model;

public class DadoClimatico {

    private String nomeCidade;
    private String siglaPais;
    private String status;
    private String descricaoStatus;
    private double temperatura;
    private double temperaturaMin;
    private double temperaturaMax;
    private double sensacaoTermica;
    private int umidade;
    private double vento;
    private double pressao;
    private double longitude;
    private double latitude;

    public DadoClimatico() {
    }

    public DadoClimatico(String nomeCidade, String siglaPais, String status, String descricaoStatus, double temperatura, double temperaturaMin, double temperaturaMax, double sensacaoTermica, int umidade, double vento, double pressao, double longitude, double latitude) {
        this.nomeCidade = nomeCidade;
        this.siglaPais = siglaPais;
        this.status = status;
        this.descricaoStatus = descricaoStatus;
        this.temperatura = temperatura;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.sensacaoTermica = sensacaoTermica;
        this.umidade = umidade;
        this.vento = vento;
        this.pressao = pressao;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(double temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public double getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(double temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public double getSensacaoTermica() {
        return sensacaoTermica;
    }

    public void setSensacaoTermica(double sensacaoTermica) {
        this.sensacaoTermica = sensacaoTermica;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public double getVento() {
        return vento;
    }

    public void setVento(double vento) {
        this.vento = vento;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
