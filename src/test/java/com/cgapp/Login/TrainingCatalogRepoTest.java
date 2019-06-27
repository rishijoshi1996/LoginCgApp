package com.cgapp.Login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.TrainingCatalog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingCatalogRepoTest {

	@Autowired
	private TrainingCatalogRepository trepo;
	
	@Test
	public void saveTrainingCatalog() {
		TrainingCatalog training = new TrainingCatalog(12, "java", "A4", "9", "Mumbai", "virtual", "16", "18", "9:30", "6:00", "www");
		trepo.save(training);
		Assert.assertNotNull(trepo.findOne(12));
		trepo.delete(12);
		Assert.assertNull(trepo.findOne(12));
	}
}
