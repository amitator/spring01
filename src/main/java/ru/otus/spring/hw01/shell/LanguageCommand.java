package ru.otus.spring.hw01.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.hw01.services.BundleChoiceDependOnLocale;

import javax.validation.constraints.Pattern;
import java.util.Locale;

@ShellComponent
public class LanguageCommand {
    private BundleChoiceDependOnLocale bundle;

    @Autowired
    public LanguageCommand(BundleChoiceDependOnLocale bundle){
        this.bundle = bundle;
    }

    @ShellMethod("Change language (en-English, ru-Russian)")
    public void language(@Pattern(regexp = "^en|ru$") String language){

        switch (language) {
            case "en":
                bundle.setLocale(Locale.US);
                break;
            case "ru":
                bundle.setLocale(new Locale("ru", "RU"));
                break;
            default:
                bundle.setLocale(Locale.ENGLISH);
                break;
        }
    }
}
