// decompiled class
import java.util.Random;

public class RandomAgent extends Agent {
    private Random c = new Random();

    public RandomAgent(Connect4Game var1, boolean var2) {
        super(var1, var2);
    }

    public final void move() {
        if (!this.myGame.boardFull()) {
            int var1;
            for(var1 = this.c.nextInt(this.myGame.getColumnCount()); a(this.myGame.getColumn(var1)) == null; var1 = this.c.nextInt(this.myGame.getColumnCount())) {
            }

            Connect4Game var2 = this.myGame;
            Connect4Slot var4;
            if ((var4 = a(var2.getColumn(var1))) != null) {
                if (this.iAmRed) {
                    var4.addRed();
                    return;
                }

                var4.addYellow();
            }
        }

    }

    private static Connect4Slot a(Connect4Column var0) {
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

    public final String getName() {
        return "Random Agent";
    }
}
