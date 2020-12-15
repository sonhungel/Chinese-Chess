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
// PHÁO
public class Cannon extends Piece{
    
    public Cannon(String Name, int color, chinesechess.Board board) {
        super(Name, color, board);
    }
    
    @Override
    public boolean Move(int Row_Dest, int Column_Dest) {
        int Row_Current = this.getY();
        int Column_Current = this.getX();
        int eat;
        //KHÔNG ĂN QUÂN CÙNG MÀU
        if (CheckColor(Row_Dest, Column_Dest) == false) {
            return false;
        }
        //CHỈ DI CHUYỂN NGANG HOẶC DỌC
        if (Row_Current != Row_Dest && Column_Current != Column_Dest) {
            return false;
        }
        //ĐI VÀ ĂN HÀNG DỌC
        if (Row_Current == Row_Dest) {
            //TỪ TRÁI SANG PHẢI
            if (Column_Current <= Column_Dest) {
                //DÙNG EAT ĐỂ ĐẾM SỐ QUÂN MÀ PHÁO BAY QUA
                eat = TouchPieceColumn(Column_Current + 1, Column_Dest, Row_Current, Row_Dest);
                //KO BAY QUA QUÂN NÀO
                if (eat == 0 && Board.GetPiece(Row_Dest, Column_Dest) == null) {
                    return true;
                } //BAY QUA 1 QUÂN VÀ ĂN QUÂN KHÁC MÀU
                else if (eat == 1 && CheckColor(Row_Dest, Column_Dest) == true && Board.GetPiece(Row_Dest, Column_Dest) != null) {
                    return true;
                } //BAY QUA HƠN 2 QUÂN
                else if (eat >= 2) {
                    return false;
                }
            } //TỪ PHẢI SANG TRÁI
            else {
                eat = TouchPieceColumn(Column_Current - 1, Column_Dest, Row_Current, Row_Dest);
                //KHÔNG BAY QUA QUÂN NÀO
                if (eat == 0 && Board.GetPiece(Row_Dest, Column_Dest) == null) {
                    return true;
                } //BAY QUA 1 QUÂN VÀ ĂN QUÂN KHÁC MÀU
                else if (eat == 1 && CheckColor(Row_Dest, Column_Dest) == true && Board.GetPiece(Row_Dest, Column_Dest) != null) {
                    return true;
                } //BAY QUA HƠN 2 QUÂN
                else if (eat >= 2) {
                    return false;
                }
            }
        }
        //ĐI NGANG
        if (Column_Current == Column_Dest) {
            //TỪ TRÊN XUỐNG DƯỚI
            if (Row_Current <= Row_Dest) {
                eat = TouchPieceRow(Row_Current + 1, Row_Dest, Column_Current, Column_Dest);
                //KHÔNG BAY QUA QUÂN NÀO
                if (eat == 0 && Board.GetPiece(Row_Dest, Column_Dest) == null) {
                    return true;
                } //BAY QUA 1 QUÂN VÀ ĂN QUÂN KHÁC MÀU
                else if (eat == 1 && CheckColor(Row_Dest, Column_Dest) == true && Board.GetPiece(Row_Dest, Column_Dest) != null) {
                    return true;
                } //BAY QUA 2 QUÂN
                else if (eat >= 2) {
                    return false;
                }
            } //TỪ DƯỚI LÊN TRÊN
            else {
                eat = TouchPieceRow(Row_Current - 1, Row_Dest, Column_Current, Column_Dest);
                //KHÔNG BAY QUA QUÂN NÀO
                if (eat == 0 && Board.GetPiece(Row_Dest, Column_Dest) == null) {
                    return true;
                } //BAY QUA 1 QUÂN VÀ ĂN QUÂN KHÁC MÀU
                else if (eat == 1 && CheckColor(Row_Dest, Column_Dest) == true && Board.GetPiece(Row_Dest, Column_Dest) != null) {
                    return true;
                } //BAY QUA 2 QUÂN
                else if (eat >= 2) {
                    return false;
                }
            }
        }
        return false;
    }
}
