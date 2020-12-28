package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
    private String playerName = "Rafael Nadal";

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
        logger.log(Level.INFO, "Player name (from setPlayerName() method: {0}", playerName);
    }

    public void action() {
        logger.log(Level.INFO, "Name set: {0}", playerName);
    }

}
