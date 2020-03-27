/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Produto;

/**
 *
 * @author hidek
 */
public class ConsultarProdutoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Produto produto = new Produto();
        
        ProdutoDao produtodao = new ProdutoDao();
        
        produto.setId(Integer.parseInt(request.getParameter("id")));
        
        produtodao.buscar(produto);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("produto", produto);
        
        return "/cadastros/produto/consultar_produto.jsp";
        
    }
    
}
