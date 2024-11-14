package game;

import java.io.Serial;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    private final Player player;
    private final Hub hub;

    public GameData(Player loadedPlayer, Hub loadedHub) {
        this.player = loadedPlayer;
        this.hub = loadedHub;
    }

    public GameData(GameData other) {
        this.player = other.player;
        this.hub = other.hub;
    }

    public Player getPlayer() {return player;}

    public Hub getHub() {return hub;}
}
