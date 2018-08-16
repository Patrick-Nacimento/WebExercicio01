/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio01.web;

import br.com.exercicio01.bean.AlunoBean;
import br.com.exercicio01.dao.AlunoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick
 */
@WebServlet(urlPatterns = "/alunos")
public class AlunoIndex extends HttpServlet {
    
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        List<AlunoBean> alunos = new AlunoDao().obterTodos();
        
        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dados - Alunos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<a href='/WebExercicio01/alunos/cadastro'>Novo Aluno</a>");
        out.println("</div>");
        out.println("<div>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<th>Id</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Codigo Matricula</th>");
        out.println("<th>Nota 01</th>");
        out.println("<th>Nota 02</th>");
        out.println("<th>Nota 03</th>");
        out.println("<th>Frequência</th>");
        out.println("<th>Média</th>");
        out.println("<th>Situacao</th>");
        out.println("</thead>");
        out.println("<tbody>");
        
        out.println("<div>");
        out.println("<h3 class='text-center'>Lista de Alunos</h3>");
        out.println("</div>");
       

        for(AlunoBean aluno: alunos){
        out.println("<tr>");
        out.println("<td>" + aluno.getId() + "</td>");
        out.println("<td>" + aluno.getNome() + "</td>");
        out.println("<td>" + aluno.getCodigoMatricula() + "</td>");
        out.println("<td>" + aluno.getNota1() + "</td>");
        out.println("<td>" + aluno.getNota2() + "</td>");
        out.println("<td>" + aluno.getNota3() + "</td>");
        out.println("<td>" + aluno.getFrequencia() + "</td>");
        out.println("<td>" + aluno.getMedia() + "</td>");
        out.println("<td>" + aluno.getSituacao() + "</td>");
        out.println("</tr>");
        }
       
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        
    }

}
