package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
    private String playerName;
    private String playerSurname;

    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public String addValuesToFlashAction() {

        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("playerName", playerName);
        flash.put("playerSurname", playerSurname);

        return "terms?faces-redirect=true";
    }

    public void pullValuesFromFlashAction(ComponentSystemEvent e) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        playerName = (String) flash.get("playerName");
        playerSurname = (String) flash.get("playerSurname");
    }

    public String termsAcceptedAction() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        flash.setKeepMessages(true);        
        pullValuesFromFlashAction(null);

        //do something with the player name and surname
        logger.log(Level.INFO, "First name: {0}", playerName);
        logger.log(Level.INFO, "Last name: {0}", playerSurname);

        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Terms accepted and player registered!"));
        return "done?faces-redirect=true";
    }

    public String termsRejectedAction() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        flash.setKeepMessages(true);
        pullValuesFromFlashAction(null);
        
        //do something with the player name and surname

        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Terms rejected! Player not registered!"));
        return "index?faces-redirect=true";
    }
}
