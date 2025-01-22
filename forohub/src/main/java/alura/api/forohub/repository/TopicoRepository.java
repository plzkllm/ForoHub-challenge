package alura.api.forohub.repository;

import alura.api.forohub.models.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByStatusTrue(Pageable pagina);
}
