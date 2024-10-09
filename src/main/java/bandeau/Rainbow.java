package bandeau;

import java.awt.Color;
import java.util.*;
/**
 * Un effet qui affiche le texte dans toutes les couleurs de l'arc en ciel
 */
public class Rainbow extends Effect {

    private final java.util.List<Color> myColors;

    public Rainbow(String message, int steps) {
        super(message);
        myColors = new ArrayList<>();
        // On initialise les couleurs
        for (int i = 0; i < steps; i++) {
            float h = ((float) i) / ((float) steps);
            myColors.add(new Color(Color.HSBtoRGB(h, 1.0f, 1.0f)));
        }
    }

    @Override
    public void playOn(Bandeau b) {
        super.init(b);
        for (Color c : myColors) {
            b.setForeground(c);
            b.sleep(300);
        }
    }
}
