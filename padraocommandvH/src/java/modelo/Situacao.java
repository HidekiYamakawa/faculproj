/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author hidek
 */
public class Situacao extends Objeto{
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao() {
    }

    public Situacao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao(String descricao, int id) {
        super(id);
        this.descricao = descricao;
    }
    
}
