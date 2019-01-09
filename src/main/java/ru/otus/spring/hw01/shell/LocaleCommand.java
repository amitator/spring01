package ru.otus.spring.hw01.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.hw01.services.BundleChoiceDependOnLocale;
import ru.otus.spring.hw01.services.QuestionsReaderImpl;

import java.util.Locale;
import java.util.Scanner;

@ShellComponent
public class LocaleCommand {
    private BundleChoiceDependOnLocale bundle;
    private QuestionsReaderImpl questionsReader;

    @Autowired
    public LocaleCommand(BundleChoiceDependOnLocale bundle, QuestionsReaderImpl questionsReader){
        this.bundle = bundle;
        this.questionsReader = questionsReader;
    }

    @ShellMethod("Change Locale")
    public void locale(){
        String lang;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your language:" +
        "\n1. English" +
        "\n2. Russian");
        lang = scanner.nextLine();
        try {
            switch (lang) {
                case "1":
                    bundle.setLocale(Locale.US);
//                    bundle.selectBundleFile();
                    break;
                case "2":
                    bundle.setLocale(new Locale("ru", "RU"));
//                    bundle.selectBundleFile();
                    questionsReader.setBundle(bundle);
                    questionsReader.getQuestions();
                    break;
                default:
                    bundle.setLocale(Locale.ENGLISH);
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
