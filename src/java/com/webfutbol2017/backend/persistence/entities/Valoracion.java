/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.backend.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "valoraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v"),
    @NamedQuery(name = "Valoracion.findByIdValoracion", query = "SELECT v FROM Valoracion v WHERE v.idValoracion = :idValoracion"),
    @NamedQuery(name = "Valoracion.findByNota", query = "SELECT v FROM Valoracion v WHERE v.nota = :nota")})
public class Valoracion implements Serializable, IDTO {

    @Column(name = "nota")
    private Integer nota;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valoracion")
    private Integer idValoracion;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seguimiento idSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValoracion", fetch = FetchType.EAGER)
    private List<Item> itemList;

    public Valoracion() {
    }

    public Valoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Valoracion(Integer idValoracion, int nota) {
        this.idValoracion = idValoracion;
        this.nota = nota;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }


    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webfutbol2017.backend.persistence.entities.Valoracion[ idValoracion=" + idValoracion + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idValoracion.toString();
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
    
}
