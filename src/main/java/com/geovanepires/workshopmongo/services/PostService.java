package com.geovanepires.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovanepires.workshopmongo.domain.Post;
import com.geovanepires.workshopmongo.repository.PostRepository;
import com.geovanepires.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	

	public Post findById(String id){
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao Encontrado"));
	}


	public List<Post> findbyTitle(String text){
		return repo.searchTitle(text);
	}

}
