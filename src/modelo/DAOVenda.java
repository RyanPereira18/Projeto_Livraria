/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 15894822637
 */
public class DAOVenda {
    ConverteDataWEB converte = new ConverteDataWEB();
    private int lastId;

    public int getLastId() {
        return lastId;
    }

    public boolean incluir(Venda objVenda) {
        
        String sql = "insert into venda (idCliente,dataVenda) values (?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objVenda.getCodCliente());
            pst.setDate(2, converte.converteBanco(objVenda.getCodVenda()));

            if (pst.executeUpdate() > 0) {
                 ResultSet rs = pst.getGeneratedKeys();// retorna o último idCaixa cadastrado
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
                    lastId = rs.getInt(1); //armazena o último idCaixa cadastrado
                }

            } else {
                 JOptionPane.showMessageDialog(null, "Venda não cadastrada");

            }
            pst.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL no incluirVenda" + e.getMessage());

        }
        return false;
    }

    public boolean removeVenda(Venda objVenda) {
        String mensagem;
        String sql = "delete from venda where idVenda=?";
        try {
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1, objVenda.getCodVenda());
            if (stmt.executeUpdate() > 0) {
                 JOptionPane.showMessageDialog(null, "Venda cancelada");

            } else {
                 JOptionPane.showMessageDialog(null, "Venda não cancelada");

            }
            stmt.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL no remove venda" + e.getMessage() + "\nComando SQL = " + sql);
 

        }
        return false;
    }
}
