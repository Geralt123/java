package Email;

public class EmailMain {
        public static void main(String[] argv) {
                EmailMessage wiadomosc = EmailMessage.builder()
                        .addFrom("sbobek@agh.edu.pl")
                        .addTo("student@agh.edu.pl")
                        .addSubject("Mail testowy")
                        .addContent("Brak tresci")
                        .build();
        }
}
