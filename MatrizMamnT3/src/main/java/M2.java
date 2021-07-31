
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marjorie
 */
public class M2 {
    public static String[][] Comisiones = new String[3][6];
    public static Scanner Scan = new Scanner(System.in);
    private static final int NombreVendedor = 0;
    private static final int Enero = 1;
    private static final int Febrero = 2;
    private static final int Marzo = 3;
    private static final int Promedio = 4;

    public static void CargaInformacion(int fila) {
        Scanner t = new Scanner(System.in);
        int contador = 0;
        System.out.println("Ingrese el nombre del vendedor:");
        Comisiones[fila][NombreVendedor] = t.nextLine();
        System.out.println("Ingrese las ventas del mes de Enero:");
        Comisiones[fila][Enero] = t.nextLine();
        System.out.println("Ingrese las ventas del mes de Febreo:");
        Comisiones[fila][Febrero] = t.nextLine();
        System.out.println("Ingrese las ventas del mes de Marzo:");
        Comisiones[fila][Marzo] = t.nextLine();
    }

    public static void TotalPorMes() {
        int acum;
        int contadorfila;
        int[] totalMes = new int[Comisiones.length];

        for (int columna = 1; columna < Comisiones[0].length - 1; columna++) {
            acum = 0;
            contadorfila = 0;
            for (int fila = 0; fila < Comisiones.length; fila++) {
                acum += Integer.parseInt(Comisiones[fila][columna]);
            }
            System.out.println("Columna No:" + columna + "    Total Acumulado:" + acum);
        }
    }

    public static void imprimirDecorado(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int x = 0; x < matriz[i].length; x++) {
                System.out.print(matriz[i][x]);
                if (x != matriz[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("...");
        }
    }

    public static void MesT() {
        String nombre = "";
        int Acumulador;
        int TotaldeMeses;
        double Promedio;

        for(int fila = 0; fila < Comisiones.length; fila++) {
            TotaldeMeses = 0;
            Acumulador = 0;
            Promedio = 0;

            for (int columna = 1; columna < Comisiones[fila].length - 2; columna++) {
                Acumulador += Integer.parseInt(Comisiones[fila][columna]);
                TotaldeMeses++;
                Promedio = (Acumulador / TotaldeMeses);
            }
            Comisiones[fila][Comisiones[fila].length - 2] = String.valueOf(Acumulador);
            Comisiones[fila][Comisiones[fila].length - 1] = String.valueOf(Promedio);
        }
    }

    public static void VentaMaximaMes(String Mes) {
        int ValorF;
        int Meses;
        int MaximodeVentas = 0;
        int MinimodeVentas = 10000;
        String NombreMaxVent = "";
        String NombreMinVent = "";

        switch (Mes.toLowerCase()) {
            case "Enero":
                Meses = 1;
                break;

            case "Febrero":
                Meses = 2;
                break;

            case "Marzo":
                Meses = 3;
                break;

            default:
                System.out.println("Inválido");
                return;
        }

        for(int Fila = 0; Fila < Comisiones.length; Fila++) {
            ValorF = Integer.parseInt(Comisiones[Fila][Meses]);

            if (ValorF > MaximodeVentas) {
                MaximodeVentas = ValorF;
                NombreMaxVent = Comisiones[Fila][0];
            } else if (ValorF < MinimodeVentas) {
                MinimodeVentas = ValorF;
                NombreMinVent = Comisiones[Fila][0];
            }
        }
        System.out.println(NombreMaxVent + " Su máximo de ventas fue: " + MaximodeVentas + " En el mes de: " + Mes);
        System.out.println(NombreMinVent + " Su mínimo de ventas fue: " + MinimodeVentas + " En el mes de: " + Mes);
    }

    public static void MaximodeVentasTODO() {
        int Vfila;
        int MinimodeVentas = 10000;
        int MaximodeVentas = 0;
        String NombreMayorVenta = "";
        String NombreMenorVenta = "";

        for(int fila = 0; fila < Comisiones.length; fila++) {
            Vfila = Integer.parseInt(Comisiones[fila][4]);

            if (Vfila > MaximodeVentas) {
                MaximodeVentas = Vfila;
                NombreMayorVenta = Comisiones[fila][0];
            } else if (Vfila < MinimodeVentas) {
                MinimodeVentas = Vfila;
                NombreMenorVenta = Comisiones[fila][0];
            }
        }

        System.out.println(NombreMayorVenta + " Su máximo de ventas fue de: " + MaximodeVentas + "");
        System.out.println(NombreMenorVenta + " Su máximo de ventas fue de: " + MinimodeVentas + "");
    }

    public static void ModificaMatriz(int fila, int columna) {
        try {
            var ModificarNombre = Comisiones[fila][columna];
            System.out.println("Nombre que desea modificar: " + ModificarNombre);
            System.out.print("Reemplazar por el nombre: ");
            var Reemplazo = Scan.nextLine();
            Comisiones[fila][columna] = Reemplazo;
            System.out.println(ModificarNombre + " " + Reemplazo);
        } catch (Exception e) {
            System.out.println("¡No se puede modificar!");
        }
    }

    public static void RegistroVendedores() {
        for (int i = 0; i < Comisiones.length; i++) {
            CargaInformacion(i);
        }
    }

    public static void main(String[] args) {
        RegistroVendedores();
        imprimirDecorado(Comisiones);
        MesT();
        TotalPorMes();
        VentaMaximaMes("febrero");
        MaximodeVentasTODO();
        ModificaMatriz(0, 0);
        imprimirDecorado(Comisiones);
    }
}