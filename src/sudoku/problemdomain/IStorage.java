package sudoku.problemdomain;

import java.io.IOException;

public interface IStorage {
    void updateGameData(SudukoGame game) throws IOException;
    SudukoGame getGameData() throws IOException;
}
