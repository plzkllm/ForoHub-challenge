package alura.api.forohub.repository;

import alura.api.forohub.models.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByStatusTrue(Pageable pagina);
}
