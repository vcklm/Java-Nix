package services;

import com_nix_ragency.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com_nix_ragency.repositories.IOwnerRepository;

import java.util.List;

@Service
public class OwnerService{
    private final IOwnerRepository ownerRepository;
    @Autowired
    public OwnerService(IOwnerRepository ownerRepository){
        this.ownerRepository=ownerRepository;
    }
    public Owner getById(Long id){
        return ownerRepository.getById(id);
    }
    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }
    public Owner saveClient(Owner client){
        return ownerRepository.save(client);
    }
    public void deleteById(Long id){
        ownerRepository.deleteById(id);
    }
}
