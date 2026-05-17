package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    //Nome do arquivo|Título da página
    STADIUM("stadium.fxml|Estádios"),
    CREATE_STADIUM("form_stadium.fxml|Criar estádio"),
    UPDATE_STADIUM("form_stadium.fxml|Editar estádio"),
    PLAYER("player.fxml|Jogadores"),
    MATCH("match.fxml|Partidas"),
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
