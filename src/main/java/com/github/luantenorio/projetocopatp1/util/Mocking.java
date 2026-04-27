package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;

public class Mocking {

    static StadiumDAO stadiumDAO = new StadiumDAO();

    public static void main(String[] args) {
        mockEstadium();
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
}
