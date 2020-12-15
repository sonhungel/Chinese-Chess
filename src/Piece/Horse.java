/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

/**
 *
 * @author Sonhungel
 */

// MÃ
public class Horse extends Piece{
    
    public Horse(String Name, int color, chinesechess.Board board) {
        super(Name, color, board);
    }
    
    @Override
    public boolean Move(int Row_Dest, int Column_Dest) {
        int Row_Current = this.getY();
        int Column_Current = this.getX();
        //KHÔNG ĂN QUÂN CÙNG MÀU
        if (CheckColor(Row_Dest, Column_Dest) == false) {
            return false;
        }
        //ĐI LÊN
        if (Row_Current > Row_Dest && Board.GetPiece(Row_Current - 1, Column_Current) == null) {
            if (Math.abs(Row_Dest - Row_Current) == 2 && Math.abs(Column_Dest - Column_Current) == 1) {
                return true;
            }
        }
        //ĐI XUỐNG
        if (Row_Current < Row_Dest && Board.GetPiece(Row_Current + 1, Column_Current) == null) {
            if (Math.abs(Row_Dest - Row_Current) == 2 && Math.abs(Column_Dest - Column_Current) == 1) {
                return true;
            }
        }
        //QUA PHẢI
        if (Column_Current < Column_Dest && Board.GetPiece(Row_Current, Column_Current + 1) == null) {
            if (Math.abs(Row_Dest - Row_Current) == 1 && Math.abs(Column_Dest - Column_Current) == 2) {
                return true;
            }
        }
        //QUA TRÁI
        if (Column_Current > Column_Dest && Board.GetPiece(Row_Current, Column_Current - 1) == null) {
            if (Math.abs(Row_Dest - Row_Current) == 1 && Math.abs(Column_Dest - Column_Current) == 2) {
                return true;
            }
        }
        return false;
    }
}
