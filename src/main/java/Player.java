public class Player {
    private int playerNum;
    private PorkerCard porkerCard;

    public Player(int playerNum, PorkerCard porkerCard) {
        this.playerNum = playerNum;
        this.porkerCard = porkerCard;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public PorkerCard getPorkerCard() {
        return porkerCard;
    }

    public Player playWith(Player p2) {
        return this.porkerCard.getPoint() > p2.getPorkerCard().getPoint()? this: p2;
    }
}
