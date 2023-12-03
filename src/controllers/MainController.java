/*
* File: MainController.java
* Author: Nagy József
* Refactor: Ferencsik Boglárka
* Date: 2021-09-11
* Copyright: 2021-2023, Nagy József 
* Licenc: MIT
*/


package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    private final MainWindow mainWindow;
    private final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    private Round round = Round.PREFLOP;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }

    private int getRandomCardIndex() {
        Random random = new Random();
        return random.nextInt(cards.length);
    }

    private void updateHumanCards() {
        int hcard1 = getRandomCardIndex();
        int hcard2 = getRandomCardIndex();
        System.out.printf("%d %d\n", hcard1, hcard2);
    }

    private void updateFlopCards() {
        int flop1 = getRandomCardIndex();
        int flop2 = getRandomCardIndex();
        int flop3 = getRandomCardIndex();
    }

    private void updateTurnCard() {
        int turn = getRandomCardIndex();
    }

    private void updateRiverCard() {
        int river = getRandomCardIndex();
    }

    public void initEvent() {
        this.mainWindow.startBtn.addActionListener(event -> {
            updateHumanCards();
        });

        this.mainWindow.stopBtn.addActionListener(event -> {
            System.out.println("Állj");
        });

        this.mainWindow.nextBtn.addActionListener(event -> {
            if (this.round == Round.PREFLOP) {
                updateFlopCards();
                this.round = Round.FLOP;
            } else if (this.round == Round.FLOP) {
                updateTurnCard();
                this.round = Round.TURN;
            } else if (this.round == Round.TURN) {
                updateRiverCard();
                this.round = Round.RIVER;
            }
        });
    }
}