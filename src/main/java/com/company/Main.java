package com.company;

import org.h2.tools.Server;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;

public class Main {


    public static void main(String[] args) throws Exception {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new CurrencyB());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
