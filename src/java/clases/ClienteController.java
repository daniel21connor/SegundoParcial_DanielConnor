package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public class ClienteController {
      Cliente[] tablaCliente;
    int indiceArray;
    private TiendaParcial conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public ClienteController(){
        this.tablaCliente = new Cliente[100];
        this.indiceArray=0;
    }
    
     public void guardarAlumno(Cliente cliente){
        this.tablaCliente[this.indiceArray]=cliente;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Cliente[] getCliente(){
        return this.tablaCliente;
    }
    
    public void abrirConexion(){
        conectorBD= new TiendaParcial();
        conexion=conectorBD.conectar();
    }    
   
    
    public String guardarAlumno2(Cliente cliente){        
        String sql = "INSERT INTO tienda.producto(codigo, marca, modelo, pantalla, anio_fabricacion) ";
             sql += " VALUES(?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, cliente.getCodigo());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getModelo());
            statement.setString(4, cliente.getPantalla());
            statement.setString(5, cliente.getAño());
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    public void getAlumnos2(StringBuffer respuesta){   
        String sql="select * from tienda.producto";
        try{
        abrirConexion();
        respuesta.setLength(0);
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("codigo")).append("</td>");
                respuesta.append("<td >").append(result.getString("marca")).append("</td>");
                respuesta.append("<td >").append(result.getString("modelo")).append("</td>");
                respuesta.append("<td >").append(result.getString("pantalla")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("anio_fabricacion"))
                        .append("\"  onclick=\"eliminarAlumno(this.id);\">") 
                         //.append("\"  onclick=\"eliminarAlumno("+result.getString("numero_carne")+");\">") 
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public String eliminarALumno(int carne){        
        String sql = "DELETE FROM alumno WHERE codigo="+carne;              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    
}