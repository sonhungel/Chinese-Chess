/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import static java.lang.Math.abs;

/**
 *
 * @author Sonhungel
 */
// TƯỢNG
public class Elephant extends Piece{
    
    public Elephant(String Name, int color, chinesechess.Board board) {
        super(Name, color, board);
    }
    
    @Override
    public boolean Move(int Row_Dest, int Column_Dest) {
        int Row_Current = this.getY();
        int Column_Current = this.getX();
        //Ko ăn quân cùng màu.
        if (CheckColor(Row_Dest, Column_Dest) == false) {
            return false;
        }
        if (abs(Row_Dest - Row_Current) != 2 || abs(Column_Dest - Column_Current) != 2 || Column_Current == Column_Dest) {
            return false;
        }
        //len phai
        if (Row_Dest < Row_Current && Column_Dest > Column_Current) {
            if (Board.GetPiece(Row_Current - 1, Column_Current + 1) != null) {
                return false;
            }
        }
        //len trai
        if (Row_Dest < Row_Current && Column_Dest < Column_Current) {
            if (Board.GetPiece(Row_Current - 1, Column_Current - 1) != null) {
                return false;
            }
        }
        //xuong phai
        if (Row_Dest > Row_Current && Column_Dest > Column_Current) {
            if (Board.GetPiece(Row_Current + 1, Column_Current + 1) != null) {
                return false;
            }
        }
        //xuong trai
        if (Row_Dest > Row_Current && Column_Dest < Column_Current) {
            if (Board.GetPiece(Row_Current + 1, Column_Current - 1) != null) {
                return false;
            }
        }
        //do khong qua song
        if (Board.GetPiece(Row_Current, Column_Current).getColor() == 0 && Row_Dest <= 4) {
            return false;
        }
        if (Board.GetPiece(Row_Current, Column_Current).getColor() == 1 && Row_Dest >= 5) {
            return false;
        }
        return true;
    }
}
