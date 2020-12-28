package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBeanSet {

    public void playerSetAction() {
        ApplicationMapHelper.setValueInApplicationMap("PlayersBeanSet.name", "Rafael");
        ApplicationMapHelper.setValueInApplicationMap("PlayersBeanSet.surname", "Nadal");
    }
}
