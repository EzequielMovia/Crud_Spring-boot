package sergi_code_Crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergi_code_Crud.entidades.Persona;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona,Long> {
    
}
