/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio01.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(urlPatterns = "/alunos/cadastro")
public class AlunoCadastro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='/WebExercicio01/alunos/store' method='post'>");
        out.println("<div>");
        out.println("       <label for=''>Nome</label>");
        out.println("       <input type='text' id='campo-nome' name='nome'>");
        out.println("</div>");
        out.println("<div>");
        out.println("       <label for=''>CódigoMatricula</label>");
        out.println("       <input type='text' id='campo-codigoMatricula' name='codigo_matricula'>");
        out.println("</div>");
        out.println("<div>");
        out.println("       <label for=''>Nota1</label>");
        out.println("       <input type='text' id='campo-nota1' name='nota1'>");
        out.println("</div>");
        out.println("<div>");
        out.println("       <label for=''>Nota2</label>");
        out.println("       <input type='text' id='campo-nota2' name='nota2'>");
        out.println("</div>");
        out.println("<div>");
        out.println("       <label for=''>Nota3</label>");
        out.println("       <input type='text' id='campo-nota3' name='nota3'>");
        out.println("</div>");
        out.println("<div>");
        out.println("       <label for=''>Frequencia</label>");
        out.println("       <input type='text' id='campo-frequencia' name='frequencia'>");
        out.println("</div>");
        out.println("		<input class='' type='submit' value='Cadastrar'>");
        
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    
    
}
