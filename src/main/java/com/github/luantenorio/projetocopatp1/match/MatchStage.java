package com.github.luantenorio.projetocopatp1.match;

public enum MatchStage {
    GROUP_STAGE("Fase de Grupos"),
    ROUND_OF_32("16 Avos de Final"),
    ROUND_OF_16("Oitavas de Final"),
    QUARTER_FINALS("Quartas de Final"),
    SEMI_FINALS("Semi-Final"),
    FINALS("Final");

    private final String label;

    MatchStage(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public static MatchStage findByName(String name){
        for (MatchStage stage : MatchStage.values()){
            if (stage.toString().contains(name.trim())) return stage;
        }
        return null;
    }
}
