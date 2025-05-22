package br.com.fiap.locatech.locatech.entitites;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {

    private Long id;

    private Long pessoaId;

    private Long veiculoId;

    private String veiculoModelo;

    private String pessoaCpf;

    private String pessoaNome;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorTotal;

    public Aluguel(AluguelRequestDTO aluguelDTO, BigDecimal valor) {
        this.pessoaId = aluguelDTO.pessoaId();
        this.veiculoId = aluguelDTO.veiculoId();
        this.dataInicio = aluguelDTO.dataInicio();
        this.dataFim = aluguelDTO.dataFim();
        this.valorTotal = valor;

    }
}
