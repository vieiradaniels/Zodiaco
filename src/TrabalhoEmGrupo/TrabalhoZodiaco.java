package trabalhoemgrupo;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class TrabalhoZodiaco {

    public static void main(String[] args) {

        String Nome, signo;
        int dianasc = 0, mesdenasc, resposta, sexo, anodenasc = 0, sorte, idade, diaA, mesA, anoA;
        do {
            Scanner ler = new Scanner(System.in);
            String[] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

            Random random = new Random();
            Calendar hoje = Calendar.getInstance();
            diaA = hoje.get(Calendar.DAY_OF_MONTH);
            mesA = hoje.get(Calendar.MONTH);
            anoA = hoje.get(Calendar.YEAR);

            System.out.println("Digite seu nome e sobrenome:");
            Nome = ler.nextLine();
            if (Nome.length() <= 8) {
                System.out.println("Digite um nome válido");
                return;
            }
            // Lê o dia de nascimento
            System.out.println("Digite o dia de nascimento:");
            dianasc = ler.nextInt();

            // Lê o mês de nascimento
            System.out.println("Digite o mês de nascimento em forma de números:");
            mesdenasc = ler.nextInt();

            // Lê o ano de nascimento
            System.out.println("Digite o ano de nascimento:");
            anodenasc = ler.nextInt();
            // Verifica se o mês está no intervalo correto (1 a 12)
            if (mesdenasc < 1 || mesdenasc > 12) {
                System.out.println("Mês inválido. Digite novamente.");
                return;
            }
            boolean anobissexto = ((anodenasc % 4 == 0) && (anodenasc % 100 != 0)) || (anodenasc % 400 == 0);

            int diasnasc;

            if (mesdenasc == 2 && anobissexto) {
                diasnasc = 29;
            } else if (mesdenasc == 2) {
                diasnasc = 28;
            } else if (mesdenasc == 4 || mesdenasc == 6 || mesdenasc == 9 || mesdenasc == 11) {
                diasnasc = 30;
            } else {
                diasnasc = 31;
            }

            if (dianasc < 1 || dianasc > diasnasc) {
                System.out.println("Dia inválido. Digite novamente.");
                return;
            }

            // Verifica se o ano está no intervalo correto (1940 a 2023)
            if (anodenasc < 1940 || anodenasc > 2023) {
                System.out.println("Ano inválido. Digite novamente.");
                return;
            }

            idade = ((anoA * 365 + mesA * 12 + diaA) - (anodenasc * 365 + mesdenasc * 12 + dianasc)) / 365;

            signo = "";
            if ((dianasc >= 21 && mesdenasc == 3) || (dianasc <= 20 && mesdenasc == 4)) {
                signo = "Áries";
            } else if ((dianasc >= 21 && mesdenasc == 4) || (dianasc <= 20 && mesdenasc == 5)) {
                signo = "Touro";
            } else if ((dianasc >= 21 && mesdenasc == 5) || (dianasc <= 20 && mesdenasc == 6)) {
                signo = "Gêmeos";
            } else if ((dianasc >= 21 && mesdenasc == 6) || (dianasc <= 21 && mesdenasc == 7)) {
                signo = "Câncer";
            } else if ((dianasc >= 22 && mesdenasc == 7) || (dianasc <= 22 && mesdenasc == 8)) {
                signo = "Leão";
            } else if ((dianasc >= 23 && mesdenasc == 8) || (dianasc <= 22 && mesdenasc == 9)) {
                signo = "Virgem";
            } else if ((dianasc >= 23 && mesdenasc == 9) || (dianasc <= 22 && mesdenasc == 10)) {
                signo = "Libra";
            } else if ((dianasc >= 23 && mesdenasc == 10) || (dianasc <= 21 && mesdenasc == 11)) {
                signo = "Escorpião";
            } else if ((dianasc >= 22 && mesdenasc == 11) || (dianasc <= 21 && mesdenasc == 12)) {
                signo = "Sagitário";
            } else if ((dianasc >= 22 && mesdenasc == 12) || (dianasc <= 19 && mesdenasc == 1)) {
                signo = "Capricórnio";
            } else if ((dianasc >= 20 && mesdenasc == 1) || (dianasc <= 18 && mesdenasc == 2)) {
                signo = "Aquário";
            } else if ((dianasc >= 19 && mesdenasc == 2) || (dianasc <= 20 && mesdenasc == 3)) {
                signo = "Peixes";
            }

            sorte = random.nextInt(100);
            String[] cores = {"vermelho", "azul", "verde", "amarelo", "rosa", "preta", "branca"};
            String cor = cores[random.nextInt(cores.length)];
            System.out.println("Digite 1 se for Feminino e 2 se for Masculino");
            sexo = ler.nextInt();
            switch (sexo) {
                case 1:

                    System.out.println("Sra." + Nome + " nasceu no dia " + String.format("%02d", dianasc) + " de " + meses[mesdenasc] + " de " + anodenasc + " você tem " + idade + " anos e seu signo é " + signo);
                    System.out.println("Sua cor é " + cor + " e seu número da sorte é: " + sorte);
                    break;

                case 2:

                    System.out.println("Sr." + Nome + " nasceu no dia " + String.format("%02d", dianasc) + " de " + meses[mesdenasc] + " de " + anodenasc + " você tem " + idade + " anos e seu signo é " + signo);
                    System.out.println("Sua cor é " + cor + " e seu número da sorte é: " + sorte);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
            System.out.println("Deseja fazer novamente? (S/N): ");
            resposta = ler.next().charAt(0);
            if (resposta != 's'|| resposta != 'S' || resposta != 'N' || resposta != 'n'){
                System.out.println("Digite somente a opção válida!");
                resposta = ler.next().charAt(0);
            }
        } while (resposta == 'S' || resposta == 's');
    }
}