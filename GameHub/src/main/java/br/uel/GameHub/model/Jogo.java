package br.uel.GameHub.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Jogo {

    private Integer idJogo;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Date lancamento;

    private BigDecimal nota;

    private String imagePath;

    public void setIdJogo(Integer idJogo){
        this.idJogo = idJogo;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}