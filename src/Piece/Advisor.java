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
// SĨ
public class Advisor extends Piece{
    
    public Advisor(String Name, int color, chinesechess.Board board) {
        super(Name, color, board);
    }
    
    @Override
    public boolean Move(int Row_Dest, int Column_Dest) {

        int Row_Current = this.getY();
        int Column_Current = this.getX();
        //Ko an quân cùng màu.
        if (CheckColor(Row_Dest, Column_Dest) == false) {
            return false;
        }
        //chỉ đi chéo 1 bước
        if (abs(Row_Dest - Row_Current) != 1 || abs(Column_Dest - Column_Current) != 1) {
            return false;
        }
        if (this.getColor() == 0) {
            if (Row_Dest < 7 || Column_Dest < 3 || Column_Dest > 5) {
                return false;
            }
        }
        if (this.getColor() == 1) {
            if (Row_Dest > 2 || Column_Dest < 3 || Column_Dest > 5) {
                return false;
            }
        }
        return true;
    }
}
