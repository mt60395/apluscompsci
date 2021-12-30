// decompiled class
import java.util.Random;

public class BrilliantAgent extends Agent {
    private Random c = new Random();

    public BrilliantAgent(Connect4Game var1, boolean var2) {
        super(var1, var2);
    }

    public final void move() {
        int var1 = this.canWin(this.iAmRed);
        int var2 = this.canWin(!this.iAmRed);
        if (var1 >= 0) {
            //var1 = var1; ?
        } else if (var2 >= 0) {
            var1 = var2;
        } else {
            BrilliantAgent var3 = this;

            for(var2 = this.c.nextInt(this.myGame.getColumnCount()); getLowestEmptySlot(var3.myGame.getColumn(var2)) == null; var2 = var3.c.nextInt(var3.myGame.getColumnCount())) {
            }

            var1 = var2;
        }

        Connect4Slot var4;
        if ((var4 = getLowestEmptySlot(this.myGame.getColumn(var1))) != null) {
            if (this.iAmRed) {
                var4.addRed();
                return;
            }

            var4.addYellow();
        }

    }

    private static Connect4Slot getLowestEmptySlot(Connect4Column var0) {
        int var1 = -1;

        for(int var2 = 0; var2 < var0.getRowCount(); ++var2) {
            if (!var0.getSlot(var2).getIsFilled()) {
                var1 = var2;
            }
        }

        if (var1 < 0) {
            return null;
        } else {
            return var0.getSlot(var1);
        }
    }

    private int canWin(boolean var1) {
        for(int var2 = 0; var2 < this.myGame.getColumnCount(); ++var2) {
            Connect4Column var3 = this.myGame.getColumn(var2);
            int var4 = -1;

            for(int var5 = 0; var5 < var3.getRowCount(); ++var5) {
                if (!var3.getSlot(var5).getIsFilled()) {
                    var4 = var5;
                }
            }

            if (var4 >= 0) {
                if (var4 < this.myGame.getRowCount() - 3 && this.myGame.getColumn(var2).getSlot(var4 + 1).getIsRed() == var1 && this.myGame.getColumn(var2).getSlot(var4 + 2).getIsRed() == var1 && this.myGame.getColumn(var2).getSlot(var4 + 3).getIsRed() == var1) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 3 && real(var1, this.myGame.getColumn(var2 + 1).getSlot(var4), this.myGame.getColumn(var2 + 2).getSlot(var4), this.myGame.getColumn(var2 + 3).getSlot(var4))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 2 && var2 > 0 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4), this.myGame.getColumn(var2 + 1).getSlot(var4), this.myGame.getColumn(var2 + 2).getSlot(var4))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 1 && var2 > 1 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4), this.myGame.getColumn(var2 + 1).getSlot(var4), this.myGame.getColumn(var2 - 2).getSlot(var4))) {
                    return var2;
                }

                if (var2 > 2 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4), this.myGame.getColumn(var2 - 3).getSlot(var4), this.myGame.getColumn(var2 - 2).getSlot(var4))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 3 && var4 < this.myGame.getRowCount() - 3 && real(var1, this.myGame.getColumn(var2 + 1).getSlot(var4 + 1), this.myGame.getColumn(var2 + 3).getSlot(var4 + 3), this.myGame.getColumn(var2 + 2).getSlot(var4 + 2))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 2 && var2 > 0 && var4 < this.myGame.getRowCount() - 2 && var4 > 0 && real(var1, this.myGame.getColumn(var2 + 1).getSlot(var4 + 1), this.myGame.getColumn(var2 - 1).getSlot(var4 - 1), this.myGame.getColumn(var2 + 2).getSlot(var4 + 2))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() - 1 && var2 > 1 && var4 < this.myGame.getRowCount() - 1 && var4 > 1 && real(var1, this.myGame.getColumn(var2 + 1).getSlot(var4 + 1), this.myGame.getColumn(var2 - 1).getSlot(var4 - 1), this.myGame.getColumn(var2 - 2).getSlot(var4 - 2))) {
                    return var2;
                }

                if (var2 < this.myGame.getColumnCount() && var2 > 2 && var4 < this.myGame.getRowCount() && var4 > 2 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4 - 1), this.myGame.getColumn(var2 - 2).getSlot(var4 - 2), this.myGame.getColumn(var2 - 3).getSlot(var4 - 3))) {
                    return var2;
                }

                if (var2 > 2 && var2 < this.myGame.getColumnCount() && var4 < this.myGame.getRowCount() - 3 && var4 >= 0 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4 + 1), this.myGame.getColumn(var2 - 2).getSlot(var4 + 2), this.myGame.getColumn(var2 - 3).getSlot(var4 + 3))) {
                    return var2;
                }

                if (var2 > 1 && var2 < this.myGame.getColumnCount() - 1 && var4 < this.myGame.getRowCount() - 2 && var4 > 0 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4 + 1), this.myGame.getColumn(var2 - 2).getSlot(var4 + 2), this.myGame.getColumn(var2 + 1).getSlot(var4 - 1))) {
                    return var2;
                }

                if (var2 > 0 && var2 < this.myGame.getColumnCount() - 2 && var4 < this.myGame.getRowCount() - 1 && var4 > 1 && real(var1, this.myGame.getColumn(var2 - 1).getSlot(var4 + 1), this.myGame.getColumn(var2 + 2).getSlot(var4 - 2), this.myGame.getColumn(var2 + 1).getSlot(var4 - 1))) {
                    return var2;
                }

                if (var2 >= 0 && var2 < this.myGame.getColumnCount() - 3 && var4 < this.myGame.getRowCount() && var4 > 2 && real(var1, this.myGame.getColumn(var2 + 3).getSlot(var4 - 3), this.myGame.getColumn(var2 + 2).getSlot(var4 - 2), this.myGame.getColumn(var2 + 1).getSlot(var4 - 1))) {
                    return var2;
                }
            }
        }

        return -1;
    }

    private static boolean real(boolean var0, Connect4Slot var1, Connect4Slot var2, Connect4Slot var3) {
        return var1.getIsFilled() && var2.getIsFilled() && var3.getIsFilled() && var1.getIsRed() == var0 && var2.getIsRed() == var0 && var3.getIsRed() == var0;
    }

    public final String getName() {
        return "Brilliant Agent";
    }
}
