import java.util.Scanner;

public class CalculadoraSalarial {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        double[] salarios = new double[5];
        int i = 0;
    
        do {
          System.out.print("Digite o salario " + (i + 1) + ": ");
          salarios[i] = entrada.nextDouble();
          i++;
        } while (i < 5);

        entrada.close();

        System.out.println("--------------------------");

        for (int j = 0; j < salarios.length; j++) {
            double desconto = calcularDescontoINSS(salarios[j]);
            System.out.println("Desconto de INSS do salario " + (j + 1) + ": " + desconto);
          }

        System.out.println("--------------------------");

        for (int k = 0; k < salarios.length; k++) {
            double desconto = calcularDescontoIR(salarios[k]);
            System.out.println("Desconto de IR do salario " + (k + 1) + ": " + desconto);
          }

        System.out.println("--------------------------");

        for (int m = 0; m < salarios.length; m++) {
            double salario = salarios[m];
            double descontoINSS = calcularDescontoINSS(salarios[m]);
            double descontoIR = calcularDescontoIR(salarios[m]);

            double valorLiquido = salario - descontoINSS - descontoIR;
            System.out.println("Valor liquido do salario " + (m + 1) + ": " + valorLiquido);
          }

        System.out.println("--------------------------");
        System.out.println("Esses sao os descontos e salario liquido, referentes a cada salario informado!");
    }

    public static double calcularDescontoINSS(double salario) {
        if (salario <= 1212.00) {
          return salario * 0.075;
        } else if (salario <= 2427.35) {
          return salario * 0.09;
        } else if (salario <= 3641.03) {
          return salario * 0.12;
        } else {
          return salario * 0.14;
        }
      }

      public static double calcularDescontoIR(double salario) {
        if (salario <= 1903.98) {
          return salario * 0.00;
        } else if (salario <= 2826.65) {
          return salario * 0.075;
        } else if (salario <= 3751.05) {
          return salario * 0.15;
        } else if (salario <= 4664.68) {
          return salario * 0.225;
        } else {
          return salario * 0.275;
        }
      }
}