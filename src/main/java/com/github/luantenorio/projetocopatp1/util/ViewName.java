package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    //Nome do arquivo|Título da página
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
    REFEREE("referee.fxml|Estádios"),
    CREATE_REFEREE("form_referee.fxml|Criar Arbitragem"),
    UPDATE_REFEREE("form_referee.fxml|Editar Arbitragem");

    private final String fileFxmlName;

    ViewName(String arquivoFxml) {
        this.fileFxmlName = arquivoFxml;
    }

    public String getFileFxmlName() {
        return fileFxmlName;
    }
}
