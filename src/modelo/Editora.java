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
public class Editora implements Serializable{
    private Integer codEditora;
    private String nome;
    

    public int getCodEditora() {
        return codEditora;
    }

    public void setCodEditora(int codEditora) {
        this.codEditora = codEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codEditora);
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
        final Editora other = (Editora) obj;
        if (!Objects.equals(this.codEditora, other.codEditora)) {
            return false;
        }
        return true;
    }
    
}
