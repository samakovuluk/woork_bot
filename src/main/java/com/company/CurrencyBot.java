package com.company;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.sql.*;

public class CurrencyBot extends TelegramLongPollingBot {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://127.0.0.1:9092/mem:dbname";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

        public void onUpdateReceived(Update update) {


            String command=update.getMessage().getText();

            SendMessage message = new SendMessage();

            if(command.equals("/getcurrency")){
                String msg=null;
                Statement stmt = null;
                Connection conn = null;

                try {

                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
                    ResultSet set=stmt.executeQuery("SELECT TOP 1 * FROM Currencies ORDER BY Date desc");
                    if (set.next()) {
                        msg=(set.getString("CURRENCY"));
                    }

                    stmt.close();
                    conn.close();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                message.setText(msg);
            }



            message.setChatId(update.getMessage().getChatId());


            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }

        public String getBotUsername() {
            return "woork_bot";
        }

        public String getBotToken() {
            return "614782693:AAEV7cMKNJrA_7-0tbToiNN8hmEOBdcpXns";
        }
    }
