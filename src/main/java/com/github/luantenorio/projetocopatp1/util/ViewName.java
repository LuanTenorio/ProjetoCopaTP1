package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    STADIUM("stadium.fxml"),
    CREATE_STADIUM("create_stadium.fxml"),
    PLAYER("player.fxml"),
    TEAM("team.fxml"),
    CREATE_TEAM("create_team.fxml");

    private final String fileFxmlName;

    ViewName(String arquivoFxml) {
        this.fileFxmlName = arquivoFxml;
    }

    public String getFileFxmlName() {
        return fileFxmlName;
    }
}
