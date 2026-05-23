package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.match.MatchStatus;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeService;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchDAO;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchEntity;
import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.team.TeamDAO;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Mocking {

    static StadiumDAO stadiumDAO = new StadiumDAO();
    static MatchDAO matchDAO = new MatchDAO();
    static RefereeService refereeService = new RefereeService();
    static RefereeMatchDAO refereeMatchDAO = new RefereeMatchDAO();
    static TeamDAO teamDAO = new TeamDAO();

    public static void main(String[] args) {
        mockEstadium();
        mockMatch();
        mockReferee();
        mockRefereeMatch();
        mockTeam();
    }

    public static void mockEstadium(){
        stadiumDAO.clearAll();
        stadiumDAO.create(new StadiumEntity("Mané Garrincha", "Brasília - DF", 72788));
        stadiumDAO.create(new StadiumEntity("Serra Dourada", "Goiânia - GO", 42000));
        stadiumDAO.create(new StadiumEntity("Bezerrão", "Gama - DF", 20000));
        stadiumDAO.create(new StadiumEntity("Boca do Jacaré", "Taguatinga - DF", 27000));
        stadiumDAO.create(new StadiumEntity("Maracanã", "Rio de Janeiro - RJ", 78838));
        stadiumDAO.create(new StadiumEntity("Mineirão", "Belo Horizonte - MG", 61927));
        stadiumDAO.create(new StadiumEntity("Morumbi", "São Paulo - SP", 66795));
        stadiumDAO.create(new StadiumEntity("Arena Corinthians", "São Paulo - SP", 49205));
        stadiumDAO.create(new StadiumEntity("Allianz Parque", "São Paulo - SP", 43713));
        stadiumDAO.create(new StadiumEntity("Beira-Rio", "Porto Alegre - RS", 50128));
        stadiumDAO.create(new StadiumEntity("Arena do Grêmio", "Porto Alegre - RS", 55662));
        stadiumDAO.create(new StadiumEntity("Castelão", "Fortaleza - CE", 63903));
        stadiumDAO.create(new StadiumEntity("Fonte Nova", "Salvador - BA", 47907));
        stadiumDAO.create(new StadiumEntity("Arena Pernambuco", "Recife - PE", 44300));
        stadiumDAO.create(new StadiumEntity("Arena da Amazônia", "Manaus - AM", 44300));
        stadiumDAO.create(new StadiumEntity("Arena das Dunas", "Natal - RN", 31375));
        stadiumDAO.create(new StadiumEntity("Arena Pantanal", "Cuiabá - MT", 41112));
        stadiumDAO.create(new StadiumEntity("Arena da Baixada", "Curitiba - PR", 42372));
        stadiumDAO.create(new StadiumEntity("Mangueirão", "Belém - PA", 45007));
        stadiumDAO.create(new StadiumEntity("Couto Pereira", "Curitiba - PR", 40502));
        stadiumDAO.create(new StadiumEntity("São Januário", "Rio de Janeiro - RJ", 21880));
        stadiumDAO.create(new StadiumEntity("Nilton Santos", "Rio de Janeiro - RJ", 44661));
        stadiumDAO.create(new StadiumEntity("Vila Belmiro", "Santos - SP", 16068));
        stadiumDAO.create(new StadiumEntity("Ilha do Retiro", "Recife - PE", 32983));
        stadiumDAO.create(new StadiumEntity("Barradão", "Salvador - BA", 30618));
        stadiumDAO.create(new StadiumEntity("Ressacada", "Florianópolis - SC", 17800));
        stadiumDAO.create(new StadiumEntity("Orlando Scarpelli", "Florianópolis - SC", 19584));
        stadiumDAO.create(new StadiumEntity("Alfredo Jaconi", "Caxias do Sul - RS", 19924));
        stadiumDAO.create(new StadiumEntity("Moisés Lucarelli", "Campinas - SP", 17728));
        stadiumDAO.create(new StadiumEntity("Brinco de Ouro", "Campinas - SP", 29108));
        stadiumDAO.create(new StadiumEntity("Nabi Abi Chedid", "Bragança Paulista - SP", 17022));
        stadiumDAO.create(new StadiumEntity("Independência", "Belo Horizonte - MG", 23018));
        stadiumDAO.create(new StadiumEntity("Arena Condá", "Chapecó - SC", 20069));
        stadiumDAO.create(new StadiumEntity("Rei Pelé", "Maceió - AL", 19105));
        stadiumDAO.create(new StadiumEntity("Frasqueirão", "Natal - RN", 15082));
        stadiumDAO.create(new StadiumEntity("Almeidão", "João Pessoa - PB", 25770));
        stadiumDAO.create(new StadiumEntity("Amigão", "Campina Grande - PB", 19000));
        stadiumDAO.create(new StadiumEntity("Batistão", "Aracaju - SE", 15586));
        stadiumDAO.create(new StadiumEntity("Albertão", "Teresina - PI", 52296));
        stadiumDAO.create(new StadiumEntity("Castelão (MA)", "São Luís - MA", 40149));
        stadiumDAO.create(new StadiumEntity("Kleber Andrade", "Cariacica - ES", 21000));
        stadiumDAO.create(new StadiumEntity("Estádio do Café", "Londrina - PR", 30000));
        stadiumDAO.create(new StadiumEntity("Centenário", "Caxias do Sul - RS", 22132));
        stadiumDAO.create(new StadiumEntity("Heriberto Hülse", "Criciúma - SC", 19225));
        stadiumDAO.create(new StadiumEntity("Baenão", "Belém - PA", 13792));
        System.out.println("Mock dos estádios...");
    }

    private static ZonedDateTime createDate(int month, int day, int hour) {
        return ZonedDateTime.of(2026, month, day, hour, 0, 0, 0, ZoneId.of("America/Sao_Paulo"));
    }

    public static void mockMatch(){
        matchDAO.clearAll();
        matchDAO.create(new MatchEntity("5f4b782b-36b9-46e4-8379-5fd7da112524", "6c473ace-a4a6-4500-93a3-71ae440b6224", "a64d611a-128b-4a5a-b043-c727724d78ba", createDate(6, 12, 16), "stadium_azteca", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("316de5e2-b25d-49a3-bf46-5f4e690bc75e", "a64d611a-128b-4a5a-b043-c727724d78ba", "dc7f4336-5d5b-4d8e-a34f-049a580d3d5f", createDate(6, 12, 16), "stadium_metlife", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("4be3fb05-e280-4a24-8073-604ea4044d87", "dc7f4336-5d5b-4d8e-a34f-049a580d3d5f", "ccdb54ee-2416-4377-8add-00e85a6e50d6", createDate(6, 13, 13), "stadium_lusail", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("550b4a36-8fc4-4215-bd43-5b6c29639e8f", "ccdb54ee-2416-4377-8add-00e85a6e50d6", "735b7ab3-37ab-4aa1-a586-ab679a533d27", createDate(6, 14, 16), "stadium_wembley", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("54b81804-8b45-4de3-9572-98a10f1e5c84", "735b7ab3-37ab-4aa1-a586-ab679a533d27", "e49a6614-99b3-4c26-9c87-14b27f879920", createDate(6, 15, 13), "stadium_maracana", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("baf56242-e087-4a3e-b625-c5a1e6a6030a", "6c473ace-a4a6-4500-93a3-71ae440b6224", "e49a6614-99b3-4c26-9c87-14b27f879920", createDate(6, 15, 16), "stadium_azteca", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("team_england", "team_iran", createDate(6, 16, 10), "stadium_metlife", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("team_usa", "team_wales", createDate(6, 16, 16), "stadium_lusail", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("team_portugal", "team_ghana", createDate(6, 17, 13), "stadium_wembley", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("team_uruguay", "team_south_korea", createDate(6, 17, 16), "stadium_maracana", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("team_brazil", "team_switzerland", createDate(6, 18, 13), "stadium_metlife", "Group Stage"));
        matchDAO.create(new MatchEntity("team_argentina", "team_mexico", createDate(6, 19, 16), "stadium_azteca", "Group Stage"));
        matchDAO.create(new MatchEntity("team_france", "team_denmark", createDate(6, 20, 13), "stadium_wembley", "Group Stage"));
        matchDAO.create(new MatchEntity("team_spain", "team_germany", createDate(6, 21, 16), "stadium_lusail", "Group Stage"));
        matchDAO.create(new MatchEntity("team_portugal", "team_uruguay", createDate(6, 22, 16), "stadium_maracana", "Group Stage"));
        matchDAO.create(new MatchEntity("team_brazil", "team_cameroon", createDate(6, 23, 16), "stadium_azteca", "Group Stage", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_argentina", "team_poland", createDate(6, 24, 16), "stadium_metlife", "Group Stage", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_france", "team_tunisia", createDate(6, 25, 12), "stadium_lusail", "Group Stage", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_spain", "team_japan", createDate(6, 26, 16), "stadium_wembley", "Group Stage", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_portugal", "team_south_korea", createDate(6, 27, 12), "stadium_maracana", "Group Stage", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_netherlands", "team_usa", createDate(6, 29, 12), "stadium_azteca", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_argentina", "team_australia", createDate(6, 29, 16), "stadium_metlife", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_france", "team_poland", createDate(6, 30, 12), "stadium_lusail", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_england", "team_senegal", createDate(6, 30, 16), "stadium_wembley", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_japan", "team_croatia", createDate(7, 1, 12), "stadium_maracana", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_brazil", "team_south_korea", createDate(7, 1, 16), "stadium_azteca", "Round of 16", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("qf-uuid-1", "team_croatia", "team_brazil", createDate(7, 5, 12), "stadium_lusail", "Quarter-finals", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("qf-uuid-2", "team_netherlands", "team_argentina", createDate(7, 5, 16), "stadium_metlife", "Quarter-finals", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_argentina", "team_croatia", createDate(7, 9, 16), "stadium_azteca", "Semi-finals", MatchStatus.SCHEDULED));
        matchDAO.create(new MatchEntity("team_argentina", "team_france", createDate(7, 14, 16), "stadium_metlife", "Final", MatchStatus.SCHEDULED));
        System.out.println("Mock das partidas...");
    }

    public static void mockReferee() {
        refereeService.deleteAll();
        refereeService.createReferee(new RefereeEntity("3107852f-5898-49cb-be15-be622cd5db38","Sandro Meira Ricci", "Inglaterra", 15, "Representou o Brasil nas Copas de 2014 e 2018."));
        refereeService.createReferee(new RefereeEntity("ca4edd9a-1939-4903-9b24-805cdd4f363a","Anderson Daronco", "Brasil", 12, "Conhecido pelo porte físico, apita na Libertadores e Brasileirão."));
        refereeService.createReferee(new RefereeEntity("d700a803-17e7-41ba-a15b-3d82f3bd19f9","Raphael Claus", "Brasil", 14, "Eleito melhor árbitro do Brasileirão diversas vezes, atuou na Copa do Mundo de 2022."));
        refereeService.createReferee(new RefereeEntity("b4630873-74b7-473f-b178-3773bf5d0a24","Wilton Pereira Sampaio", "Brasil", 16, "Árbitro FIFA, apitou as quartas de final da Copa do Mundo de 2022."));
        refereeService.createReferee(new RefereeEntity("56d7cdb5-24d2-4343-b0a1-8e54a5f5536f","Carlos Eugênio Simon", "Brasil", 20, "Apitou nas Copas do Mundo de 2002, 2006 e 2010. Hoje é comentarista."));
        refereeService.createReferee(new RefereeEntity("3fec8f4b-0b8d-4f9b-9357-499a347833ad","Nestor Pitana", "Argentina", 15, "Apitou a final da Copa do Mundo de 2018 entre França e Croácia."));
        refereeService.createReferee(new RefereeEntity("5d112505-9e58-4420-925b-23a0284074af","Wilmar Roldán", "Colômbia", 18, "Um dos árbitros com mais partidas na história da Copa Libertadores."));
        refereeService.createReferee(new RefereeEntity("9ed07b31-77f3-4cf1-bc27-f1a41bbd76a9","Andrés Cunha", "Uruguai", 13, "Árbitro na Copa de 2018 e na polêmica final da Libertadores de 2018."));
        refereeService.createReferee(new RefereeEntity("Patricio Loustau", "Argentina", 14, "Árbitro experiente em clássicos sul-americanos e eliminatórias."));
        refereeService.createReferee(new RefereeEntity("Roberto Tobar", "Chile", 11, "Apitou a final da Copa América de 2019."));
        refereeService.createReferee(new RefereeEntity("Pierluigi Collina", "Itália", 28, "Lenda da arbitragem, apitou a final da Copa de 2002. Hoje atua na FIFA."));
        refereeService.createReferee(new RefereeEntity("Howard Webb", "Inglaterra", 25, "Apitou a final da Copa do Mundo de 2010 e a final da Champions no mesmo ano."));
        refereeService.createReferee(new RefereeEntity("Szymon Marciniak", "Polônia", 12, "Apitou a final da Copa do Mundo de 2022 entre Argentina e França."));
        refereeService.createReferee(new RefereeEntity("Daniele Orsato", "Itália", 14, "Apitou a final da Champions League de 2020 e a semi da Copa de 2022."));
        refereeService.createReferee(new RefereeEntity("Antonio Mateu Lahoz", "Espanha", 15, "Conhecido por seu estilo comunicativo, apitou a final da Champions de 2021."));
        refereeService.createReferee(new RefereeEntity("Felix Brych", "Alemanha", 18, "Apitou a final da Champions League de 2017."));
        refereeService.createReferee(new RefereeEntity("Björn Kuipers", "Holanda", 16, "Apitou a final da Eurocopa 2020 e várias finais de competições europeias."));
        refereeService.createReferee(new RefereeEntity("Clément Turpin", "França", 13, "Apitou a final da Champions League de 2022 entre Real Madrid e Liverpool."));
        refereeService.createReferee(new RefereeEntity("Nicola Rizzoli", "Itália", 16, "Apitou a final da Copa do Mundo de 2014 no Maracanã."));
        refereeService.createReferee(new RefereeEntity("Danny Makkelie", "Holanda", 10, "Ex-policial, apita frequentemente grandes jogos da Champions League."));
        refereeService.createReferee(new RefereeEntity("Mark Geiger", "Estados Unidos", 14, "Primeiro árbitro dos EUA a apitar na fase de mata-mata de uma Copa (2014)."));
        refereeService.createReferee(new RefereeEntity("César Ramos", "México", 12, "Atuou nas Copas de 2018 e 2022, apitando a semifinal França x Marrocos."));
        refereeService.createReferee(new RefereeEntity("Bakary Gassama", "Gâmbia", 15, "Um dos principais árbitros da África, esteve em três Copas do Mundo."));
        refereeService.createReferee(new RefereeEntity("Janny Sikazwe", "Zâmbia", 10, "Famoso por encerrar uma partida da Copa Africana de Nações antes do tempo em 2022."));
        refereeService.createReferee(new RefereeEntity("Alireza Faghani", "Irã", 14, "Apitou a disputa de terceiro lugar na Copa de 2018."));
        refereeService.createReferee(new RefereeEntity("Ravshan Irmatov", "Uzbequistão", 18, "Recordista de partidas apitadas em Copas do Mundo (11 jogos)."));
        refereeService.createReferee(new RefereeEntity("Matthew Breeze", "Austrália", 16, "Apita grandes torneios na Ásia e Oceania desde os anos 2000."));
        refereeService.createReferee(new RefereeEntity("José Maria", "Brasil", 5, "Estreante no Brasileirão, com histórico focado na série B."));
        refereeService.createReferee(new RefereeEntity("Leandro Pedro Vuaden", "Brasil", 22, "Árbitro marcante no futebol nacional, conhecido por deixar o jogo seguir."));
        refereeService.createReferee(new RefereeEntity("Marcelo de Lima Henrique", "Brasil", 25, "Um dos árbitros em atividade mais velhos do futebol brasileiro."));
        refereeService.createReferee(new RefereeEntity("João Batista", "Brasil", 3, "Atua nas categorias de base do campeonato paulista."));
        refereeService.createReferee(new RefereeEntity("Carlos Eduardo Silva", "Brasil", 8, "Árbitro promissor da federação goiana."));
        refereeService.createReferee(new RefereeEntity("John Smith", "Inglaterra", 6, "Atua principalmente na Championship (segunda divisão inglesa)."));
        refereeService.createReferee(new RefereeEntity("Hans Müller", "Alemanha", 9, "Apitou recentemente a final da Copa da Alemanha."));
        refereeService.createReferee(new RefereeEntity("Pierre Dubois", "França", 7, "Faz parte do quadro de arbitragem da Ligue 1 há 4 anos."));
        refereeService.createReferee(new RefereeEntity("Mario Rossi", "Itália", 11, "Especialista em VAR na liga italiana."));
        refereeService.createReferee(new RefereeEntity("Diego Fernandez", "Espanha", 5, "Ganhou prêmio de revelação na arbitragem de La Liga."));
        refereeService.createReferee(new RefereeEntity("Luiz Antônio", "Brasil", 2, "Em transição do futebol amador para o profissional."));
        refereeService.createReferee(new RefereeEntity("Fernando Gomes", "Portugal", 13, "Apita na primeira divisão de Portugal e fase de grupos da Europa League."));
        refereeService.createReferee(new RefereeEntity("Alejandro Gomez", "Argentina", 8, "Apitou dois superclássicos Boca x River."));
        refereeService.createReferee(new RefereeEntity("David Taylor", "Escócia", 10, "Comanda jogos do clássico Celtic vs Rangers."));
        refereeService.createReferee(new RefereeEntity("Kenji Sato", "Japão", 7, "Árbitro em ascensão na J-League."));
        refereeService.createReferee(new RefereeEntity("Ahmed Ali", "Egito", 12, "Veterano na Liga dos Campeões da CAF."));
        refereeService.createReferee(new RefereeEntity("Chris Beath", "Austrália", 14, "Apitou a final do Mundial de Clubes da FIFA de 2021."));
        refereeService.createReferee(new RefereeEntity("Victor Kassai", "Hungria", 18, "Apitou a final da Champions League de 2011."));
        refereeService.createReferee(new RefereeEntity("Martin Atkinson", "Inglaterra", 20, "Um dos árbitros com mais partidas na história da Premier League."));
        refereeService.createReferee(new RefereeEntity("Michael Oliver", "Inglaterra", 12, "Árbitro de elite atual da Premier League e FIFA."));
        refereeService.createReferee(new RefereeEntity("Anthony Taylor", "Inglaterra", 13, "Atuou ativamente salvando a vida de Christian Eriksen na Euro 2020."));
        refereeService.createReferee(new RefereeEntity("Slavko Vinčić", "Eslovênia", 12, "Apitou a final da Europa League de 2022."));
        refereeService.createReferee(new RefereeEntity("Carlos Velasco Carballo", "Espanha", 15, "Chefe do projeto VAR na Espanha."));
        refereeService.createReferee(new RefereeEntity("Pedro Proença", "Portugal", 17, "Apitou a final da Champions e da Eurocopa no mesmo ano (2012)."));
        refereeService.createReferee(new RefereeEntity("Frank De Bleeckere", "Bélgica", 21, "Árbitro belga de maior renome internacional nos anos 2000."));
        refereeService.createReferee(new RefereeEntity("Massimo Busacca", "Suíça", 15, "Atual chefe do departamento de arbitragem da FIFA."));
        refereeService.createReferee(new RefereeEntity("Horacio Elizondo", "Argentina", 16, "Apitou a final de 2006 e expulsou Zidane."));
        refereeService.createReferee(new RefereeEntity("Cüneyt Çakır", "Turquia", 18, "Um dos árbitros mais respeitados da UEFA na década de 2010."));
        System.out.println("Mock dos árbitros...");
    }

    public static void mockRefereeMatch(){
        refereeMatchDAO.clearAll();
        refereeMatchDAO.create(new RefereeMatchEntity("3107852f-5898-49cb-be15-be622cd5db38", "316de5e2-b25d-49a3-bf46-5f4e690bc75e"));
        refereeMatchDAO.create(new RefereeMatchEntity("ca4edd9a-1939-4903-9b24-805cdd4f363a", "5f4b782b-36b9-46e4-8379-5fd7da112524"));
        refereeMatchDAO.create(new RefereeMatchEntity("d700a803-17e7-41ba-a15b-3d82f3bd19f9", "4be3fb05-e280-4a24-8073-604ea4044d87"));
        System.out.println("Mock dos relacionamentos time e árbitro...");
    }

    public static void mockTeam() {
        teamDAO.clearAll();
        teamDAO.create(new TeamEntity("6c473ace-a4a6-4500-93a3-71ae440b6224", "Mexico", "A", "Javier Aguirre"));
        teamDAO.create(new TeamEntity("a64d611a-128b-4a5a-b043-c727724d78ba", "South Africa", "A", "Hugo Broos"));
        teamDAO.create(new TeamEntity("dc7f4336-5d5b-4d8e-a34f-049a580d3d5f", "South Korea", "A", "Hong Myung-bo"));
        teamDAO.create(new TeamEntity("ccdb54ee-2416-4377-8add-00e85a6e50d6", "Czechia", "A", "Ivan Hasek"));
        teamDAO.create(new TeamEntity("735b7ab3-37ab-4aa1-a586-ab679a533d27", "Canada", "B", "Jesse Marsch"));
        teamDAO.create(new TeamEntity("e49a6614-99b3-4c26-9c87-14b27f879920", "Bosnia and Herzegovina", "B", "Sergej Barbarez"));
        teamDAO.create(new TeamEntity("Qatar", "B", "Julen Lopetegui"));
        teamDAO.create(new TeamEntity("Switzerland", "B", "Murat Yakin"));
        teamDAO.create(new TeamEntity("Brazil", "C", "Carlo Ancelotti"));
        teamDAO.create(new TeamEntity("Morocco", "C", "Walid Regragui"));
        teamDAO.create(new TeamEntity("Haiti", "C", "Sebastien Migne"));
        teamDAO.create(new TeamEntity("Scotland", "C", "Steve Clarke"));
        teamDAO.create(new TeamEntity("USA", "D", "Mauricio Pochettino"));
        teamDAO.create(new TeamEntity("Paraguay", "D", "Gustavo Alfaro"));
        teamDAO.create(new TeamEntity("Australia", "D", "Tony Popovic"));
        teamDAO.create(new TeamEntity("Turkey", "D", "Vincenzo Montella"));
        teamDAO.create(new TeamEntity("Germany", "E", "Julian Nagelsmann"));
        teamDAO.create(new TeamEntity("Curacao", "E", "Dick Advocaat"));
        teamDAO.create(new TeamEntity("Ivory Coast", "E", "Emerse Fae"));
        teamDAO.create(new TeamEntity("Ecuador", "E", "Sebastian Beccacece"));
        teamDAO.create(new TeamEntity("Netherlands", "F", "Ronald Koeman"));
        teamDAO.create(new TeamEntity("Japan", "F", "Hajime Moriyasu"));
        teamDAO.create(new TeamEntity("Sweden", "F", "Jon Dahl Tomasson"));
        teamDAO.create(new TeamEntity("Tunisia", "F", "Sami Trabelsi"));
        teamDAO.create(new TeamEntity("Belgium", "G", "Rudi Garcia"));
        teamDAO.create(new TeamEntity("Egypt", "G", "Hossam Hassan"));
        teamDAO.create(new TeamEntity("Iran", "G", "Amir Ghalenoei"));
        teamDAO.create(new TeamEntity("New Zealand", "G", "Darren Bazeley"));
        teamDAO.create(new TeamEntity("Spain", "H", "Luis de la Fuente"));
        teamDAO.create(new TeamEntity("Cape Verde", "H", "Bubista"));
        teamDAO.create(new TeamEntity("Saudi Arabia", "H", "Herve Renard"));
        teamDAO.create(new TeamEntity("Uruguay", "H", "Marcelo Bielsa"));
        teamDAO.create(new TeamEntity("France", "I", "Didier Deschamps"));
        teamDAO.create(new TeamEntity("Senegal", "I", "Pape Thiaw"));
        teamDAO.create(new TeamEntity("Iraq", "I", "Graham Arnold"));
        teamDAO.create(new TeamEntity("Norway", "I", "Stale Solbakken"));
        teamDAO.create(new TeamEntity("Argentina", "J", "Lionel Scaloni"));
        teamDAO.create(new TeamEntity("Algeria", "J", "Vladimir Petkovic"));
        teamDAO.create(new TeamEntity("Austria", "J", "Ralf Rangnick"));
        teamDAO.create(new TeamEntity("Jordan", "J", "Jamal Sellami"));
        teamDAO.create(new TeamEntity("Portugal", "K", "Roberto Martinez"));
        teamDAO.create(new TeamEntity("DR Congo", "K", "Sebastien Desabre"));
        teamDAO.create(new TeamEntity("Uzbekistan", "K", "Timur Kapadze"));
        teamDAO.create(new TeamEntity("Colombia", "K", "Nestor Lorenzo"));
        teamDAO.create(new TeamEntity("England", "L", "Thomas Tuchel"));
        teamDAO.create(new TeamEntity("Croatia", "L", "Zlatko Dalic"));
        teamDAO.create(new TeamEntity("Ghana", "L", "Otto Addo"));
        teamDAO.create(new TeamEntity("Panama", "L", "Thomas Christiansen"));
        System.out.println("Mock das seleções...");
    }
}
