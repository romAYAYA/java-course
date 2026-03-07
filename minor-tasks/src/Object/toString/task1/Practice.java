package Object.toString.task1;

public class Practice {
    public static void main(String[] args) {
        Address house = new Address();
        house.city = "Stockholm";
        house.street = "Drottninggatan";
        house.houseNumber = 68;
        house.residents = new String[]{"Эмма Нильссон", "Ларс Эрикссон"};
        System.out.println(house);
    }
}

