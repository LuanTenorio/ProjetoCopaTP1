package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.match.MatchStatus;
import com.github.luantenorio.projetocopatp1.referee.RefereeDAO;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchDAO;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchEntity;
import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Mocking {

    static StadiumDAO stadiumDAO = new StadiumDAO();
    static MatchDAO matchDAO = new MatchDAO();
    static RefereeDAO refereeDAO = new RefereeDAO();
    static RefereeMatchDAO refereeMatchDAO = new RefereeMatchDAO();

    public static void main(String[] args) {
        mockEstadium();
        mockMatch();
        mockReferee();
        mockRefereeMatch();
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
        matchDAO.create(new MatchEntity("316de5e2-b25d-49a3-bf46-5f4e690bc75e", "team_mexico", "team_poland", createDate(6, 12, 16), "stadium_azteca", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("5f4b782b-36b9-46e4-8379-5fd7da112524", "team_brazil", "team_serbia", createDate(6, 12, 16), "stadium_metlife", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("4be3fb05-e280-4a24-8073-604ea4044d87", "team_argentina", "team_saudi_arabia", createDate(6, 13, 13), "stadium_lusail", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("550b4a36-8fc4-4215-bd43-5b6c29639e8f", "team_france", "team_australia", createDate(6, 14, 16), "stadium_wembley", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("54b81804-8b45-4de3-9572-98a10f1e5c84", "team_spain", "team_costa_rica", createDate(6, 15, 13), "stadium_maracana", "Group Stage", MatchStatus.FINISHED));
        matchDAO.create(new MatchEntity("baf56242-e087-4a3e-b625-c5a1e6a6030a", "team_germany", "team_japan", createDate(6, 15, 16), "stadium_azteca", "Group Stage", MatchStatus.FINISHED));
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
        refereeDAO.clearAll();
        refereeDAO.create(new RefereeEntity("3107852f-5898-49cb-be15-be622cd5db38","Sandro Meira Ricci", "Brasil", 15, "Representou o Brasil nas Copas de 2014 e 2018."));
        refereeDAO.create(new RefereeEntity("ca4edd9a-1939-4903-9b24-805cdd4f363a","Anderson Daronco", "Brasil", 12, "Conhecido pelo porte físico, apita na Libertadores e Brasileirão."));
        refereeDAO.create(new RefereeEntity("d700a803-17e7-41ba-a15b-3d82f3bd19f9","Raphael Claus", "Brasil", 14, "Eleito melhor árbitro do Brasileirão diversas vezes, atuou na Copa do Mundo de 2022."));
        refereeDAO.create(new RefereeEntity("b4630873-74b7-473f-b178-3773bf5d0a24","Wilton Pereira Sampaio", "Brasil", 16, "Árbitro FIFA, apitou as quartas de final da Copa do Mundo de 2022."));
        refereeDAO.create(new RefereeEntity("56d7cdb5-24d2-4343-b0a1-8e54a5f5536f","Carlos Eugênio Simon", "Brasil", 20, "Apitou nas Copas do Mundo de 2002, 2006 e 2010. Hoje é comentarista."));
        refereeDAO.create(new RefereeEntity("3fec8f4b-0b8d-4f9b-9357-499a347833ad","Nestor Pitana", "Argentina", 15, "Apitou a final da Copa do Mundo de 2018 entre França e Croácia."));
        refereeDAO.create(new RefereeEntity("5d112505-9e58-4420-925b-23a0284074af","Wilmar Roldán", "Colômbia", 18, "Um dos árbitros com mais partidas na história da Copa Libertadores."));
        refereeDAO.create(new RefereeEntity("9ed07b31-77f3-4cf1-bc27-f1a41bbd76a9","Andrés Cunha", "Uruguai", 13, "Árbitro na Copa de 2018 e na polêmica final da Libertadores de 2018."));
        refereeDAO.create(new RefereeEntity("Patricio Loustau", "Argentina", 14, "Árbitro experiente em clássicos sul-americanos e eliminatórias."));
        refereeDAO.create(new RefereeEntity("Roberto Tobar", "Chile", 11, "Apitou a final da Copa América de 2019."));
        refereeDAO.create(new RefereeEntity("Pierluigi Collina", "Itália", 28, "Lenda da arbitragem, apitou a final da Copa de 2002. Hoje atua na FIFA."));
        refereeDAO.create(new RefereeEntity("Howard Webb", "Inglaterra", 25, "Apitou a final da Copa do Mundo de 2010 e a final da Champions no mesmo ano."));
        refereeDAO.create(new RefereeEntity("Szymon Marciniak", "Polônia", 12, "Apitou a final da Copa do Mundo de 2022 entre Argentina e França."));
        refereeDAO.create(new RefereeEntity("Daniele Orsato", "Itália", 14, "Apitou a final da Champions League de 2020 e a semi da Copa de 2022."));
        refereeDAO.create(new RefereeEntity("Antonio Mateu Lahoz", "Espanha", 15, "Conhecido por seu estilo comunicativo, apitou a final da Champions de 2021."));
        refereeDAO.create(new RefereeEntity("Felix Brych", "Alemanha", 18, "Apitou a final da Champions League de 2017."));
        refereeDAO.create(new RefereeEntity("Björn Kuipers", "Holanda", 16, "Apitou a final da Eurocopa 2020 e várias finais de competições europeias."));
        refereeDAO.create(new RefereeEntity("Clément Turpin", "França", 13, "Apitou a final da Champions League de 2022 entre Real Madrid e Liverpool."));
        refereeDAO.create(new RefereeEntity("Nicola Rizzoli", "Itália", 16, "Apitou a final da Copa do Mundo de 2014 no Maracanã."));
        refereeDAO.create(new RefereeEntity("Danny Makkelie", "Holanda", 10, "Ex-policial, apita frequentemente grandes jogos da Champions League."));
        refereeDAO.create(new RefereeEntity("Mark Geiger", "Estados Unidos", 14, "Primeiro árbitro dos EUA a apitar na fase de mata-mata de uma Copa (2014)."));
        refereeDAO.create(new RefereeEntity("César Ramos", "México", 12, "Atuou nas Copas de 2018 e 2022, apitando a semifinal França x Marrocos."));
        refereeDAO.create(new RefereeEntity("Bakary Gassama", "Gâmbia", 15, "Um dos principais árbitros da África, esteve em três Copas do Mundo."));
        refereeDAO.create(new RefereeEntity("Janny Sikazwe", "Zâmbia", 10, "Famoso por encerrar uma partida da Copa Africana de Nações antes do tempo em 2022."));
        refereeDAO.create(new RefereeEntity("Alireza Faghani", "Irã", 14, "Apitou a disputa de terceiro lugar na Copa de 2018."));
        refereeDAO.create(new RefereeEntity("Ravshan Irmatov", "Uzbequistão", 18, "Recordista de partidas apitadas em Copas do Mundo (11 jogos)."));
        refereeDAO.create(new RefereeEntity("Matthew Breeze", "Austrália", 16, "Apita grandes torneios na Ásia e Oceania desde os anos 2000."));
        refereeDAO.create(new RefereeEntity("José Maria", "Brasil", 5, "Estreante no Brasileirão, com histórico focado na série B."));
        refereeDAO.create(new RefereeEntity("Leandro Pedro Vuaden", "Brasil", 22, "Árbitro marcante no futebol nacional, conhecido por deixar o jogo seguir."));
        refereeDAO.create(new RefereeEntity("Marcelo de Lima Henrique", "Brasil", 25, "Um dos árbitros em atividade mais velhos do futebol brasileiro."));
        refereeDAO.create(new RefereeEntity("João Batista", "Brasil", 3, "Atua nas categorias de base do campeonato paulista."));
        refereeDAO.create(new RefereeEntity("Carlos Eduardo Silva", "Brasil", 8, "Árbitro promissor da federação goiana."));
        refereeDAO.create(new RefereeEntity("John Smith", "Inglaterra", 6, "Atua principalmente na Championship (segunda divisão inglesa)."));
        refereeDAO.create(new RefereeEntity("Hans Müller", "Alemanha", 9, "Apitou recentemente a final da Copa da Alemanha."));
        refereeDAO.create(new RefereeEntity("Pierre Dubois", "França", 7, "Faz parte do quadro de arbitragem da Ligue 1 há 4 anos."));
        refereeDAO.create(new RefereeEntity("Mario Rossi", "Itália", 11, "Especialista em VAR na liga italiana."));
        refereeDAO.create(new RefereeEntity("Diego Fernandez", "Espanha", 5, "Ganhou prêmio de revelação na arbitragem de La Liga."));
        refereeDAO.create(new RefereeEntity("Luiz Antônio", "Brasil", 2, "Em transição do futebol amador para o profissional."));
        refereeDAO.create(new RefereeEntity("Fernando Gomes", "Portugal", 13, "Apita na primeira divisão de Portugal e fase de grupos da Europa League."));
        refereeDAO.create(new RefereeEntity("Alejandro Gomez", "Argentina", 8, "Apitou dois superclássicos Boca x River."));
        refereeDAO.create(new RefereeEntity("David Taylor", "Escócia", 10, "Comanda jogos do clássico Celtic vs Rangers."));
        refereeDAO.create(new RefereeEntity("Kenji Sato", "Japão", 7, "Árbitro em ascensão na J-League."));
        refereeDAO.create(new RefereeEntity("Ahmed Ali", "Egito", 12, "Veterano na Liga dos Campeões da CAF."));
        refereeDAO.create(new RefereeEntity("Chris Beath", "Austrália", 14, "Apitou a final do Mundial de Clubes da FIFA de 2021."));
        refereeDAO.create(new RefereeEntity("Victor Kassai", "Hungria", 18, "Apitou a final da Champions League de 2011."));
        refereeDAO.create(new RefereeEntity("Martin Atkinson", "Inglaterra", 20, "Um dos árbitros com mais partidas na história da Premier League."));
        refereeDAO.create(new RefereeEntity("Michael Oliver", "Inglaterra", 12, "Árbitro de elite atual da Premier League e FIFA."));
        refereeDAO.create(new RefereeEntity("Anthony Taylor", "Inglaterra", 13, "Atuou ativamente salvando a vida de Christian Eriksen na Euro 2020."));
        refereeDAO.create(new RefereeEntity("Slavko Vinčić", "Eslovênia", 12, "Apitou a final da Europa League de 2022."));
        refereeDAO.create(new RefereeEntity("Carlos Velasco Carballo", "Espanha", 15, "Chefe do projeto VAR na Espanha."));
        refereeDAO.create(new RefereeEntity("Pedro Proença", "Portugal", 17, "Apitou a final da Champions e da Eurocopa no mesmo ano (2012)."));
        refereeDAO.create(new RefereeEntity("Frank De Bleeckere", "Bélgica", 21, "Árbitro belga de maior renome internacional nos anos 2000."));
        refereeDAO.create(new RefereeEntity("Massimo Busacca", "Suíça", 15, "Atual chefe do departamento de arbitragem da FIFA."));
        refereeDAO.create(new RefereeEntity("Horacio Elizondo", "Argentina", 16, "Apitou a final de 2006 e expulsou Zidane."));
        refereeDAO.create(new RefereeEntity("Cüneyt Çakır", "Turquia", 18, "Um dos árbitros mais respeitados da UEFA na década de 2010."));
        System.out.println("Mock dos árbitros...");
    }

    public static void mockRefereeMatch(){
        refereeMatchDAO.create(new RefereeMatchEntity("3107852f-5898-49cb-be15-be622cd5db38", "316de5e2-b25d-49a3-bf46-5f4e690bc75e"));
        refereeMatchDAO.create(new RefereeMatchEntity("ca4edd9a-1939-4903-9b24-805cdd4f363a", "5f4b782b-36b9-46e4-8379-5fd7da112524"));
        refereeMatchDAO.create(new RefereeMatchEntity("d700a803-17e7-41ba-a15b-3d82f3bd19f9", "4be3fb05-e280-4a24-8073-604ea4044d87"));
    }
}
