package uel.br.Loja.model;

import java.math.BigDecimal;

public class ItemCompra {

    private int idItem;

    private int idCompra;

    private int idJogo;

    private String nomeJogo;

    private BigDecimal precoJogo;

    private int qtd;

    public int getIdItem() {
        return idItem;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public int getIdJogo() {
        return idJogo;
    }
    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }
    public String getNomeJogo() {
        return nomeJogo;
    }
    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
    public BigDecimal getPrecoJogo() {
        return precoJogo;
    }
    public void setPrecoJogo(BigDecimal precoJogo) {
        this.precoJogo = precoJogo;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
