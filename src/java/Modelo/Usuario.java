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
public class Usuario {
    int IDE_USU;
    String NOM_USU;
    String APE_USU;
    String COR_USU;
    String CON_USU;

    public Usuario() {
    }

    public Usuario(int IDE_USU, String NOM_USU, String APE_USU, String COR_USU, String CON_USU) {
        this.IDE_USU = IDE_USU;
        this.NOM_USU = NOM_USU;
        this.APE_USU = APE_USU;
        this.COR_USU = COR_USU;
        this.CON_USU = CON_USU;
    }

    public int getIDE_USU() {
        return IDE_USU;
    }

    public void setIDE_USU(int IDE_USU) {
        this.IDE_USU = IDE_USU;
    }

    public String getNOM_USU() {
        return NOM_USU;
    }

    public void setNOM_USU(String NOM_USU) {
        this.NOM_USU = NOM_USU;
    }

    public String getAPE_USU() {
        return APE_USU;
    }

    public void setAPE_USU(String APE_USU) {
        this.APE_USU = APE_USU;
    }

    public String getCOR_USU() {
        return COR_USU;
    }

    public void setCOR_USU(String COR_USU) {
        this.COR_USU = COR_USU;
    }

    public String getCON_USU() {
        return CON_USU;
    }

    public void setCON_USU(String CON_USU) {
        this.CON_USU = CON_USU;
    }
    
    
    
}

