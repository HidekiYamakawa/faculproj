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
public class CadastrarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //precisamos antes colocar o vetor de situacoes na session
        try {
            Situacao situacao = new Situacao();
            SituacaoDao situacaodao = new SituacaoDao();
            ArrayList<Situacao> arrsituacao = new ArrayList<>();
            situacao.setDescricao("");
            arrsituacao = situacaodao.listar(situacao);
            HttpSession session = request.getSession();
            session.setAttribute("arrsituacao", arrsituacao);
        } catch (Exception ex) {
            //nada a fazer
        }
        try {

            Produto produto = new Produto();
            produto.setDescricao(request.getParameter("txtdescricao"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
            Situacao situacao = new Situacao(); //perceba que procisamos criar um objeto situacao que será agregado ao produto
            situacao.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
            produto.setSituacao(situacao); //aqui acontece a agregação
            if (produto.getDescricao().length() == 0) {
                return "/cadastros/produto/cadastrar_produto.jsp";
            } else {

                ProdutoDao produtodao = new ProdutoDao();

                produtodao.cadastrar(produto);

                return "/cadastros/produto/sucesso.jsp";

            }
        } catch (Exception ex) {
            return "/cadastros/produto/cadastrar_produto.jsp";
        }

    }

}
