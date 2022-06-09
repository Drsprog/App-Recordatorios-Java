/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Recordatorio {
    int IDE_REC;
    String TIT_REC;
    int IDE_USU;
    int IDE_SRV;
    Date INI_REC;
    Date FPG_REC;
    Date ALR_REC;
    String CLC_REC;

    public Recordatorio() {
    }

    public Recordatorio(int IDE_REC, String TIT_REC, int IDE_USU, int IDE_SRV, Date INI_REC, Date FPG_REC, Date ALR_REC, String CLC_REC) {
        this.IDE_REC = IDE_REC;
        this.TIT_REC = TIT_REC;
        this.IDE_USU = IDE_USU;
        this.IDE_SRV = IDE_SRV;
        this.INI_REC = INI_REC;
        this.FPG_REC = FPG_REC;
        this.ALR_REC = ALR_REC;
        this.CLC_REC = CLC_REC;
    }

    public int getIDE_REC() {
        return IDE_REC;
    }

    public void setIDE_REC(int IDE_REC) {
        this.IDE_REC = IDE_REC;
    }

    public String getTIT_REC() {
        return TIT_REC;
    }

    public void setTIT_REC(String TIT_REC) {
        this.TIT_REC = TIT_REC;
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

    public Date getINI_REC() {
        return INI_REC;
    }

    public void setINI_REC(Date INI_REC) {
        this.INI_REC = INI_REC;
    }

    public Date getFPG_REC() {
        return FPG_REC;
    }

    public void setFPG_REC(Date FPG_REC) {
        this.FPG_REC = FPG_REC;
    }

    public Date getALR_REC() {
        return ALR_REC;
    }

    public void setALR_REC(Date ALR_REC) {
        this.ALR_REC = ALR_REC;
    }

    public String getCLC_REC() {
        return CLC_REC;
    }

    public void setCLC_REC(String CLC_REC) {
        this.CLC_REC = CLC_REC;
    }
    
    
}

