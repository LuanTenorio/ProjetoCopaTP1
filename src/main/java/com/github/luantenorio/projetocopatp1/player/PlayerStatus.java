package com.github.luantenorio.projetocopatp1.player;

public enum PlayerStatus {
    ACTIVE("Ativo"),
    INJURED("Lesionado"),
    SUSPENDED("Suspenso");

    private final String label;

    PlayerStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
