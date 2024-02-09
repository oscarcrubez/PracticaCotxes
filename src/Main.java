import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);



    public static void main(String[] args) {


        Main main = new Main();
        main.init();
         
    }


    public void init(){
        int menuItem = 0;

        String[][] client = new String[100][2];

        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Sortir");
            System.out.println("Sel·lecciona una opció: ");

            if (input.hasNextInt()){
                menuItem = input.nextInt();
                switch (menuItem){
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        String[][] client1= case1(client);

                        for (int i=0; i<100; i++){
                            for (int j=0; j<2; j++){
                                client[i][j] = client1[i][j];
                            }
                        }

                        //insert code here
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        //insert code here
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        //insert code here
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        //insert code here
                        break;
                    case 5:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            }else{
                System.out.println("Opció no vàlida");
            }
            input.nextLine();
            System.out.println("");

        }while(menuItem!=5);

    }

    public static String[][] case1(String[][] client){
        Scanner escanner = new Scanner(System.in);
        boolean rep = true;

        for (int i=0; i<100; i++){
            if (client[i][0] == null && client[i][1] == null){

                do{
                    System.out.println("Introdueix el DNI del client:");
                    client[i][0] = escanner.nextLine();

                    if (i != 0){
                        for (int j=0; j<100; j++){
                            if (client[j][0].equals(client[i][0])){
                                rep = false;
                                break;
                            }else if (i-1 == j){
                                rep =true;
                                break;
                            }
                        }
                    }

                }while (!rep);

                do{
                    System.out.println("Introdueix el nom del client:");
                    client[i][1] = escanner.nextLine();
                }while (client[i][1].isEmpty());

                break;
            }

        }

        return client;
    }


    //insert code here

}