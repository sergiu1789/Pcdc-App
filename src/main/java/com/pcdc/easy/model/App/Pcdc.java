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
    private LocalTime oraUltimoAggiornamento;
    @Column
    private Integer giorniSpento;
    @Column
    private String versionePcdc;


}
