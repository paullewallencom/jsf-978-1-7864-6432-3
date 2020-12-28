package beans;

import javax.faces.context.FacesContext;

/**
 *
 * @author Anghel Leonard
 */
public final class ApplicationMapHelper {

    public static void setValueInApplicationMap(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
    }

    public static Object getValueFromApplicationMap(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }
}
