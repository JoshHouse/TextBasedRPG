package game;

import java.io.Serial;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    private final Player player;
    private final Hub hub;

    public GameData(Player player, Hub hub) {
        this.player = player;
        this.hub = hub;
    }

    public GameData(GameData other) {
        this.player = other.player;
        this.hub = other.hub;
    }

    public static Player getPlayer() {return player;}

    public static Hub getHub() {return hub;}
}
