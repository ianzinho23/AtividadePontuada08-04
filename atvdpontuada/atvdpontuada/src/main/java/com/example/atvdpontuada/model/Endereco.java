package com.example.atvdpontuada.model;

import jakarta.persistence.*;

/**
 * Classe que representa o endereço de um funcionário no sistema.
 * Utiliza JPA para mapeamento objeto-relacional.
 */
@Entity
public class Endereco {
    // Identificador único do endereço
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Rua ou avenida do endereço
    private String logradouro;

    // Número do endereço
    private String numero;

    // Informações adicionais como apartamento, bloco, etc.
    private String complemento;

    // Cidade onde está localizado o endereço
    private String cidade;

    // Método getter para obter o ID do endereço
    public Long getId() {
        return id;
    }

    // Método setter para definir o ID do endereço
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obter o logradouro
    public String getLogradouro() {
        return logradouro;
    }

    // Método setter para definir o logradouro
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    // Método getter para obter o número
    public String getNumero() {
        return numero;
    }

    // Método setter para definir o número
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Método getter para obter o complemento
    public String getComplemento() {
        return complemento;
    }

    // Método setter para definir o complemento
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Método getter para obter a cidade
    public String getCidade() {
        return cidade;
    }

    // Método setter para definir a cidade
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}