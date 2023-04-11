package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Receita;
import com.example.demo.repositorio.ReceitaRepositorio;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class ReceitaController {
    private final ReceitaRepositorio receitaRepositorio;

    @GetMapping
    public List<Receita> list() {
        return receitaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Receita> findById(@PathVariable @NotNull Long id) {
        return receitaRepositorio.findById(id);
    }

    @PostMapping("/api/receita")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita criar(@RequestBody @NotNull Receita receita) {

        return receitaRepositorio.save(receita);

    }

    @PutMapping("/{id}")
    public Optional<Receita> update(@PathVariable @NotNull @Positive Long id, @RequestBody Receita receita) {
        return receitaRepositorio.findById(id).map(record -> {
            record.setNomeEmpresa(receita.getNomeEmpresa());
            record.setCnpj(receita.getCnpj());
            record.setMes(receita.getMes());
            record.setAno(receita.getAno());
            record.setDispensa(receita.getDispensa());
            record.setDocFiscal(receita.getDocFiscal());
            record.setTotalReceita(receita.getTotalReceita());
            record.setTotalBruta(receita.getTotalBruta());
            return receitaRepositorio.save(record);
        });

    }

}
