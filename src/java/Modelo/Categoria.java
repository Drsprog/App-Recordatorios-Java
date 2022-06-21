/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Categoria {
    int ide_cat;
    String nom_cat;

    public Categoria() {
    }

    public Categoria(int ide_cat, String nom_cat) {
        this.ide_cat = ide_cat;
        this.nom_cat = nom_cat;
    }

    public int getIde_cat() {
        return ide_cat;
    }

    public void setIde_cat(int ide_cat) {
        this.ide_cat = ide_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }
    
}
