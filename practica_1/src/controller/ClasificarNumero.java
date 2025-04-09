package controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class ClasificarNumero {

    public void MostrarNumero(){
        try {
            String archivo="C:\\Users\\ASUS\\Documents\\3.TERCER CICLO\\ESTRUCTURA DE DATOS\\practica_1\\src\\data.txt";
            BufferedReader contadorTotal = new BufferedReader(new FileReader(archivo));
            int totalNumeros = 0;
            while (contadorTotal.readLine() != null) 
            totalNumeros++;
            contadorTotal.close();

            int[] numeros = new int[totalNumeros];

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                numeros[i] = Integer.parseInt(linea.trim());
                i++;
            }
            lector.close();

            int contadorPrimos=0;
            
            for(int n:numeros){
                if(esPrimo(n)){
                    contadorPrimos++;
                }
            }
            int[] numerosPrimos=new int[contadorPrimos];
            
            
            int m=0;
                for(int n:numeros){
                if(esPrimo(n)){
                    numerosPrimos[m]=n;
                    m++;
                }
            }

            
            
            
            System.out.println("Los siguientes son los números primos:");
            for (int n : numerosPrimos) {
                System.out.print(n + "\n");
            }
            System.out.println("En total se encontraron "+contadorPrimos+" numeros Primos");

            
            Long tiempoInicio=System.nanoTime();
            Long tiempoFinal = System.nanoTime();
            Long tiempoTotal= tiempoFinal-tiempoInicio;
            System.out.println("el tiempo de ejecucion es:" + tiempoTotal + " nanosegundos");



        } catch (Exception e) {
            System.out.println("Error al leer el archivo: ");
        }
    };
    
       
    

    public boolean esPrimo(int n){
        int contador=0;
        if(n<=1){
            return false;
        }

        for(int i=2; i<=n;i++){
            if(n%i==0){
                contador++;
            }
            if(contador>1){
                return false;
            }
        }
        return true;
        
    }

}


