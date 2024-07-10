package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion=0;
        double cantidad=0.0;
        urlconeccion URLCONECCIO= new urlconeccion();//instancia la clase url coneecion
        datosAPI DatosApi=new datosAPI();//instancia la clase datosAPI
        ResultExtractor extractor=new ResultExtractor();//instancia la clase ResultExtractor
       // ResultExtractor extractor=new ResultExtractor();
        //extraer EXTRAE=new extraer();
//mostrar el menu en pantalla
        String menu= """
                **************BIEMVENIDO AL CONVERSOR DE MONEDAS***********
                1) DOLAR A PESO DOMINICANO
                2) DE PESO DOMINICANO A DOLAR
                3) DE DOLAR A PESO ARGENTINO
                4) DE PESO ARGENTINO A DOLAR
                5) DE DOLAR A PESO COLOMBIANO
                6) DE PESO COLOMBIANO A DOLAR
                7) SALIR
                """;
        Scanner lectura=new Scanner(System.in);//leer por teclado

        while (opcion!=7){
            System.out.println(menu);
            System.out.println("SELECCIONE UNA OPCION.");
            try {
                opcion=lectura.nextInt();
            }catch (InputMismatchException e){
                System.out.println("ESTA OPCION NO ES VALIDA");
                lectura.next();
                continue;
                }
            if (opcion>=1 && opcion<=6){
                System.out.println("INGRESE LA CANTIDAD A CONVERTIR");
                try {
                    cantidad =lectura.nextDouble();
                } catch (InputMismatchException e){
                    System.out.println("LA CANTIDAD NO ES CORRECTA");
                    lectura.next();
                    continue;
                }
                lectura.nextLine();

                String moneda1="";
                String moneda2="";

                switch (opcion){
                    case 1:
                        moneda1="USD";
                        moneda2="DOP";
                        break;
                    case 2:
                        moneda1="DOP";
                        moneda2="USD";
                        break;
                    case 3:
                        moneda1="USD";
                        moneda2="ARS";
                        break;
                    case 4:
                        moneda1="ARS";
                        moneda2="USD";
                        break;
                    case 5:
                        moneda1="USD";
                        moneda2="COP";
                        break;
                    case 6:
                        moneda1="COP";
                        moneda2="USD";
                        break;
                }
                String url=URLCONECCIO.generalUrl(moneda1,moneda2,cantidad);
                String repuesta=DatosApi.enviarGet(url);
                String resultado=extractor.extract(repuesta);
                //String resultado=extraer.Extrae(repuesta);
                System.out.println("SI CAMBIAS: "+Double.toString(cantidad)+" "+moneda1+" LE HACE: "+resultado+" "+moneda2+" ");

            } else if (opcion==7) {System.out.println("el sistema se esta cerrando");

            }
            else {System.out.println("ESTA OPCION NO ES VALIDA, SOLO LAS QUE TIENE EL MENU");
            }

        }

lectura.close();





















    }
}



