package polimorf.hamlet;

public class Actor {
    public void play() {
        System.out.println("Актер вышел на сцену и начал монолог: " + "\"" + this.sayLine() + "\"");
    }

    public String sayLine() {
        return "Провала прошу, провала";
    }

}
