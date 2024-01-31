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
@Table(name = "cuenta")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta extends Base {
    @Column(name = "tipo_producto")
    private String tipo_producto;

    @Column(name = "num_cuenta")
    private String num_cuenta;

    @Column(name = "tipo_moneda")
    private String tipo_moneda;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "sucursal")
    private String sucursal;

    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("clienteId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    private Cliente cliente;*/
    @ManyToOne(optional = false)
    @JoinColumn(name="clienteId")
    private Cliente cliente;
}
