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
public class Servicio {
    int IDE_SRV;
    String NOM_SRV;
    int IDE_CAT;
    int IDE_USU;
    String MON_SRV;
    double PAG_SRV;

    public Servicio() {
    }

    public Servicio(int IDE_SRV, String NOM_SRV, int IDE_CAT, int IDE_USU, String MON_SRV, double PAG_SRV) {
        this.IDE_SRV = IDE_SRV;
        this.NOM_SRV = NOM_SRV;
        this.IDE_CAT = IDE_CAT;
        this.IDE_USU = IDE_USU;
        this.MON_SRV = MON_SRV;
        this.PAG_SRV = PAG_SRV;
    }

    public int getIDE_USU() {
        return IDE_USU;
    }

    public void setIDE_USU(int IDE_USU) {
        this.IDE_USU = IDE_USU;
    }

    
    public int getIDE_SRV() {
        return IDE_SRV;
    }

    public void setIDE_SRV(int IDE_SRV) {
        this.IDE_SRV = IDE_SRV;
    }

    public String getNOM_SRV() {
        return NOM_SRV;
    }

    public void setNOM_SRV(String NOM_SRV) {
        this.NOM_SRV = NOM_SRV;
    }

    public int getIDE_CAT() {
        return IDE_CAT;
    }

    public void setIDE_CAT(int IDE_CAT) {
        this.IDE_CAT = IDE_CAT;
    }

    public String getMON_SRV() {
        return MON_SRV;
    }

    public void setMON_SRV(String MON_SRV) {
        this.MON_SRV = MON_SRV;
    }

    public double getPAG_SRV() {
        return PAG_SRV;
    }

    public void setPAG_SRV(double PAG_SRV) {
        this.PAG_SRV = PAG_SRV;
    }
    
    
}
