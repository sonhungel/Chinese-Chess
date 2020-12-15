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
// TỐT
public class Pawn extends Piece{
    
    public Pawn(String Name, int color, chinesechess.Board board) {
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
        //CHỈ DI CHUYỂN NGANG HOẶC DỌC
        if (Row_Current != Row_Dest && Column_Current != Column_Dest) {
            return false;
        }
        //ĐI DỌC
        if (Row_Current == Row_Dest) {
            //Row_Current >=5 or <=4 KIỂM TRA QUÂN ĐÃ QUA SÔNG HAY CHƯA. Column-Current-Column_Dest == 1 BƯỚC ĐI DỌC BẰNG 1 Ô
            if (this.getColor() == 1 && Row_Current >= 5 && Math.abs(Column_Current - Column_Dest) == 1) {
                return true;
            }
            if (this.getColor() == 0 && Row_Current <= 4 && Math.abs(Column_Current - Column_Dest) == 1) {
                return true;
            }
            return false;
        }
        //ĐI NGANG
        if (Column_Current == Column_Dest) {
            //QUÂN XANH
            if (this.getColor() == 1 && Math.abs(Row_Current - Row_Dest) == 1 && Row_Dest >= 4) {
                if (Row_Current + 1 == Row_Dest) {
                    return true;
                }
            }
            //QUÂN ĐỎ
            if (this.getColor() == 0 && Math.abs(Row_Current - Row_Dest) == 1 && Row_Dest <= 5) {
                if (Row_Current - 1 == Row_Dest) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
