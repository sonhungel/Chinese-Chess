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

// XE
public class Chariot extends Piece {

    public Chariot(String Name, int color, chinesechess.Board board) {
        super(Name, color, board);
    }

    public boolean Move(int Row_Dest, int Column_Dest) {
        int Row_Current = this.getY();
        int Column_Current = this.getX();
        // KHÔNG ĂN QUÂN CÙNG MÀU
        if (CheckColor(Row_Dest, Column_Dest) == false)
            return false;
        // CHỈ DI CHUYỂN NGANG HOẶC DỌC
        if (Row_Current != Row_Dest && Column_Current != Column_Dest)
            return false;

        // ĐI DỌC
        if (Row_Current == Row_Dest) {
            if (Column_Current <= Column_Dest
                    && TouchPieceColumn(Column_Current + 1, Column_Dest, Row_Current, Row_Dest) != 0)
                return false;
            else if (Column_Current >= Column_Dest
                    && TouchPieceColumn(Column_Current - 1, Column_Dest, Row_Current, Row_Dest) != 0)
                return false;
        }
        // ĐI NGANG
        if (Column_Current == Column_Dest) {
            if (Row_Current <= Row_Dest 
                    && TouchPieceRow(Row_Current + 1, Row_Dest, Column_Current, Column_Dest) != 0)
                return false;
            else if (Row_Current >= Row_Dest
                    && TouchPieceRow(Row_Current - 1, Row_Dest, Column_Current, Column_Dest) != 0)
                return false;
        }
        return true;
    }
}
