package com.github.luantenorio.projetocopatp1.util;

public enum ViewName {
    ESTADIUM("estadium.fxml");

    private final String fileFxmlName;

    ViewName(String arquivoFxml) {
        this.fileFxmlName = arquivoFxml;
    }

    public String getFileFxmlName() {
        return fileFxmlName;
    }
}
