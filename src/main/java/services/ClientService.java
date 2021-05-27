package services;

import com_nix_ragency.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com_nix_ragency.repositories.IClientRepository;

import java.util.List;

@Service
public class ClientService{
    private final IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    public Client getById(Long id){
        return clientRepository.getById(id);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
