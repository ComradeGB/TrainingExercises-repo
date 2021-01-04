package gb;

public class Main {

    public static void main(String[] args) {
        Employer [] employerArray = new Employer[5];
        employerArray [0] = new Employer("Иванов Иван Иваныч","ведущий инженер",
                "ivan@employer.com","8-908-123-45-11", 150000,51);
        employerArray [1] = new Employer("Сидоров Петр Михайлович","инженер",
                "petr@employer.com","8-909-123-22-67", 100000,33);
        employerArray [2] = new Employer("Титов Валентин Николаевич","инженер-программист",
                "ivan@employer.com","8-910-123-11-67", 140000,35);
        employerArray [3] = new Employer("Сизов Андрей Михайлович","инженер-конструктор",
                "ivan@employer.com","8-911-111-45-44", 150000,41);
        employerArray [4] = new Employer("Милонов Александр Владиславович","менеджер",
                "ivan@employer.com","8-912-321-45-67", 80000,42);
        for (int i =0 ; i < 5; i++){
            if (employerArray[i].age > 40){
                employerArray[i].print();
            }
        }
    }

    public static class Employer{
        private String fullName;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        Employer(String fullName, String position, String email,
                 String phone, int salary, int age){
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public void print(){
            System.out.printf("%nПолное имя сотрудника - %S %nДолжность - %s %nЭл.Почта - %s %nНомер телефона - %s %nЗарплата - %d %nВозраст - %d %n",
                    fullName, position, email, phone, salary, age);
        }
    }
}
