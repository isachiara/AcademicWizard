<%-- 
    Document   : Inicio
    Created on : 23/04/2018, 14:37:45
    Author     : Isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso do Admin</title>
    </head>
    <body>
        <h1>AcademicWizard</h1>

        <form action="CrudAdminAluno" method="POST">
            <h4>Formulário Aluno</h4>
            <label>Matricula:</label>
            <input type="text" name="matricula" value="201510240"/></br>
            <label>Nome:</label>
            <input type="text" name="nome" value="Isabella"/></br>
            <label>CPF:</label>
            <input type="text" name="cpf" value="1004587200"/></br>
            <label>Curso:</label>
            <input type="text" name="curso" value="TADS"/></br>
            <label>Sexo:</label>
            <input type="radio" name="genero" value="M" /> Masculino
            <input type="radio" name="genero" value="F" /> Feminino</p>
        <label>Senha:</label>
        <input type="password" name="senha" value="senha"/></br>

        </br></br>

        <label>Estado:</label>
        <input type="text" name="estado" value="estado"/></br>
        <label>Cidade:</label>
        <input type="text" name="cidade" value="cidade"/></br>
        <label>Bairro:</label>
        <input type="text" name="bairro" value="bairro"/></br>
        <label>Rua:</label>
        <input type="text" name="rua" value="rua"/></br>
        <label>Numero:</label>
        <input type="text" name="numero" value="455"/></br>
        <label>Cep:</label>
        <input type="text" name="cep" value="15445200"/></br>
        </br></br>

        <label>Telefone:</label>
        <input type="text" name="telefone" value="158456121"/></br>
        </br></br>
        <input type="submit" name="submit" value="submit" />
    </form>

    <form action="CrudAdminProfessor">
        <h4>Formulário Professor</h4>
        <label>Siape:</label>
        <input type="text" name="siape" value="2091928"/></br>
        <label>Nome:</label>
        <input type="text" name="nome" value="Professor01"/></br>
        <label>CPF:</label>
        <input type="text" name="cpf" value="304.222.453-19"/></br>
        <label>Sexo:</label>
        <input type="radio" name="genero" value="M" /> Masculino
        <input type="radio" name="genero" value="F" /> Feminino</p>
    <label>Curso:</label>
    <input type="text" name="curso" value="TADS"/></br>
    <label>Senha:</label>
    <input type="text" name="senha" value="senha"/></br>


    </br></br>

    <label>Estado:</label>
    <input type="text" name="estado" value="estado"/></br>
    <label>Cidade:</label>
    <input type="text" name="cidade" value="cidade"/></br>
    <label>Bairro:</label>
    <input type="text" name="bairro" value="bairro"/></br>
    <label>Rua:</label>
    <input type="text" name="rua" value="rua"/></br>
    <label>Numero:</label>
    <input type="text" name="numero" value="455"/></br>
    <label>Cep:</label>
    <input type="text" name="cep" value="15445200"/></br>
    </br></br>

    <label>Telefone:</label>
    <input type="text" name="telefone" value="158456121"/></br>
    </br></br>
    <input type="submit" name="submit" value="submit" />
    </br></br>
</form>
       
        <form action="CrudAdminDisciplina">
            <label>Nome Disciplina:</label>
            <input type="text" name="nome" value="Disciplina01"/>
            <label>Carga Horaria</label>
            <input type="text" name="carga" value="45 horas"/>
            <label>Horario</label>
            <input type="text" name="hora" value="8h"/>
            <label>Dia(s)</label>
            <input type="text" name="dias" value="Segunda e Terça"/>
            <label>Periodo</label>
            <input type="text" name="periodo" value="3º"/>
            <label>Requisito</label>
            <input type="text" name="requisito" value="Nenhum"/>
            //lista de professores
        </form>
</body>
</html>

