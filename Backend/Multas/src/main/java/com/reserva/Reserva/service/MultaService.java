package com.example.casosemestral;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.casosemestral.model.request.agregarMulta;
import com.example.casosemestral.model.request.actualizarMulta;
import com.example.casosemestral.model.entities.Multas;
import com.example.casosemestral.repositories.MultasRepository;

@Service
public class MultaService{

	@Autowired 
	private MultasRepository MultasRepository;

	public List<Multas> obtenerTodasLasMultas(){
		return MultasRepository.findAll();
	}


	public Multas obtenerMultasPorId(int idUsuario){
		Multas multa = (MultasRepository.findById(idUsuario)).orElse(null);
		if(multa == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID no encontrada");
		}
		return multa;
	}

	public Multas agregarMulta(agregarMulta nueva){

		Multas multaNueva = new Multas();
		
		multaNueva.setMotivo(nueva.getMotivoMulta());
		return MultasRepository.save(multaNueva);
		}
		
		
		
		public String eliminarMulta (int idMulta){
		if (MultasRepository.existsById(idMulta)) {
			MultasRepository.deleteById(idMulta);
			return "Multa eliminada con exito";
		}else{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Multa no encontrada");
		
		}
	}
		
	public Multas actualizarMulta(actualizarMulta nuevaMulta){
		Multas multa = MultasRepository.findById(nuevaMulta.getIdMulta()).orElse(null);
		if (multa == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Multa no encontrada");

		}else{
			multa.setMotivo(nuevaMulta.getMotivoMulta());
			return MultasRepository.save(multa);
		}
	}
}
