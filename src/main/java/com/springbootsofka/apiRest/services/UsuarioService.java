package com.springbootsofka.apiRest.services;

import com.springbootsofka.apiRest.models.UsuarioModel;
import com.springbootsofka.apiRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
/**
 * @Service : le indica a SpringBoot que es de tipo service
 * @Autowired : indica que es una instancia
 */

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Metodo que utiliza el metodo findAll() del Usuariorepositorio,
     * trae todos los usuarios, los guarda en una arrayList y devuelve
     * ese Arraylist
     * @return : ArrayList con todos los usuarios en el repository
     */
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     *
     * @param usuario : Recibe un usuario del tipo UsuarioModel,
     *                Guarda el usuario en el repositorio
     * @return : retorna el mismo usuario pero con un Id asignado
     */
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

}
