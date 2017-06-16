package vista.contenedores;

import java.util.Observable;

public class Consola extends Observable
{
    private String contenidos = "";

    public void agregarMensaje(String m)
    {
        contenidos = "\t" + m + "\n" +contenidos;
        setChanged();
        notifyObservers();
    }

    public String getMensaje()
    {
        return contenidos;
    }
}

