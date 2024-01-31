package com.core.banca.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movimiento_cc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoCC extends Base {
    @Column(name = "fecha_transaccion")
    private Date fecha_transaccion;

    @Column(name = "tipo_transaccion")
    private String tipo_transaccion;

    @Column(name = "tipo_moneda")
    private String tipo_moneda;

    @Column(name = "monto")
    private double monto;

    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("cuentaId")
    @ManyToOne(optional = false, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "cuentaId", referencedColumnName = "id")
    private Cuenta cuenta;*/
    @ManyToOne(optional = false)
    @JoinColumn(name="cuentaId")
    private Cuenta cuenta;
}
