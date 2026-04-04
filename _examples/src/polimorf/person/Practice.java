package polimorf.person;

public class Practice {
    public static void main(String[] args) {
        String name = "Катя";

        System.out.println("Что " + name + " делает как работник:");
        Employee employee = new SoftwareDeveloper(name);
        employee.work();
        System.out.println("Получает зарплату за месяц: " + employee.getSalary() + " тг.");
        // Таких методов в интерфейсе Employee нет - произойдет ошибка
        // employee.eat();
        // employee.doDebug();

        System.out.println("\nЧто " + name + " делает как человек:");
        Person person = new SoftwareDeveloper(name);
        person.eat();
        person.sleep();
        // Таких методов в классе Person нет - произойдет ошибка
        // person.work();
        // person.doDebug();

        System.out.println("\nЧто " + name + " делает как программист:");
        SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper(name);
        softwareDeveloper.doDebug();
        softwareDeveloper.think();
    }
}

