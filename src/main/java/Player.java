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
        int p1Point = this.porkerCard.getPoint();
        int p2Point = p2.getPorkerCard().getPoint();
        if(p1Point == p2Point) return null;
        return p1Point > p2Point ? this: p2;
    }
}
