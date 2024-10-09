package bandeau;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * RandomSequenceGenerator
 */
public class RandomSequenceGenerator {

    /**
     * générateur aléatoire
     * @param max la limite
     * @return une liste de tous les entiers de 0 (inclus) à max (exclu) dans un ordre aléatoire
     */
    public List<Integer> randomIntegers(int max) {
    /*  A l'ancienne : on met tous les entiers dans une liste
        List <Integer> range = new ArrayList<>(max);
        for (int i = 0; i < max; i++)
            range.add(i);
    */
        // En utilisant les "streams" de Java 8+
        List<Integer> range = IntStream.range(0, max).boxed().collect(Collectors.toList());
        // On mélange le contenu de la liste d'entiers
        Collections.shuffle(range);
        return range;
    }
}
