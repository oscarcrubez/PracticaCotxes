
/*
INTEGRANTS DEL GRUP:
Santiago Fernández-Pedrera López
Òscar Cruañas Gonzalbez

ENLLAÇ AL REPOSITORI:
https://github.com/oscarcrubez/PracticaCotxes.git
 */


import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        Main main = new Main();
        main.init();
         
    }

    /**
     * Aquest mètode mostra el menú inicial i permet a l'usuari seleccionar les diferents
     * accions que ofereix el programa.
     */
    public void init(){
        int menuItem = 0;

        // Definir les matrius necessàries per guardar totes les dades.
        String [][] mecanics = new String[100][3]; // Matriu per les dades dels empleats donats d'alta.
        String [][] reparacions = new String[100][3]; // Matriu per les dades de les noves reparacions.
        String[][] client = new String[100][2]; // Matriu per les dades dels clients.
        String[][] vehicle = new String[100][3]; // Matriu per les dades dels vehicles donats d'alta.

        do {

            // Menú principal.
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

                        // Bucle per representar les dades dels clients existents.
                        for (int i=0; i<100; i++){
                            for (int j=0; j<2; j++){
                                client[i][j] = client1[i][j];

                            }
                        }

                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");

                        String [][] mecanics1 = case2(mecanics);

                        // Bucle per representar les dades dels empleats donats d'alta.
                        for (int i = 0; i < 100; i++) {
                            for (int j = 0; j < 3; j++) {
                                    mecanics [i][j] = mecanics1 [i][j];
                            }
                        }

                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");

                        String[][] vehicle1= case3(vehicle, client);

                        // Bucle per representar les dades dels vehicles donats d'alta.
                        for (int i=0; i<100; i++){
                            for (int j=0; j<3; j++){
                                vehicle[i][j] = vehicle1[i][j];
                            }
                        }

                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");

                        String[][] reparacions1 = case4(reparacions, vehicle, mecanics);

                        // Bucle per representar les dades de les reparacions.
                        for (int i = 0; i < 100; i++) {
                            for (int j = 0; j < 3; j++) {
                                reparacions [i][j] = reparacions1 [i][j];
                                if (reparacions[i][j] != null){
                                    System.out.println(reparacions[i][j] + "   ");
                                }
                            }
                        }

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
            System.out.println();

        }while(menuItem!=5);

    }

    /**
     * Aquest mètode serveix per donar d'alta nous empleats (mecànics),
     * serveix per guardar les dades necessàries de cada mecànic.
     *
     * @param dadesMecanic array per guardar les dades dels mecànics.
     *
     * @return l'array amb les dades dels mecànics (nº d'empleat, nom i disponibilitat).
     */
    public static String[][] case2(String[][] dadesMecanic) {

        Scanner scanner = new Scanner(System.in);


        int opcioNou; // Variable per tornar a introduïr mecànic sense tornar al menú principal.
        boolean rep = true; // Variable booleana per comprovar que no es repeteix el codi de l'empleat.

        do {

            // Bucle per a control d'error: codi d'empleat ja existent
            for (int i = 0; i < 100; i++) {
                if (dadesMecanic[i][0] == null && dadesMecanic[i][1] == null) {

                    // Bucle per introduïr el codi de l'empleat sempre que aquest no existeixi prèviament.
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

                    // Introducció del nom i la disponibilitat de l'empleat sense permetre que els camps quedin en blanc.
                    do {
                        System.out.println("Introdueix el nom de l'empleat:");
                        dadesMecanic [i][1] = scanner.nextLine();
                    } while (dadesMecanic[i][1].isEmpty());

                    do {
                        System.out.println("Introdueix si està lliure (escriu \"lliure\") o ocupat (escriu \"ocupat\")");
                        dadesMecanic [i][2] = scanner.nextLine();
                    } while (dadesMecanic[i][2].isEmpty());

                    break;

                }
            }


            // Obtenció de valor per repetir o no tot el procés
            System.out.println("\nSi vols introduïr un altre mecànic, escriu [1]. Per tornar al menú principal, escriu [2]");
            opcioNou = scanner.nextInt();

        } while (opcioNou == 1);

        return dadesMecanic;

    }


    /**
     * Aquest mètode serveix per donar d'alta noves reparacions,
     * guardant les dades necessaries de cada una i oferint a l'usuari quin vehicle vol reparar.
     *
     * @param novesRep array per guardar les dades de les noves reparacions.
     * @param vehicle array amb les dades dels vehicles donats d'alta (en necessitem la matrícula).
     * @param mecanics array amb les dades dels empleat donat d'alta (en necessitem el nº d'empleat).
     *
     * @return un array amb les dades de les reparacions (matrícula del vehicle, nº de l'empleat que l'està
     * reparant i l'estat de la reparació).
     */
    public static String[][] case4(String[][] novesRep, String[][] vehicle, String[][] mecanics) {

        Scanner scanner = new Scanner(System.in);

        boolean valorCorrecte; // Variable per saber si l'usuari introdueix un valor de la llista de matrícules o vol tornar al menú principal.
        int numLlistaMat; // Número ordinal de la llista de matrícules.
        boolean dispoMeca = false; // Booleà que indica la disponibilitat del mecànic i que ajuda a definir l'estat de la reparació.
        int limit = 0;

        // Bucle per mostrar les matrícules dels vehicles donats d'alta.
        for (int i = 0; i < 100; i++) {

            if (vehicle[i][0] == null) {
                break;
            } else {
                System.out.println((i + 1) + ": " + vehicle[i][0]);
                limit = i + 1;
            }

        }

        System.out.println("Si la matrícula es troba a la llista, introdueix el número associat.");
        System.out.println("Si la matrícula no es troba a la llista, torna al menú principal pitjant qualsevol tecla i selecciona l'opció: Introduïr nou vehicle.");

        valorCorrecte = scanner.hasNextInt();

        if (valorCorrecte) {

            numLlistaMat = scanner.nextInt();

            // El codi s'executa si l'usuari selecciona una matrícula existent.
            if (numLlistaMat > 0 && numLlistaMat <= limit) {

                // Bucle per omplir el número d'empleat i l'estat de la reparació.
                for (int i = 0; i < 100; i++) {

                    if (novesRep[i][0] == null) {

                        // Omple el primer camp de la matrícula que estigui buit amb la matrícula existent seleccionada.
                        novesRep[i][0] = vehicle[numLlistaMat - 1][0];

                        for (int j = 0; j < 100; j++) {

                            // Defineix l'estat de la reparació en funció dels mecànics disponibles.
                            if (mecanics[j][2].equals("lliure")) {

                                novesRep[i][1] = mecanics[j][0];
                                novesRep[i][2] = "En curs";

                                mecanics[j][2] = "ocupat";

                                dispoMeca = true;
                                break;
                            }

                        }

                        if (!dispoMeca) {
                            novesRep[i][2] = "Oberta";
                        }

                        break;
                    }

                }

            }

        }

        return novesRep;

    }

    /**
     * Aquest mètode serveix per donar d'alta nous clients,
     * fent que l'usuari introdueixi les dades necessàries.
     *
     * @param client array per guardar les dades dels clients.
     * @return l'array amb les dades dels clients (DNI i nom del client).
     */
    public static String[][] case1(String[][] client){
        Scanner escanner = new Scanner(System.in);
        boolean rep = true; // Booleà per definir si el DNI del client existeix prèviament o no.


        for (int i=0; i<100; i++){
            if (client[i][0] == null && client[i][1] == null){

                // Bucle per introduïr el DNI del nou client sempre que aquest no existeixi prèviament.
                do{
                    System.out.println("Introdueix el DNI del client:");
                    client[i][0] = escanner.nextLine();

                    if (i != 0){
                        for (int j=0; j<100; j++){
                            if (client[j][0].equals(client[i][0])){
                                System.out.println("Aquest usuari ja existeix");
                                rep = false;
                                break;
                            }else if (i-1 == j){
                                rep =true;
                                break;
                            }
                        }
                    }

                }while (!rep);

                // Bucle per introduïr el nom del client, sense permetre que es quedi en blanc.
                do{
                    System.out.println("Introdueix el nom del client:");
                    client[i][1] = escanner.nextLine();
                }while (client[i][1].isEmpty());

                break;
            }

        }

        return client;
    }

    /**
     * Aquest mètode serveix per donar d'alta nous vehicles,
     * l'usuari n'introduirà les dades després de seleccionar el DNI corresponent.
     *
     * @param vehicle array per guardar les dades dels vehicles.
     * @param client l'array amb les dades dels clients, necessari per a obtenir el seu DNI.
     * @return l'array amb les dades dels vehicles donats d'alta (matrícula, model del cotxe i DNI del client).
     */
    public static String[][] case3(String[][] vehicle, String[][] client) {
        Scanner escanner = new Scanner(System.in);
        boolean rep = true; // Variable usada per no repetir matrícules existents.
        int limit = 0;

        // Bucle per imprimir els DNIs existents.
        for (int i = 0; i < 100; i++){
            if (client[i][0] == null){
                break;
            }else{
                System.out.println((i+1)+ ": " + client[i][0]);
            }
            limit = i+1;
        }


        System.out.println("Si està en aquesta llista, seleccioni el seu DNI amb el codi proporcionat.");
        System.out.println("En cas contrari, premi cualsevol tecla per tornar al menú i insertar un usuari");

        boolean valorCorrecte= escanner.hasNextInt();

        if (valorCorrecte){
            int ndni = escanner.nextInt();

            // El codi s'executa si l'usuari ha seleccionat un DNI existent.
            if (ndni > 0 && ndni <= limit){

                for (int i = 0; i < 100; i++) {
                    if (vehicle[i][0] == null && vehicle[i][1] == null && vehicle[i][2] == null) {

                        // Introducció d'una nova matrícula sempre que aquesta no existeixi prèviament.
                        do{
                            System.out.println("Introdueix la matrícula del vehicle:");
                            vehicle[i][0] = escanner.nextLine();


                            if (i != 0) {
                                for (int j = 0; j < 100; j++) {
                                    if (vehicle[j][0].equals(vehicle[i][0])) {
                                        System.out.println("Aquesta matrícula ja existeix");
                                        rep = false;
                                        break;
                                    } else if (i - 1 == j) {
                                        rep = true;
                                        break;
                                    }
                                }
                            }
                        }while (!rep || vehicle[i][0].isEmpty());

                        // Introducció del model del vehicle sense permetre deixar el camp en blanc.
                        do{
                            System.out.println("Introdueix el model del vehicle:");
                            vehicle[i][1] = escanner.nextLine();
                        }while (vehicle[i][1].isEmpty());


                        vehicle[i][2] = client[ndni-1][0];

                        break;
                    }
                }

            }
        }
        return vehicle;
    }





}