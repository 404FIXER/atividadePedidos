package br.senacRelacionamento.service;

import br.senacRelacionamento.controller.dtos.PedidosItensRequestDTO;
import br.senacRelacionamento.modelo.Pedidos;
import br.senacRelacionamento.modelo.PedidosItens;
import br.senacRelacionamento.repositorio.PedidosItensRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosItensService {

    @Autowired
    private PedidosItensRepositorio pedidosItensRepositorio;


    private PedidosService pedidosService;

    public PedidosItensService(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }


    public List<PedidosItens> listarTodos() { return pedidosItensRepositorio.findAll();}




    public PedidosItens criar(PedidosItensRequestDTO item){
        try {
            Pedidos pedidoResult = pedidosService.listarById(item.getPedidoId());
            PedidosItens itemPersist = this.pedidosItensRequestDtoParaPedidosItens(item);
            itemPersist.setPedido(pedidoResult);

            return pedidosItensRepositorio.save(itemPersist);


        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PedidosItens
    pedidosItensRequestDtoParaPedidosItens(PedidosItensRequestDTO entrada){
        PedidosItens saida = new PedidosItens();
        saida.setQuantidade(entrada.getQuantidade());
        saida.setValorUnitario(entrada.getValorUnitario());

        return saida;
    }





}
