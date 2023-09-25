package sistema.ford.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mecanico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String endereco;
    private List<LocalDateTime> horarios;

    public Mecanico(String email, String senha, String nome, String endereco, List<LocalDateTime> horarios) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.horarios = horarios;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<LocalDateTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<LocalDateTime> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", horarios=" + horarios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mecanico mecanico = (Mecanico) o;
        return Objects.equals(id, mecanico.id) && Objects.equals(email, mecanico.email) && Objects.equals(senha, mecanico.senha) && Objects.equals(nome, mecanico.nome) && Objects.equals(endereco, mecanico.endereco) && Objects.equals(horarios, mecanico.horarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha, nome, endereco, horarios);
    }
}
