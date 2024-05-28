package sergi_code_Crud.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import sergi_code_Crud.entidades.Persona;
import sergi_code_Crud.repositorios.RepositorioPersona;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    @Autowired
    private RepositorioPersona repositorioPersona;
    
    @GetMapping //getAll() /Lee el objeto persona y trae TODA la informacion
   public List<Persona> traerTOdasLasPersonas(){
    // ******TAMBIEN SE PUEDE HACER DE ESTA MANERA**** 
    //List<Persona> list = actividadServicio.listarActividades();
    //   return list;
    return repositorioPersona.findAll();

   }

   @GetMapping("{id}") //Get individual va a traer solo lo que se le pida por ID.
   public Persona obtenerPersonaPorId(@PathVariable Long id){
    return repositorioPersona.findById(id)
    .orElseThrow(() -> new RuntimeException("no se encontre la Persona con el ID " + id));

   }

   @PostMapping // Crea una persona
   public Persona crearPersona(@RequestBody Persona persona){
    return repositorioPersona.save(persona);
    

   }

   @PutMapping("{id}")  //diferencia del Post no crea sino que actualiza sobre lo ya creado al objeto Persona

   public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona persona1){
   Persona persona2 = repositorioPersona.findById(id)
    .orElseThrow(() -> new RuntimeException("no se encontre la Persona con el ID " + id));
    persona2.setNombre(persona2.getNombre());
    persona2.setApellido(persona2.getApellido());
    persona2.setDireccion(persona2.getDireccion());
   
    return repositorioPersona.save(persona2);


   }

   @DeleteMapping("{id}")  //esta insatancia va a eliminar los datos por completo

   public String borrarPersona(@PathVariable Long id){
    Persona persona = repositorioPersona.findById(id)
    .orElseThrow(() -> new RuntimeException("no se encontre la Persona con el ID " + id));
        repositorioPersona.delete(persona);
    return "La persona con el ID: " + id + " " + "fue eliminada";

   }



}
