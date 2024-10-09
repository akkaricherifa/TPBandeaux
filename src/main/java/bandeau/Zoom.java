package bandeau;

/**
 * Un effet qui zoome le message avec un délai à spécifier
 */
public class Zoom extends Effect {

    private final int myDelay;

    public Zoom(String message, int delay) {
        super(message);
        myDelay = delay;
    }

    @Override
    public void playOn(Bandeau b) {
        super.init(b);
        for (int fontSize = 1; fontSize < 40; fontSize++) {
            b.setFont(
                    new java.awt.Font("Monospaced", java.awt.Font.BOLD, fontSize)
            );
            b.sleep(myDelay);
        }
    }
}
