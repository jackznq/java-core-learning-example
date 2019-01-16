package org.javacore.pattern.memento;

import java.util.ArrayList;
import java.util.List;

//象棋棋子备忘录管理类：负责人
class MementoCaretaker {

    private List<ChessmanMemento> chessmanMementos = new ArrayList<>();

    public ChessmanMemento getMemento(int i) {
        return chessmanMementos.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        chessmanMementos.add(memento);
    }
}
