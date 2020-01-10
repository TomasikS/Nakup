package com.sovy.nakupeclipse;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nakup")
public class Nakup implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nakup() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datumObjednavky")
    private String datumObjednavky;

    public String getDatumDodania() {
        return datumDodania;
    }

    public void setDatumDodania(String datumDodania) {
        this.datumDodania = datumDodania;
    }

    @Column(name = "datumDodania")
    private String datumDodania;

    public String getDatumObjednavky() {
        return datumObjednavky;
    }

    public void setDatumObjednavky(String datumObjednavky) {
        this.datumObjednavky = datumObjednavky;
    }

    @Column(name = "datumSplatnosti")
    private String datumSplatnosti;

    public String getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(String datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    @Column(name = "sposobPlatby")
    private String sposobPlatby;

    public String getSposobPlatby() {
        return sposobPlatby;
    }

    public void setSposobPlatby(String sposobPlatby) {
        this.sposobPlatby = sposobPlatby;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idBook")
    private Long idBook;

    /*public Nakup(String firstName, String lastName, String email, String platba) {
    this.datumDodania = firstName;
    this.datumObjednavky = lastName;
    this.datumSplatnosti = email;
    this.sposobPlatby = platba;
  }*/
}
