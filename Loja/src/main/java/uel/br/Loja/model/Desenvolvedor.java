package uel.br.Loja.model;

public class Desenvolvedor {

    private String nomeDesenvolvedor;
    
    private int idJogo;

    public String getNomeDesenvolvedor (){
        return nomeDesenvolvedor;
    }

    public void setNomeDesenvolvedor(String nomeDesenvolvedor){
        this.nomeDesenvolvedor = nomeDesenvolvedor;
    }

    public int getIdJogo (){
        return idJogo;
    }

    public void setIdJogo (int idJogo){
        this.idJogo = idJogo;
    }
}