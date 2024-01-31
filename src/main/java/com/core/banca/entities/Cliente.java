package com.core.banca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Cliente extends Base {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "appaterno")
    private String appaterno;

    @Column(name = "apmaterno")
    private String apmaterno;

    @Column(name = "documento_tipo")
    private String documento_tipo;

    @Column(name = "documento_dni")
    private String documento_dni;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "genero")
    private String genero;
}
