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
// TƯỚNG
public class King extends Piece{
    
    public King(String Name, int color, chinesechess.Board board) {
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
        //KIỂM TRA TƯỚNG BUỘC PHẢI ĐỨNG Ở TRONG Ô CỦA TƯỚNG
        if (this.getColor() == 0 && (Row_Dest < 7 || Column_Dest < 3 || Column_Dest > 5)) {
            return false;
        }
        if (this.getColor() == 1 && (Row_Dest > 2 || Column_Dest < 3 || Column_Dest > 5)) {
            return false;
        }
        //CHỈ ĐƯỢC ĐI NGANG HOẶC DỌC
        if (Row_Current != Row_Dest && Column_Current != Column_Dest) {
            return false;
        }
        //CHỈ ĐƯỢC ĐI MỘT Ô
        //ĐI DỌC
        if (Row_Current == Row_Dest && Math.abs(Column_Current - Column_Dest) != 1) {
            return false;
        }
        if (Column_Current == Column_Dest && Math.abs(Row_Current - Row_Dest) != 1) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                Piece desPiece = Board.GetPiece(i, j);
                if (desPiece != null) {
                    if (desPiece.getColor() != this.getColor()) {
                        if (desPiece.Move(Row_Dest, Column_Dest)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
