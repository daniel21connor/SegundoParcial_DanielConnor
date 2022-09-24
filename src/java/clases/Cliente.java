package Clases;

public class Cliente {
    private int codigo;
    private String nombre;
    private String modelo;
    private String pantalla;
   private String año;

    
    public Cliente(int codigo, String nombre, String modelo, String pantalla, String años){
       this.codigo=codigo;
       this.nombre=nombre;
       this.modelo=modelo;
       this.pantalla=pantalla;
       this.año=años;
    }
    
   

    public int Codigo() {
        return codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    }