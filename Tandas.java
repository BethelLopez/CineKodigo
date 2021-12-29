import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;








    class Salas  {

      public String title;
        int seatsNumber;


        }



    class Boletas extends Salas {
        final static double costo = 13.69d;
        static int asientosDisponibles;
        static int cantidad;
        public static Salas sala1 = new Salas();
        public static Salas sala2 = new Salas();
        public static Salas sala3 = new Salas();
        public static Salas sala4 = new Salas();
        static int salaNumero;
        private static final DecimalFormat df = new DecimalFormat("0.00");


        //static Salas movie=new Salas();
         public static void main(String[] args) {
            int respuestaSi = 1;
            int respuesta2 = 2;
            String despedida1 = "Muchas gracias por su visita vuelva pronto";
            String despedida2 = "Muchas gracias por su compra, que disfruta la pelicula";

            while (respuestaSi == 1) {
                sala1.title = "Psycho";
                sala1.seatsNumber = 50;
                sala2.title = "Vertigo";
                sala2.seatsNumber = 75;
                sala3.title = "Citizen Kane";
                sala3.seatsNumber = 100;
                sala4.title = "Casablanca";
                sala4.seatsNumber = 125;


                Scanner numero = new Scanner(System.in);
                Scanner palabra = new Scanner(System.in);
                System.out.println("Bienvenidos a cine Kodigo hoy estamos exhibiendo \n Sala 1 " + sala1.title +
                        "\n Sala 2 " + sala2.title + "\n Sala 3 " + sala3.title + "\n Sala 4 " + sala4.title);
                System.out.println("Entre el numero de sala donde se exhibe la pelicula que desea ver");
                salaNumero = numero.nextInt();

                switch (salaNumero) {
                    case 1:
                        asientosDisponibles = sala1.seatsNumber;
                        break;
                    case 2:
                        asientosDisponibles = sala2.seatsNumber;
                        break;
                    case 3:
                        asientosDisponibles = sala3.seatsNumber;
                        break;
                    case 4:
                        asientosDisponibles = sala4.seatsNumber;
                        break;
                    default:
                        System.out.println("No es un numero de sala valido " + "\nPara volver al menu principal presione 1\n" +
                                "Para salir del sistema por favor presione 2");
                           respuestaSi=numero.nextInt();
                          if (respuestaSi !=1){
                              System.out.println(despedida1);
                          }
                        break;
                }
                if (salaNumero <5) {
                    System.out.println("Cuantas boletas desea comprar?");
                    cantidad = numero.nextInt();


                    if (asientosDisponibles < cantidad) {
                        System.out.println("Lo sentimos no tenemos esa cantidad de  asientos disponibles solo nos quedan " +
                                asientosDisponibles + "\nPara volver al menu principal presione 1\n" +
                                "Para salir del sistema por favor presione 2");
                              respuestaSi=numero.nextInt();
                            if (respuestaSi !=1){
                            System.out.println(despedida1);
                         };
                       } else {
                        System.out.println("Esta comprando boletas para niños?");
                        String respuesta = palabra.nextLine();
                        String si = "si";
                        String no = "no";


                        if (respuesta.compareToIgnoreCase(si) == 0) {
                            System.out.println("cuantos niños?");
                            int cantidadNinos = numero.nextInt();
                            double totalNinos = (cantidadNinos * costo) / 2;
                            double totalAdultos = (cantidad - cantidadNinos) * costo;
                            double totalGeneral = totalNinos + totalAdultos;
                            System.out.println("Total a pagar " + df.format(totalGeneral));
                            System.out.println(despedida2);
                            respuestaSi=2;


                        } else if (respuesta.compareToIgnoreCase(no) == 0) {
                            double totalGeneral = costo * cantidad;
                            System.out.println("total a pagar " + df.format(totalGeneral));
                            System.out.println(despedida2);
                            respuestaSi=2;

                        } else {
                            System.out.println("No es una respuesta valida \n Para volver al menu principal presione 1 \n " +
                                    "Para salir del sistema por favor presione 2");
                            respuestaSi=numero.nextInt();
                            if (respuestaSi !=1){
                                System.out.println(despedida1);
                            };
                        }


                    }
                }
            }
        }
    }