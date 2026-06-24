package controller;

import model.KnowledgeRepository;
import util.InputHandler;
import view.ConsoleView;

public class KnowledgeController {
    private KnowledgeRepository repository;
    private ConsoleView view;
    private InputHandler input;

    public KnowledgeController() {
        repository = new KnowledgeRepository();
        view = new ConsoleView();
        input = new InputHandler();

    }
}