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
public class DAOCliente {
    public List<Cliente> getListaCliente(){
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cliente obj = new Cliente();
                obj.setCodCliente(rs.getInt("codCliente"));
                obj.setNome(rs.getString("nomeCliente"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL no getListaCliente" + e.getMessage());

        }
        return lista;
    }
}
