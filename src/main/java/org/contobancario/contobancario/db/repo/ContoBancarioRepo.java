package org.contobancario.contobancario.db.repo;

import org.contobancario.contobancario.db.pojo.ContoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoBancarioRepo extends JpaRepository<ContoBancario, Integer> {

}
