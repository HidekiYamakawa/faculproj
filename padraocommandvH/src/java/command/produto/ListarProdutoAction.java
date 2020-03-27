/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Produto;

/**
 *
 * @author hidek
 */
public class ListarProdutoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ArrayList<Produto> arrproduto = new ArrayList<Produto>();
        
        Produto produto = new Produto();
        
        produto.setDescricao("");
        
        ProdutoDao produtodao = new ProdutoDao();
        
        arrproduto = produtodao.listar(produto);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("arrproduto", arrproduto);
        
        return "/cadastros/produto/listar_produto.jsp";
        
    }
    
}
