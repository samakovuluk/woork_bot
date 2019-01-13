import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class CurrencyB extends TelegramLongPollingBot {


        public void onUpdateReceived(Update update) {

//            System.out.println(update.getMessage().getText());
//            System.out.println(update.getMessage().getFrom().getFirstName() );

            String command=update.getMessage().getText();

            SendMessage message = new SendMessage();

            if(command.equals("/getcurrency")){


                message.setText(new Currency().getUSDKZT());
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
