package com.cg.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.BedDao;
import com.cg.dao.TreatmentHistoryDao;
import com.cg.entities.Beds;
import com.cg.entities.States;
import com.cg.entities.TreatmentHistory;
import com.cg.entities.TreatmentStatus;
import com.cg.services.BedServiceImpl;
import com.cg.services.TreatmentHistoryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalServiceTest {

	@Autowired
	private BedServiceImpl service;

	@MockBean
	private BedDao repository;

	@Autowired
	private TreatmentHistoryServiceImpl treatService;

	@MockBean
	private TreatmentHistoryDao thDao;

	@Test
	public void getAllBedTest() {

		when(repository.findAll()).thenReturn((List<Beds>) Stream
				.of(new Beds(10, 10, "acd", "xyz", States.FREE), new Beds(20, 10, "def", "xyz", States.OCCUPIED))
				.collect(Collectors.toList()));

		assertEquals(2, service.viewBeds().size());

	}

	@Test
	public void testGetTreatmentInfo() {
		TreatmentHistory treatHistory = new TreatmentHistory();
		treatHistory.setPatientId(1);
		treatHistory.setDiagnosis("agdh");
		treatHistory.setDoctorName("ashjh");
		treatHistory.setTreatmentStatus(TreatmentStatus.NORMAL);
		
		Mockito.when(thDao.getOne(1)).thenReturn(treatHistory);

		assertThat(treatService.getTreatmentInformation(1)).isEqualTo(treatHistory);
	}

}
