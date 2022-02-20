package com.springbootsofka.apiRest.controllers;

import com.springbootsofka.apiRest.models.UsuarioModel;
import com.springbootsofka.apiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
     *
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

}
