package br.uel.admgamehub.model;

public class Review {
    private int revIdJogo;
    private int revIdCliente;
    private String revComentario;
    private double revNota;
    private String revData;

    public int getRevIdJogo() { return revIdJogo; }
    public void setRevIdJogo(int revIdJogo) { this.revIdJogo = revIdJogo; }
    public int getRevIdCliente() { return revIdCliente; }
    public void setRevIdCliente(int revIdCliente) { this.revIdCliente = revIdCliente; }
    public String getRevComentario() { return revComentario; }
    public void setRevComentario(String revComentario) { this.revComentario = revComentario; }
    public double getRevNota() { return revNota; }
    public void setRevNota(double revNota) { this.revNota = revNota; }
    public String getRevData() { return revData; }
    public void setRevData(String revData) { this.revData = revData; }
}
