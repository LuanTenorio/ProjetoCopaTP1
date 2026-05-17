package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.referee.RefereeDAO;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;

public class Mocking {

    static StadiumDAO stadiumDAO = new StadiumDAO();
    static MatchDAO matchDAO = new MatchDAO();
    static RefereeDAO refereeDAO = new RefereeDAO();

    public static void main(String[] args) {
        mockEstadium();
        mockMatch();
        mockReferee();
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

    public static void mockMatch(){
        /* TODO: A ser feito assim que existir um mockTeam() */
    }

    // Associar árbitros com partidas
    public static void mockReferee() {
        refereeDAO.clearAll();
        refereeDAO.create(new RefereeEntity("Sandro Meira Ricci", "Brasileiro", 15, "Representou o Brasil nas Copas de 2014 e 2018."));
        refereeDAO.create(new RefereeEntity("Anderson Daronco", "Brasileiro", 12, "Conhecido pelo porte físico, apita na Libertadores e Brasileirão."));
        refereeDAO.create(new RefereeEntity("Raphael Claus", "Brasileiro", 14, "Eleito melhor árbitro do Brasileirão diversas vezes, atuou na Copa do Mundo de 2022."));
        refereeDAO.create(new RefereeEntity("Wilton Pereira Sampaio", "Brasileiro", 16, "Árbitro FIFA, apitou as quartas de final da Copa do Mundo de 2022."));
        refereeDAO.create(new RefereeEntity("Carlos Eugênio Simon", "Brasileiro", 20, "Apitou nas Copas do Mundo de 2002, 2006 e 2010. Hoje é comentarista."));
        refereeDAO.create(new RefereeEntity("Nestor Pitana", "Argentino", 15, "Apitou a final da Copa do Mundo de 2018 entre França e Croácia."));
        refereeDAO.create(new RefereeEntity("Wilmar Roldán", "Colombiano", 18, "Um dos árbitros com mais partidas na história da Copa Libertadores."));
        refereeDAO.create(new RefereeEntity("Andrés Cunha", "Uruguaio", 13, "Árbitro na Copa de 2018 e na polêmica final da Libertadores de 2018."));
        refereeDAO.create(new RefereeEntity("Patricio Loustau", "Argentino", 14, "Árbitro experiente em clássicos sul-americanos e eliminatórias."));
        refereeDAO.create(new RefereeEntity("Roberto Tobar", "Chileno", 11, "Apitou a final da Copa América de 2019."));
        refereeDAO.create(new RefereeEntity("Pierluigi Collina", "Italiano", 28, "Lenda da arbitragem, apitou a final da Copa de 2002. Hoje atua na FIFA."));
        refereeDAO.create(new RefereeEntity("Howard Webb", "Inglês", 25, "Apitou a final da Copa do Mundo de 2010 e a final da Champions no mesmo ano."));
        refereeDAO.create(new RefereeEntity("Szymon Marciniak", "Polonês", 12, "Apitou a final da Copa do Mundo de 2022 entre Argentina e França."));
        refereeDAO.create(new RefereeEntity("Daniele Orsato", "Italiano", 14, "Apitou a final da Champions League de 2020 e a semi da Copa de 2022."));
        refereeDAO.create(new RefereeEntity("Antonio Mateu Lahoz", "Espanhol", 15, "Conhecido por seu estilo comunicativo, apitou a final da Champions de 2021."));
        refereeDAO.create(new RefereeEntity("Felix Brych", "Alemão", 18, "Apitou a final da Champions League de 2017."));
        refereeDAO.create(new RefereeEntity("Björn Kuipers", "Holandês", 16, "Apitou a final da Eurocopa 2020 e várias finais de competições europeias."));
        refereeDAO.create(new RefereeEntity("Clément Turpin", "Francês", 13, "Apitou a final da Champions League de 2022 entre Real Madrid e Liverpool."));
        refereeDAO.create(new RefereeEntity("Nicola Rizzoli", "Italiano", 16, "Apitou a final da Copa do Mundo de 2014 no Maracanã."));
        refereeDAO.create(new RefereeEntity("Danny Makkelie", "Holandês", 10, "Ex-policial, apita frequentemente grandes jogos da Champions League."));
        refereeDAO.create(new RefereeEntity("Mark Geiger", "Norte-americano", 14, "Primeiro árbitro dos EUA a apitar na fase de mata-mata de uma Copa (2014)."));
        refereeDAO.create(new RefereeEntity("César Ramos", "Mexicano", 12, "Atuou nas Copas de 2018 e 2022, apitando a semifinal França x Marrocos."));
        refereeDAO.create(new RefereeEntity("Bakary Gassama", "Gambiano", 15, "Um dos principais árbitros da África, esteve em três Copas do Mundo."));
        refereeDAO.create(new RefereeEntity("Janny Sikazwe", "Zambiano", 10, "Famoso por encerrar uma partida da Copa Africana de Nações antes do tempo em 2022."));
        refereeDAO.create(new RefereeEntity("Alireza Faghani", "Iraniano", 14, "Apitou a disputa de terceiro lugar na Copa de 2018."));
        refereeDAO.create(new RefereeEntity("Ravshan Irmatov", "Uzbeque", 18, "Recordista de partidas apitadas em Copas do Mundo (11 jogos)."));
        refereeDAO.create(new RefereeEntity("Matthew Breeze", "Australiano", 16, "Apita grandes torneios na Ásia e Oceania desde os anos 2000."));
        refereeDAO.create(new RefereeEntity("José Maria", "Brasileiro", 5, "Estreante no Brasileirão, com histórico focado na série B."));
        refereeDAO.create(new RefereeEntity("Leandro Pedro Vuaden", "Brasileiro", 22, "Árbitro marcante no futebol nacional, conhecido por deixar o jogo seguir."));
        refereeDAO.create(new RefereeEntity("Marcelo de Lima Henrique", "Brasileiro", 25, "Um dos árbitros em atividade mais velhos do futebol brasileiro."));
        refereeDAO.create(new RefereeEntity("João Batista", "Brasileiro", 3, "Atua nas categorias de base do campeonato paulista."));
        refereeDAO.create(new RefereeEntity("Carlos Eduardo Silva", "Brasileiro", 8, "Árbitro promissor da federação goiana."));
        refereeDAO.create(new RefereeEntity("John Smith", "Inglês", 6, "Atua principalmente na Championship (segunda divisão inglesa)."));
        refereeDAO.create(new RefereeEntity("Hans Müller", "Alemão", 9, "Apitou recentemente a final da Copa da Alemanha."));
        refereeDAO.create(new RefereeEntity("Pierre Dubois", "Francês", 7, "Faz parte do quadro de arbitragem da Ligue 1 há 4 anos."));
        refereeDAO.create(new RefereeEntity("Mario Rossi", "Italiano", 11, "Especialista em VAR na liga italiana."));
        refereeDAO.create(new RefereeEntity("Diego Fernandez", "Espanhol", 5, "Ganhou prêmio de revelação na arbitragem de La Liga."));
        refereeDAO.create(new RefereeEntity("Luiz Antônio", "Brasileiro", 2, "Em transição do futebol amador para o profissional."));
        refereeDAO.create(new RefereeEntity("Fernando Gomes", "Português", 13, "Apita na primeira divisão de Portugal e fase de grupos da Europa League."));
        refereeDAO.create(new RefereeEntity("Alejandro Gomez", "Argentino", 8, "Apitou dois superclássicos Boca x River."));
        refereeDAO.create(new RefereeEntity("David Taylor", "Escocês", 10, "Comanda jogos do clássico Celtic vs Rangers."));
        refereeDAO.create(new RefereeEntity("Kenji Sato", "Japonês", 7, "Árbitro em ascensão na J-League."));
        refereeDAO.create(new RefereeEntity("Ahmed Ali", "Egípcio", 12, "Veterano na Liga dos Campeões da CAF."));
        refereeDAO.create(new RefereeEntity("Chris Beath", "Australiano", 14, "Apitou a final do Mundial de Clubes da FIFA de 2021."));
        refereeDAO.create(new RefereeEntity("Victor Kassai", "Húngaro", 18, "Apitou a final da Champions League de 2011."));
        refereeDAO.create(new RefereeEntity("Martin Atkinson", "Inglês", 20, "Um dos árbitros com mais partidas na história da Premier League."));
        refereeDAO.create(new RefereeEntity("Michael Oliver", "Inglês", 12, "Árbitro de elite atual da Premier League e FIFA."));
        refereeDAO.create(new RefereeEntity("Anthony Taylor", "Inglês", 13, "Atuou ativamente salvando a vida de Christian Eriksen na Euro 2020."));
        refereeDAO.create(new RefereeEntity("Slavko Vinčić", "Esloveno", 12, "Apitou a final da Europa League de 2022."));
        refereeDAO.create(new RefereeEntity("Carlos Velasco Carballo", "Espanhol", 15, "Chefe do projeto VAR na Espanha."));
        refereeDAO.create(new RefereeEntity("Pedro Proença", "Português", 17, "Apitou a final da Champions e da Eurocopa no mesmo ano (2012)."));
        refereeDAO.create(new RefereeEntity("Frank De Bleeckere", "Belga", 21, "Árbitro belga de maior renome internacional nos anos 2000."));
        refereeDAO.create(new RefereeEntity("Massimo Busacca", "Suíço", 15, "Atual chefe do departamento de arbitragem da FIFA."));
        refereeDAO.create(new RefereeEntity("Horacio Elizondo", "Argentino", 16, "Apitou a final de 2006 e expulsou Zidane."));
        refereeDAO.create(new RefereeEntity("Cüneyt Çakır", "Turco", 18, "Um dos árbitros mais respeitados da UEFA na década de 2010."));
        System.out.println("Mock dos árbitros...");
    }
}
