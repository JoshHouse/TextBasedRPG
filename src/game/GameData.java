package game;

import java.io.Serial;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    private Player player;
    private Hub hub;

    public GameData(Player player, Hub hub) {
        this.player = player;
        this.hub = hub;
    }

    public Player getPlayer() {return player;}

    public Hub getHub() {return hub;}
}
