package com.github.luantenorio.projetocopatp1.feed;

import com.github.luantenorio.projetocopatp1.match.EventType;
import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.match.MatchEvent;
import com.github.luantenorio.projetocopatp1.match.MatchStatus;
import com.github.luantenorio.projetocopatp1.player.PlayerDAO;
import com.github.luantenorio.projetocopatp1.player.PlayerEntity;
import com.github.luantenorio.projetocopatp1.team.TeamDAO;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class FeedController implements Initializable {

    @FXML private Label lblTotalMatches;
    @FXML private Label lblTotalGoals;
    @FXML private Label lblAvgGoals;
    @FXML private VBox topScorersContainer;
    @FXML private VBox mostConcededContainer;

    private final MatchDAO matchDAO = new MatchDAO();
    private final PlayerDAO playerDAO = new PlayerDAO();
    private final TeamDAO teamDAO = new TeamDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDashboard();
    }

    private void loadDashboard() {
        List<MatchEntity> allMatches = matchDAO.findAll();

        // apenas partidas finalizadas
        List<MatchEntity> finishedMatches = allMatches.stream()
                .filter(m -> m.getStatus() == MatchStatus.FINISHED)
                .toList();

        // cards de resumo
        int totalMatches = finishedMatches.size();
        lblTotalMatches.setText(String.valueOf(totalMatches));

        // conta gols de todos os eventos (GOAL e OWN_GOAL)
        int totalGoals = finishedMatches.stream()
                .mapToInt(m -> {
                    Set<MatchEvent> history = m.getHistory();
                    if (history == null) return 0;
                    return (int) history.stream()
                            .filter(e -> e.type() == EventType.GOAL || e.type() == EventType.OWN_GOAL)
                            .count();
                })
                .sum();
        lblTotalGoals.setText(String.valueOf(totalGoals));

        double avg = totalMatches == 0 ? 0.0 : (double) totalGoals / totalMatches;
        lblAvgGoals.setText(String.format("%.1f", avg));

        // top goleadores
        // description dos eventos GOAL contém o nome/id do jogador
        Map<String, Integer> goalsByPlayer = new HashMap<>();
        for (MatchEntity match : finishedMatches) {
            Set<MatchEvent> history = match.getHistory();
            if (history == null) continue;
            for (MatchEvent event : history) {
                if (event.type() == EventType.GOAL) {
                    String desc = event.description();
                    goalsByPlayer.merge(desc, 1, Integer::sum);
                }
            }
        }

        // resolve nomes dos jogadores (tenta por id, cai no description se não achar)
        List<PlayerEntity> allPlayers = playerDAO.findAll();
        Map<String, String> playerIdToName = new HashMap<>();
        for (PlayerEntity p : allPlayers) {
            playerIdToName.put(p.getId(), p.getName());
        }

        List<Map.Entry<String, Integer>> topScorers = goalsByPlayer.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());

        topScorersContainer.getChildren().clear();
        for (Map.Entry<String, Integer> entry : topScorers) {
            String displayName = playerIdToName.getOrDefault(entry.getKey(), entry.getKey());
            topScorersContainer.getChildren().add(createRankRow(displayName, entry.getValue() + " gols"));
        }

        if (topScorers.isEmpty()) {
            topScorersContainer.getChildren().add(createEmptyLabel("Nenhum gol registrado"));
        }

        // seleções que mais sofreram gols
        // gols sofridos = gols marcados pelo adversário (score do placar)
        Map<String, Integer> concededByTeam = new HashMap<>();
        for (MatchEntity match : finishedMatches) {
            String score = match.getScore(); // "x-y"
            if (score == null || !score.contains("-")) continue;
            try {
                String[] parts = score.split("-");
                int goalsTeam1 = Integer.parseInt(parts[0].trim());
                int goalsTeam2 = Integer.parseInt(parts[1].trim());
                // team2 sofreu os gols do team1 e vice-versa
                concededByTeam.merge(match.getTeam2Id(), goalsTeam1, Integer::sum);
                concededByTeam.merge(match.getTeam1Id(), goalsTeam2, Integer::sum);
            } catch (NumberFormatException ignored) {}
        }

        List<Map.Entry<String, Integer>> mostConceded = concededByTeam.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .toList();

        mostConcededContainer.getChildren().clear();
        for (Map.Entry<String, Integer> entry : mostConceded) {
            TeamEntity team = teamDAO.findById(entry.getKey());
            String teamName = team != null ? team.getName() : entry.getKey();
            mostConcededContainer.getChildren().add(createRankRow(teamName, entry.getValue() + " gols"));
        }

        if (mostConceded.isEmpty()) {
            mostConcededContainer.getChildren().add(createEmptyLabel("Nenhum dado disponível"));
        }
    }

    private GridPane createRankRow(String label, String value) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(60);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(40);
        grid.getColumnConstraints().addAll(col1, col2);

        Label lblName = new Label(label);
        lblName.getStyleClass().add("text-row");
        lblName.setMaxWidth(Double.MAX_VALUE);

        Label lblValue = new Label(value);
        lblValue.getStyleClass().add("text-row");
        lblValue.setMaxWidth(Double.MAX_VALUE);

        grid.add(lblName, 0, 0);
        grid.add(lblValue, 1, 0);

        return grid;
    }

    private Label createEmptyLabel(String text) {
        Label lbl = new Label(text);
        lbl.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 14px; -fx-text-fill: #20195F; -fx-padding: 20px 0;");
        lbl.setMaxWidth(Double.MAX_VALUE);
        lbl.setAlignment(Pos.CENTER);
        return lbl;
    }
}