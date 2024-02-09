import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);



    public static void main(String[] args) {

        Main main = new Main();
        main.init();
    }



    public void init(){
        int menuItem = 0;
        int sum = 0;

        String [][] mecanics = new String[100][3];

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

                        String [][] mecanics1 = altaMeca(mecanics);

                        System.out.println("Dades dels empleats existents:\n");

                        for (int i = 0; i < 100; i++) {
                            for (int j = 0; j < 3; j++) {

                                    System.out.print(mecanics1[i][j] + "   ");
                                    mecanics [i][j] = mecanics1 [i][j];
                            }
                            System.out.println();
                        }

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
     * @return l'array amb les dades dels mecànics
     */
    public static String[][] altaMeca(String[][] dadesMecanic) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int opcioNou;
        String nomMeca;
        String codiMeca;
        String dispoMeca;
        boolean rep = true;

        // Creació de l'array de les dades dels mecànics
        dadesMecanic = new String[100][3];

        do {

            // Saber si l'array de mecànics està plè
            if (sum > 100) {
                System.out.println("Ja has omplert el nombre màxim d'empleats.");
                break;
            }

            // Bucle per a control d'error: codi d'empleat ja existent
            for (int i=0; i<100; i++) {
                if (dadesMecanic[i][0] == null && dadesMecanic[i][1] == null) {

                    do {
                        System.out.println("Introdueix el codi de l'empleat (6 enters del 0 al 9):");
                        dadesMecanic[i][0] = scanner.nextLine();

                        if (i != 0) {
                            for (int j = 0; j < 100; j++) {
                                if (dadesMecanic[j][0].equals(dadesMecanic[i][0])) {
                                    rep = false;
                                    break;
                                } else if (i - 1 == j) {
                                    rep = true;
                                    break;
                                }
                            }
                        }

                    } while (!rep);

                    System.out.println("Introdueix el nom de l'empleat:");
                    dadesMecanic [i][1] = scanner.nextLine();
                    System.out.println("Introdueix si està lliure (escriu \"lliure\") o ocupat (escriu \"ocupat\")");
                    dadesMecanic [i][2] = scanner.nextLine();

                    break;

                }
            }


            // Obtenció de valor per repetir o no tot el procés
            System.out.println("\nSi vols introduïr un altre mecànic, escriu [1]. Per tornar al menú principal, escriu [2]");
            opcioNou = scanner.nextInt();

        } while (opcioNou == 1);

        return dadesMecanic;

    }

    //insert code here

}