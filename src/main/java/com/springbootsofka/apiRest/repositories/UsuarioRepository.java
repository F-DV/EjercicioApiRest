package com.springbootsofka.apiRest.repositories;

import com.springbootsofka.apiRest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    /**
     * Utilizamos esta interface y extendemos de CrudRepository que es la clase que implementa la mayoria
     * de los metodos que utilizamos con base de datos, le indicamos el tipo de dato y el tipo de indentificador
     * @Repository : le indica a Spring que es un repositorio
     *
     */
}
