package org.contobancario.contobancario.db.serv;

import java.util.List;
import java.util.Optional;

import org.contobancario.contobancario.db.pojo.ContoBancario;
import org.contobancario.contobancario.db.repo.ContoBancarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepo contoRepo;

    public List<ContoBancario> getAllContoBancario() {

        return contoRepo.findAll();
    }

    public Optional<ContoBancario> getContoBancarioById(int id) {

        return contoRepo.findById(id);
    }

    public void save(ContoBancario e) {

        contoRepo.save(e);
    }

    public void delete(ContoBancario e) {

        contoRepo.delete(e);
    }
}