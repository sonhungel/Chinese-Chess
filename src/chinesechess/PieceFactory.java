package chinesechess;
import Piece.*;


enum PieceType{
    ADVISOR,CANNON,CHARIOT,ELEPHANT,HORSE,KING,PAWN;
}
enum PlayerType{
    RED,GREEN;
}

public class PieceFactory {
    private PieceFactory(){

    }

    public static final Piece getPiece(PieceType pieceType, PlayerType playerType,Board board ) {
        if(playerType == PlayerType.RED)
        {
            switch (pieceType) {
 
                case ADVISOR:
                    return new Advisor("RAdvisor", 0, board);
                case CANNON:
                    return new Cannon("RCannon", 0, board);
                case CHARIOT:
                    return new Chariot("RChariot", 0, board);
                case ELEPHANT:
                    return new Elephant("RElephant", 0, board);
                case HORSE:
                    return new Horse("RHorse", 0, board);
                case KING:
                    return new King("King_Red", 0, board);
                case PAWN:
                    return new Pawn("RPawn", 0, board);
                default:
                    throw new IllegalArgumentException("This Piece type is unsupported");
            }
        }
        else // GREEN
        {
            switch (pieceType) {
 
                case ADVISOR:
                    return new Advisor("GAdvisor", 1, board);
                case CANNON:
                    return new Cannon("GCannon", 1, board);
                case CHARIOT:
                    return new Chariot("GChariot", 1, board);
                case ELEPHANT:
                    return new Elephant("GElephant", 1, board);
                case HORSE:
                    return new Horse("GHorse", 1, board);
                case KING:
                    return new King("King_Green", 1, board);
                case PAWN:
                    return new Pawn("GPawn", 1, board);
                default:
                    throw new IllegalArgumentException("This Piece type is unsupported");
            }
        }
        
    }
}


