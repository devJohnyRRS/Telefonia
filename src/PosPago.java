import java.util.Date;
import java.util.Iterator;

public class PosPago extends Assinante {
    private float assinatura;

    PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void FazerChamada(Date data, int duracao) {
        this.chamadas.add(new Chamada(data, duracao));
        ++this.numChamadas;
    }

    public void ImprimirFatura(int mes) {
        this.toString();
        System.out.println("###Chamadas###");
        Iterator var3 = this.chamadas.iterator();

        while(var3.hasNext()) {
            Chamada chamada = (Chamada)var3.next();
            if (chamada.getData().getMonth() == mes) {
                System.out.println(chamada.toString());
            }
        }

        System.out.println("###Total###");
        float valorChamadas = 0.0F;
        Iterator var4 = this.chamadas.iterator();

        while(var4.hasNext()) {
            Chamada chamada = (Chamada)var4.next();
            if (chamada.getData().getMonth() == mes) {
                valorChamadas = (float)((double)valorChamadas + 1.04);
            }
        }

        System.out.println("Fatura: R$ " + valorChamadas + this.assinatura);
    }
}