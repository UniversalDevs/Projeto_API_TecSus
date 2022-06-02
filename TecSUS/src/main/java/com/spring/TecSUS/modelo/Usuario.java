package com.spring.TecSUS.modelo;

import javax.persistence.*;

@Entity
@Table(name= "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private int user_id;
    
    @Column(name= "user_nome", length = 100, nullable = false)
    private String user_nome;

    @Column(name= "user_email", length = 100, nullable = false)
    private String user_email;

    @Column(name= "user_senha", length = 100, nullable = false)
    private String user_senha;

    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    public String getNome() {
        return user_nome;
    }

    public void setNome(String user_nome) {
        this.user_nome = user_nome;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getSenha() {
        return user_senha;
    }

    public void setSenha(String user_senha) {
        this.user_senha = user_senha;
    }

}
