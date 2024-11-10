import java.util.Date;

public class Chamada {
    private Date data;
    private int duracao;

    Chamada(Date data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public Date getData() {
        return this.data;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public String toString() {
        String var10000 = String.valueOf(this.data);
        return "Data: " + var10000 + ", Duração: " + this.duracao;
    }
}

