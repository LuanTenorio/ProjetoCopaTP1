package com.github.luantenorio.projetocopatp1.match;

public record MatchChipDTO(String id, String name) {
    @Override
    public String toString() {
        return name;
    }
}
