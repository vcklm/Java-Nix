package services;

import com_nix_ragency.models.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com_nix_ragency.repositories.IFlatRepository;

import java.util.List;

@Service
public class FlatService{
    private final IFlatRepository flatRepository;

    @Autowired
    public FlatService(IFlatRepository flatRepository){
        this.flatRepository=flatRepository;
    }
    public Flat getById(Long id){
        return flatRepository.getById(id);
    }
    public List<Flat> findAll(){
        return flatRepository.findAll();
    }
    public Flat saveClient(Flat client){
        return flatRepository.save(client);
    }
    public void deleteById(Long id){
        flatRepository.deleteById(id);
    }
}
