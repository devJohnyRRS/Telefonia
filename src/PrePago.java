
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class PrePago extends Assinante {
    private float creditos;
    private int numRecargas;
    protected ArrayList<Recarga> recargas = new ArrayList();

    PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
    }

    public void Recarregar(Date data, float valor) {
        this.recargas.add(new Recarga(data, valor));
        ++this.numRecargas;
        this.creditos += valor;
    }

    public void FazerChamada(Date data, int duracao) {
        if ((double)this.creditos >= 1.45) {
            this.chamadas.add(new Chamada(data, duracao));
            ++this.numChamadas;
            this.creditos = (float)((double)this.creditos - 1.45);
        } else {
            System.out.println("Créditos insuficientes");
        }

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

        System.out.println("###Recargas###");
        var3 = this.recargas.iterator();

        while(var3.hasNext()) {
            Recarga recarga = (Recarga)var3.next();
            if (recarga.getData().getMonth() == mes) {
                System.out.println(recarga.toString());
            }
        }

        System.out.println("###Total###");
        float valorChamadas = 0.0F;
        Iterator var4 = this.chamadas.iterator();

        while(var4.hasNext()) {
            Chamada chamada = (Chamada)var4.next();
            if (chamada.getData().getMonth() == mes) {
                valorChamadas = (float)((double)valorChamadas + 1.45);
            }
        }

        float valorRecargas = 0.0F;
        Iterator var5 = this.recargas.iterator();

        while(var5.hasNext()) {
            Recarga recarga = (Recarga)var5.next();
            if (recarga.getData().getMonth() == mes) {
                valorRecargas += recarga.getValor();
            }
        }

        System.out.println("Chamadas: R$ " + valorChamadas + "\nRecargas: R$ " + valorRecargas);
        System.out.println("Créditos restantes: R$ " + this.creditos);
    }
}

