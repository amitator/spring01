package ru.otus.spring.hw01.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.hw01.services.Quiz;

@ShellComponent
public class StartCommand {
    private Quiz quiz;

    @Autowired
    public StartCommand(Quiz quiz){
        this.quiz = quiz;
    }

    @ShellMethod("Starts quiz")
    public void start(){
        quiz.run();
    }
}
