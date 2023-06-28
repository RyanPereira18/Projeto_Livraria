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

public class DAOItemVenda { // Data Acess Object
    
    DAOProduto daoProduto = new DAOProduto();
    
    public List<ItemVenda> getListaItensVenda(Integer id) {
        String sql = "select * from itensvenda where idvenda=?";
        List<ItemVenda> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ItemVenda obj = new ItemVenda();
                System.out.println("IDVENDA="+rs.getInt("idvenda"));
               // obj.getObjVenda().setIdVenda(rs.getInt("idvenda"));
                obj.setCodItensVenda(rs.getInt("iditensvenda"));
                obj.setObjProduto(daoProduto.localizarProduto(rs.getInt("codProduto")));
                obj.setQuantidadeProduto(rs.getInt("quantidade"));
                obj.getObjProduto().setValor(rs.getDouble("valor"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getListaItensVenda" + e.getMessage());

        }
        return lista;
    }

    public boolean incluir(ItemVenda objItensVenda) {

        String sql = "insert into itensvenda (idproduto,idvenda,quantidade,valor) values (?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objItensVenda.getObjProduto().getCodProduto());
            pst.setInt(2, objItensVenda.getObjVenda().getCodVenda());
            pst.setInt(3, objItensVenda.getQuantidadeProduto());
            pst.setDouble(4, objItensVenda.getObjProduto().getValor());

            if (pst.executeUpdate() > 0) {

               // JOptionPane.showMessageDialog(null, "Item de venda cadastrado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Item de venda não cadastrado!");

            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getListaItensVenda" + e.getMessage());

        }
        return false;
    }

    public boolean remover(ItemVenda objItemVenda) {
        String sql = "delete from itensvenda where iditensvenda=?";
        
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objItemVenda.getCodItemVenda());
            if (pst.executeUpdate() > 0) {
                 JOptionPane.showMessageDialog(null, "Item de venda removido com sucesso!");

            } else {
                 JOptionPane.showMessageDialog(null, "Item de venda não removido!");

            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do ItensVenda" + e.getMessage());

        }
        return false;
    }
}
