
package br.com.exercicio01.web;

import br.com.exercicio01.bean.AlunoBean;
import br.com.exercicio01.dao.AlunoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick
 */
@WebServlet(urlPatterns = "/alunos/store")
public class AlunosStore extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AlunoBean aluno = new AlunoBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodigoMatricula(req.getParameter("codigo_matricula"));
        aluno.setNota1(Double.parseDouble(req.getParameter("nota1")));
        aluno.setNota2(Double.parseDouble(req.getParameter("nota2")));
        aluno.setNota3(Double.parseDouble(req.getParameter("nota3")));
        aluno.setFrequencia(Integer.parseInt(req.getParameter("frequencia")));
        aluno.setMedia(aluno.calcularMedia());
        
        if(aluno.calcularMedia() < 5){
            aluno.setSituacao("REPROVADO");
        }else if(aluno.calcularMedia() >= 6 && aluno.calcularMedia() < 7){
            aluno.setSituacao("EM EXAME");
        }else{
            aluno.setSituacao("APROVADO");
        }
        
        if(aluno.getFrequencia() < 65){
            aluno.setSituacao("REPROVADO POR FREQUENCIA");
        }
        
        int codigo = new AlunoDao().adicionar(aluno);
        
        if(codigo > 0){
            resp.sendRedirect("/WebExercicio01/alimentos");
        }
    }
    
    
    
}
