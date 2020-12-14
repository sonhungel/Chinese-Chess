/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;
import chinesechess.Board;

/**
 *
 * @author Sonhungel
 */
public abstract class Piece {
    private int x;
    private  int y;
    
    private String Name;
    private int color;
    
    public Board Board;
    
    // Get - Set Position
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    // Get - Set Color
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    // Get - Set Name
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public Piece(String Name,int color,Board board)
    {
        this.Name=Name;
        this.color=color;
        this.Board=board;
    }
    
    public boolean Move(int x,int y)
    {
        return true;
    }
    
    public boolean CheckColor(int Row_Dest,int Column_Dest){
        Piece Current_Piece = Board.GetPiece(Row_Dest, Column_Dest);
        if(Current_Piece!=null)
            if(Current_Piece.getColor() == this.getColor())
                return false;
        return true;
    }
    // Touch Row & Column
    public int TouchPieceRow(int Row_Current,int Row_Dest,int Column_Current,int Column_Dest)
    {
        int index=0;
        if(Row_Current<Row_Dest){
            for(int i = Row_Current ; i<Row_Dest ; i++)
                if(Board.GetPiece(i, Column_Current)!=null)
                    index++;
        }
        else if(Row_Current>=Row_Dest){
            for(int i = Row_Current ; i>Row_Dest ; i--)
                if(Board.GetPiece(i, Column_Current)!=null)
                    index++;      
        }
        return index;
    }
    public int TouchPieceColumn(int Column_Current,int Column_Dest,int Row_Current,int Row_Dest)
    {
        int index=0;
        if(Column_Current>Column_Dest){
            for(int i = Column_Current ; i>Column_Dest ; i--)
                if(Board.GetPiece(Row_Current, i)!=null)
                    index++;
        }
        else if(Column_Current<Column_Dest){
            for(int i = Column_Current ; i<Column_Dest ; i++)
                if(Board.GetPiece(Row_Current, i)!=null)
                    index++;
        }
        return index;
    }
}
