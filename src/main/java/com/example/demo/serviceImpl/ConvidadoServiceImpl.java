package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Convidado;
import com.example.demo.repository.ConvidadoRepository;
import com.example.demo.service.ConvidadoService;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@Override
	public Convidado find(Long id) {
		Optional<Convidado> obj = convidadoRepository.findById(id);
		return obj.orElseThrow(() -> new com.example.demo.service.exception.ObjectNotFoundException(
				"Objeto não encontrado com o ID: " + id + Convidado.class.getName()));
	}

	@Override
	public Convidado insert(Convidado obj) {
		return convidadoRepository.save(obj);
	}

	@Override
	public List<Convidado> findAll() {
		return convidadoRepository.findAll();
	}

	public Convidado update(Convidado obj) {
		Convidado newObj = find(obj.getId());
		updateData(newObj, obj);
		return convidadoRepository.save(newObj);
	}

	private void updateData(Convidado newObj, Convidado obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
	}

	@Override
	public void delete(Long id) {
		try {
			find(id);
			convidadoRepository.deleteById(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
