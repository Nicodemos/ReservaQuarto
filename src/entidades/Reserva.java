package entidades;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    public static SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
    private int numeroQuarto;
    private Date checkin;
    private Date checkout;

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
    private Date hoje;
    public Reserva(){

        hoje = new Date();

    }
    public long duracao(){

            long duracaoMil = checkout.getTime() - checkin.getTime();
            return TimeUnit.DAYS.convert(duracaoMil, TimeUnit.MILLISECONDS);
    }

    public void atualizaData(Date checkin, Date checkout) throws Excecoes{
        if (checkout.after(checkin) && checkout.after(hoje) && !checkin.before(hoje)){

            this.checkin = checkin;
            this.checkout = checkout;
        }
        else throw new Excecoes("Data de checkin deve ser menor que a data de checkout e >= data vigente!");
    }
    public void resevaQuarto(int numeroQuarto, Date checkin, Date checkout) throws Excecoes{

        if (checkout.after(hoje) && checkin.before(checkout)){
            this.checkout = checkout;
            this.checkin = checkin;
            this.numeroQuarto = numeroQuarto;

            System.out.println("***** Reserva efetuada com sucesso! ******");
            System.out.println(" Núme do quarto: "+
                    this.numeroQuarto+"\n"+
                    " Checkin: "+simpleDate.format(this.checkin) +"\n"+
                    " Checkout: "+simpleDate.format(this.checkout) +"\n"+
                    " Duração: "+this.duracao()+"\n"+
                    "_______________________________________________"
            );
        }
        else{
            throw new Excecoes("Data de Checkin/Checkout incompatível!");
        }
    }
}
