package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    //Nome do arquivo|Título da página
    FEED("feed.fxml|Início"),
    TEAM("team.fxml|Seleções"),
    PLAYER("player.fxml|Jogadores"),
    CREATE_PLAYER("create_player.fxml|Criar Jogador"),
    UPDATE_PLAYER("create_player.fxml|Editar Jogador"),
    CREATE_TEAM("create_team.fxml|Criar Seleção"),
    UPDATE_TEAM("create_team.fxml|Editar Seleção"),
    STADIUM("stadium.fxml|Estádios"),
    CREATE_STADIUM("form_stadium.fxml|Criar estádio"),
    UPDATE_STADIUM("form_stadium.fxml|Editar estádio"),
    MATCH("match.fxml|Partidas"),
    CREATE_MATCH("form_match.fxml|Criar Partida"),
    UPDATE_MATCH("form_match.fxml|Editar Partida"),
    RESULT("result.fxml|Adicionar Resultado"),
    REFEREE("referee.fxml|Estádios"),
    CREATE_REFEREE("form_referee.fxml|Criar Arbitragem"),
    UPDATE_REFEREE("form_referee.fxml|Editar Arbitragem"),
    USER("user.fxml|Gestão de Usuários"),
    USER_CREATE("form_user.fxml|Cadastrar Novo Usuário"),
    UPDATE_RESULT("form_result.fxml|Atualizar Resultado de Partida"),
    CREATE_EVENT("form_event.fxml|Adicionar Evento de Partida"),
    UPDATE_EVENT("form_event.fxml|Editar Evento de Partida")
    ;

    private final String fileFxmlName;

    ViewName(String arquivoFxml) {
        this.fileFxmlName = arquivoFxml;
    }

    public String getFileFxmlName() {
        return fileFxmlName;
    }
}
