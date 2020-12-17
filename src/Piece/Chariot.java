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
                    && !CanMoveOnColumn(Column_Current + 1, Column_Dest, Row_Current))
                return false;
            else if (Column_Current >= Column_Dest
                    && !CanMoveOnColumn(Column_Current - 1, Column_Dest, Row_Current))
                return false;
        }
        // ĐI NGANG
        if (Column_Current == Column_Dest) {
            if (Row_Current <= Row_Dest 
                    && !CanMoveOnRow(Row_Current + 1, Row_Dest, Column_Current))
                return false;
            else if (Row_Current >= Row_Dest
                    && !CanMoveOnRow(Row_Current - 1, Row_Dest, Column_Current))
                return false;
        }
        return true;
    }

    // Kiểm tra ở mỗi Row và mỗi Column để xác định vật cản. Nếu có 1 piece bất kì nào đó nằm trong đường đi
    // => Sẽ không thể di chuyển tới Des đc. 

    /// Check empty Row from current position to desination position
    public boolean CanMoveOnRow(int Row_Current,int Row_Dest,int Column_Current)
    {
        if(Row_Current<Row_Dest){
            for(int i = Row_Current ; i<Row_Dest ; i++)
                if(Board.GetPiece(i, Column_Current)!=null)
                    return false;
        }
        else if(Row_Current>=Row_Dest){
            for(int i = Row_Current ; i>Row_Dest ; i--)
                if(Board.GetPiece(i, Column_Current)!=null)
                    return false;
        }
        return true;
    }
    /// Check empty Column from current position to desination position
    public boolean CanMoveOnColumn(int Column_Current,int Column_Dest,int Row_Current)
    {
        if(Column_Current>Column_Dest){
            for(int i = Column_Current ; i>Column_Dest ; i--)
                if(Board.GetPiece(Row_Current, i)!=null)
                    return false;
        }
        else if(Column_Current<Column_Dest){
            for(int i = Column_Current ; i<Column_Dest ; i++)
                if(Board.GetPiece(Row_Current, i)!=null)
                    return false;
        }
        return true;
    }
}
