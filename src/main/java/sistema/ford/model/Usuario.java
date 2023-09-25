package sistema.ford.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha, nome);
    }
}
