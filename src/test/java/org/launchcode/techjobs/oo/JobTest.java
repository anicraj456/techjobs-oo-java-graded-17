package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobAll = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //1
        assertEquals("Product tester", jobAll.getName());
        assertTrue(jobAll.getName() instanceof String);
        //2
        assertEquals("ACME", jobAll.getEmployer().getValue());
        assertTrue(jobAll.getEmployer() instanceof Employer);
        //3
        assertEquals("Desert", jobAll.getLocation().getValue());
        assertTrue(jobAll.getLocation() instanceof Location);
        //4
        assertEquals("Quality control", jobAll.getPositionType().getValue());
        assertTrue(jobAll.getPositionType() instanceof PositionType);
        //5
        assertEquals("Persistence", jobAll.getCoreCompetency().getValue());
        assertTrue(jobAll.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job jobAll1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobAll2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(jobAll2,jobAll1);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobAll1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobAll1.toString().startsWith(System.lineSeparator()));
        assertTrue(jobAll1.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobAll1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedString = System.lineSeparator()+ "ID: " + jobAll1.getId()+System.lineSeparator()+
                "Name: Product tester"  +System.lineSeparator()+
                "Employer: ACME"  +System.lineSeparator()+
                "Location: Desert"  +System.lineSeparator()+
                "Position Type: Quality control" +System.lineSeparator()+
                "Core Competency: Persistence" +System.lineSeparator()
                ;
        assertEquals(jobAll1.toString(), expectedString);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobAll1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedString = System.lineSeparator()+ "ID: " + jobAll1.getId()+System.lineSeparator()+
                "Name: Product tester"  +System.lineSeparator()+
                "Employer: Data not available"  +System.lineSeparator()+
                "Location: Desert"  +System.lineSeparator()+
                "Position Type: Quality control" +System.lineSeparator()+
                "Core Competency: Persistence" +System.lineSeparator()
                ;
        assertEquals(jobAll1.toString(), expectedString);
    }


}
