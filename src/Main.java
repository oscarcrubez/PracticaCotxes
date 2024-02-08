import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);



    public static void main(String[] args) {

        Main main = new Main();
        main.init();
    }



    public void init(){
        int menuItem = 0;
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
                        //insert code here
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");

                        altaMeca();

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


    /**
     *
     */
    public static void altaMeca() {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        // Creació de l'array de les dades dels mecànics
        String[][] dadesMecanic = new String[100][3];

        while (true) {

            // Saber si l'array de mecànics està plè
            if (sum > 100) {
                System.out.println("Ja has omplert el nombre màxim d'empleats.");
                break;
            }

            System.out.println("Introdueix el codi de l'empleat (6 enters del 0 al 9):");
            dadesMecanic [sum][0] = scanner.nextLine();

            System.out.println("Introdueix el nom de l'empleat:");
            dadesMecanic [sum][1] = scanner.nextLine();

            System.out.println("Introdueix si està lliure (escriu \"lliure\") o ocupat (escriu \"ocupat\")");
            dadesMecanic [sum][2] = scanner.nextLine();

            System.out.println("\nEmpleat introduït correctament. Les seves dades són les següents\n");

            System.out.println("Codi: " + dadesMecanic [sum][0]);
            System.out.println("Nom: " + dadesMecanic [sum][1]);
            System.out.println("Disponibilitat: " + dadesMecanic [sum][2]);
            System.out.println(" ");


            sum++; // Sumatori que ens permet guardar els diferents empleats en diferents arrays (primer índex de la matriu)

        }

    }

    //insert code here

}