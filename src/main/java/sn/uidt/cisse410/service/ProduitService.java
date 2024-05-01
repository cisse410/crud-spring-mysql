package sn.uidt.cisse410.service;

import java.util.List;

import sn.uidt.cisse410.model.Produit;

public interface ProduitService {
	Produit creer(Produit produit);
	
	List<Produit> lire();
	
	Produit modifier(Long id, Produit produit);
	
	String supprimer(Long id);
}
