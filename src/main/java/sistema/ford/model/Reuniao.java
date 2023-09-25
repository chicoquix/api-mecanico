package sistema.ford.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reuniao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Mecanico mecanico;
    private LocalDateTime horario;

    public Reuniao(Usuario usuario, Mecanico mecanico, LocalDateTime horario) {
        this.usuario = usuario;
        this.mecanico = mecanico;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Reuniao{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", mecanico=" + mecanico +
                ", horario=" + horario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reuniao reuniao = (Reuniao) o;
        return Objects.equals(id, reuniao.id) && Objects.equals(usuario, reuniao.usuario) && Objects.equals(mecanico, reuniao.mecanico) && Objects.equals(horario, reuniao.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, mecanico, horario);
    }
}
