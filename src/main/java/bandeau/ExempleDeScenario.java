package bandeau;

public class ExempleDeScenario {

    /**
     * "Programme principal" : point d'entrée d'exécution
     *
     * @param args les "arguments de ligne de commande", transmis au lancement du programme
     */
    public static void main(String[] args) {
        String message;
        if (args.length > 0) {
            message = args[0]; // le premier paramètre
        } else {
            message = "Démonstration du bandeau";
        }

        // Créer un scénario
        Scenario s = new Scenario();
        // Ajouter des effets au scénario
        s.addEffect(new RandomEffect(message, 700), 1);
        s.addEffect(new TeleType("Je m'affiche caractère par caractère", 100), 1);

        // Créer les bandeaux
        Bandeau b1 = new Bandeau();
        Bandeau b2 = new Bandeau();
        Bandeau b3 = new Bandeau();

        System.out.println("CTRL+C pour terminer le programme");

        // Créer des threads utilisant la classe interne privée
        Thread t1 = new Thread(new BandeauRunnable(s, b1));
        Thread t2 = new Thread(new BandeauRunnable(s, b2));
        Thread t3 = new Thread(new BandeauRunnable(s, b3));

        // Démarrer les threads
        t1.start();
        t2.start();
        t3.start();

        // Attendre que les threads terminent avant de continuer


        // Ajouter un nouvel effet et rejouer le scénario sur b1 après l'exécution des autres
        s.addEffect(new Rotate("2 tours à gauche", 180, 4000, false), 2);
        s.playOn(b1);

    }

    // Classe interne privée pour gérer l'exécution du scénario sur un bandeau
    private static class BandeauRunnable implements Runnable {
        private Scenario scenario;
        private Bandeau bandeau;

        // Constructeur pour initialiser le scénario et le bandeau
        public BandeauRunnable(Scenario scenario, Bandeau bandeau) {
            this.scenario = scenario;
            this.bandeau = bandeau;
        }

        @Override
        public void run() {
            scenario.playOn(bandeau);  // Exécuter le scénario sur le bandeau
        }
    }
}