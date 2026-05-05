package Byteburger;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] codigos = {1, 2, 3, 4, 5, 6, 7};
        String[] nomes = {"ByteBurger Classico", "ByteBurger Duplo",
                "Batata Frita P", "Batata Frita G",
                "Refrigerante Lata", "Suco Natural", "Agua"};
        double[] precos = {22.90, 29.90, 12.00, 18.00, 7.00, 10.00, 4.00};
        int[] categorias = {1, 1, 2, 2, 3, 3, 3};
        int totalItens = codigos.length;

        double ultimoTotalPedido = 0;

        int produtoSorteadoIndice = -1;
        double valorDesconto = 0;
        String nomeProdutoSorteado = "";
        int opcao = -1;

        do {
            System.out.println("\n========================================");
            System.out.println("  BYTEBURGER - Sistema de Pedidos");
            System.out.println("========================================");
            System.out.println("  1. Novo Pedido");
            System.out.println("  2. Consultar Cardapio por Categoria");
            System.out.println("  3. Calcular Troco");
            System.out.println("  4. Sorteio do Dia");
            System.out.println("  0. Encerrar");
            System.out.println("========================================");
            System.out.print("  Escolha uma opcao: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("\n   Entrada invalida! Digite um numero (0 a 4).");
                scanner.nextLine();
                continue;
            }

            if (opcao < 0 || opcao > 4) {
                System.out.println("\n   Opcao invalida! Digite 0, 1, 2, 3 ou 4.");
                continue;
            }

            switch (opcao) {

                case 1:
                    ArrayList<String> itensPedido = new ArrayList<>();
                    ArrayList<Double> precosPedido = new ArrayList<>();
                    double total = 0;

                    System.out.println("\n--- CARDAPIO ---");
                    for (int i = 0; i < totalItens; i++) {
                        System.out.printf("  %d. %s - R$ %.2f%n",
                                codigos[i], nomes[i], precos[i]);
                    }

                    if (produtoSorteadoIndice != -1 && valorDesconto > 0) {
                        System.out.println("\n  PROMOCAO DO DIA ATIVA! ");
                        System.out.printf("  Produto sorteado: %s%n", nomeProdutoSorteado);
                        System.out.printf("  Desconto de R$ %.2f no valor total do pedido!%n", valorDesconto);
                    }

                    System.out.println("\nNOVO PEDIDO");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("\nDeseja adicionar itens ao pedido? (S/N): ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("SIM")) {

                        boolean adicionando = true;

                        while (adicionando) {
                            System.out.println("\n--- ADICIONAR ITEM ---");
                            System.out.print("Digite o codigo do produto: ");

                            if (!scanner.hasNextInt()) {
                                System.out.println("   Entrada invalida! Digite um numero.");
                                scanner.nextLine();
                                continue;
                            }

                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            if (codigo >= 1 && codigo <= totalItens) {
                                int indice = codigo - 1;
                                total += precos[indice];
                                itensPedido.add(nomes[indice]);
                                precosPedido.add(precos[indice]);
                                System.out.printf("   + %s adicionado! (R$ %.2f)%n",
                                        nomes[indice], precos[indice]);

                                System.out.print("\nDeseja adicionar outro item? (S/N): ");
                                String continuar = scanner.nextLine();
                                if (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("SIM")) {
                                    adicionando = false;
                                }
                            } else {
                                System.out.println("   Codigo invalido! Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("  Nenhum item adicionado ao pedido.");
                    }

                    double descontoAplicado = 0;
                    if (produtoSorteadoIndice != -1 && valorDesconto > 0) {
                        descontoAplicado = valorDesconto;
                        System.out.printf("%n  Desconto do produto sorteado (%s) aplicado: -R$ %.2f%n",
                                nomeProdutoSorteado, descontoAplicado);
                        produtoSorteadoIndice = -1;
                        valorDesconto = 0;
                    }

                    double totalComDesconto = total - descontoAplicado;
                    if (totalComDesconto < 0) {
                        totalComDesconto = 0;
                    }

                    System.out.println("\n--- RESUMO DO PEDIDO ---");
                    System.out.println("Cliente: " + nomeCliente);
                    System.out.println("Itens:");

                    if (itensPedido.isEmpty()) {
                        System.out.println("  Nenhum item adicionado");
                    } else {
                        int i = 0;
                        for (String item : itensPedido) {
                            System.out.printf("  - %-22s R$ %.2f%n", item, precosPedido.get(i));
                            i++;
                        }
                    }

                    System.out.printf("Subtotal: R$ %.2f%n", total);
                    if (descontoAplicado > 0) {
                        System.out.printf("Desconto: -R$ %.2f%n", descontoAplicado);
                    }
                    System.out.printf("Total a pagar: R$ %.2f%n", totalComDesconto);

                    ultimoTotalPedido = totalComDesconto;
                    break;


        } while (opcao != 0);

        scanner.close();
    }
}

