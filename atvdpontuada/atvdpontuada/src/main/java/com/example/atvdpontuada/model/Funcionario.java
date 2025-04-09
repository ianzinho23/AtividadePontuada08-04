package com.example.atvdpontuada.model;

import jakarta.persistence.*;

/**
 * Classe que representa um funcionário no sistema.
 * Utiliza JPA para mapeamento objeto-relacional.
 */
@Entity
public class Funcionario {
    // Identificador único do funcionário
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do funcionário
    private String nome;

    // CPF do funcionário (único e obrigatório)
    @Column(unique = true, nullable = false)
    private String cpf;

    // Data de nascimento do funcionário
    private String dataNascimento;

    // Sexo do funcionário (MASCULINO ou FEMININO)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    // Setor em que o funcionário trabalha
    @Enumerated(EnumType.STRING)
    private Setor setor;

    // Estado civil do funcionário
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    // Salário do funcionário
    private double salario;

    // Email do funcionário (único)
    @Column(unique = true)
    private String email;

    // Endereço do funcionário (relacionamento 1:1)
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    // Métodos getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}