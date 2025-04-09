package com.example.atvdpontuada.controller;


import com.example.atvdpontuada.model.Funcionario;
import com.example.atvdpontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*")  // Permite requisições de qualquer origem
public class FuncionarioController {

    private final FuncionarioService service;

    @Autowired
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Funcionario funcionario) {
        try {
            Funcionario novo = service.salvar(funcionario);
            String mensagem = "Funcionário " + novo.getNome() + " cadastrado com sucesso";
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("mensagem", mensagem));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        List<Funcionario> funcionarios = service.listar();
        return funcionarios.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        try {
            funcionario.setId(id);
            service.atualizar(id, funcionario);
            String mensagem = "Funcionário atualizado com sucesso";
            return ResponseEntity.ok(Map.of("mensagem", mensagem));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            Funcionario funcionario = service.buscarPorId(id);
            String nome = funcionario.getNome();
            service.deletar(id);
            return ResponseEntity.ok(Map.of("mensagem", "Funcionário " + nome + " excluído com sucesso"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", e.getMessage()));
        }
    }
}