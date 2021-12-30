import java.util.Random;

public class TeacherAgent2 extends Agent {
    Random r;
    int count = 0;
    boolean getCount = true;
    int row;
    int col;
    int doubleThreatIndex = -1;

    public TeacherAgent2(Connect4Game game, boolean iAmRed) {
        super(game, iAmRed);
        this.r = new Random();
        this.row = this.myGame.getRowCount();
        this.col = this.myGame.getColumnCount();
    }

    private boolean horizontal(int currRow, int currCol) {
        int n = 0;
        int cols = currCol - 1;
        while (cols >= 0 && this.myGame.getColumn(cols).getSlot(currRow).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(currRow).getIsRed() == this.iAmRed) {
            cols--;
            n++;
        }
        cols = currCol + 1;
        while (cols < this.col && this.myGame.getColumn(cols).getSlot(currRow).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(currRow).getIsRed() == this.iAmRed) {
            cols++;
            n++;
        }
        return (n >= 3);
    }

    private boolean diagonalD(int currRow, int currCol) {
        int n = 0;
        int cols = currCol - 1;
        int rows = currRow - 1;
        while (cols >= 0 && rows >= 0 && this.myGame.getColumn(cols).getSlot(rows).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(rows).getIsRed() == this.iAmRed) {
            cols--;
            rows--;
            n++;
        }
        cols = currCol + 1;
        rows = currRow + 1;
        while (cols < this.col && rows < this.row && this.myGame.getColumn(cols).getSlot(rows).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(rows).getIsRed() == this.iAmRed) {
            cols++;
            rows++;
            n++;
        }
        return (n >= 3);
    }

    private boolean diagonalI(int currRow, int currCol) {
        int n = 0;
        int cols = currCol - 1;
        int rows = currRow + 1;
        while (cols >= 0 && rows < this.row && this.myGame.getColumn(cols).getSlot(rows).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(rows).getIsRed() == this.iAmRed) {
            cols--;
            rows++;
            n++;
        }
        cols = currCol + 1;
        rows = currRow - 1;
        while (cols < this.col && rows >= 0 && this.myGame.getColumn(cols).getSlot(rows).getIsFilled() && this.myGame
                .getColumn(cols).getSlot(rows).getIsRed() == this.iAmRed) {
            cols++;
            rows--;
            n++;
        }
        if (n >= 3)
            return true;
        return false;
    }

    private int checkdoubleThreats() {
        for (int j = 0; j < this.row; j++) {
            int lowest = getLowestEmptyIndex(this.myGame.getColumn(j));
            if (lowest != -1) {
                int threats = 0;
                for (int i = lowest; i > 3; i--) {
                    threats = 0;
                    if (horizontal(i, j) || diagonalD(i, j) || diagonalI(i, j))
                        threats++;
                    if (horizontal(i - 1, j) || diagonalD(i - 1, j) || diagonalI(i - 1, j))
                        threats++;
                    if (threats == 2)
                        return j;
                }
            }
        }
        return -1;
    }

    private void count() {
        char[][] m = this.myGame.getBoardMatrix();
        for (char c : m[this.myGame.getRowCount() - 1]) {
            if (c != 'B')
                this.count = 1;
        }
    }

    private void checkZZ() {
        if (this.count % 2 == 0) ;
    }

