package com.github.luantenorio.projetocopatp1.users;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UserController implements Initializable {




    @FXML private TextField filterName;
    @FXML private TextField filterEmail;
    @FXML private TextField filterCountry;
    @FXML private ComboBox<String> filterAccessLevel;


    @FXML private VBox rowsContainer;
    @FXML private Label infoPagination;


    private final UserService userService = new UserService();
    private List<UserEntity> allUsers = new ArrayList<>();
    private List<UserEntity> filteredUsers = new ArrayList<>();


    
    private int currentPage = 1;
    private final int ITEMS_PAGE = 8;

    public UserController() { }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        filterAccessLevel.getItems().add(0, "Todos");

        loadData();
    }

    private void loadData() {

        UserDAO userDAO = new UserDAO();
        allUsers = userDAO.findAll();
        filteredUsers = new ArrayList<>(allUsers);

        renderTable();
    }



    @FXML
    public void filterName() { applyFilters(); }

    @FXML
    public void filterEmail() { applyFilters(); }

    @FXML
    public void filterCountry() { applyFilters(); }

    @FXML
    public void filterAccessLevel() { applyFilters(); }

    private void applyFilters() {
        String nameStr = filterName.getText() != null ? filterName.getText().toLowerCase() : "";
        String emailStr = filterEmail.getText() != null ? filterEmail.getText().toLowerCase() : "";
        String countryStr = filterCountry.getText() != null ? filterCountry.getText().toLowerCase() : "";
        String levelStr = filterAccessLevel.getValue();

        filteredUsers = allUsers.stream().filter(u -> {
            boolean matchesName = u.getName().toLowerCase().contains(nameStr);
            boolean matchesEmail = u.getEmail().toLowerCase().contains(emailStr);


            String userCountry = u.getCountry() != null ? u.getCountry().toLowerCase() : "";
            boolean matchesCountry = userCountry.contains(countryStr);

            boolean matchesLevel = true;
            if (levelStr != null && !levelStr.equals("Todos")) {
                if (levelStr.equals("Administrador") && !(u instanceof AdminEntity)) matchesLevel = false;
                if (levelStr.equals("Organizador") && !(u instanceof OrganizerEntity)) matchesLevel = false;
                if (levelStr.equals("Árbitro") && !(u instanceof RefereeUserEntity)) matchesLevel = false;
            }

            return matchesName && matchesEmail && matchesCountry && matchesLevel;
        }).collect(Collectors.toList());

        currentPage = 1;
        renderTable();
    }



    private void renderTable() {
        rowsContainer.getChildren().clear();

        int totalItens = filteredUsers.size();
        int totalPaginas = (int) Math.ceil((double) totalItens / ITEMS_PAGE);
        if (totalPaginas == 0) totalPaginas = 1;

        infoPagination.setText(currentPage + " de " + totalPaginas);


        int inicio = (currentPage - 1) * ITEMS_PAGE;
        int fim = Math.min(inicio + ITEMS_PAGE, totalItens);


        for (int i = inicio; i < fim; i++) {
            UserEntity u = filteredUsers.get(i);
            rowsContainer.getChildren().add(createGridLine(u));
        }
    }

    private GridPane createGridLine(UserEntity u) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");
        grid.setMinHeight(40);


        ColumnConstraints col1 = new ColumnConstraints(); col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints(); col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints(); col3.setPercentWidth(25);
        ColumnConstraints col4 = new ColumnConstraints(); col4.setPercentWidth(25);
        grid.getColumnConstraints().addAll(col1, col2, col3, col4);


        Label lblName = new Label(u.getName());
        lblName.getStyleClass().add("text-row");
        lblName.setMaxWidth(Double.MAX_VALUE);

        Label lblEmail = new Label(u.getEmail());
        lblEmail.getStyleClass().add("text-row");
        lblEmail.setMaxWidth(Double.MAX_VALUE);

        Label lblCountry = new Label(u.getCountry() != null ? u.getCountry() : "N/A");
        lblCountry.getStyleClass().add("text-row");
        lblCountry.setMaxWidth(Double.MAX_VALUE);

        Label lblType = new Label(translateLevel(u));
        lblType.getStyleClass().add("text-row");
        lblType.setMaxWidth(Double.MAX_VALUE);

        grid.add(lblName, 0, 0);
        grid.add(lblEmail, 1, 0);
        grid.add(lblCountry, 2, 0);
        grid.add(lblType, 3, 0);

        return grid;
    }

    private String translateLevel(UserEntity u) {
        if (u instanceof AdminEntity) return "Administrador";
        if (u instanceof OrganizerEntity) return "Organizador";
        if (u instanceof RefereeUserEntity) return "Árbitro";
        return "Desconhecido";
    }



    @FXML
    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            renderTable();
        }
    }

    @FXML
    public void nextPage() {
        int totalPages = (int) Math.ceil((double) filteredUsers.size() / ITEMS_PAGE);
        if (currentPage < totalPages) {
            currentPage++;
            renderTable();
        }
    }

    @FXML
    public void navigateToCreateUser() {
        Router.navigateTo(ViewName.USER_CREATE);
    }
}