package com.emilywu.sudoku;

import com.emilywu.sudoku.buildlogic.SudokuBuildLogic;
import com.emilywu.sudoku.userinterface.IUserInterfaceContract;
import com.emilywu.sudoku.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryState) throws IOException {
        uiImpl = new UserInterfaceImpl(primaryState);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
