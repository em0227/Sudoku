package com.emilywu.sudoku.buildlogic;

import com.emilywu.sudoku.comutationlogic.GameLogic;
import com.emilywu.sudoku.persistence.LocalStorageImpl;
import com.emilywu.sudoku.problemdomain.IStorage;
import com.emilywu.sudoku.problemdomain.SudokuGame;
import com.emilywu.sudoku.userinterface.IUserInterfaceContract;
import com.emilywu.sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }

}
