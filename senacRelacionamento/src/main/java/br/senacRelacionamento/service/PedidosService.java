package br.senacRelacionamento.service;


import br.senacRelacionamento.controller.dtos.PedidosRequestDTO;
import br.senacRelacionamento.modelo.Pedidos;
import br.senacRelacionamento.repositorio.PedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepositorio pedidosRepositorio;

    public List<Pedidos> listarTodos() { return pedidosRepositorio.findAll();}

    public Pedidos criar(PedidosRequestDTO pedidos){

        Pedidos pedidosPersist = this.pedidoRequestDtoParaPedido(pedidos);

        return pedidosRepositorio.save(pedidosPersist);
    }

    private Pedidos pedidoRequestDtoParaPedido(PedidosRequestDTO entrada){
        Pedidos saida = new Pedidos();
        saida.setDataCriacao(LocalDateTime.now());
        saida.setDataEntrega(entrada.getDataEntrega());
        saida.setNomeCliente(entrada.getNomeCliente());
        saida.setDocumentoCliente(entrada.getDocumentoCliente());

        return saida;
    }

    public Pedidos atualizar(Long id, PedidosRequestDTO pedidos) throws Exception{
        if(pedidosRepositorio.existsById(id) == false) {
            throw new RuntimeException("pedido não encontrado");
        }
        Pedidos pedidosPersist = this.pedidoRequestDtoParaPedido(pedidos);
        pedidosPersist.setId(id);

        return pedidosRepositorio.save(pedidosPersist);

    }
    public void deletar(Long id) {
        if(!pedidosRepositorio.existsById(id)){
            throw new RuntimeException("Registro não encontrado");

        }

        pedidosRepositorio.deleteById(id);
    }

    public Pedidos listarById(Long id) {
        Optional<Pedidos> pedidoResult = pedidosRepositorio.findById(id);
        if(pedidoResult.isEmpty()){
            throw new RuntimeException("Pedido não encontrado");

        }
        return pedidoResult.get();
    }

}
