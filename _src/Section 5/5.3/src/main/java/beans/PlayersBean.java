package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@SessionScoped
public class PlayersBean implements Serializable{
    
    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());

    private String playerName = "";
    private String playerSurname = "";

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

    @PostConstruct
    public void init(){
        logger.info("PlayersBean was successfully initializated!");
    }
    
    public void playerNameSurnameAction(int a) {
        logger.log(Level.INFO, "Called from ProfileBean! Approach:{0}", a);
        logger.log(Level.INFO, "{0} {1}", new Object[]{playerName, playerSurname});
    }
}
