package beans;

import java.util.Comparator;

/**
 *
 * @author Anghel Leonard
 */
public class TreeSetComparator implements Comparator<Players> {

    @Override
    public int compare(Players key_1, Players key_2) {
        return key_1.getRanking() - key_2.getRanking();
    }
}
