package com.pcdc.easy.model.App;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pcdc {

    @Id
    @GeneratedValue
    private  Long id;

    @Column
    private String ipAddress;
    @Column
    private String macAddress;
    @Column
    private String nomePc;
    @Column
    private String dominio;
    @Column
    private String stato;
    @Column
    private String commessa;
    @Column
    private String sede;
    @Column
    private Date dataUltimoAggiornamento;
    @Column
    private Date oraUltimoAggiornamento;
    @Column
    private Integer giorniSpento;
    @Column
    private String versionePcdc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getNomePc() {
        return nomePc;
    }

    public void setNomePc(String nomePc) {
        this.nomePc = nomePc;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getCommessa() {
        return commessa;
    }

    public void setCommessa(String commessa) {
        this.commessa = commessa;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Date getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    public Date getOraUltimoAggiornamento() {
        return oraUltimoAggiornamento;
    }

    public void setOraUltimoAggiornamento(Date oraUltimoAggiornamento) {
        this.oraUltimoAggiornamento = oraUltimoAggiornamento;
    }

    public Integer getGiorniSpento() {
        return giorniSpento;
    }

    public void setGiorniSpento(Integer giorniSpento) {
        this.giorniSpento = giorniSpento;
    }

    public String getVersionePcdc() {
        return versionePcdc;
    }

    public void setVersionePcdc(String versionePcdc) {
        this.versionePcdc = versionePcdc;
    }
}
