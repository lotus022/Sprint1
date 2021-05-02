package com.cg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.BedDao;
import com.cg.entities.Beds;
import com.cg.exception.BedNotfoundException;

import java.util.List;
import java.util.Optional;

@Service("/bedService")
public class BedServiceImpl implements IBedService {
	Logger logger = LoggerFactory.getLogger(BedServiceImpl.class);

	@Autowired
	BedDao bDao;

	@Override
	public Beds addBeds(Beds bed) {
		logger.info("Bed added");
		if (bed == null) {
			throw new BedNotfoundException("No bed found");
		} else {
			
			return bDao.saveAndFlush(bed); 
		}

	}

	@Override
	public List<Beds> viewBeds() {
		logger.info("for vew all beds................");
		List<Beds> lbed = bDao.findAll();
		if (lbed.isEmpty()) {
			throw new BedNotfoundException("Bed not found");
		}
		return lbed;
	}

	public Beds saveUpdate(Beds bed) {
		
		return bed=bDao.save(bed);
	}

	public Beds editBeds(Beds bed) {
		logger.info("To edit bed service............");
		if (bed == null) {
			throw new BedNotfoundException("Bed not found");
		} else {
			bed=bDao.save(bed);
			return bed;
		}
	}

	@Override
	public String removeBeds(int id) {
		logger.info("Remove beds...........");
		Beds bed=bDao.findById(id).get();
		if (bed==null) {
			throw new BedNotfoundException("bed not found of given id");
		} else {
			bDao.deleteById(id);
			return "bed Remove Successfully.....";
		}
		
		
	}





}
