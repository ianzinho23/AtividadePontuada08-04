package com.example.atvdpontuada.service;

import com.example.atvdpontuada.model.Funcionario;
import com.example.atvdpontuada.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return repository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        repository.deleteById(id);
    }
}