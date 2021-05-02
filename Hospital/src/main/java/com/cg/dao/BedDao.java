package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.entities.Beds;


@Repository("beddao")
public interface BedDao extends JpaRepository<Beds, Integer> {
	//public Beds findByBedId(int id);
	/*
	 * 
	 * @Query("UPDATE Beds b SET b.name=:name,b.room=:room, b.state=:state WHERE b.id=:id"
	 * ) void editBeds(@Param("name") String name, @Param("room") String
	 * room,@Param("id") long id, @Param("state") State state);
	 */
	
}
