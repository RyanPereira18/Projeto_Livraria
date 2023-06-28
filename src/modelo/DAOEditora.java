/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 15894822637
 */
public class DAOEditora {
    public List<Editora> getListaEditora(){
        String sql = "select * from categoria";
        List<Editora> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                Editora obj = new Editora();
                obj.setCodEditora(rs.getInt("codEditora"));
                obj.setNome(rs.getString("Nome"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erro de SQL no getListaProduto" + e.getMessage());

        }
        return lista;
    }
    
     public Editora localizarEditora(Integer cod) {
        String sql = "select * from Editora where codEditora = ?";
        Editora obj = new Editora();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodEditora(rs.getInt("codCategoria"));
                obj.setNome(rs.getString("Nome"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no localizarEditora" + e.getMessage());

        }
        return null;
    }
}
