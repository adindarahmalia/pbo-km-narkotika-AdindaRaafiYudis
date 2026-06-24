package controller;

import model.KnowledgeRepository;
import util.InputHandler;
import view.ConsoleView;

public class KnowledgeController {
    private KnowledgeController repository;
    private ConsoleView view;
    private InputHandler input;

    public KnowledgeController() {
        repository = new KnowledgeController();
        view = new ConsoleView();
        input = new InputHandler();

    }
}