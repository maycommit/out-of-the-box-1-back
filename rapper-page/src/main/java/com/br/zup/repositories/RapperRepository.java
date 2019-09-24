package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.models.Rapper;

@Repository
public interface RapperRepository extends CrudRepository<Rapper, Integer> {

}
