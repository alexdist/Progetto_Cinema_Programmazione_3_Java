package Cinema.cinema_Infrastructure;

public class PostoASedere {
    private int numero;
    private boolean libero;

    public PostoASedere(int numero, boolean libero){
        this.numero = numero;
        this.libero = libero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isLibero() {
        return libero;
    }

    public void setLibero(boolean libero) {
        this.libero = libero;
    }
}
