package br.com.alura.mvc.mudi.mudi.repository;

import br.com.alura.mvc.mudi.mudi.model.Pedido;
import br.com.alura.mvc.mudi.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos")
    List<Pedido> findByStatus(StatusPedido status, Pageable sort);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findByUsuario(@Param("username") String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE p.status = :status AND u.username = :username")
    List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido statusPedido, @Param("username") String username);
}
