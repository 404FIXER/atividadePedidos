package br.senacRelacionamento.repositorio;

import br.senacRelacionamento.modelo.PedidosItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosItensRepositorio extends JpaRepository<PedidosItens, Long> {

}
