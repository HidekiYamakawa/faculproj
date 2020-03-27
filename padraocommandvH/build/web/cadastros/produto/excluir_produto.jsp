<%-- 
    Document   : excluir_produto
    Created on : 26/03/2020, 20:50:42
    Author     : hidek
--%>

<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Produto</title>
    </head>
    <body>
        <%
            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto");
        %>
        <form action="/padraocommandvH/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Excluir"/>
            <input type="hidden" name="confirmaexclusao" id="confirmaexclusao" value="2"/>
            <h1>Confirmar a exclusão definitiva do registro abaixo?</h1>
            <div>
                <label>Descrição</label>
                <label><b><%= objproduto.getDescricao()%></b></label>
            </div>
            <div>
                <label>Quantidade</label>
                <label><b><%= objproduto.getQuantidade()%></b></label>
            </div>
            <div>
                <input type="submit" name="btnconfirma" id="btnconfirma" value="Confirma"/> 
            </div>

        </form>
    </body>
</html>
