package com.example.demo.models;

import org.hibernate.validator.constraints.Length;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 100, nullable = false)
    private String nomeEmpresa;

    @NotNull
    @NotBlank
    @Column()
    private String cnpj;

    @NotBlank
    @NotNull
    @Column()
    private String mes;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 9)
    @Column()
    private String ano;

    @NotBlank
    @NotNull
    @Column()
    private String dispensa;

    @NotBlank
    @NotNull
    @Column()
    private String docFiscal;

    @NotBlank
    @NotNull
    @Column()
    private String totalReceita;

    @NotBlank
    @NotNull
    @Column()
    private String totalBruta;

}
