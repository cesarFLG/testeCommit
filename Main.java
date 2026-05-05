package Byteburger;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        case 2:
        System.out.println("\nCONSULTAR CARDAPIO POR CATEGORIA");
        System.out.println("  1 - Lanches");
        System.out.println("  2 - Acompanhamentos");
        System.out.println("  3 - Bebidas");
        System.out.println("  0 - Voltar");

        int categoria = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("  Escolha uma categoria: ");

            if (scanner.hasNextInt()) {
                categoria = scanner.nextInt();
                scanner.nextLine();

                if (categoria >= 0 && categoria <= 3) {
                    entradaValida = true;
                } else {
                    System.out.println("   Opcao invalida! Digite 0, 1, 2 ou 3.");
                }
            } else {
                System.out.println("   Entrada invalida! Digite um numero.");
                scanner.nextLine();
            }
        }

        if (categoria == 0) {
            break;
        }

        switch (categoria) {
            case 1:
                System.out.println("\n--- LANCHES ---");
                break;
            case 2:
                System.out.println("\n--- ACOMPANHAMENTOS ---");
                break;
            case 3:
                System.out.println("\n--- BEBIDAS ---");
                break;
        }

        for (int i = 0; i < totalItens; i++) {
            if (categorias[i] == categoria) {
                System.out.printf("  %d. %s - R$ %.2f%n",
                        codigos[i], nomes[i], precos[i]);
            }
        }
        break;