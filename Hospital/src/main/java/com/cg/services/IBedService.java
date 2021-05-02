package com.cg.services;

import java.util.List;
import java.util.Optional;

import com.cg.entities.Beds;




public interface IBedService {
	
	public Beds addBeds(Beds bed);
	public List<Beds> viewBeds();
	public Beds editBeds(Beds bed);
	public String removeBeds(int id);
	public Beds saveUpdate(Beds bed);
}
