package br.senacRelacionamento.controller;

import br.senacRelacionamento.controller.dtos.PedidosRequestDTO;
import br.senacRelacionamento.modelo.Pedidos;
import br.senacRelacionamento.service.PedidosService;
import br.senacRelacionamento.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/listar")
    public ResponseEntity<List<Pedidos>> listarTodos() {return ResponseEntity.ok(pedidosService.listarTodos());}

    @PostMapping("/criar")

    public ResponseEntity<Pedidos> criar (@RequestBody PedidosRequestDTO pedidos) {
        try{
            return ResponseEntity.ok(pedidosService.criar(pedidos));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/atualizar/{id}")

    public ResponseEntity<Pedidos> atualizar(@PathVariable Long id,
                                             @RequestBody  PedidosRequestDTO pedidos) {
        try{
            return ResponseEntity.ok(pedidosService.atualizar(id, pedidos));
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try{
            pedidosService.deletar(id);
            return ResponseEntity.ok(null);
        }catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }

    }

}
