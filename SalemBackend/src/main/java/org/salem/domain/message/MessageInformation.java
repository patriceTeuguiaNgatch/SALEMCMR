package org.salem.domain.message;

public class MessageInformation {

    public static String DEMANDE_INFORMATION = "Demande d'information";
    public static String REMERCIMENT = "Remerciement";

    public static String formateRequestInformation(Message message) {
        String messageFormat = message.getComment();
        String name = String.format("<br><font color=green> %s %s  </font><br>", message.getName().getFirstName(),
                message.getName().getLastName());
        messageFormat += name;
        String emailFormat = String.format("<font color=blue> %s </font><br>", message.getEmail());
        messageFormat += emailFormat;
        String phoneNumberFormat = String.format("<font color=red> %s </font><br>", message.getPhoneNumber());
        messageFormat += phoneNumberFormat;
        return messageFormat;
    }

    public static String formateDonThankYouMessage(Message message) {

        String messageFormat = String.format("<h2>Bonjour %s %s </h2>", message.getName().getFirstName(),
                message.getName().getLastName());
        messageFormat += "<br><p><font color=green>SALEM </font>vous remercions chaleuresement pour votre geste particulierment généreux.</p>";
        messageFormat += "<p>Nous vous rassurons que votre participation sera utilé pour une cause noble</p>";
        String name = String.format("<br><font color=green> %s %s  </font><br>", message.getName().getFirstName(),
                message.getName().getLastName());
        messageFormat += name;
        String emailFormat = String.format("<font color=blue> %s </font><br>", message.getEmail());
        messageFormat += emailFormat;
        String phoneNumberFormat = String.format("<font color=red> %s </font><br>", message.getPhoneNumber());
        messageFormat += phoneNumberFormat;
        return messageFormat;
    }

}