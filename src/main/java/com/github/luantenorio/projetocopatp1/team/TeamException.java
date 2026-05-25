package com.github.luantenorio.projetocopatp1.team;

public class TeamException extends RuntimeException {

    private TeamException(String message) {
        super(message);
    }

    public static class MinimumPlayersException extends TeamException {
        public MinimumPlayersException() {
            super("A seleção deve ter no mínimo " + TeamEntity.getMinPlayers() + " jogadores.");
        }
    }

    public static class MaximumPlayersException extends TeamException {
        public MaximumPlayersException() {
            super("A seleção deve ter no máximo " + TeamEntity.getMaxPlayers() + " jogadores.");
        }
    }
}
