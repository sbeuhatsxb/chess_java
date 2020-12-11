package Pieces;

import java.util.ArrayList;
import java.util.Hashtable;
import Board.Square;

public abstract class Piece {

    private static byte instances = 0;
    protected static final Hashtable<Class<?>, Integer> CHILDINSTANCES = new Hashtable<>();

    //True : Light piece / False : Dark piece
    protected boolean color;
    protected String name;
    protected String shortname;
    protected String position;
    protected Square square;
    protected boolean firstMove;
    int rank;
    int file;


    public Piece(String pos){
        firstMove = true;
        this.position = pos;
        instances++;
        Class<?> childClass = getClass();
        name = childClass.getSimpleName();
        CHILDINSTANCES.put(childClass, getCountIndividuelChildInstances(childClass) + 1);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "square=" + square +
                '}';
    }

    public abstract ArrayList<String> allowedMoves(String oldReadablePosition);

    //Numérote les filles crées individuellement
    public static int getCountIndividuelChildInstances(Class<?> childClass) {
        return CHILDINSTANCES.computeIfAbsent(childClass, x -> 0);
    }

    public int getCountIndividuelChildInstances() {
        return CHILDINSTANCES.get(getClass());
    }


    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getShortname() {
        return shortname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }
}
