package mx.com.tot.service;

import mx.com.tot.dao.EmpleadoRepository;
import mx.com.tot.dto.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class EmpleadoService {
    public EmpleadoService() {
        System.out.println("EmpleadoService()>>>>>>");
    }

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll() {
        return   empleadoRepository.getAll();
    }
}
