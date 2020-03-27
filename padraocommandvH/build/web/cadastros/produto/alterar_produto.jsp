<%-- 
    Document   : alterar_produto
    Created on : 26/03/2020, 17:46:54
    Author     : hidek
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Situacao"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
        <%
            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto");//aqui pega o objeto produto que esta na sessão
%>
        <form action="/padraocommandvH/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Alterar"/>

            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="<%= objproduto.getDescricao()%>"/>
            </div>
            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="<%= objproduto.getQuantidade()%>"/>
            </div>
            <!--perceb aque o campo abaixo devera ser uma combo, onde o array list foi disponibilizado na session-->
            <!--porém como se trata de alteração devemos setar qual item será selecionado -->
            <div>
                <label>Situação</label>
                <select name="cmbsituacao">
                    <%
                        String selecionado = "";
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrsituacao) {
                            if (obj.getId() == objproduto.getSituacao().getId()) {
                                selecionado = "selected=selected"; //deixa a propriedade selected como selecionada
                            } else {
                                selecionado = ""; //senão deixa vazio
                            }
                    %>
                    <option <%= selecionado%> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>Situação</label>
                <lable><b><%= objproduto.getSituacao().getDescricao()%></b></lable>
            </div>
            
            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>
        </form>
    </body>
</html>
