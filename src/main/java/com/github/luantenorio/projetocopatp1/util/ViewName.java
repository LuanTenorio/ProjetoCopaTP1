package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    STADIUM("stadium.fxml|Estádios"),
    PLAYER("player.fxml|Jogadores");

    private final String fileFxmlName;

    ViewName(String arquivoFxml) {
        this.fileFxmlName = arquivoFxml;
    }

    public String getFileFxmlName() {
        return fileFxmlName;
    }
}
