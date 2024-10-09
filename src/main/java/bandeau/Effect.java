package bandeau;

/**
 * Un effet a pour responsabilité de savoir se jouer dans un bandeau. Optionnellement, un effet change le message
 * affiche avant de se jouer.
 */
public abstract class Effect {

    /**
     * Le message à afficher pour cet effet (si null, on ne change pas de message)
     */
    protected final String myMessage;

    public Effect(String message) {
        myMessage = message;
    }

    protected void init(Bandeau bandeau) {
        if (null != myMessage) {
            bandeau.setMessage(myMessage);
        }

    }

    /**
     * Jouer cet effet sur un bandeau
     */
    abstract public void playOn(Bandeau bandeau);
}
