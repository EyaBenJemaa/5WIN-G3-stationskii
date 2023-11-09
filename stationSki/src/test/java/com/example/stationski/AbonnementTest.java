package com.example.stationski.services;

import com.example.stationski.entities.Abonnement;
import com.example.stationski.entities.TypeAbonnement;
import com.example.stationski.repositories.AbonnementRepository;
import com.example.stationski.repositories.SkieurRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbonnementTest {

    @Mock
    private AbonnementRepository abonnementRepository;

    @Mock
    private SkieurRepository skieurRepository;

    @InjectMocks
    private AbonnementService abonnementService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAbonnementByType() {
        // Arrange
        TypeAbonnement type = TypeAbonnement.ANNUEL;
        Set<Abonnement> expectedAbonnements = new HashSet<>(); // Set your expected abonnements here

        // Mock the behavior of the repository
        when(abonnementRepository.findByTypeAbon(type)).thenReturn(expectedAbonnements);

        // Act
        Set<Abonnement> result = abonnementService.getAbonnementByType(type);

        // Assert
        assertEquals(expectedAbonnements, result);
    }

}
