package com.generation.progetoFarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.progetoFarmacia.model.Produto;
import com.generation.progetoFarmacia.repository.RepositoryProduto;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ControllerProduto {

	 @Autowired
	 private RepositoryProduto repository;
	 
	 @GetMapping 
	 public ResponseEntity<List<Produto>> GetAll(@RequestBody Produto produto){
		 return ResponseEntity.ok(repository.findAll());		 
	 }
	 
	 @PostMapping
	 public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto){
		 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	 }
	 
	 @PutMapping
	 public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto){
		 return ResponseEntity.ok().body(repository.save(produto));
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable long id ) {
		 repository.deleteById(id);
	 }
}
