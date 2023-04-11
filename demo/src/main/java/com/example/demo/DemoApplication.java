package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Receita;
import com.example.demo.repositorio.ReceitaRepositorio;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	

	@Bean
	CommandLineRunner initDataBase(ReceitaRepositorio receitaRepositorio) {
		return args -> {

			receitaRepositorio.deleteAll();
			Receita r = new Receita();
			r.setNomeEmpresa("LuisFelipe");
			r.setCnpj("11111111111");
			r.setMes("Fevereiro");
			r.setAno("2023");
			r.setDispensa("6.125,99");
			r.setDocFiscal("6.125,99");
			r.setTotalReceita("6.125,99");
			r.setTotalBruta("6.125,99");
			receitaRepositorio.save(r);
			
			
		};
	}
	

}
