package sn.uidt.cisse410.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.uidt.cisse410.model.Produit;
import sn.uidt.cisse410.repository.ProduitRepository;

@Service
@AllArgsConstructor
public class ProduitServiceImplement implements ProduitService{
	
	private ProduitRepository produitRepository;

	@Override
	public Produit creer(Produit produit) {
		// TODO Auto-generated method stub
		return produitRepository.save(produit);
	}

	@Override
	public List<Produit> lire() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Produit modifier(Long id, Produit produit) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).map(pro -> {
			pro.setPrix(produit.getPrix());
			pro.setNom(produit.getNom());
			pro.setDescription(produit.getDescription());
			return produitRepository.save(pro);
		}).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
	}

	@Override
	public String supprimer(Long id) {
		produitRepository.deleteById(id);
		return "Produit supprimé";
	}

}
