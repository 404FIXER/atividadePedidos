package br.senacRelacionamento.repositorio;

import br.senacRelacionamento.modelo.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepositorio extends JpaRepository<Pedidos, Long> {
}
