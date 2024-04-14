package persistencia.DAO;


import java.util.List;
import modelo.Contacto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author developer
 */
public interface ContactoDAO {

    Contacto read(String s);

    void create(Contacto contacto);

    void update(Contacto contacto);

    void delete(Contacto contacto);

    List<Contacto> list();

}
