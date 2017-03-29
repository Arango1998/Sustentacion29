/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.backend.persistence.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByIdSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.idSeguimiento = :idSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByFechaInicio", query = "SELECT s FROM Seguimiento s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Seguimiento.findByFechaFin", query = "SELECT s FROM Seguimiento s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Seguimiento.findByResultadoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.resultadoSeguimiento = :resultadoSeguimiento")})
public class Seguimiento implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seguimiento")
    private Integer idSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "resultado_seguimiento")
    private String resultadoSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_entrenador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idEntrenador;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador idJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguimiento", fetch = FetchType.EAGER)
    private List<Valoracion> valoracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguimiento", fetch = FetchType.EAGER)
    private List<PosicionSeguimiento> posicionSeguimientoList;

    public Seguimiento() {
    }

    public Seguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Seguimiento(Integer idSeguimiento, Date fechaInicio, Date fechaFin, String resultadoSeguimiento, String observacion) {
        this.idSeguimiento = idSeguimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resultadoSeguimiento = resultadoSeguimiento;
        this.observacion = observacion;
    }

    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResultadoSeguimiento() {
        return resultadoSeguimiento;
    }

    public void setResultadoSeguimiento(String resultadoSeguimiento) {
        this.resultadoSeguimiento = resultadoSeguimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Usuario getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Usuario idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<PosicionSeguimiento> getPosicionSeguimientoList() {
        return posicionSeguimientoList;
    }

    public void setPosicionSeguimientoList(List<PosicionSeguimiento> posicionSeguimientoList) {
        this.posicionSeguimientoList = posicionSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimiento != null ? idSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.idSeguimiento == null && other.idSeguimiento != null) || (this.idSeguimiento != null && !this.idSeguimiento.equals(other.idSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webfutbol2017.backend.persistence.entities.Seguimiento[ idSeguimiento=" + idSeguimiento + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idSeguimiento.toString();
    }
    
}
