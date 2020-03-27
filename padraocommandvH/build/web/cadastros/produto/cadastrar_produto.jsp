<%-- 
    Document   : cadastrar_produto
    Created on : 26/03/2020, 20:06:27
    Author     : hidek
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Situacao"%>
<%@page import="modelo.Situacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <form>
            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>
            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value=""/>
            </div>
            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value=""/>
            </div>
            <div>
                <label>Situação</label>
                <select name="cmbsituacao">
                    <%
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrsituacao) {
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>   
            </div>
        </form>
    </body>
</html>
