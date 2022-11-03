/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionsqljava;

/**
 *
 * @author aleja
 */
public class Principal {
     public static void main(String[] args) {
        Conexion conexion=new Conexion();
        conexion.conectar();
       conexion.consultaTabla();
       conexion.desconectar();
    }
}
