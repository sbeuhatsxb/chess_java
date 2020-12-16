public class Rules {

    private boolean endGames;

    public Rules(){
        endGames = false;
    }

    public boolean isEndGames() {
        return endGames;
    }

    public void setEndGames(boolean endGames) {
        this.endGames = endGames;
    }

    //Castling (roque)
    //Check
    //Checkmate
    //Draw (annuler)
    //Stalemate (pat)
    //take
    //new piece (default : queen)
    //Opening (who plays first)
    //
}
