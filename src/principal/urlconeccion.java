package principal;

public class urlconeccion {
    public  String generalUrl(String inicialDeMoneda1, String inicialDeMoneda2, double cantidad){
        String monto=Double.toString(cantidad);
        String coneccion="https://v6.exchangerate-api.com/v6/36119d4c095b59642d10aeb4/pair/"+inicialDeMoneda1+"/"+inicialDeMoneda2+"/"+cantidad;


        return coneccion;

    }
}
