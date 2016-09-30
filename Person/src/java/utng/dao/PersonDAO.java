/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.dao;

import java.util.List;
import utng.model.Person;

/**
 *
 * @author Jorge
 */
public interface PersonDAO {
    void agregarPerson(Person person);
    void borrarPerson(int pUuid);
    void cambiarPerson(Person person);
    List<Person> desplegarPerson();
    Person elegirPerson(int pUuid);
    
}
