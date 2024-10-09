package bandeau;

import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.util.Random;

/**
 * L'effet FontEnumerator tire au sort parmi les polices de caractère disponibles et affiche dans le bandeau le nom de
 * la police, affiche dans la police de caractère elle même
 */
public class FontEnumerator extends Effect {

    private final String[] fonts;
    private final int maxFonts;
    private final Random generator;

    public FontEnumerator(int numberOfFontsToShow) {
        super(null);
        maxFonts = numberOfFontsToShow;
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts = gEnv.getAvailableFontFamilyNames();
        generator = new Random(System.currentTimeMillis());
    }

    @Override
    public void playOn(Bandeau bandeau) {
        Font initial = bandeau.getFont();

        for (int repeat = 0; repeat < maxFonts; repeat++) {
            int fontNumber = generator.nextInt(fonts.length);
            bandeau.setMessage(fonts[fontNumber]);
            bandeau.setFont(new Font(fonts[fontNumber], Font.BOLD, 16));
            bandeau.sleep(500);
        }

        bandeau.setFont(initial);
    }

}
