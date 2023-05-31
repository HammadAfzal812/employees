package edu.imdadia.alumnus.services;

import edu.imdadia.alumnus.entity.AlumnusEntity;
import edu.imdadia.alumnus.repository.AlumnusRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlumnusServiceImpl implements AlumnusService {
    private final AlumnusRepo alumnusRepo;

    public AlumnusServiceImpl(AlumnusRepo alumnusRepo) {
        this.alumnusRepo = alumnusRepo;
    }

    @Override
    public List<AlumnusEntity> findAllByDistrict(String district) {
        return alumnusRepo.findAllByDistrict(district);
    }

    @Override
    public List<AlumnusEntity> findAllByType(String type) {
        return alumnusRepo.findByType(type);
    }

    @Override
    public void save(AlumnusEntity alumnusEntity) {

        try {
            alumnusRepo.save(alumnusEntity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(AlumnusEntity alumnusEntity) {
        alumnusRepo.delete(alumnusEntity);
    }

    @Override
    public Optional<AlumnusEntity> findByAlumnusName(String name) {
        return alumnusRepo.findByAlumnusName(name);
    }

    @Override
    public Optional<AlumnusEntity> findByAlumnusNameAndFatherName(String name, String fatherName) {
        return alumnusRepo.findByAlumnusNameAndFatherName(name,fatherName);
    }
}