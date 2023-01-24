package com.Portafolio.mgb.Controller;

import com.Portafolio.mgb.Entity.Persona;
import com.Portafolio.mgb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return("La persona Fue creada.");
    } 
    
   @DeleteMapping("/personas/borrar/{id}")
   public String deletePersona(@PathVariable Long id){
       ipersonaService.deletePersona(id);
       return("La persona fue eliminada.");
   }
   @PutMapping("/personas/editar/{id}")
   public Persona editPersona(@PathVariable Long id,    
           @RequestParam("nombre") String nuevoNombre,
           @RequestParam("nombre") String nuevoapellido,
           @RequestParam("nombre") String nuevoimg){
      Persona persona = ipersonaService.findPersona(id);
      persona.setNombre(nuevoNombre);
      persona.setApellido(nuevoapellido);
      persona.setImg(nuevoimg);
      
      ipersonaService.savePersona(persona);
      return (persona);
   }

@GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)5);
    }
}