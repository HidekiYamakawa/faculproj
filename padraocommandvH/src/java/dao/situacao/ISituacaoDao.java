/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.situacao;

import java.util.ArrayList;
import modelo.Situacao;

/**
 *
 * @author hidek
 */
public interface ISituacaoDao {
    
    public ArrayList<Situacao> listar(Situacao situacao);
    
    public void buscar(Situacao situacao);
    
    public boolean alterar(Situacao situacao);
    
    public boolean excluir(Situacao situacao);
    
    public boolean cadastrar(Situacao situacao);
    
}
