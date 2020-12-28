package beans;

import java.util.Random;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private static final Logger LOG = Logger.getLogger(PlayersBean.class.getName());   
    
    private String playerName = "";
    private String playerSurname = "";

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

    public String validateData() {
        
        LOG.info("#validateData() called ...");

        FacesContext facesContext = FacesContext.getCurrentInstance();

        Random r = new Random();
        int valid = r.nextInt(20);
        if (valid < 10) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Player " + playerName + " " + playerSurname +" is not valid.", ""));
        }

        return "index";
    }
}
