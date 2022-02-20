package com.springbootsofka.apiRest.repositories;

import com.springbootsofka.apiRest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    /**
     * Utilizamos esta interface y extendemos de CrudRepository que es la clase que implementa la mayoria
     * de los metodos que utilizamos con base de datos, le indicamos el tipo de dato y el tipo de indentificador
     * @Repository : le indica a Spring que es un repositorio
     *
     */

    /**
     * Este medoto es especial ya que con solo llamarlo de la manera correcta como findByPrioridad y declararlo como
     * abstract, springBoot se encarga de reocnocer lo que queremos hacer que es buscar usuarios por prioridad
     * @param prioridad : recibe la prioridad que buscamos
     * @return : devuelve un arrayList con los usuariomodel de esa prioridad
     */
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);


}
