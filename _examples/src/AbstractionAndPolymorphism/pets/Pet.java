package AbstractionAndPolymorphism.pets;

public abstract class Pet {
    private int pawsCount;
    private String voice;

    public Pet(String voice, int pawsCount) {
        this.voice = voice;
        this.pawsCount = pawsCount;
    }

    public void sleep() {
        System.out.println("Сплю");
    }

    public void play() {
        System.out.println("Играю");
    }

    public void giveVoice() {
        System.out.println(voice);
    }

    public int getPawsCount() {
        return pawsCount;
    }
}
