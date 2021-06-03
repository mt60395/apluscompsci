public class MyAgent extends Agent {
    /**
     * Constructs a new agent, giving it the game and telling it whether it is Red or Yellow.
     *
     * @param game The game the agent will be playing.
     * @param iAmRed True if the agent is Red, False if the agent is Yellow.
     */
    public MyAgent(Connect4Game game, boolean iAmRed) {
        super(game, iAmRed);
    }

    /**
     * The move method is run every time it is this agent's turn in the game. You may assume that
     * when move() is called, the game has at least one open slot for a token, and the game has not
     * already been won.
     *
     * By the end of the move method, the agent should have placed one token into the game at some
     * point.
     *
     * After the move() method is called, the game engine will check to make sure the move was
     * valid. A move might be invalid if: - No token was place into the game. - More than one token
     * was placed into the game. - A previous token was removed from the game. - The color of a
     * previous token was changed. - There are empty spaces below where the token was placed.
     *
     * If an invalid move is made, the game engine will announce it and the game will be ended.
     *
     */
    public void move() {
        if (iCanWin() != - 1) {
            moveOnColumn(iCanWin());
        }
        else if (theyCanWin() != -1) {
            moveOnColumn(theyCanWin());
        }
        else if (pairCheck() != -1) {
            moveOnColumn(pairCheck());
        }
        else {
            boolean[] blacklist = getBlacklistedColumns(true);
            boolean[] greylist = getBlacklistedColumns(false);

            int count = 0;
            for (boolean b: blacklist) {
                if (b) count++;
            }
            if (count == myGame.getColumnCount()) { // last resort: draw
                moveOnColumn(randomMove());
                return;
            }

            // stack in the middle columns, stretching out
            // inspiration from what the teacher agent does i guess
            for (int i = 0; i < myGame.getColumnCount() / 2; i++) { // ASSUMPTION OF BOARD DIMENSIONS
                int mid = myGame.getColumnCount() / 2;
                if (stackColumn(greylist, mid + i) != -1) {
                    moveOnColumn(mid + i);
                    return;
                }
                if (stackColumn(greylist, mid - i) != -1) {
                    moveOnColumn(mid - i);
                    return;
                }
            }
            // good moves have been exhausted by this point

            for (int i = 0; i < greylist.length; i++) {
                if (greylist[i] && !blacklist[i]) { // if it's true in the greylist then it's OK but not bad
                    moveOnColumn(i);
                    return;
                }
            }
            // ok moves have been exhausted by this point

            moveOnColumn(randomMove());
        }
    }

    /**
     * Drops a token into a particular column so that it will fall to the bottom of the column. If
     * the column is already full, nothing will change.
     *
     * @param columnNumber The column into which to drop the token.
     */
    public void moveOnColumn(int columnNumber) {
        int lowestEmptySlotIndex = getLowestEmptyIndex(myGame.getColumn(columnNumber));   // Find the top empty slot in the column
        // If the column is full, lowestEmptySlot will be -1
        if (lowestEmptySlotIndex > -1) // if the column is not full
        {
            Connect4Slot lowestEmptySlot = myGame.getColumn(columnNumber).getSlot(lowestEmptySlotIndex);  // get the slot in this column at this index
            if (iAmRed) // If the current agent is the Red player...
            {
                lowestEmptySlot.addRed(); // Place a red token into the empty slot
            } else // If the current agent is the Yellow player (not the Red player)...
            {
                lowestEmptySlot.addYellow(); // Place a yellow token into the empty slot
            }
        }
    }

    /**
     * Returns the index of the top empty slot in a particular column.
     *
     * @param column The column to check.
     * @return the index of the top empty slot in a particular column; -1 if the column is already
     * full.
     */
    public int getLowestEmptyIndex(Connect4Column column) {
        int lowestEmptySlot = -1;
        for (int i = 0; i < column.getRowCount(); i++) {
            if (!column.getSlot(i).getIsFilled()) {
                lowestEmptySlot = i;
            }
        }
        return lowestEmptySlot;
    }

    /**
     * Returns a random valid move. If your agent doesn't know what to do, making a random move can
     * allow the game to go on anyway.
     *
     * @return a random valid move.
     */
    public int randomMove() {
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            if (!myGame.getColumn(i).getIsFull()) {
                return i;
            }
        }
        return -1; // no way this should happen
    }

    /**
     * Returns the column that would allow the agent to win.
     *
     * You might want your agent to check to see if it has a winning move available to it so that it
     * can go ahead and make that move. Implement this method to return what column would allow the
     * agent to win.
     *
     * @return the column that would allow the agent to win.
     */
    public int iCanWin() {
        return canWin(iAmRed);
    }

    /**
     * Returns the column that would allow the opponent to win.
     *
     * You might want your agent to check to see if the opponent would have any winning moves
     * available so your agent can block them. Implement this method to return what column should be
     * blocked to prevent the opponent from winning.
     *
     * @return the column that would allow the opponent to win.
     */
    public int theyCanWin() {
        return canWin(!iAmRed);
    }

    /**
     * Returns the name of this agent.
     *
     * @return the agent's name
     */
    public String getName() {
        return "My Agent";
    }

    // custom methods

    /**
     * Returns if the provided color can win with the next move.
     *
     * @param toCheck the color; iAmRed is my agent and !iAmRed is the other agent
     * @return the column that would allow the provided agent/color to win
     */
    public int canWin(boolean toCheck) {
        // checking columns. color on top doesn't matter, one needs to be placed if 3 in a row
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            if (longestRunVertical(i) == 3 && !myGame.getColumn(i).getIsFull()) {
                return i;
            }
        }

        // checking rows
        // this algorithm differs from canWinInTwo because it needs to check if the slot under is valid or not
	    // @TODO fix. literally just use getLowestEmptyIndex. loop through columns instead of rows
        for (int i = myGame.getRowCount() - 1; i >= 0; i--) {
            char[] row = getRow(i);
            if (isEmpty(row)) {
                break;
            }
            int count = countRow(row, toCheck);
            if (count >= 3) {
                char[] rowUnder; // bottom row to make sure the slot isn't getting faked out
                if (i + 1 == myGame.getRowCount()) { // it is the bottom row. no need to worry
                    rowUnder = new char[0];
                }
                else {
                    rowUnder = getRow(i + 1);
                }
                int index = testRow(row, rowUnder, toCheck); // find a valid column in the row that would lead to a win
                if (index != -1) {
                    return index;
                }
            }
        }

        // checking diagonals
        for (int col = 0; col < myGame.getColumnCount(); col++) {
            Connect4Column c = myGame.getColumn(col);
            int lowest = getLowestEmptyIndex(c);
            if (!c.getIsFull()) {
                // make positive diagonals
                if (getDiagonalCount(col, lowest, toCheck, true) >= 3) {
                    return col;
                }
                // make negative diagonals
                if (getDiagonalCount(col, lowest, toCheck, false) >= 3) {
                    return col;
                }
            }
        }
        return -1;
    }

    /**
     * Returns if placing a slot in a column would allow an agent to win with the next move.
     *
     * @param col the column to check
     * @param toCheck the agent to check
     * @return if an agent can win within the next two moves
     */
    public boolean canWinInTwo(int col, boolean toCheck) {
        Connect4Column c = myGame.getColumn(col);
        if (c.getIsFull()) return false;

        int lowest = getLowestEmptyIndex(c) - 1; // can win is just checking one spot above

        // no vertical checking, you are literally denying a vertical win if you place something in a column
        // check horizontal first
        if (lowest >= 0) {
            char[] row = getRow(lowest);
            if (!isEmpty(row)) {
                int count = 0;
                // traverse through the right side of the row
                for (int colTraverse = col + 1; colTraverse < myGame.getColumnCount(); colTraverse++) {
                    Connect4Slot slot = myGame.getColumn(colTraverse).getSlot(lowest);
                    if (slot.getIsFilled() && slot.getIsRed() == toCheck) {
                        count++; // until the streak stops
                    }
                    else {
                        break;
                    }
                }
                // traverse through the left side of the row
                for (int colTraverse = col - 1; colTraverse >= 0; colTraverse--) {
                    Connect4Slot slot = myGame.getColumn(colTraverse).getSlot(lowest);
                    if (slot.getIsFilled() && slot.getIsRed() == toCheck) {
                        count++; // until the streak stops
                    }
                    else {
                        break;
                    }
                }
                if (count >= 3) {
                    return true;
                }
            }
        }

        // then check diagonal. it's the same as checking diagonal normally just one above
        if (getDiagonalCount(col, lowest, toCheck, true) >= 3) {
            return true;
        }
        return getDiagonalCount(col, lowest, toCheck, false) >= 3;
    }

    // VERTICAL CHECKS

    /**
     * Returns the running count for the top color in a column.
     *
     * @param col the column to check
     * @return the max count, 1 to 3
     */
    public int longestRunVertical(int col) {
        // do it from the top
        int count = 0;
        Connect4Column c = myGame.getColumn(col);
        // needs to start with the top color
        int rowStart = getLowestEmptyIndex(c) + 1;
        for (int row = rowStart; row < myGame.getRowCount(); row++) {
            Connect4Slot slot = c.getSlot(row);
            boolean topSlot = c.getSlot(rowStart).getIsRed();
            if (slot.getIsRed() == topSlot) {
                count++;
                if (count == 3) {
                    return 3;
                }
            }
            else {
                return count;
            }
        }
        return 0;
    }

    // HORIZONTAL CHECKS

    /**
     * Returns a char array representation of the row.
     *
     * @param r the row index to create the representation of
     * @return the char array representation of the row
     */
    public char[] getRow(int r) {
        char[] row = new char[myGame.getColumnCount()];
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            char status;
            Connect4Column c = myGame.getColumn(i);
            if (c.getSlot(r).getIsFilled()) {
                if (c.getSlot(r).getIsRed()) {
                    status = 'R';
                }
                else {
                    status = 'Y';
                }
            }
            else {
                status = '-';
            }
           row[i] = status;
        }
        return row;
    }

    /**
     * Returns the count of a color in a row.
     *
     * @param row the char representation of the row
     * @param color the color to check
     * @return the count of the color in the row
     */
    public int countRow(char[] row, boolean color) {
        int count = 0;
        for (char ch: row) {
            if (ch == 'R' && color) {
                count++;
            }
            else if (ch == 'Y' && !color) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns if a row is empty.
     *
     * @param row the char representation of the row
     * @return if a row is empty
     */
    public boolean isEmpty(char[] row) {
        for (char ch: row) {
            if (ch != '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * Tests an entire row for all of its empty slots. If an empty slot is filled and will make a
     * continuous pattern of 4, then the slot / column index is returned.
     *
     * @param row the row, represented by chars
     * @param rowUnder the row under to make sure the slot will be dropped to the correct level
     * @param color the color to check
     * @return the column index that will cause a win, needs to be filled urgently
     */
    public int testRow(char[] row, char[] rowUnder, boolean color) { // test for true:red or false: yellow
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '-') {
                if (rowUnder.length != 0) {
                    if (rowUnder[i] == '-') {
                        break;
                    }
                }
                char[] temp = new char[row.length];
                System.arraycopy(row, 0, temp, 0, row.length);
                char status = color?'R':'Y';
                temp[i] = status;
                int count = 0;
                for (char ch: temp) {
                    if (ch == status) {
                        count++;
                    }
                    else {
                        count = 0;
                    }

                    if (count == 4) return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns if they can win in a possible two moves; a dangerous pair.
     * Won't happen in the bottom row (assuming dimensions), but still matters.
     *
     * @return one of the two columns that would allow the other player to win
     */
    public int pairCheck() {
        for (int i = myGame.getRowCount() - 1; i >= 0; i--) {
            char[] row = getRow(i);
            if (isEmpty(row)) break;
            int count = countRow(row, !iAmRed);
            if (count < 2) break;

            char[] rowUnder; // bottom row to make sure the slot isn't getting faked out
            if (i + 1 == myGame.getRowCount()) { // it is the bottom row. no need to worry
                rowUnder = new char[0];
            }
            else {
                rowUnder = getRow(i + 1);
            }

            boolean[] blacklist = getBlacklistedColumns(true);
            for (int test = 1; test < row.length - 2; test++) {
                // check if in pairs or if there is a space between the two.

                // for pairs, you can't have [0,1] and [5,6] as a pair. (ASSUMPTION OF BOARD DIMENSIONS)
                // this magic case comes when you are open on both ends. those pairs will never have both ends open

                char enemy = iAmRed?'Y':'R';
                if (row[test] == enemy && row[test + 1] == enemy && row[test - 1] == '-' && row[test + 2] == '-') {
                    if (rowUnder.length != 0) {
                        if (rowUnder[test - 1] == '-' || rowUnder[test + 2] == '-') {
                            break;
                        }
                    }

                    if (!blacklist[test - 1]) {
                        return test - 1;
                    }
                    else if (!blacklist[test + 2]) {
                        return test + 2;
                    }
                }

                // check for things of two with a gap in the middle
                if (test != row.length - 3) {
                    if (row[test] == enemy && row[test + 1] == '-' && row[test + 2] == enemy) {
                        if (!blacklist[test + 1]) {
                            return test + 1;
                        }
                    }
                }
            }
        }
        // @TODO maybe add a pair check for diagonals?
        return -1;
    }

    // DIAGONAL CHECKS

    /**
     * Counts the created diagonal from a column and the slot that the diagonal stems out from.
     * This is used for calculating a diagonal win and a possible diagonal win.
     *
     * @param column the column to check
     * @param lowest the slot to create a diagonal from
     * @param toCheck the color to check for the created diagonal
     * @param positive check for the positive or negative slope out of the slots' 2 created diagonals
     * @return the count of the color toCheck in the diagonal
     */
    public int getDiagonalCount(int column, int lowest, boolean toCheck, boolean positive) {
        int count = 0; // diagonal counter
        int row; // decrementing or incrementing the row while moving horizontally
        // between columns, representing possible diagonals.
        // partition the board into left and right of the current column

        // do the left half of the board. traverse from current column to the very left
        // the left half will be lower than the current empty row if positive diagonal. higher if negative
        row = lowest + (positive? -1:1);
        for (int i = column - 1; i >= 0; i--) {
            // out of bounds check: row will decrease for positive, must be >=0
            // row will increase for negative, must be < row count
            if (positive? row >= 0:row < myGame.getRowCount()) {
                Connect4Slot slot = myGame.getColumn(i).getSlot(positive? row--:row++);
                if (slot.getIsFilled() && slot.getIsRed() == toCheck) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        // do the right half of the board. traverse from current column to the very right
        // the left half will be higher than the current empty row if positive diagonal. lower if negative
        row = lowest + (positive? 1:-1);
        for (int i = column + 1; i < myGame.getColumnCount(); i++) {
            // out of bounds check: row will increase for positive, must be < row count
            // row will decrease for negative, must be >= 0
            if (positive? row < myGame.getRowCount():row >= 0) {
                Connect4Slot slot = myGame.getColumn(i).getSlot(positive? row++:row--);
                if (slot.getIsFilled() && slot.getIsRed() == toCheck) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }

    // GENERAL STRATEGY

    /**
     * Returns a blacklist or greylist of columns. If the player moves in a blacklisted column, then
     * the game will stop due to an invalid move or because it will allow the other player to win.
     * The greylist is a list of columns that my agent can move in, preferably if the other player moves
     * in the column first.
     * It's a greylist because it won't guarantee a loss, but if necessary then it can be moved in.
     *
     * @param strict if strict, then don't add on the greylist.
     * @return the blacklist or greylist
     */
    public boolean[] getBlacklistedColumns(boolean strict) {
        // blacklist
        boolean[] columns = new boolean[myGame.getColumnCount()];
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            if (myGame.getColumn(i).getIsFull()) {
                columns[i] = true;
            }
        }
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            if (!columns[i] && canWinInTwo(i, !iAmRed)) {
                columns[i] = true;
            }
        }
        // greylist
        if (!strict) {
            for (int i = 0; i < myGame.getColumnCount(); i++) {
                if (!columns[i] && canWinInTwo(i, iAmRed)) {
                    columns[i] = true;
                }
            }
        }
        return columns;
    }

    /**
     * Attempts to stack the middle columns of the board to force a vertical win.
     * Returns if the column would be a good move.
     *
     * @param greylist the greylist is used to be extra cautious and have higher chances of winning later
     * @param column the column index to force
     * @return the column index if it is valid in the greylist (not full, won't cost a win)
     */
    public int stackColumn(boolean[] greylist, int column) {
        Connect4Column mid = myGame.getColumn(column);
        if (!mid.getIsFull() && !greylist[column]) {
            return column;
        }
        return -1;
    }
}
