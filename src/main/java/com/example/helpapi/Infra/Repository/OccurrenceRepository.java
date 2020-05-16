package com.example.helpapi.Infra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helpapi.Domain.Models.Occurrence;
@Repository
public interface OccurrenceRepository extends JpaRepository< Occurrence, Integer> {

	public List<Occurrence> findAll();

//	public Occurrence findByIdandName(int id, String name);

	public Occurrence findById(int id);

}
