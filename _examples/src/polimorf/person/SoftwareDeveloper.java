package polimorf.person;

public class SoftwareDeveloper extends Person implements Employee {
    public SoftwareDeveloper(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("Выполняет свою работу - генерит код весь день");
    }

    @Override
    public double getSalary() {
        return 1_000_000.0;
    }

    public void doDebug() {
        System.out.println("Ищет ошибки в коде");
    }

    public void think() {
        System.out.println("Обдумывает решение задачи");
    }
}
