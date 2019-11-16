package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBuilder{

    private List<String> strings;
    private Turn turn;

    GameBuilder(){
        this.strings = new ArrayList<>();
    }

    GameBuilder row(String string){
        this.strings.add(string);
        return this;
    }

    GameBuilder turn(Turn turn){
        this.turn = turn;
        return this;
    }
    Game build(){
        Board board = new Board();
        for (int i=0; i<this.strings.size();i++){
            for (int j=0; j<this.strings.get(i).length();j++){
                char character = this.strings.get(i).charAt(j);
                Piece piece = getPieceFromChar(character);
                if (piece != null){
                    board.put(new Coordinate(i,j),piece);
                }
            }
        }
        if (turn == null) {
            turn = new Turn();
        }
        Game game = new Game();
        game.setBoard(board);
        game.setTurn(turn);
        return game;
    }

    private Piece getPieceFromChar(Character character) {
        Map<Character,Piece> charToPieceMap = new HashMap<>();
        charToPieceMap.put('b',new Pawn(Color.WHITE));
        charToPieceMap.put('B',new Draught(Color.WHITE));
        charToPieceMap.put('n',new Pawn(Color.BLACK));
        charToPieceMap.put('N',new Draught(Color.BLACK));
        return charToPieceMap.get(character);
    }


}
