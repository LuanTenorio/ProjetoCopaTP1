package com.github.luantenorio.projetocopatp1.match;

public enum MatchStatus {
    SCHEDULED("Agendada"),
    IN_PROGRESS("Em Progresso"),
    FINISHED("Finalizada");

    private final String label;

    MatchStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static MatchStatus findByName(String name){
        for (MatchStatus status : MatchStatus.values()){
            if (status.toString().contains(name.trim())) return status;
        }
        return null;
    }
}