/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import dao.situacao.SituacaoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Produto;
import modelo.Situacao;

/**
 *
 * @author hidek
 */
public class BuscarProdutoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try{
            
            Situacao situacao = new Situacao();
            SituacaoDao situacaodao = new SituacaoDao();
            ArrayList<Situacao> arrsituacao = new ArrayList<>();
            situacao.setDescricao(""); //desta forma virão todos os registros
            arrsituacao = situacaodao.listar(situacao);
            HttpSession session = request.getSession();
            session.setAttribute("arrsituacao", arrsituacao);
        }catch(Exception ex){
            //nada a fazer
        }
        
        Produto produto = new Produto();
        
        ProdutoDao produtodao = new ProdutoDao();
        
        produto.setId(Integer.parseInt(request.getParameter("id")));
        
        produtodao.buscar(produto);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("prodtuto", produto);
        
        return "/cadastros/produto/alterar_produto.jsp";
        
    }
    
    
}
