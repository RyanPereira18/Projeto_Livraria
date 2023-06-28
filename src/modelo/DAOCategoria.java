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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 15894822637
 */
public class DAOCategoria {
    public List<Categoria> getListaCategoria(){
        String sql = "select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                Categoria obj = new Categoria();
                obj.setCodCategoria(rs.getInt("codCategoria"));
                obj.setNome(rs.getString("nome"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erro de SQL no getListaProduto" + e.getMessage());

        }
        return lista;
    }
    
     public Categoria localizarCategoria(Integer cod) {
        String sql = "select * from produto where idProduto = ?";
        Categoria obj = new Categoria();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodCategoria(rs.getInt("codCategoria"));
                obj.setNome(rs.getString("Nome"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no localizarProduto" + e.getMessage());

        }
        return null;
    }
}
