import entidades.Excecoes;
import entidades.Reserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Boolean condicao = true;
        Reserva res = new Reserva();
        int numeroQuarto;
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        Date entrada;
        Date saida;
        int val=0;
        Scanner  entradaDados = new Scanner(System.in);

        while(condicao) {
            System.out.println("********** Faça sua reserva! ***********");
            System.out.println("Digite (1) para uma nova reserva e (2) para atualizar a ultima reserva.");
            val = entradaDados.nextInt();

            switch (val){
                case 1:
                    System.out.println("Digite o numero do quarto");
                    numeroQuarto = entradaDados.nextInt();
                    try{
                        System.out.println("Data do Checkin: ");
                        entrada = sp.parse(entradaDados.next());
                        System.out.println("Data do Checkout: ");
                        saida= sp.parse(entradaDados.next());
                        res.resevaQuarto(numeroQuarto, entrada, saida);
                    }
                    catch (ParseException e) {
                        System.out.println("Erro de parse: "+e);
                    }
                    catch (Excecoes ex){
                        System.out.println((ex.getMessage()));
                    }
                    catch (InputMismatchException inP){
                        System.out.println("Erro no tipo de dados para vairiável esperada: "+ inP.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Data do Checkin: ");
                        entrada = sp.parse(entradaDados.next());
                        System.out.println("Data do Checkout: ");
                        saida= sp.parse(entradaDados.next());
                        res.atualizaData(entrada,saida);
                    }
                    catch (ParseException e) {
                        System.out.println("Erro de parse: "+e);
                    }
                    catch (Excecoes ex){
                        System.out.println((ex.getMessage()));
                    }
                    catch (InputMismatchException inP){
                        System.out.println("Erro no tipo de dados para vairiável esperada: "+ inP.getMessage());
                    }
                    break;
            }
        }
    }
}