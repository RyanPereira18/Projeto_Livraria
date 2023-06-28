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
public class DAOProduto {
    public List<Produto> getListaProduto(){
        String sql = "select * from produto";
        List<Produto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                Produto obj = new Produto();
                obj.setCodProduto(rs.getInt("codProduto"));
                obj.setNome(rs.getString("Nome"));
                obj.setPrecoVenda(rs.getDouble("Preco da Venda"));
                obj.setPrecoCusto(rs.getDouble("Preco do Custo"));
                obj.setQuantidadeEstoque(rs.getInt("Quantidade de estoque"));
                java.sql.Date dt = rs.getDate("Data Lançamento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setCodEditora(rs.getInt("codEditora"));
                obj.setCodVenda(rs.getInt("codVenda"));
                obj.setCodCliente(rs.getInt("codCliente"));
                obj.setCodCategoria(rs.getInt("codCategoria"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erro de SQL no getListaProduto" + e.getMessage());

        }
        return lista;
    }
    
     public Produto localizarProduto(Integer id) {
        String sql = "select * from produto where idProduto = ?";
        Produto obj = new Produto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodProduto(rs.getInt("codProduto"));
                obj.setNome(rs.getString("Nome"));
                obj.setPrecoVenda(rs.getDouble("Preco da Venda"));
                obj.setPrecoCusto(rs.getDouble("Preco do Custo"));
                obj.setQuantidadeEstoque(rs.getInt("Quantidade de estoque"));
                java.sql.Date dt = rs.getDate("Data Lançamento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setCodEditora(rs.getInt("codEditora"));
                obj.setCodVenda(rs.getInt("codVenda"));
                obj.setCodCliente(rs.getInt("codCliente"));
                obj.setCodCategoria(rs.getInt("codCategoria"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no localizarProduto" + e.getMessage());

        }
        return null;
    }
}
