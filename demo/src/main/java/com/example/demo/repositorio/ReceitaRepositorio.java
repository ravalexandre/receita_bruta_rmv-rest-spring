package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Receita;


@Repository
public interface ReceitaRepositorio extends JpaRepository<Receita, Long> {

}
