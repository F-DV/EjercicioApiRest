package com.springbootsofka.apiRest.services;

import com.springbootsofka.apiRest.models.UsuarioModel;
import com.springbootsofka.apiRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    /**
     * El metodo debe ser de tipo Optional, ya que si no encuentra el usuario del id ingresado, puede fallar,
     * Lo que hace optional es que nos evita tener que preocuparnos si un dato esta o no y no tendremos
     * el fallo por nullPointerException. Optional, solo es para datos de retorno
     * @param id : recibe el id a buscar
     * @return : retorna el usuario que representa el id ingresado
     */
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    /**
     * Hacemos uso del metodo abstracto programado en UsuarioRepository
     * @param prioridad : recibimos el tipo de prioridad
     * @return : retornamos una lista con los usuario que corresponden a esa prioridad
     */
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    /**
     * Debemos programar el metodo try catch, ya que el metodo deleteById genera un error si no encuentra el id
     * que va a eliminar
     * @param id : id del usuario a eliminar
     * @return : true, si fue eliminado correctamente o false si no se pudo eliminar.
     */
    public boolean eliminarUsuario(long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    /**
     * Implementa el metodo Count de CrudRepository para contar cuantos usuarios
     * tiene la base de datos al momento de la solicitud
     * @return : Long del numeor de usuario encontrados en la base de datos
     */
    public Long contarUsuarios(){
        return usuarioRepository.count();
    }

    /**
     * Metodo para buscar usuario por email
     * @param email :  recibe String del usuario que se desea buscar
     * @return : retorna los datos del usuario que corresponde al email ingresado
     */
    public UsuarioModel buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
