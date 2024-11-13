package game;

import java.io.Serial;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    private Player player;
    private Shop shop;

    public GameData(Player player, Shop shop) {
        this.player = player;
        this.shop = shop;
    }

    public Player getPlayer() {return player;}

    public Shop getShop() {return shop;}
}
