package Board;

import Pieces.Piece;
import Pieces.PiecePos;

public class Square {
    private static byte instances = 0;
    //True : Light square / False : Dark square
    private boolean color;
    private int[] location;
    private Piece piece;
    private String readablePos;
    private byte id;
    private boolean hasPiece;

    public Square(){
        id = instances;
        instances++;
    }

    public String getReadableLocation(int rank, int file){
        String alpha=String.valueOf(PiecePos.tebahpla[file]);
        String rankString=String.valueOf(rank+1);
        setReadablePos(alpha+rankString);
        return alpha+rankString;
    }

    public String getReadableColor(boolean color){
        return (color)?"White":"Black";
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        setHasPiece(true);
        this.piece = piece;
    }

    public String getReadablePos() {
        return readablePos;
    }

    public void setReadablePos(String readablePos) {
        this.readablePos = readablePos;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public byte getId() {
        return id;
    }

    public boolean getHasPiece() {
        return hasPiece;
    }

    public void setHasPiece(boolean hasPiece) {
        if(!hasPiece){
            setPiece(null);
        }
        this.hasPiece = hasPiece;
    }
}
