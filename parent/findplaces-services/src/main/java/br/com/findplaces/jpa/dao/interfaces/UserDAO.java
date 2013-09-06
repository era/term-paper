package br.com.findplaces.jpa.dao.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.User;

public interface UserDAO extends BaseDAO<User, Long> {

	User findUserBySocialID(String id);
	
	void saveLikesFromUser(List<Likes> likes);
	
	void saveLikesFromUser(Likes likes);
	
	User findUserByEmailAndPassword(String email, String password);
	
	Seller saveSellerConfigurations(Seller seller);
	
	Seller findSellerBySocialID(String id);
}
