package br.senacRelacionamento.controller;

import br.senacRelacionamento.controller.dtos.PedidosItensRequestDTO;
import br.senacRelacionamento.modelo.PedidosItens;
import br.senacRelacionamento.service.PedidosItensService;
import br.senacRelacionamento.service.PedidosService;
import br.senacRelacionamento.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidosItens")
@CrossOrigin
public class PedidosItensController {

    @Autowired
    private PedidosItensService pedidosItensService;

    @GetMapping("/listar")
    public ResponseEntity<List<PedidosItens>> listar() {
        return ResponseEntity.ok(pedidosItensService.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar (@RequestBody PedidosItensRequestDTO pedidosItens){
        try{
            return ResponseEntity.created(null).body(pedidosItensService.criar(pedidosItens));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }





}
