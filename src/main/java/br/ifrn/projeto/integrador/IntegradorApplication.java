package br.ifrn.projeto.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Quando o servidor está ativo e adicionamos alguma dependência, ela não vai ser levada em conta. É preciso desligar 
o servidor e depois restarta. 

O Maven é responsável por gerenciar os pacotes do spring.

https://ralflima.com/treinamentos/criando_apis_com_spring_boot/spring_modulo1_dependencias.php

*/
@SpringBootApplication
public class IntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorApplication.class, args);
	}

}
