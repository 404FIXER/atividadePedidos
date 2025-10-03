package br.senacRelacionamento.controller.dtos;

public class PedidosResponseDTO extends PedidosRequestDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
