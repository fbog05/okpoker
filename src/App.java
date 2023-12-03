/*
* File: MainController.java
* Author: Nagy József
* Refactor: Ferencsik Boglárka
* Date: 2021-09-11
* Copyright: 2021-2023, Nagy József 
* Licenc: MIT
*/

import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
