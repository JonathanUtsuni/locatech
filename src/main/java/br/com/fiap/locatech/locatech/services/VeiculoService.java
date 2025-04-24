package br.com.fiap.locatech.locatech.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.locatech.entitites.Veiculo;
import br.com.fiap.locatech.locatech.repositories.VeiculoRepository;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAllVeiculos(int page, int size) {
        int offset = (page - 1) * size;
        return this.veiculoRepository.findAll(size, offset);
    }

    public Optional<Veiculo> findVeiculoById(Long id) {
        return this.veiculoRepository.findById(id);
    }

    public void saveVeiculo(Veiculo veiculo) {
        var save = this.veiculoRepository.save(veiculo);
        Assert.state(save == 1, "erro ao salvar veiculo" + veiculo.getModelo());
    }

    public void updateVeiculo(Veiculo veiculo, Long id) {
        var update = veiculoRepository.update(veiculo, id);
        if (update == 0) {
            throw new RuntimeException("veiculo não encontrado");
        }
    }

    public void delete(Long id) {
        var delete = this.veiculoRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("veiculo não encontrado");
        }
    }

}
