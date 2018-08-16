/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio01.dao;

import br.com.exercicio01.bean.AlunoBean;
import br.com.exercicio01.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class AlunoDao {
    
    public List<AlunoBean> obterTodos(){
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try{
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while(resultSet.next()){
                AlunoBean aluno = new AlunoBean();
                aluno.setId(resultSet.getInt("id"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setCodigoMatricula(resultSet.getString("codigoMatricula"));
                aluno.setNota1(resultSet.getDouble("nota1"));
                aluno.setNota2(resultSet.getDouble("nota2"));
                aluno.setNota3(resultSet.getDouble("nota3"));
                aluno.setFrequencia(resultSet.getInt("frequencia"));
                aluno.setMedia(resultSet.getDouble("media"));
                aluno.setSituacao(resultSet.getString("situacao"));
                alunos.add(aluno);
            }  
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return alunos;
        
    }
    
    public int adicionar(AlunoBean aluno){
        String sql = "INSERT INTO alunos (nome, codigoMatricula, nota1, nota2, nota3, frequencia, media, situacao) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, aluno.getNome());
            ps.setString(quantidade++, aluno.getCodigoMatricula());
            ps.setDouble(quantidade++, aluno.getNota1());
            ps.setDouble(quantidade++, aluno.getNota2());
            ps.setDouble(quantidade++, aluno.getNota3());
            ps.setInt(quantidade++, aluno.getFrequencia());
            ps.setDouble(quantidade++, aluno.getMedia());
            ps.setString(quantidade++, aluno.getSituacao());
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }return -1;
    }
    
}
