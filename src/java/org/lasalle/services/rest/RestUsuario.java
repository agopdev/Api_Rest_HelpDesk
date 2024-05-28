package org.lasalle.services.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.lasalle.services.controller.ControllerUsuario;
import org.lasalle.services.model.Usuario;

/**
 *
 * @author alonso
 */
@Path("usuario")
public class RestUsuario {

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam("user") String user, @FormParam("password") String password) {
        String out = "";
        try {
            ControllerUsuario controllerUsuario = new ControllerUsuario();
            Usuario usuario = controllerUsuario.getUsuarioByUsernameAndPassword(user, password);

            if (usuario != null) {
                out = "{\"idUsuario\": \"" + usuario.getIdUsuario() + "\", \"username\": \"" + usuario.getUsername() + "\", \"token\": \"" + usuario.getToken() + "\", \"lastConnection\": \"" + usuario.getLastConnection() + "\"}";
            } else {
                out = "{\"error\": \"Credenciales incorrectas\"}";
            }
        } catch(Exception e) {
            out = "{\"error\": \"" + e.getMessage() + "\"}";
        }
        return Response.ok(out).build();
    }
    
    @Path("getAllLogin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLogin(@FormParam("user") String user, @FormParam("password") String password) {
        String out = "";
        Usuario usuario = null;
        Gson gson = new Gson();
        
        try {
            ControllerUsuario controllerUsuario = new ControllerUsuario();
            usuario = controllerUsuario.getAllLogin(user, password);
            out = gson.toJson(usuario);
            
        } catch (Exception e) {
            out = """
                    {
                        "result": "%s"
                    }
                  """;
            
            out = String.format(out, e.getMessage());
        }
        return Response.ok(out).build();
    }
    
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        String out = "";
        List<Usuario> listUsers = null;
        Gson gson = new Gson();
        try {
            ControllerUsuario controllerUsuario = new ControllerUsuario();
            listUsers = controllerUsuario.getAll();
            out = gson.toJson(listUsers);
            
        } catch (Exception e) {
            out = """
                  {
                    "result": "%s"
                  }
                  """;
            
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
}