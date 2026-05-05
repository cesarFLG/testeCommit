package Byteburger;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

                case 4:
                    System.out.println("\nSORTEIO DO DIA");

                    produtoSorteadoIndice = (int) (Math.random() * totalItens);
                    nomeProdutoSorteado = nomes[produtoSorteadoIndice];
                    double precoSorteado = precos[produtoSorteadoIndice];
                    valorDesconto = precoSorteado * 0.20;

                    double precoComDesconto = precoSorteado - valorDesconto;

                    System.out.println("   PRODUTO SORTEADO DO DIA!");
                    System.out.printf("  Produto: %s%n", nomeProdutoSorteado);
                    System.out.printf("  Preco original:    R$ %.2f%n", precoSorteado);
                    System.out.printf("  Desconto de 20%%:  -R$ %.2f%n", valorDesconto);
                    System.out.printf("  Preco com desconto: R$ %.2f%n", precoComDesconto);
                    System.out.println("\n   Esse desconto sera aplicado no seu proximo pedido!");
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema. Volte sempre!");
                    break;

                default:
                    System.out.println("\nOpcao invalida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