    public void move() {
        if (this.getCount)
            count();
        if (!this.iAmRed) {
            int i = 0;
            int j = (int) (Math.random() * 2.0D);
            int tcw = theyCanWin();
            int icw = iCanWin();
            int dt = checkdoubleThreats();
            if (tcw > -1) {
                moveOnColumn(tcw);
            } else if (icw > -1) {
                moveOnColumn(icw);
            } else if (dt > -1 && ICanWinOffOfMyPlay(dt) == -1) {
                moveOnColumn(dt);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsFilled() && this.myGame
                    .getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsRed() && !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 1).getIsFilled()) {
                moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame
                    .getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame
                    .getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(2)) == this.myGame.getRowCount() - 2 &&
                    theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
                moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame
                    .getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame
                    .getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(4)) == this.myGame.getRowCount() - 2 &&
                    theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
                moveOnColumn(4);
            } else if (getLowestEmptyIndex(this.myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
                moveOnColumn(3);
            } else if (j % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 &&
                    setsUp3fromCol2(2) == 2) {
                moveOnColumn(2);
            } else if (j % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 &&
                    setsUp3fromCol4(4) == 4) {
                moveOnColumn(4);
            } else if (j % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
                moveOnColumn(1);
            } else if (j % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
                moveOnColumn(5);
            } else {
                i = 0;
                while (i < 200) {
                    int k = randomMove();
                    if (k != theyCanWinOffOfMyPlay(k) && ICanWinOffOfMyPlay(k) != k) {
                        moveOnColumn(k);
                        break;
                    }
                    i++;
                }
            }
            if (i == 200) {
                for (int x = 0; x < this.myGame.getColumnCount(); x++) {
                    if (getLowestEmptyIndex(this.myGame.getColumn(x)) != -1) {
                        moveOnColumn(x);
                        return;
                    }
                }
                moveOnColumn(randomMove());
            }
            return;
        }
        int c = 0;
        int rand = (int) (Math.random() * 2.0D);
        if (iCanWin() > -1) {
            moveOnColumn(iCanWin());
        } else if (theyCanWin() > -1) {
            moveOnColumn(theyCanWin());
        } else if (checkdoubleThreats() > -1) {
            moveOnColumn(checkdoubleThreats());
        } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsFilled() &&
                !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsRed() && !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 1).getIsFilled()) {
            moveOnColumn(2);
        } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() &&
                !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsFilled() &&
                !this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(2)) == this.myGame.getRowCount() - 2 &&
                theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
            moveOnColumn(2);
        } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() &&
                !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsFilled() &&
                !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(4)) == this.myGame.getRowCount() - 2 &&
                theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
            moveOnColumn(4);
        } else if (getLowestEmptyIndex(this.myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
            moveOnColumn(3);
        } else if (rand % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 &&
                setsUp3fromCol2(2) == 2) {
            moveOnColumn(2);
        } else if (rand % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 &&
                setsUp3fromCol4(4) == 4) {
            moveOnColumn(4);
        } else if (rand % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
            moveOnColumn(1);
        } else if (rand % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
            moveOnColumn(5);
        } else {
            c = 0;
            while (c < 200) {
                int i = randomMove();
                if (i != theyCanWinOffOfMyPlay(i) && ICanWinOffOfMyPlay(i) != i) {
                    moveOnColumn(i);
                    break;
                }
                c++;
            }
        }
        if (c == 200) {
            for (int x = 0; x < this.myGame.getColumnCount(); x++) {
                if (getLowestEmptyIndex(this.myGame.getColumn(x)) != -1) {
                    moveOnColumn(x);
                    return;
                }
            }
            moveOnColumn(randomMove());
        }
    }

    public int setsUp3fromCol2(int spot) {
        int lowest = getLowestEmptyIndex(this.myGame.getColumn(spot));
        if (lowest - 1 > 3 && this.myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsFilled() &&
                !this.myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsRed() && this.myGame
                .getColumn(spot + 2).getSlot(lowest - 1).getIsFilled() &&
                !this.myGame.getColumn(spot + 2).getSlot(lowest - 1).getIsRed())
            return -1;
        return 2;
    }

    public int setsUp3fromCol4(int spot) {
        int lowest = getLowestEmptyIndex(this.myGame.getColumn(spot));
        if (lowest - 1 > 3 && this.myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsFilled() &&
                !this.myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsRed() && this.myGame
                .getColumn(spot - 2).getSlot(lowest - 1).getIsFilled() &&
                !this.myGame.getColumn(spot - 2).getSlot(lowest - 1).getIsRed())
            return -1;
        return 4;
    }

    public void moveOnColumn(int columnNumber) {
        this.count += 2;
        int lowestEmptySlotIndex = getLowestEmptyIndex(this.myGame.getColumn(columnNumber));
        if (lowestEmptySlotIndex > -1) {
            Connect4Slot lowestEmptySlot = this.myGame.getColumn(columnNumber).getSlot(lowestEmptySlotIndex);
            if (this.iAmRed) {
                lowestEmptySlot.addRed();
            } else {
                lowestEmptySlot.addYellow();
            }
        }
    }

    public int getLowestEmptyIndex(Connect4Column column) {
        int lowestEmptySlot = -1;
        for (int i = 0; i < column.getRowCount(); i++) {
            if (!column.getSlot(i).getIsFilled())
                lowestEmptySlot = i;
        }
        return lowestEmptySlot;
    }

    public int randomMove() {
        int i = this.r.nextInt(this.myGame.getColumnCount());
        while (getLowestEmptyIndex(this.myGame.getColumn(i)) == -1)
            i = this.r.nextInt(this.myGame.getColumnCount());
        return i;
    }

    public int iCanWin() {
        int i;
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            if (!test.getIsFull()) {
                int count = 0;
                for (int j = 0; j < test.getRowCount(); j++) {
                    if (test.getSlot(j).getIsFilled()) {
                        if (!test.getSlot(j).getIsRed())
                            break;
                        count++;
                        if (count == 3)
                            return i;
                    }
                }
            }
        }
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            if (!test.getIsFull()) {
                int spot = test.getRowCount() - 1;
                for (int j = 0; j < test.getRowCount(); ) {
                    if (!test.getSlot(j).getIsFilled()) {
                        j++;
                        continue;
                    }
                    spot = j - 1;
                }
                int count = 0;
                int col = i - 1;
                while (col >= 0 && this.myGame.getColumn(col).getSlot(spot).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(spot).getIsRed()) {
                    count++;
                    col--;
                }
                col = i + 1;
                while (col < this.myGame.getColumnCount() && this.myGame.getColumn(col).getSlot(spot).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(spot).getIsRed()) {
                    count++;
                    col++;
                }
                if (count >= 3)
                    return i;
            }
        }
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            int emptySpot = getLowestEmptyIndex(test);
            if (emptySpot != -1) {
                int count = 0;
                int col = i - 1;
                int row = emptySpot - 1;
                while (col >= 0 && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col--;
                    row--;
                }
                row = emptySpot + 1;
                col = i + 1;
                while (col < this.myGame.getColumnCount() && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col++;
                    row++;
                }
                if (count >= 3)
                    return i;
                count = 0;
                col = i - 1;
                row = emptySpot + 1;
                while (col >= 0 && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col--;
                    row++;
                }
                row = emptySpot - 1;
                col = i + 1;
                while (col < this.myGame.getColumnCount() && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                        .getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col++;
                    row--;
                }
                if (count >= 3)
                    return i;
            }
        }
        return -1;
    }

    public int theyCanWin() {
        int i;
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            if (!test.getIsFull()) {
                int count = 0;
                for (int j = 0; j < test.getRowCount(); j++) {
                    if (test.getSlot(j).getIsFilled()) {
                        if (test.getSlot(j).getIsRed() == true)
                            break;
                        count++;
                        if (count == 3)
                            return i;
                    }
                }
            }
        }
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            if (!test.getIsFull()) {
                int spot = test.getRowCount() - 1;
                for (int j = 0; j < test.getRowCount(); ) {
                    if (!test.getSlot(j).getIsFilled()) {
                        j++;
                        continue;
                    }
                    spot = j - 1;
                }
                int count = 0;
                int col = i - 1;
                while (col >= 0 && this.myGame.getColumn(col).getSlot(spot).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(spot).getIsRed()) {
                    count++;
                    col--;
                }
                col = i + 1;
                while (col < this.myGame.getColumnCount() && this.myGame.getColumn(col).getSlot(spot).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(spot).getIsRed()) {
                    count++;
                    col++;
                }
                if (count >= 3)
                    return i;
            }
        }
        for (i = 0; i < this.myGame.getColumnCount(); i++) {
            Connect4Column test = this.myGame.getColumn(i);
            int emptySpot = getLowestEmptyIndex(test);
            if (emptySpot != -1) {
                int count = 0;
                int col = i - 1;
                int row = emptySpot - 1;
                while (col >= 0 && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col--;
                    row--;
                }
                row = emptySpot + 1;
                col = i + 1;
                while (col < this.myGame.getColumnCount() && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col++;
                    row++;
                }
                if (count >= 3)
                    return i;
                count = 0;
                col = i - 1;
                row = emptySpot + 1;
                while (col >= 0 && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col--;
                    row++;
                }
                row = emptySpot - 1;
                col = i + 1;
                while (col < this.myGame.getColumnCount() && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                        !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
                    count++;
                    col++;
                    row--;
                }
                if (count >= 3)
                    return i;
            }
        }
        return -1;
    }

    public int theyCanWinOffOfMyPlay(int i) {
        Connect4Column test = this.myGame.getColumn(i);
        int emptySpot = getLowestEmptyIndex(test);
        if (emptySpot == -1 || emptySpot == 0)
            return -1;
        emptySpot--;
        int count = 0;
        int col = i - 1;
        int row = emptySpot - 1;
        while (col >= 0 && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
            row--;
        }
        row = emptySpot + 1;
        col = i + 1;
        while (col < this.myGame.getColumnCount() && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
            row++;
        }
        if (count >= 3)
            return i;
        count = 0;
        col = i - 1;
        row = emptySpot + 1;
        while (col >= 0 && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
            row++;
        }
        row = emptySpot - 1;
        col = i + 1;
        while (col < this.myGame.getColumnCount() && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
            row--;
        }
        if (count >= 3)
            return i;
        row = emptySpot;
        count = 0;
        col = i - 1;
        while (col >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
        }
        col = i + 1;
        while (col < this.myGame.getColumnCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() &&
                !this.myGame.getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
        }
        if (count >= 3)
            return i;
        return -1;
    }

    public int ICanWinOffOfMyPlay(int i) {
        Connect4Column test = this.myGame.getColumn(i);
        int emptySpot = getLowestEmptyIndex(test);
        if (emptySpot == -1 || emptySpot == 0)
            return -1;
        emptySpot--;
        int count = 0;
        int col = i - 1;
        int row = emptySpot - 1;
        while (col >= 0 && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
            row--;
        }
        row = emptySpot + 1;
        col = i + 1;
        while (col < this.myGame.getColumnCount() && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
            row++;
        }
        if (count >= 3)
            return i;
        count = 0;
        col = i - 1;
        row = emptySpot + 1;
        while (col >= 0 && row < test.getRowCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
            row++;
        }
        row = emptySpot - 1;
        col = i + 1;
        while (col < this.myGame.getColumnCount() && row >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
            row--;
        }
        if (count >= 3)
            return i;
        row = emptySpot;
        count = 0;
        col = i - 1;
        while (col >= 0 && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col--;
        }
        col = i + 1;
        while (col < this.myGame.getColumnCount() && this.myGame.getColumn(col).getSlot(row).getIsFilled() && this.myGame
                .getColumn(col).getSlot(row).getIsRed()) {
            count++;
            col++;
        }
        if (count >= 3)
            return i;
        return -1;
    }

    public String getName() {
        return "Teacher Agent 2";
    }
}
