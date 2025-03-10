package com.example.event_management;


import com.example.event_management.repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramareService {

    @Autowired
    private ProgramareRepository programareRepository;

    public Programare addProgramare(Programare programare) {
        return programareRepository.save(programare);
    }

    public List<Programare> getAllProgramari() {
        return programareRepository.findAll();
    }

    public Programare updateProgramare(Long id, Programare programare) {
        programare.setId(id);
        return programareRepository.save(programare);
    }

    public void deleteProgramare(Long id) {
        programareRepository.deleteById(id);
    }
}
