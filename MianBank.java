package ProjectBank;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class MianBank {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<User> listUser = new ArrayList<>();
    public static ArrayList<Account> listAccount = new ArrayList<>();
    public static ArrayList<Bank> listBanks = new ArrayList<>();
    public static ArrayList<Transaction> listTransaction = new ArrayList<>();
    public static Date date = new Date();

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream inputStream = new FileInputStream("transation");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            listTransaction = (ArrayList<Transaction>) objectInputStream.readObject();

            objectInputStream.close();

        }catch (Exception e){

        }


        try {
            FileInputStream inputStream = new FileInputStream("MyProject");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            listUser = (ArrayList<User>) objectInputStream.readObject();

            objectInputStream.close();
        } catch (Exception e) {

        }

        // Пользователи
        //1. логин 1 пароль 1 ID 416
        //2. логин 2 пароль 2 ID 581
        //3. логин 3 пароль 3 Id 7165

        System.out.println("1.Авторизация");
        System.out.println("2.Зарегристриреватся");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            moun();
        } else if (answer == 2) {
            Auther();
        }


    }

    public static void moun() throws IOException {
        System.out.println("Пожалуста авторизуйтесь");
        System.out.println("Введите логин");
        String login = reader.readLine();
        System.out.println("Введите праоль");
        String possword = reader.readLine();
        for (User user : listUser) {
            if (user.getLogin().equals(login) && user.getPossword().equals(possword)) {
                outh(login,possword);
            }
        }
    }

    public static void Auther() throws IOException {
        System.out.println("Здравствуйте");
        System.out.println("Напишите имя");
        String name = reader.readLine();
        System.out.println("Напишите фамилю");
        String lust = reader.readLine();
        System.out.println("Введите логин");
        String login = reader.readLine();
        System.out.println("Введите пароль");
        String posswor = reader.readLine();
        listUser.add(new User(generetyID(), name, lust, login, posswor));
        System.out.println("Вы успешно зарегристрировались");
        try {
            FileOutputStream outputStream = new FileOutputStream("MyProject");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(listUser);

            objectOutputStream.close();
        } catch (Exception e) {

        }
        outh(login, posswor);
    }

    public static void outh(String login1, String posswor1) throws IOException {
        System.out.println();
        System.out.println("Что вы хотите сделать");
        System.out.println("1.Информация а маем аккоуента");
        System.out.println("2.Хотите пополнит счет");
        System.out.println("3.Хотите снять деньег");
        System.out.println("4.Хотите перевести деньги на другой счет");
        System.out.println("5.Информация о попольнение счета");
        System.out.println("6.Редактировать");
        System.out.println("7.Выход");
        int answer = Integer.parseInt(reader.readLine());
        switch (answer){
            case 1:
                infoAkk(login1,posswor1);
                break;
            case 2:
                AUTZADD(login1, posswor1);
                break;
            case 3:
                AUTZSET(login1,posswor1);
                break;
            case 4:
                AUTZRETURN(login1,posswor1);
                break;
            case 5:
                infoDate(login1,posswor1);
                break;
            case 6:
                redectine(login1,posswor1);
            case 7:
                System.exit(0);
        }


    }

    public static void redectine(String login1, String posswor1) throws IOException {
        System.out.println("Вы уверины что хотите изминить данные о себе 1 - Да");
        System.out.println("Вер нутса в главный меню 2 - Да");
        int answer = Integer.parseInt(reader.readLine());
        int count = 3;
        boolean tr = true;
        if (answer == 1){
            System.out.println("пожалучта ише раз авторизуйтесь");
            for (int i = 0; i < 3; i++) {
                System.out.println("Введите логин");
                String login = reader.readLine();
                System.out.println("Введите пароль");
                String possword = reader.readLine();
                if (login.equals(login1) && possword.equals(posswor1)) {
                    for (User user : listUser) {
                        if (user.getLogin().equals(login) && user.getPossword().equals(possword)){
                            System.out.println("------------------------");
                            System.out.println("Следовайте инструкциям");
                            System.out.println("Введите имя");
                            user.setFirstName(reader.readLine());
                            System.out.println("Введите фамилию");
                            user.setLastName(reader.readLine());
                            System.out.println("Введите логин");
                            user.setLogin(reader.readLine());
                            System.out.println("Введите пароль");
                            user.setPossword(reader.readLine());
                            System.out.println();
                            System.out.println("Новые данные палучены");
                            System.out.println();
                            tr = false;
                            System.out.println("Имя " + user.getFirstName() + " Фамилия " + user.getLastName() + " счет Сом " + user.getBalanceCom()
                                    + " счет доллора " + user.getBalanceDollor() + " ID " + user.getId());

                            try {
                                FileOutputStream outputStream = new FileOutputStream("MyProject");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listUser);

                                objectOutputStream.close();

                            } catch (Exception e) {

                            }
                        }
                    }
                }if (!tr){
                    break;
                }
                else {
                    count--;
                    System.out.println("Логин и пароль не совпадали");
                    System.out.println("У вас осталось попыток " + count);
                }
            }
        }else if (answer == 2){
            outh(login1, posswor1);
        }

    }

    public static void AUTZRETURN(String login1, String posswor1) throws IOException {
        System.out.println();
        System.out.println("Здравствуйте");
        System.out.println("Что вы хотите сделать");
        System.out.println("1.Хотите перевести на другой счет на сомах");
        System.out.println("2.Хотите перевести на другой счет на доллорах");
        System.out.println("3.Вернутса в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        switch (answer) {
            case 1:
                returnMaony(login1,posswor1);
                break;
            case 2:
                returnDoller(login1,posswor1);
                break;
            case 3:
                outh(login1, posswor1);
        }
    }

    public static void infoDate(String login1, String posswor1) throws IOException {
        System.out.println("Информация о пополнений счета");
        for (Transaction transaction : listTransaction) {
            System.out.println("деньги "+transaction.getAmount() + " время " + transaction.getTimestamp() + " имя " + transaction.getAccount().getName()
            + " доллор " + transaction.getAccount().getBalanceDollor() + " сом " + transaction.getAccount().getBalanceSom());
        }
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, posswor1);
        }
    }

    public static void AUTZSET(String login1, String posswor1) throws IOException {
        System.out.println();
        System.out.println("1.Снять деньги на доллоров");
        System.out.println("2.Снять деньги на сомах");
        System.out.println("3.Вернутса в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        switch (answer){
            case 1:
                setSom(login1, posswor1);
                break;
            case 2:
                setDollor(login1,posswor1);
            case 3:
                outh(login1, posswor1);
        }
    }

    public static void setDollor(String login1, String posswor1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int count = 3;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && posswor1.equals(possword)){
                for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)){
                        System.out.println("У вас есть на счету " + user.getBalanceDollor());
                        System.out.println("Сколко хотите снять денег");
                        int maony = Integer.parseInt(reader.readLine());
                        if (maony!= 0 && maony <= user.getBalanceDollor()){
                            user.setBalanceDollor(user.getBalanceDollor() - maony);
                            System.out.println();
                            System.out.println("Вы сняли денег " + maony + " доллоров");
                            System.out.println("У вас остался счет " + user.getBalanceDollor());
                            System.out.printf("%td %tB %tY года %n время: %tH:%tM:%tS%n", date, date, date, date, date, date);
                            try {
                                FileOutputStream outputStream = new FileOutputStream("MyProject");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listUser);

                                objectOutputStream.close();

                            } catch (Exception e) {

                            }
                            System.out.println("1.вернутся в главный меню");
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                outh(login1, posswor1);
                            }
                        }else {
                            System.out.println("Имей совисть");
                            System.out.println("1.вернутся в главный меню");
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                outh(login1, posswor1);
                            }
                        }
                    }
                }
            }else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, posswor1);
        }
    }

    public static void setSom(String login1, String posswor1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int count = 3;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && posswor1.equals(possword)){
                for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)){
                        System.out.println("У вас есть на счету " + user.getBalanceCom());
                        System.out.println("Сколко хотите снять денег");
                        int maony = Integer.parseInt(reader.readLine());
                        if (maony!= 0 && maony <= user.getBalanceCom()){
                            user.setBalanceCom(user.getBalanceCom() - maony);
                            System.out.println();
                            System.out.println("Вы сняли денег " + maony + " cомов");
                            System.out.println("У вас остался счет " + user.getBalanceCom());
                            System.out.printf("%td %tB %tY года %n время: %tH:%tM:%tS%n", date, date, date, date, date, date);
                            try {
                                FileOutputStream outputStream = new FileOutputStream("MyProject");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listUser);

                                objectOutputStream.close();

                            } catch (Exception e) {

                            }
                            System.out.println("1.вернутся в главный меню");
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                outh(login1, posswor1);
                            }
                        }else {
                            System.out.println("Имей совисть");
                            System.out.println("1.вернутся в главный меню");
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                outh(login1, posswor1);
                            }
                        }
                    }
                }
            }else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, posswor1);
        }

    }



    public static void infoAkk(String login1, String posswor1) throws IOException {
        for (User user : listUser) {
            if (login1.equals(user.getLogin()) && posswor1.equals(user.getPossword())) {
                System.out.println("Имя " + user.getFirstName() + " Фамилия " + user.getLastName() + " счет Сом " + user.getBalanceCom()
                + " счет доллора " + user.getBalanceDollor() + " ID " + user.getId());
            }
        }
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, posswor1);
        }
    }

    public static void AUTZADD(String login, String possword) throws IOException {
        System.out.println();
        System.out.println("Здравствуйте");
        System.out.println("Что вы хотите сделать");
        System.out.println("1.Пополнить счет на сомах");
        System.out.println("2.Пополнить счет на доллоров");
        System.out.println("3.Вернутса в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        switch (answer) {
            case 1:
                addAccountCom(login,possword);
                break;
            case 2:
                addAccountDollor(login,possword);
                break;
            case 3:
                outh(login, possword);
        }
    }


    public static void addAccountCom(String login1, String possword1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int count = 3;
        int n = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && possword1.equals(possword)) {
                for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)) {
                        System.out.println("Сколько сумма?");
                        n++;
                        int many = Integer.parseInt(reader.readLine());
                        if (many != 0) {
                            user.manaySom(many);
                            System.out.println("Вы успешна паполнели счет");
                            System.out.println("Паполнилась счет " + user.getBalanceCom());
                            System.out.printf("%td %tB %tY года %n время: %tH:%tM:%tS%n", date, date, date, date, date, date);
                            listAccount.add(new Account(user.getId(), user.getFirstName(), user, many,0));
                            for (Account account : listAccount) {
                                listTransaction.add(new Transaction(many, date, account));
                            }

                            try {
                                FileOutputStream outputStream = new FileOutputStream("MyProject");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listUser);

                                objectOutputStream.close();

                            } catch (Exception e) {

                            }
                            try {
                                FileOutputStream outputStream= new FileOutputStream("transation");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listTransaction);
                                objectOutputStream.close();

                            }catch (Exception e){

                            }
                        }
                    }
                }
            }if (n == 1){
                break;
            }
            else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, possword1);
        }
    }

    public static void addAccountDollor(String login1, String possword1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int n = 0;
        int count = 3;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && possword1.equals(possword)) {
                for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)) {
                        System.out.println("Сколько сумма?");
                        n++;
                        int many = Integer.parseInt(reader.readLine());
                        if (many != 0) {
                            user.manayDollor(many);
                            System.out.println("Вы успешна паполнели счет");
                            System.out.println("Паполнилась счет " + user.getBalanceDollor());
                            System.out.printf("%td %tB %tY года %n время: %tH:%tM:%tS%n", date, date, date, date, date, date);
                            listAccount.add(new Account(user.getId(), user.getFirstName(), user, 0,many));
                            for (Account account : listAccount) {
                                listTransaction.add(new Transaction(many, date, account));
                            }

                            try {
                                FileOutputStream outputStream = new FileOutputStream("MyProject");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listUser);

                                objectOutputStream.close();

                            } catch (Exception e) {

                            }
                            try {
                                FileOutputStream outputStream= new FileOutputStream("transation");
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(listTransaction);
                                objectOutputStream.close();

                            }catch (Exception e){

                            }
                        } else {
                            System.out.println("Имей совисть");
                        }
                    }
                }
            }if (n == 1){
                break;
            }
            else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }



        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, possword1);
        }
    }



    public static void returnMaony(String login1, String possword1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int count = 3;
        int n = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && possword1.equals(possword)) {
                for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)) {
                        System.out.println("Увас в счете  " + user.getBalanceCom() + " сом");
                        System.out.println("каму хотите перевести");
                        System.out.println("Введите ID");
                        int answer = Integer.parseInt(reader.readLine());
                        for (User user1 : listUser) {
                            if (user1.getId() == answer) {
                                System.out.println(user1.getFirstName());
                                System.out.println("Сколько хотите переслать денег");
                                int maony = Integer.parseInt(reader.readLine());
                                if (maony != 0 && user.getBalanceCom() >= maony) {
                                    user1.manaySom(maony);
                                    user.setBalanceCom(user.getBalanceCom() - maony);
                                    System.out.println("Вы успешно передали деньги");
                                    System.out.println("---------------------------");
                                    System.out.println("Вашем счету " + user.getBalanceCom() + " сомов остался ");
                                    System.out.println(date);
                                    n++;
                                    try {
                                        FileOutputStream outputStream = new FileOutputStream("MyProject");
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                        objectOutputStream.writeObject(listUser);

                                        objectOutputStream.close();

                                    } catch (Exception e) {

                                    }
                                } else {
                                    System.out.println("Имей совисть!");
                                }
                            }
                        }
                    }
                }
            }
            if (n == 1){
                break;
            }
            else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }


        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, possword1);
        }
    }



    public static void returnDoller(String login1, String possword1) throws IOException {
        System.out.println("пожалучта ише раз авторизуйтесь");
        int count = 3;
        int temp = 0;
        boolean n = false;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите логин");
            String login = reader.readLine();
            System.out.println("Введите пароль");
            String possword = reader.readLine();
            if (login1.equals(login) && possword1.equals(possword)) {
            for (User user : listUser) {
                    if (user.getLogin().equals(login) && user.getPossword().equals(possword)) {
                        System.out.println("Увас в счете  " + user.getBalanceDollor() + " доллор");
                        System.out.println("каму хотите перевести");
                        System.out.println("Введите ID");
                        temp++;
                        int answer = Integer.parseInt(reader.readLine());
                        for (User user1 : listUser) {
                            if (user1.getId() == answer) {
                                n = true;
                                System.out.println(user1.getFirstName());
                                System.out.println("Сколько хотите переслать денег");
                                int maony = Integer.parseInt(reader.readLine());
                                if (maony != 0 && user.getBalanceDollor() >= maony) {
                                    user1.manayDollor(maony);
                                    user.setBalanceDollor(user.getBalanceDollor() - maony);
                                    System.out.println("Вы успешно передали деньги");
                                    System.out.println("Ваш счету " + user.getBalanceDollor() + " доллоров остался");
                                    System.out.println(date);
                                    try {
                                        FileOutputStream outputStream = new FileOutputStream("MyProject");
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                        objectOutputStream.writeObject(listUser);

                                        objectOutputStream.close();

                                    } catch (Exception e) {

                                    }
                                } else {
                                    System.out.println("Имей совисть!");
                                }
                            }
                        }
                    }
            }
            }
            if (temp == 1){
                break;
            }
            else {
                count--;
                System.out.println("Логин и пароль не совпадали");
                System.out.println("У вас осталось попыток " + count);
            }
        }


        if (!n){
            System.out.println("Не нашло ID");
        }

        System.out.println();
        System.out.println("1.вернутся в главный меню");
        int answer = Integer.parseInt(reader.readLine());
        if (answer == 1) {
            outh(login1, possword1);
        }
    }



    //Генерация индивидуального ID
    public static int generetyID() {
        int id = (int) (Math.random() * 10000) + 100;

        boolean answer = checkID(id);
        if (answer) {
            return id;
        } else {
            return generetyID();
        }

    }


    //Проверка индивидуального ID
    public static boolean checkID(int id) {
        for (User employee : listUser) {
            if (id == employee.getId()) {
                return false;
            }
        }
        return true;
    }


}
