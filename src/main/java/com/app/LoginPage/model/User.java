package com.app.LoginPage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "loginUser")
public class User {
    @Id
    private String usuario;
    private String senha;

    @Override
    public String toString() {
        return "User{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(usuario, user.usuario) && Objects.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, senha);
    }

    User(){
    }

    public User(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
