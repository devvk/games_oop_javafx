package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException() throws ImpossibleMoveException {
        Logic logic = new Logic();
        Cell startPosition = Cell.C1;
        Figure bishopBlack = new BishopBlack(startPosition);
        logic.add(bishopBlack);
        Cell newPosition = Cell.H5;
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> logic.move(startPosition, newPosition));
        assertThat(exception.getMessage()).isEqualTo(
                String.format("Could not move by diagonal from %s to %s", startPosition, newPosition
                )
        );
    }

    @Test
    public void whenMoveThenOccupiedCellException() throws ImpossibleMoveException {
        Logic logic = new Logic();
        Cell startPosition = Cell.C1;
        Figure bishopBlack = new BishopBlack(startPosition);
        logic.add(bishopBlack);
        Cell newPosition = Cell.E3;
        Figure queenBlack = new QueenBlack(newPosition);
        logic.add(queenBlack);
        assertThrows(OccupiedCellException.class, () -> logic.move(startPosition, newPosition));
    }
}
