// decompiled class
import java.util.Random;
public class TeacherAgent extends Agent {
    private Random r = new Random();
    private boolean e = true;
    private int rows;
    private int cols;

    public TeacherAgent(Connect4Game game, boolean iAmRed) {
        super(game, iAmRed);
        rows = myGame.getRowCount();
        cols = myGame.getColumnCount();
    }

    private static int getLowestEmptyIndex(Connect4Column var0) {
        int var1 = -1;

        for (int var2 = 0; var2 < var0.getRowCount(); ++var2) {
            if (!var0.getSlot(var2).getIsFilled()) {
                var1 = var2;
            }
        }

        return var1;
    }

    private boolean a(int var1, int var2) {
        int var3 = 0;

        for (int var4 = var2 - 1; var4 >= 0 && myGame.getColumn(var4).getSlot(var1).getIsFilled() && myGame.getColumn(var4).getSlot(var1).getIsRed() == iAmRed; ++var3) {
            --var4;
        }

        for (int var4 = var2 + 1; var4 < cols && myGame.getColumn(var4).getSlot(var1).getIsFilled() && myGame.getColumn(var4).getSlot(var1).getIsRed() == this.iAmRed; ++var3) {
            ++var4;
        }

        //System.out.println("boolean a: " + var3);
        return var3 >= 3;
    }

    private boolean b(int var1, int var2) {
        int var3 = 0;
        int var4 = var2 - 1;

        int var5;
        for (var5 = var1 - 1; var4 >= 0 && var5 >= 0 && this.myGame.getColumn(var4).getSlot(var5).getIsFilled() && this.myGame.getColumn(var4).getSlot(var5).getIsRed() == this.iAmRed; ++var3) {
            --var4;
            --var5;
        }

        var4 = var2 + 1;

        for (var5 = var1 + 1; var4 < this.cols && var5 < this.rows && this.myGame.getColumn(var4).getSlot(var5).getIsFilled() && this.myGame.getColumn(var4).getSlot(var5).getIsRed() == this.iAmRed; ++var3) {
            ++var4;
            ++var5;
        }

        //System.out.println("boolean b: " + var3);
        return var3 >= 3;
    }

    private boolean c(int var1, int var2) {
        int var3 = 0;
        int var4 = var2 - 1;

        int var5;
        for (var5 = var1 + 1; var4 >= 0 && var5 < this.rows && this.myGame.getColumn(var4).getSlot(var5).getIsFilled() && this.myGame.getColumn(var4).getSlot(var5).getIsRed() == this.iAmRed; ++var3) {
            --var4;
            ++var5;
        }

        var4 = var2 + 1;

        for (var5 = var1 - 1; var4 < this.cols && var5 >= 0 && this.myGame.getColumn(var4).getSlot(var5).getIsFilled() && this.myGame.getColumn(var4).getSlot(var5).getIsRed() == this.iAmRed; ++var3) {
            ++var4;
            --var5;
        }

        //System.out.println("boolean c: " + var3);
        return var3 >= 3;
    }

    private int c() {
        for (int var1 = 0; var1 < this.rows; ++var1) { // loop through rows
            int var2;
            if ((var2 = getLowestEmptyIndex(myGame.getColumn(var1))) != -1) { // if
                for (int var3 = var2; var3 > 3; --var3) {
                    var2 = 0;
                    if (this.a(var3, var1) || this.b(var3, var1) || this.c(var3, var1)) {
                        ++var2;
                    }

                    if (this.a(var3 - 1, var1) || this.b(var3 - 1, var1) || this.c(var3 - 1, var1)) {
                        ++var2;
                    }

                    if (var2 == 2) {
                        System.out.println("int c: return");
                        return var1;
                    }
                }
            }
        }

        System.out.println("int c: return a -1");
        return -1;
    }

