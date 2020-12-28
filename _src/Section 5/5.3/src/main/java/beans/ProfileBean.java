package beans;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class ProfileBean {

    public void viewProfile() {

        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elcontext = context.getELContext();

        //approach 1        
        PlayersBean playersBean_1 = (PlayersBean) context.getApplication().
                evaluateExpressionGet(context, "#{playersBean}", PlayersBean.class);

        if (playersBean_1 != null) {
            playersBean_1.playerNameSurnameAction(1);
        } else {
            System.out.println("SESSION BEAN NOT FOUND 1!");
        }        

        //approach 2        
        PlayersBean playersBean_2 = (PlayersBean) context.getApplication().
                getExpressionFactory().createValueExpression(elcontext, "#{playersBean}", 
                        PlayersBean.class).getValue(elcontext);
        if (playersBean_2 != null) {
            playersBean_2.playerNameSurnameAction(2);
        } else {
            System.out.println("SESSION BEAN NOT FOUND 2!");
        }
        
        //approach 3
        PlayersBean playersBean_3 = (PlayersBean) elcontext.getELResolver().
                getValue(elcontext, null, "playersBean");
        if (playersBean_3 != null) {
            playersBean_3.playerNameSurnameAction(3);
        } else {
            System.out.println("SESSION BEAN NOT FOUND 3!");
        }
    }
}
