package com.github.luantenorio.projetocopatp1.match;

public enum EventType {
    GOAL("Gol"),
    OWN_GOAL("Gol Contra"),
    FOUL("Falta"),
    YELLOW_CARD("Cartão Amarelo"),
    RED_CARD("Cartão Vermelho"),
    SUB("Substituição"),
    INJURY("Lesão"),
    MATCH_START("Começo da Partida"),
    MATCH_END("Fim da Partida"),
    EXTRA_TIME("Acréscimos");

    private final String label;

    EventType(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static EventType findByName(String name){
        for (EventType type : EventType.values()){
            if (type.toString().contains(name.trim())) return type;
        }
        return null;
    }
}