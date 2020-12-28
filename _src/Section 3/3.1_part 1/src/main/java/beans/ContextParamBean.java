package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class ContextParamBean {

    private String numberone;

    public String getNumberone() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        numberone = facesContext.getExternalContext().getInitParameter("number.one.in.ATP");
        return numberone;
    }
}
