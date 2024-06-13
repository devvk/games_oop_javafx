package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenCreateBishopBlackThenPositionIsCorrect() {
        Cell startPosition = Cell.A1;
        Figure bishopBlack = new BishopBlack(startPosition);
        assertThat(bishopBlack.position()).isEqualTo(startPosition);
    }

    @Test
    void whenCopyBishopBlackThenPositionIsUpdated() {
        Cell startPosition = Cell.A1;
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.H8;
        Figure copiedBishopBlack = bishopBlack.copy(newPosition);
        assertThat(copiedBishopBlack.position()).isEqualTo(newPosition);
    }

    @Test
    void whenBishopBlackMovesThanPathIsCorrect() {
        Cell startPosition = Cell.C1;
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell[] expectedPath = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actualPath = bishopBlack.way(Cell.G5);
        assertThat(actualPath).isEqualTo(expectedPath);
    }
}
