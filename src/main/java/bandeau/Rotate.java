package bandeau;

/**
 * Un effet qui fait faire un tour complet au texte
 */
public class Rotate extends Effect {

    private final int dureeDunTour;
    private final int nombreDePas;
    private final boolean clockwise;

    /**
     * @param message le message, si null le message du bandeau est conservé
     * @param pas nombre de pas de la rotation
     * @param duree durée du tour en millisecondes
     * @param sens sens de rotation (vrai : horaire, faux : antihoraire)
     */
    public Rotate(String message, int pas, int duree, boolean sens) {
        super(message);
        dureeDunTour = duree;
        nombreDePas = pas;
        clockwise = sens;
    }

    @Override
    public void playOn(Bandeau b) {
        super.init(b);
        int delay = dureeDunTour / nombreDePas;
        double old = b.getRotation();
        int increment = clockwise ? 1 : -1;
        for (int pas = 0; Math.abs(pas) != nombreDePas; pas += increment) {
            double theta = (Math.PI * 2 * pas) / nombreDePas;
            b.setRotation(theta);
            b.sleep(delay);
        }
        b.setRotation(old);
    }
}
