package BehaviouralPatterns;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args){
        LanguageHandler languageHandler = new ChainOfResponsibilityDemo().generateLanguageLinks();

        String language1 = "english";
        languageHandler.handle(language1);

        String language2 = "hindi";
        languageHandler.handle(language2);

        String language3 = "telugu";
        languageHandler.handle(language3);

        String language4 = "persian";
        languageHandler.handle(language4);
    }

    LanguageHandler generateLanguageLinks(){
        EnglishHandler eng = new EnglishHandler();
        HindiHandler hin = new HindiHandler();
        TeluguHandler tel = new TeluguHandler();

        eng.setNextLanguageHandler(hin);
        hin.setNextLanguageHandler(tel);

        return eng;
    }
}

interface LanguageHandler{
    void handle(String language);
    void setNextLanguageHandler(LanguageHandler languageHandler);
}

abstract class AbstractHandler implements LanguageHandler{

    LanguageHandler nextLanguageHandler;
    @Override
    public void setNextLanguageHandler(LanguageHandler languageHandler) {
        this.nextLanguageHandler = languageHandler;
    }
}

class EnglishHandler extends AbstractHandler{

    @Override
    public void handle(String language) {
        if("ENGLISH".equalsIgnoreCase(language)) {
            System.out.println("Instructions in English Language");
            return;
        }
        this.nextLanguageHandler.handle(language);
    }
}

class HindiHandler extends AbstractHandler{

    @Override
    public void handle(String language) {
        if("HINDI".equalsIgnoreCase(language)) {
            System.out.println("Instructions in Hindi Language");
            return;
        }
        this.nextLanguageHandler.handle(language);
    }
}

class TeluguHandler extends AbstractHandler{

    @Override
    public void handle(String language) {
        if("TELUGU".equalsIgnoreCase(language)) {
            System.out.println("Instructions in Telugu Language");
            return;
        }
        System.out.println("Select any one of ENGLISH, HINDI, TELUGU");
    }
}