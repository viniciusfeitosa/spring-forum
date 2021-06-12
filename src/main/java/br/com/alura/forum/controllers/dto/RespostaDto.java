package br.com.alura.forum.controllers.dto;

import br.com.alura.forum.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
