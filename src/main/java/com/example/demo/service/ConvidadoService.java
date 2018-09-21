package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Convidado;

@Service
public interface ConvidadoService {

	Convidado find(Long id);

	Convidado insert(Convidado obj);

	List<Convidado> findAll();

	void delete(Long id);

}
