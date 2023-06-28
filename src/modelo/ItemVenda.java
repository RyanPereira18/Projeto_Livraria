/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 15894822637
 */
public class ItemVenda implements Serializable{
   private Integer CodItemVenda;
    private Integer quantidadeProduto;
    private Produto objProduto;
    private Venda objVenda;

    public ItemVenda() {
    }

    public Produto getObjProduto() {
        return objProduto;
    }

    public void setObjProduto(Produto objProduto) {
        this.objProduto = objProduto;
    }

    public Venda getObjVenda() {
        return objVenda;
    }

    public void setObjVenda(Venda objVenda) {
        this.objVenda = objVenda;
    }

    public Integer getCodItemVenda() {
        return CodItemVenda;
    }

    public void setCodItensVenda(Integer CodItemVenda) {
        this.CodItemVenda = CodItemVenda;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.CodItemVenda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.CodItemVenda, other.CodItemVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return objProduto.getDescricao()+" Valor: "+objProduto.getValor()+" Quant.: "+String.valueOf(quantidadeProduto); 
    }
    
}
