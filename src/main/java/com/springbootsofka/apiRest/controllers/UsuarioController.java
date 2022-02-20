package com.springbootsofka.apiRest.controllers;

import com.springbootsofka.apiRest.models.UsuarioModel;
import com.springbootsofka.apiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    /**
     * @RestController : Le dice a spring de que tipo es clase
     * @RequestMapping("/usuario") : Indica en que direccion del servidor se van activar los metodos de esta clase
     * @Autowired : indica a spring que ya hay una instancia de esta clase para que la busque
     * Utilizamos la instancia de Service para utilizar el metodo que nos trae los usuarios del repository
     * @GetMapping() : le indica a spring que siempre que recibamos una peticion tipo Get, ejecute el metodo que referencia
     * @PostMapping() : Ejecuta peticiones de tipo Post
     * @ResponseBody permite enviar dentro del cuerpo de la solicitud HTTP
     *@GetMapping( path = "/{id}") : si el cliente solicita por http://localhost:8080/usuario/"numeroId", le devuelve
     * extactamente el usuario que representa ese id, es un nuevo servicio
     * @PathVariable("id") :  tomara el numero ingreado en la url como parametro de entrada para activar el metodo
     * @GetMapping("/query") : Activa un nuevo servicio (metodo que esta etiquetado), ejemplo:
     *                          http://localhost:8080/usuario/query?prioridad=5
     */

    @Autowired
    UsuarioService usuarioService;

    /**@return : lista de usuario que solicitó
     */
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    /**
     * @param usuario : recibe las peticiones de usuario
     * @return : usuario guardado
     */
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id: " + id;
        }else{
            return "No pudo eliminar el usuario con id : " + id;
        }
    }

    /**
     * Metodo para devolver el numero de usuarios que tiene la base de datos
     * @return : retorna un String con un mensaje que indica cuantos usuarios tiene la base de datos
     * en el momento que es solicitada
     */
    @GetMapping("/cuantosHay")
    public String cuantosUsuariosHay(){
        long usuariosEnBaseDeDatos = this.usuarioService.contarUsuarios();
        return "La base de datos tiene: " + usuariosEnBaseDeDatos + " usuarios";
    }


}
