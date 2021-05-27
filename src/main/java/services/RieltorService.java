package services;

import com_nix_ragency.models.Rieltor;
import org.springframework.beans.factory.annotation.Autowired;
import com_nix_ragency.repositories.IRieltorRepository;

import java.util.List;

public class RieltorService {
    private final IRieltorRepository rieltorRepository;
    @Autowired
    public RieltorService(IRieltorRepository rieltorRepository){
        this.rieltorRepository=rieltorRepository;
    }
    public Rieltor getById(Long id){
        return rieltorRepository.getById(id);
    }
    public List<Rieltor> findAll(){
        return rieltorRepository.findAll();
    }
    public Rieltor saveClient(Rieltor client){
        return rieltorRepository.save(client);
    }
    public void deleteById(Long id){
        rieltorRepository.deleteById(id);
    }
}
