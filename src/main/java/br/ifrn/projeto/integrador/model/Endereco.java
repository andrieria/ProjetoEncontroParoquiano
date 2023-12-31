package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
// import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class Endereco {

    // @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;
    private String estado;
    private String cidade;
    private String rua;
    private int numero;
    private String bairro;
    private String complemento; 

}
