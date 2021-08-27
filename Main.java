import javax.management.Query;

public class Main {

    public static void main(String[] args) {
        letter letter1 = new letter (1, "Письмо 1", "123@123.ru", "1234@1234.ru","Добрый день!");
        admission_order prikaz_trudoustr = new admission_order(2, "Трудоустройство 2", "Иванов Иван Иванович", "Принимаем нового специалиста", "СОЗДАН");
        dismissal_order prikaz_uvoln = new dismissal_order(3, "Увольнение 2", "Петров Петр Петрович", "Увольняем старого спечиалиста", "СОЗДАН", "Трудовая дисциплина");
        letter1.print();
        System.out.println();
        prikaz_trudoustr.print();
        System.out.println();
        prikaz_uvoln.print();
        System.out.println();

        prikaz_trudoustr.setStatus("ИСПОЛНЕН");
        prikaz_uvoln.setStatus("ИСПОЛНЕН");

        prikaz_trudoustr.print();
        System.out.println();
        prikaz_uvoln.print();
    }
}
    class hrdocument {
        private Integer number;
        String title;
        private String employee;
        private String status;

        public Integer getNumber() {
            return number;
        }

        public String getEmployee() {
            return employee;
        }

        public String getStatus() {
            return status;
        }

        public final void setStatus(String status) {
            if (this.status.equals("ИСПОЛНЕН")){
                System.out.println("Документ исполнен, статус изменить невозможно");
            } else {
                this.status=status;
            }
        }

        public hrdocument(Integer number, String title, String employee, String status){
            this.number=number;
            this.title=title;
            this.employee=employee;
            switch (status){
                case "СОЗДАН":
                case "ИСПОЛНЕН":
                    this.status=status;
                    break;
                default:
                    throw new IllegalArgumentException("Exception: wrong value!");
            }
        }

        public void print() {
            System.out.println("Номер документа: " + number);
            System.out.println("Название документа: " + title);
            System.out.println("Сотрудник: " + employee);
            System.out.println("Статус: " + status);
        }
    }

    class letter {
        private Integer number;
        String title;
        String sendTo;
        String sendFrom;
        String text;

        public letter(Integer number, String title, String sendTo, String sendFrom, String text) {
            this.number=number;
            this.title=title;
            this.sendTo=sendTo;
            this.sendFrom=sendFrom;
            this.text=text;
        }

        public void print() {
            System.out.println("Номер документа: " + number);
            System.out.println("Название документа: " + title);
            System.out.println("Получатель(и): " + sendTo);
            System.out.println("Отправитель: " + sendFrom);
            System.out.println("Текст письма: " + text);
        }

    }

    class admission_order extends hrdocument {
        String text;
        public admission_order(Integer number, String title, String employee, String text, String status) {
            super(number, title, employee, status);
            this.text=text;
        }
        public void print() {
            super.print();
            System.out.println("Текст приказа: " + text);
        }

    }

    class dismissal_order extends hrdocument {
        String text;
        String dismissal_reason;
        public dismissal_order(Integer number, String title, String employee, String text, String status, String dismissal_reason) {
            super(number,title, employee, status);
            this.text=text;
            this.dismissal_reason=dismissal_reason;
        }
        public void print() {
            super.print();
            System.out.println("Текст приказа: " + text);
            System.out.println("Причина увольнения: " + dismissal_reason);
        }
    }
