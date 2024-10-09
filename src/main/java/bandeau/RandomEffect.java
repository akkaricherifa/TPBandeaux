package bandeau;

import java.awt.Font;

/**
 * Un effet qui affiche les caractères du message un par un dans un style qui rappelle l'affichage du "jeu du pendu" :
 * Au départ, tous les caractères du message sont affichés par un trait de soulignement "_" Les caractères du message
 * sont ensuite révélés un par un, dans un ordre aléatoire. Cet effet doit fonctionner correctement, quelle que soit la
 * longueur du message à afficher
 */
public class RandomEffect extends Effect {
    private final RandomSequenceGenerator myRandom = new RandomSequenceGenerator();

    private final int myDelay;

    public RandomEffect(String message, int delay) {
        super(message);
        myDelay = delay;
    }

    @Override
    public void playOn(Bandeau b) {
        super.init(b);
        Font initial = b.getFont();
        String message = b.getMessage();
        StringBuilder display = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            display.append("_");
        }

        b.setFont(new Font("Monospaced", Font.BOLD, 25));
        b.setMessage(display.toString());
        b.sleep(myDelay);
        for (Integer i : myRandom.randomIntegers(message.length())) {
            display.setCharAt(i, message.charAt(i));
            b.setMessage(display.toString());
            b.sleep(myDelay);
        }
        b.setFont(initial);
    }
}