    public final void move() {
        int var3;
        int var4;
        if (this.e) {
            char[] var2;
            var3 = (var2 = this.myGame.getBoardMatrix()[this.myGame.getRowCount() - 1]).length;

            for (var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] != 'B') {
                }
            }
        }

        int var6;
        int var7;
        if (!this.iAmRed) {
            var6 = 0;
            var7 = (int) (Math.random() * 2.0D);
            var3 = this.iCanWin();
            var4 = this.theyCanWin();
            int var5 = this.c();
            if (var3 >= 0) {
                this.moveOnColumn(var3);
            } else if (var4 >= 0) {
                this.moveOnColumn(var4);
            } else if (var5 >= 0 && this.e(var5) == -1) {
                this.moveOnColumn(var5);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsFilled() && this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsRed() && !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 1).getIsFilled()) {
                this.moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(2)) == this.myGame.getRowCount() - 2 && this.d(2) == -1 && this.e(2) == -1) {
                this.moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(4)) == this.myGame.getRowCount() - 2 && this.d(4) == -1 && this.e(4) == -1) {
                this.moveOnColumn(4);
            } else if (getLowestEmptyIndex(this.myGame.getColumn(3)) > 0 && this.d(3) == -1 && this.e(3) == -1) {
                this.moveOnColumn(3);
            } else if (var7 % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(2)) > 0 && this.d(2) == -1 && this.e(2) == -1 && this.a(2) == 2) {
                this.moveOnColumn(2);
            } else if (var7 % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(4)) > 0 && this.d(4) == -1 && this.e(4) == -1 && this.b(4) == 4) {
                this.moveOnColumn(4);
            } else if (var7 % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(1)) > 0 && this.d(1) == -1 && this.e(1) == -1) {
                this.moveOnColumn(1);
            } else if (var7 % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(5)) > 0 && this.d(5) == -1 && this.e(5) == -1) {
                this.moveOnColumn(5);
            } else {
                for (var6 = 0; var6 < 200; ++var6) {
                    if ((var7 = this.randomMove()) != this.d(var7) && this.e(var7) != var7) {
                        this.moveOnColumn(var7);
                        break;
                    }
                }
            }

            if (var6 == 200) {
                for (var7 = 0; var7 < this.myGame.getColumnCount(); ++var7) {
                    if (getLowestEmptyIndex(this.myGame.getColumn(var7)) != -1) {
                        this.moveOnColumn(var7);
                        return;
                    }
                }

                this.moveOnColumn(this.randomMove());
            }

        } else {
            var6 = 0;
            var7 = (int) (Math.random() * 2.0D);
            if (this.theyCanWin() >= 0) {
                this.moveOnColumn(this.theyCanWin());
            } else if (this.iCanWin() >= 0) {
                this.moveOnColumn(this.iCanWin());
            } else if (this.c() >= 0) {
                this.moveOnColumn(this.c());
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsFilled() && !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 1).getIsRed() && !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 1).getIsFilled()) {
                this.moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && !this.myGame.getColumn(4).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(2)) == this.myGame.getRowCount() - 2 && this.d(2) == -1 && this.e(2) == -1) {
                this.moveOnColumn(2);
            } else if (this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && !this.myGame.getColumn(3).getSlot(this.myGame.getRowCount() - 2).getIsRed() && this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsFilled() && !this.myGame.getColumn(2).getSlot(this.myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(this.myGame.getColumn(4)) == this.myGame.getRowCount() - 2 && this.d(4) == -1 && this.e(4) == -1) {
                this.moveOnColumn(4);
            } else if (getLowestEmptyIndex(this.myGame.getColumn(3)) > 0 && this.d(3) == -1 && this.e(3) == -1) {
                this.moveOnColumn(3);
            } else if (var7 % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(2)) > 0 && this.d(2) == -1 && this.e(2) == -1 && this.a(2) == 2) {
                this.moveOnColumn(2);
            } else if (var7 % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(4)) > 0 && this.d(4) == -1 && this.e(4) == -1 && this.b(4) == 4) {
                this.moveOnColumn(4);
            } else if (var7 % 2 == 0 && getLowestEmptyIndex(this.myGame.getColumn(1)) > 0 && this.d(1) == -1 && this.e(1) == -1) {
                this.moveOnColumn(1);
            } else if (var7 % 2 == 1 && getLowestEmptyIndex(this.myGame.getColumn(5)) > 0 && this.d(5) == -1 && this.e(5) == -1) {
                this.moveOnColumn(5);
            } else {
                for (var6 = 0; var6 < 200; ++var6) {
                    if ((var3 = this.randomMove()) != this.d(var3) && this.e(var3) != var3) {
                        this.moveOnColumn(var3);
                        break;
                    }
                }
            }

            if (var6 == 200) {
                for (var3 = 0; var3 < this.myGame.getColumnCount(); ++var3) {
                    if (getLowestEmptyIndex(this.myGame.getColumn(var3)) != -1) {
                        this.moveOnColumn(var3);
                        return;
                    }
                }

                this.moveOnColumn(this.randomMove());
            }

        }
        System.out.println("__________________________________________________________________________________");
    }

    private int a(int var1) {
        System.out.println("int a call");
        return (var1 = getLowestEmptyIndex(this.myGame.getColumn(2))) - 1 > 3 && this.myGame.getColumn(3).getSlot(var1 - 1).getIsFilled() && !this.myGame.getColumn(3).getSlot(var1 - 1).getIsRed() && this.myGame.getColumn(4).getSlot(var1 - 1).getIsFilled() && !this.myGame.getColumn(4).getSlot(var1 - 1).getIsRed() ? -1 : 2;
    }

    private int b(int var1) {
        System.out.println("int b call");
        return (var1 = getLowestEmptyIndex(this.myGame.getColumn(4))) - 1 > 3 && this.myGame.getColumn(3).getSlot(var1 - 1).getIsFilled() && !this.myGame.getColumn(3).getSlot(var1 - 1).getIsRed() && this.myGame.getColumn(2).getSlot(var1 - 1).getIsFilled() && !this.myGame.getColumn(2).getSlot(var1 - 1).getIsRed() ? -1 : 4;
    }

    private void moveOnColumn(int var1) {
        int var2;
        if ((var2 = getLowestEmptyIndex(this.myGame.getColumn(var1))) >= 0) {
            Connect4Slot var3 = this.myGame.getColumn(var1).getSlot(var2);
            if (this.iAmRed) {
                var3.addRed();
                return;
            }
            var3.addYellow();
        }
    }

    private int randomMove() {
        int i = r.nextInt(myGame.getColumnCount());
        while (getLowestEmptyIndex(myGame.getColumn(i)) == -1) {
            i = r.nextInt(myGame.getColumnCount());
        }
        return i;
    }

    private int theyCanWin() { // assume that you are yellow and your opponent is red.
        Connect4Column var2;
        int var3;
        int var4;
        // check horizontally
        for (int i = 0; i < this.myGame.getColumnCount(); ++i) { // loop through columns (laid out vertically from left to right)
            if (!(var2 = this.myGame.getColumn(i)).getIsFull()) { // check if column is available to even put one in. can be empty too
                var3 = 0;

                for (var4 = 0; var4 < var2.getRowCount(); ++var4) { // loop through each column (bottom to top). count consecutive.
                    if (var2.getSlot(var4).getIsFilled()) { // if the slot is filled
                        if (!var2.getSlot(var4).getIsRed()) {
                            break; // skip column if it detects a yellow
                        }

                        ++var3; // if there are 3 reds in a column then move there to block it.
                        if (var3 == 3) {
                            System.out.println("theyCanWin return: " + i);
                            return i;
                        }
                    }
                }
            }
        }

        int var5;
        for (int i = 0; i < this.myGame.getColumnCount(); ++i) {
            if (!(var2 = this.myGame.getColumn(i)).getIsFull()) { // can be empty too
                var3 = var2.getRowCount() - 1; // should be the top row

                for (var4 = 0; var4 < var2.getRowCount(); ++var4) { // loop through each column (bottom to top)
                    if (var2.getSlot(var4).getIsFilled()) { // starting from the bottom, if something is filled then decrease the top. count the amount or index available?
                        var3 = var4 - 1;
                        break;
                    }
                }

                var4 = 0;

                // count the number of full columns with the top slot as a red. but exclude the current column.
                // loop through the columns going backwards (right to left). if the column is filled and the top slot is a red, then increment
                for (var5 = i - 1; var5 >= 0 && this.myGame.getColumn(var5).getSlot(var3).getIsFilled() && this.myGame.getColumn(var5).getSlot(var3).getIsRed(); --var5) {
                    ++var4;
                }

                // loop through the columns going forwards (left to right). if the column is filled and the top slot is red, then increment.
                for (var5 = i + 1; var5 < this.myGame.getColumnCount() && this.myGame.getColumn(var5).getSlot(var3).getIsFilled() && this.myGame.getColumn(var5).getSlot(var3).getIsRed(); ++var5) {
                    ++var4;
                }

                if (var4 >= 3) {
                    System.out.println("theyCanWin return 2: " + i);
                    return i;
                }
            }
        }

        for (int i = 0; i < this.myGame.getColumnCount(); ++i) {
            if ((var3 = getLowestEmptyIndex(var2 = this.myGame.getColumn(i))) != -1) { // if the column has at least one slot filled, var3 is the lowest slot
                var4 = 0;
                var5 = i - 1; // index of the left column

                int var6;
                for (var6 = var3 - 1; var5 >= 0 && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                    // var4 is the number of columns to the left with the (top filled) red/enemy slots
                    ++var4;
                    --var5;
                }

                var6 = var3 + 1;

                for (var5 = i + 1; var5 < this.myGame.getColumnCount() && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                    // var4 is the number of columns to the right with the (top filled) red/enemy slots
                    ++var4;
                    ++var5;
                }

                if (var4 >= 3) { // if the number of columns excluding current has the top slot as red then they can win.
                    System.out.println("theyCanWin return 3: " + i);
                    return i;
                }

                var4 = 0;
                var5 = i - 1; // index of the left column

                // starting from one column to the right and going left, if the column has a top slot that is red then increment var4
                for (var6 = var3 + 1; var5 >= 0 && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                    ++var4;
                    --var5;
                }

                var6 = var3 - 1;

                // starting from one column to the right and it's not the most left row and going right, if the top slot is red then increment var4
                for (var5 = i + 1; var5 < this.myGame.getColumnCount() && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                    ++var4;
                    ++var5;
                }

                if (var4 >= 3) {
                    System.out.println("theyCanWin return 4: " + i);
                    return i;
                }
            }
        }

        System.out.println("theyCanWin return a -1");
        return -1;
    }

    private int iCanWin() { // you are yellow and your opponent is red
        int col;
        Connect4Column currentColumn;
        int lowest;
        int diagonalCounter;
        // column checking. simple vertical win.
        for (col = 0; col < this.myGame.getColumnCount(); ++col) { // loop through columns
            if (!(currentColumn = this.myGame.getColumn(col)).getIsFull()) { // if the column is not full. can be empty
                lowest = 0;

                for (diagonalCounter = 0; diagonalCounter < currentColumn.getRowCount(); ++diagonalCounter) { // loop through bottom to top
                    if (currentColumn.getSlot(diagonalCounter).getIsFilled()) { // if it is filled
                        if (currentColumn.getSlot(diagonalCounter).getIsRed()) { // if it is red then skip column
                            break;
                        }

                        ++lowest;
                        if (lowest == 3) {
                            System.out.println("iCanWin return: " + col);
                            return col;
                        }
                    }
                }
            }
        }

        // top horizontal checking.
        int traverse;
        for (col = 0; col < this.myGame.getColumnCount(); ++col) { // loop through columns
            if (!(currentColumn = this.myGame.getColumn(col)).getIsFull()) { // if it's available
                lowest = currentColumn.getRowCount() - 1; // top slot

                for (diagonalCounter = 0; diagonalCounter < currentColumn.getRowCount(); ++diagonalCounter) {
                    if (currentColumn.getSlot(diagonalCounter).getIsFilled()) {
                        lowest = diagonalCounter - 1; // get the most top filled slot of the column
                        break;
                    }
                }

                diagonalCounter = 0;

                // count to the left. if the column has a top slot that is filled and it is yellow then increment.
                for (traverse = col - 1; traverse >= 0 && this.myGame.getColumn(traverse).getSlot(lowest).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(lowest).getIsRed(); --traverse) {
                    ++diagonalCounter;
                }

                // count to the right. if the column has a top slot that is filled and it is yellow then increment. because there's only 7
                for (traverse = col + 1; traverse < this.myGame.getColumnCount() && this.myGame.getColumn(traverse).getSlot(lowest).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(lowest).getIsRed(); ++traverse) {
                    ++diagonalCounter;
                }

                if (diagonalCounter >= 3) {
                    System.out.println("iCanWin return 2: " + col); // return this column
                    return col;
                }
            }
        }

        for (col = 0; col < this.myGame.getColumnCount(); ++col) {
            if ((lowest = getLowestEmptyIndex(currentColumn = this.myGame.getColumn(col))) != -1) { // check if it has at least one
                diagonalCounter = 0;
                traverse = col - 1; // column to the left. traversing columns

                // checking bottom left to top right
                // traverse columns from right to left, starting from the column to the left of it. check diagonals
                // doing left side
                int row;
                for (row = lowest - 1; traverse >= 0 && row >= 0 && this.myGame.getColumn(traverse).getSlot(row).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(row).getIsRed(); --row) {
                    //going from the filled top of the col down. if the diagonal row (top right to bottom left) is filled with my color
                    ++diagonalCounter;
                    --traverse;
                }

                row = lowest + 1;

                // traverse columns from left to right, starting from the column to the right of it. checking diagonals going from bottom left to top right
                for (traverse = col + 1; traverse < this.myGame.getColumnCount() && row < currentColumn.getRowCount() && this.myGame.getColumn(traverse).getSlot(row).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(row).getIsRed(); ++row) {
                    ++diagonalCounter;
                    ++traverse;
                }

                if (diagonalCounter >= 3) {
                    System.out.println("iCanWin return 3: " + col);
                    return col;
                }

                diagonalCounter = 0;
                traverse = col - 1; // start from the left
                // do bottom right to top left
                // doing right side
                for (row = lowest + 1; traverse >= 0 && row < currentColumn.getRowCount() && this.myGame.getColumn(traverse).getSlot(row).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(row).getIsRed(); ++row) {
                    // loop through the rows starting from one above the empty slot?
                    ++diagonalCounter;
                    --traverse; // go from left column to the left
                }

                row = lowest - 1;

                // doing right side
                for (traverse = col + 1; traverse < this.myGame.getColumnCount() && row >= 0 && this.myGame.getColumn(traverse).getSlot(row).getIsFilled() && !this.myGame.getColumn(traverse).getSlot(row).getIsRed(); --row) {
                    ++diagonalCounter;
                    ++traverse;
                }

                if (diagonalCounter >= 3) {
                    System.out.println("iCanWin return 4: " + col);
                    return col;
                }
            }
        }

        return -1;
    }

    private int d(int var1) {
        Connect4Column var2;
        int var3;
        if ((var3 = getLowestEmptyIndex(var2 = this.myGame.getColumn(var1))) != -1 && var3 != 0) {
            --var3;
            int var4 = 0;
            int var5 = var1 - 1;

            int var6;
            for (var6 = var3 - 1; var5 >= 0 && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                ++var4;
                --var5;
            }

            var6 = var3 + 1;

            for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                ++var4;
                ++var5;
            }

            if (var4 >= 3) {
                System.out.println("int d return: " + var1);
                return var1;
            } else {
                var4 = 0;
                var5 = var1 - 1;

                for (var6 = var3 + 1; var5 >= 0 && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                    ++var4;
                    --var5;
                }

                var6 = var3 - 1;

                for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                    ++var4;
                    ++var5;
                }

                if (var4 >= 3) {
                    System.out.println("int d return 2: " + var1);
                    return var1;
                } else {
                    var6 = var3;
                    var4 = 0;

                    for (var5 = var1 - 1; var5 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var5) {
                        ++var4;
                    }

                    for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && !this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var5) {
                        ++var4;
                    }

                    System.out.println("int d return 3: " + var1);
                    return var4 >= 3 ? var1 : -1;
                }
            }
        } else {
            System.out.println("int d return a -1");
            return -1;
        }
    }

    private int e(int var1) {
        System.out.println("second e called");
        Connect4Column var2;
        int var3;
        if ((var3 = getLowestEmptyIndex(var2 = this.myGame.getColumn(var1))) != -1 && var3 != 0) {
            --var3;
            int var4 = 0;
            int var5 = var1 - 1;

            int var6;
            for (var6 = var3 - 1; var5 >= 0 && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                ++var4;
                --var5;
            }

            var6 = var3 + 1;

            for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                ++var4;
                ++var5;
            }

            if (var4 >= 3) {
                System.out.println("int e return: " + var1);
                return var1;
            } else {
                var4 = 0;
                var5 = var1 - 1;

                for (var6 = var3 + 1; var5 >= 0 && var6 < var2.getRowCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var6) {
                    ++var4;
                    --var5;
                }

                var6 = var3 - 1;

                for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && var6 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var6) {
                    ++var4;
                    ++var5;
                }

                if (var4 >= 3) {
                    System.out.println("int e return 2: " + var1);
                    return var1;
                } else {
                    var6 = var3;
                    var4 = 0;

                    for (var5 = var1 - 1; var5 >= 0 && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); --var5) {
                        ++var4;
                    }

                    for (var5 = var1 + 1; var5 < this.myGame.getColumnCount() && this.myGame.getColumn(var5).getSlot(var6).getIsFilled() && this.myGame.getColumn(var5).getSlot(var6).getIsRed(); ++var5) {
                        ++var4;
                    }

                    System.out.println("int e return 3: " + var1);
                    return var4 >= 3 ? var1 : -1;
                }
            }
        } else {
            System.out.println("int e return a -1");
            return -1;
        }
    }

    public final String getName() {
        return "Teacher Agent";
    }
}
