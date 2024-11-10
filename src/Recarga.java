import java.util.Date;

public class Recarga {
    private Date data;
    private float valor;

    Recarga(Date data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public float getValor() {
        return this.valor;
    }

    public String toString() {
        String var10000 = String.valueOf(this.data);
        return "Data: " + var10000 + ", Valor: " + this.valor;
    }
}

