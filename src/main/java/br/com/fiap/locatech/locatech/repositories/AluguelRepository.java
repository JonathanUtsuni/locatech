package br.com.fiap.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.locatech.entitites.Aluguel;

public interface AluguelRepository {

    Optional<Aluguel> findById(Long id);

    List<Aluguel> findAll(int size, int offset);

    Integer save(AluguelRequestDTO aluguel);

    Integer update(Aluguel aluguel, Long id);

    Integer delete(Long id);

}
